package homework1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FacadeJSON implements Facade {
    private static FacadeJSON facadeJSON;
    private static FileWriter writer;
    private static Scanner in;
    private static File file;
    private static ObjectMapper mapper;

    public static FacadeJSON getInstance() {
        return facadeJSON == null ? facadeJSON = new FacadeJSON() : facadeJSON;
    }

    private FacadeJSON() {
        try {
            file = new File("tree.txt");
            writer = new FileWriter("tree.txt", false);
            in = new Scanner(file);
            mapper = new ObjectMapper();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeTree(TreeImpl tree) {
        try {
            writer.write(mapper.writeValueAsString(tree));
            writer.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public TreeImpl readTree() {
        String line = in.nextLine();
        try {
            return mapper.readValue(line, TreeImpl.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
