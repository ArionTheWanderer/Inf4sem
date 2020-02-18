import java.util.ArrayList;
import java.util.List;

class TreeNode {
    String name;
    Type type;
    int priority;
    TreeNode parent;
    List<TreeNode> children;

    public TreeNode(String name, Type type, int priority, TreeNode parent) {
        this.name = name;
        this.type = type;
        this.priority = priority;
        this.parent = parent;
        this.children = new ArrayList<TreeNode>();
    }

    public TreeNode() {}

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", priority=" + priority + ", parent=" + parent.name +
                '}';
    }

    public void setParent(TreeNode node) {
        this.parent = node;
    }

    public void add(TreeNode node) {
        children.add(node);
        node.parent = this;
    }
}