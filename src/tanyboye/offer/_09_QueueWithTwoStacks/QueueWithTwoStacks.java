package tanyboye.offer._09_QueueWithTwoStacks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: chengbg
 * @date: 2019/2/24
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead，
 * 分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 **/
public class QueueWithTwoStacks<T> {

    private Queue<T> queue1 = new LinkedList<>();

    private Queue<T> queue2 = new LinkedList<>();

    public void appendTail(T t) {
        queue1.add(t);
    }

    public T deleteHead() throws Exception {
        if (!queue2.isEmpty()) {
            T item = queue2.poll();
            return item;
        } else {
            if (queue1.isEmpty()) {
                throw new Exception("queue is empty");
            } else {
                while (!queue1.isEmpty()) {
                    queue2.add(queue1.poll());
                }
                T item = queue2.poll();
                return item;
            }
        }
    }

}
