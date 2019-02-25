package tanyboye.offer._08_NextNodeInBinaryTrees;

/**
 * @author: chengbg
 * @date: 2019/2/25
 **/
public class NextNodeInBinaryTrees {
    public Node NextNodeInBinaryTrees(Node node) throws Exception {
        if (node == null) {
            throw new Exception("node is null");
        }
        if (node.right != null) { //如果当前节点有右子树，则右子树的最左子节点为下一个节点
            Node temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        } else { //如果当前节点没有右子树，则向上遍历找到一个节点为该父节点的左节点为止，则此父节点为下一个节点
            Node temp = node;
            while (temp.parent != null) {
                if (temp.parent.left == temp) {
                    return temp.parent;
                }
                temp = temp.parent;
            }
            return null;
        }
    }
}

class Node {
    Node left;
    Node right;
    Node parent;
}
