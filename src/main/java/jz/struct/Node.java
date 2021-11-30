package jz.struct;

import java.util.List;

/**
 * @author Melody
 * @date 2021/11/22 14:29
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

}
