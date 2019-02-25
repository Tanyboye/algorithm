package tanyboye.letcode._02_addTwoNumbers;

/**
 * @author: chengbg
 * @date: 2019/2/25
 * 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 **/
public class addTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(0);
        ListNode head = first;
        int flag = 0;
        ListNode node;
        while (l1 != null && l2 != null) {
            int number = l1.val + l2.val + flag;
            if (number >= 10) {
                node = new ListNode(number - 10);
                flag = 1;
            } else {
                node = new ListNode(number);
                flag = 0;
            }
            head.next = node;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 == null && flag == 1) {
            node = new ListNode(1);
            head.next = node;
            return first.next;
        }
        while (l1 != null) {
            int number = l1.val + flag;
            if (number >= 10) {
                node = new ListNode(number - 10);
                flag = 1;
            } else {
                node = new ListNode(number);
                flag = 0;
            }
            head.next = node;
            head = head.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int number = l2.val + flag;
            if (number >= 10) {
                node = new ListNode(number - 10);
                flag = 1;
            } else {
                node = new ListNode(number);
                flag = 0;
            }
            head.next = node;
            head = head.next;
            l2 = l2.next;
        }
        if (flag == 1) {
            node = new ListNode(1);
            head.next = node;
        }
        return first.next;
    }

    /**
     * 简化方法1的代码量
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(0);
        ListNode head = first;
        int flag = 0;
        ListNode node;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int number = v1 + v2 + flag;
            if (number >= 10) {
                node = new ListNode(number - 10);
                flag = 1;
            } else {
                node = new ListNode(number);
                flag = 0;
            }
            head.next = node;
            head = head.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (flag == 1) {
            node = new ListNode(1);
            head.next = node;
        }
        return first.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}