import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Interpreter {
    public static void interpret(String command, TreeImpl tree) {
        if (command.startsWith("return children ")) {
            returnChildren(tree, command);
        } else
        if (command.startsWith("add ")) {
            add(tree, command);
        } else
        if (command.startsWith("delete ")) {
            delete(tree, command);
        } else
        if (command.equals("save")) {
            FacadeJSON.getInstance().writeTree(tree);
        }
    }

    private static void returnChildren(TreeImpl tree, String command) {
        String[] wordsOfCommand = command.split(" ");
        String type = wordsOfCommand[2];
        String name = wordsOfCommand[3];
        MyIterator iterator = tree.getIterator("DFS");
        while (iterator.hasNext()) {
            TreeNode node = iterator.next();
            if (node.type.toString().equals(type) && name.equals(node.name)) {
                System.out.println(node.children);
            }
        }
    }

    private static void delete(TreeImpl tree, String command) {
        String[] words = command.split(" ");
        TreeNode toDelete = findByAddress(words[1], tree);
        if (toDelete != null) {
            toDelete.parent.children.remove(toDelete);
            toDelete.parent = null;
        } else {
            System.out.println("Адрес не найден");
        }
    }

    private static void add(TreeImpl tree, String query) {
        String[] words = query.split(" ");
        TreeNode parent = findByAddress(words[1], tree);
        Type type = null;
        try {
            type = Type.valueOf(words[3]);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        if (type != null && parent != null) {
            Builder builder = new Builder();
            parent.add(builder
                    .setName(words[2])
                    .setType(type)
                    .setPriority(Integer.parseInt(words[4])).build());
        } else
            System.out.println("Введены неверные параметры.");

    }

    private static TreeNode findByAddress(String string, TreeImpl tree) {
        String[] address = string.split(",");
        MyIterator iterator = tree.getIterator("BFS");
        while (iterator.hasNext()) {
            TreeNode node = iterator.next();
            return childrenIteration(node.children, address);
        }
        return null;
    }

    private static TreeNode childrenIteration(List<TreeNode> children, String[] address) {
        Iterator<TreeNode> childrenIterator = children.iterator();
        while (childrenIterator.hasNext()) {
            TreeNode node = childrenIterator.next();
            if (node.name.equals(address[0]) && !node.children.isEmpty() && address.length == 1) {
                return node;
            }
            if (node.name.equals(address[0]) && !node.children.isEmpty()) {
                String[] truncatedAddress = Arrays.copyOfRange(address, 1, address.length - 1);
                childrenIteration(node.children, truncatedAddress);
            } else if(node.name.equals(address[0])) {
                return node;
            }
        }
        return null;
    }
}
