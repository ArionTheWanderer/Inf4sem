package homework3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PageStructure {
    // private boolean[][] graph;
    private static PageStructure pageStructure;
    private List<List<String>> navigation;
    private List<String> pages;
    private BufferedReader br;

    public static PageStructure getInstance() {
        return pageStructure == null ? pageStructure = new PageStructure() : pageStructure;
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

    public String getStartPage() {
        return navigation.get(0).get(0);
    }

    public boolean isPage(String page) {
        return pages.contains(page);
    }

     private PageStructure() {
        try {
            File file = new File("h3_page_structure.txt");
            if (file.exists()) {
                System.out.println("File exists");
                FileReader fr = new FileReader(file);
                br = new BufferedReader(fr);
                setNav();
            } else {
                System.out.println("File doesn't exist");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void setNav() {
        try {
            int number = Integer.parseInt(br.readLine());
            // graph = new boolean[number][number];
            navigation = new ArrayList<>();
            pages = new ArrayList<>();
            for (int i = 0; i < number; i++) {
                navigation.add(new ArrayList<>());
                String p = br.readLine();
                navigation.get(i).add(p);
                pages.add(p);
            }
            for (int i = 0; i < number; i++) {
                String[] links = br.readLine().split(" ");
                for (String link : links) {
                    navigation.get(i).add(link);
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
