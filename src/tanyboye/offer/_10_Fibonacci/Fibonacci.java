package tanyboye.offer._10_Fibonacci;

/**
 * @author: chengbg
 * @date: 2019/2/24
 * 写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
 **/
public class Fibonacci {

    /**
     * 递归方式
     * @param n
     * @return
     */
    public int fibonacci_recursion(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("error number");
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci_recursion(n - 1) + fibonacci_recursion(n - 2);
    }

    /**
     * 循环方式
     * @param n
     * @return
     */
    public int fibonacci_loop(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("error number");
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int f0 = 0;
        int f1 = 1;
        int f = 0;
        for (int i = 2; i <= n; i++) {
            f = f0 + f1;
            f0 = f1;
            f1 = i;
        }
        return f;
    }
}
