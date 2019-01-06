package tanyboye.offer._07_ConstructBinaryTree;

/**
 * @author: chengbg
 * @date: 2019/1/6
 * 输入某二叉树的前序遍历和中序遍历结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{ 1, 2, 4, 7, 3, 5, 6, 8 }和中序遍历序列{ 4, 7, 2, 1, 5, 3, 8, 6 }
 **/
public class ConstructBinaryTree {
    /**
     * 递归重建二叉树
     *
     * @param pre 前序遍历序列
     * @param pl  每次递归的前序遍历序列的起始位置
     * @param ph  每次递归的前序遍历序列的结束位置
     * @param in  中序遍历序列
     * @param il  每次递归的中序遍历序列的起始位置
     * @param ih  每次递归的中序遍历序列的结束位置
     * @return
     */
    public static Node constructBinaryTree(int[] pre, int pl, int ph, int[] in, int il, int ih) {
        int root = pre[pl];//前序遍历序列的第一个为根节点
        Node node = new Node();
        node.value = root;
        for (int i = il; i < ih; i++) {
            if (in[i] == root) {//根节点位置
                int len = i - il;
                if (i != il) {//如果有左子树，则递归构建
                    Node left = constructBinaryTree(pre, pl + 1, pl + len + 1, in, il, i);
                    node.left = left;
                }
                if (i != ih - 1) {//如果有右子树，则递归构建
                    Node right = constructBinaryTree(pre, pl + len + 1, ph, in, i + 1, ih);
                    node.right = right;
                }
            }
        }
        return node;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        Node node = constructBinaryTree(pre, 0, pre.length, in, 0, in.length);
        System.out.println(node.value);
    }
}

class Node {
    int value;
    Node left;
    Node right;
}
