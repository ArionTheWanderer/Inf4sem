package homework1;

import java.util.ArrayList;

class Builder {
    private TreeNode node;

    public Builder() {
        node = new TreeNode();
    }

    public void reset() {
        node = new TreeNode();
    }

    public Builder setName(String name) {
        node.name = name;
        return this;
    }

    public Builder setParent(TreeNode parent) {
        node.parent = parent;
        return this;
    }

    public Builder setType(Type type) {
        node.type = type;
        return this;
    }

    public Builder setPriority(int priority) {
        node.priority = priority;
        return this;
    }

    public TreeNode build() {
        node.children = new ArrayList<>();
        return node;
    }
}
