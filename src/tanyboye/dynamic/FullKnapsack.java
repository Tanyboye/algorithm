package tanyboye.dynamic;

/**
 * @author:chengbg
 * @date:2018/12/24
 * 完全背包
 */
public class FullKnapsack {
    public static void main(String[] args) {
        int[] weight = {140, 20, 50, 20, 6, 12, 30, 80, 400, 300};
        int[] value = {10, 2, 5, 80, 6, 12, 30, 40, 7, 100};
        int fullKnapsack2 = fullKnapsack2(weight, value, 100000);
        System.out.println(fullKnapsack2);
    }

    public static int fullKnapsack(int[] weight, int[] value, int capacity) {
        int len1 = weight.length;
        int len2 = value.length;
        int[][] a = new int[len1][capacity];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < capacity; j++) {
                a[i][j] = 0;
            }
        }
        for (int i = 0; i < len1 - 1; i++) {
            for (int j = 0; j < capacity; j++) {
                if (j < weight[i]) {
                    a[i + 1][j] = a[i][j];
                } else {
                    a[i + 1][j] = Math.max(a[i][j], a[i + 1][j - weight[i]] + value[i]);
                }
            }
        }
        return a[len1 - 1][capacity - 1];
    }

    /**
     * 使用一维数组，降低空间复杂度
     *
     * @param weight
     * @param value
     * @param capacity
     * @return
     */
    public static int fullKnapsack2(int[] weight, int[] value, int capacity) {
        int len1 = weight.length;
        int len2 = value.length;
        int[] a = new int[capacity];
        for (int j = 0; j < capacity; j++) {
            a[j] = 0;
        }
        for (int i = 0; i < len1 - 1; i++) {
            for (int j = 0; j < capacity; j++) {
                if (j < weight[i]) {
                    a[j] = a[j];
                } else {
                    a[j] = Math.max(a[j], a[j - weight[i]] + value[i]);
                }
            }
        }
        return a[capacity - 1];
    }
}
