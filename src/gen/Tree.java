package gen;

import java.util.Arrays;
import java.util.List;

public class Tree {
    private String node;
    private List<Tree> children;
    public Tree(String node) {
        this.node = node;
    }
    public Tree(String node, Tree... children) {
        this(node);
        this.children = Arrays.asList(children);
    }

    public Tree(String node, List<Tree> children) {
        this.node = node;
        this.children = children;
    }
}