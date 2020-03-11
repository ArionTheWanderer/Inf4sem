package homework3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Site {
    private static Site site;
    private List<List<String>> navigation;
    private List<String> pages;
    private BufferedReader br;
    private List<List<String>> positions;

    public static Site getInstance() {
        return site == null ? site = new Site() : site;
    }

    public Page createPage(String page) {
        if (isPage(page)) {
            for (String p: pages) {
                if (p.equals(page)) {
                    int number = pages.indexOf(p);
                    List<String> strings = positions.get(number);
                    String type = strings.get(0);
                    switch (type) {
                        case "TA":
                            return new PageTA(pages.get(number));
                        case "VA":
                            return new PageVA(pages.get(number));
                        default: return new PageCommon(pages.get(number));
                    }
                }
            }
        }
        return null;
    }

    public String getTextOnPosition(String page, int position) {
        int number = 0;
        for (String p : pages) {
            if (p.equals(page)) {
                number = pages.indexOf(p);
            } else {
                return null;
            }
        }
        List<String> strings = positions.get(number);
        return strings.get(position);
    }

    public boolean isLink(String currentPage, String link) {
        if (isPage(link)) {
            for (List<String> strings : navigation) {
                if (strings.get(0).equals(currentPage)) {
                    for (String string: strings) {
                        if (string.equals(link))
                            return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public Page getStartPage() {
        String type = positions.get(0).get(0);
        switch (type) {
            case "TA":
                return new PageTA(pages.get(0));
            case "VA":
                return new PageVA(pages.get(0));
            default: return new PageCommon(pages.get(0));
        }
    }

    public boolean isPage(String page) {
        return pages.contains(page);
    }

     private Site() {
        try {
            File file = new File("h3_page_structure.txt");
            if (file.exists()) {
                System.out.println("File exists");
                FileReader fr = new FileReader(file);
                br = new BufferedReader(fr);
                setNav();
                setPositions();
            } else {
                System.out.println("File doesn't exist");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void setNav() {
        try {
            int numberOfPage = Integer.parseInt(br.readLine());
            navigation = new ArrayList<>();
            pages = new ArrayList<>();
            for (int i = 0; i < numberOfPage; i++) {
                navigation.add(new ArrayList<>());
                String p = br.readLine();
                navigation.get(i).add(p);
                pages.add(p);
            }
            for (int i = 0; i < numberOfPage; i++) {
                String[] links = br.readLine().split(" ");
                for (String link : links) {
                    navigation.get(i).add(link);
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void setPositions() {
        try {
            int numberOfPage = pages.size();
            positions = new ArrayList<>();
            for (int i = 0; i < numberOfPage; i++) {
                positions.add(new ArrayList<>());
                String typeOfAdvertising = br.readLine();
                if (typeOfAdvertising.startsWith("TA")) {
                    positions.get(i).add("TA");
                } else if (typeOfAdvertising.startsWith("VA")) {
                    positions.get(i).add("VA");
                } else {
                    positions.get(i).add("NoA");
                }
                for (int j = 0; j < 100; j++) {
                    String position = br.readLine();
                    if (position != null) {
                        positions.get(i).add(position);
                    } else {
                        positions.get(i).add("");
                    }
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
