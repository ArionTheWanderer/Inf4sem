import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.Scanner;

public class FacadeXML implements Facade {
    private static FacadeXML facadeXML;
    private static FileWriter writer;
    private static Scanner in;
    private static File file;

    public static FacadeXML getInstance() {
        return facadeXML == null ? facadeXML = new FacadeXML() : facadeXML;
    }

    private FacadeXML() {
        try {
            file = new File("tree.xml");
            writer = new FileWriter("tree.xml", true);
            in = new Scanner(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeTree(TreeImpl tree) {
        try {
            writer.write(parseToXML(tree));
            writer.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public TreeImpl readTree() {
        StringBuilder s = new StringBuilder();
        while (in.hasNextLine()) {
            s.append(in.nextLine());
        }
        return parseFromXML(s.toString());
    }

    private String parseToXML(TreeImpl tree) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TreeImpl.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(tree, sw);
            return sw.toString();
        } catch (JAXBException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private TreeImpl parseFromXML(String string) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(TreeImpl.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (TreeImpl) jaxbUnmarshaller.unmarshal(new StringReader(string));
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e);
        }
    }

}
