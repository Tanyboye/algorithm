package tanyboye.offer._06_PrintListInReversedOrder;

/**
 * @author: chengbg
 * @date: 2019/1/6
 * 输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 **/
public class PrintListInReversedOrder {

    public static void print(Node node) {
        if (node == null) {
            return;
        }
        if (node.next != null) {
            print(node.next);
        }
        System.out.println(node.value);
    }

    public static void main(String[] args) {
        Node node = new Node();
        node.value = 0;
        Node head = node;
        for (int i = 1; i < 10; i++) {
            Node child = new Node();
            child.value = i;
            node.next = child;
            node = child;
        }
        print(head);
    }
}

class Node {
    int value;
    Node next;
}
