package tanyboye.dynamic;

/**
 * @author:chengbg
 * @date:2018/12/26 区间调度问题
 * 有n项工作，每项工作分别在si开始，fi结束。对每项工作，你都可以选择参加或不参加，但选择了
 * 参加某项工作就必须至始至终参加全程参与，即参与工作的时间段不能有重叠(即使开始的时间和结束
 * 的时间重叠都不行)。
 * 这个问题在贪心算法一节习题中出现过。原来的目标是使得你能参与的工作数量最多。但是现在我们
 * 对每个工作赋予一个权值，它可能表示这项工作你能获得的报酬。请问，你应该选择哪些工作，才能
 * 使得你获得的报酬最多。
 * 这个问题也被称为区间调度问题。如图1，按照贪心策略，先后选择活动1和活动3，它们是相容的，
 * 但是你能获得的总报酬为2, 没有只从事工作2获得的报酬多。请你设计算法，帮助我们选择最优的活
 * 动方案。
 */

public class IntervalScheduling {

    /**
     * task[i][j]表示有i个任务，结束时间为j的最多报酬
     *
     * @param task
     * @return
     */
    public static int intervalScheduling(int[][] task) {
        sort(task);//根据结束时间从小到大排序
        int n = task.length;
        int end = task[n - 1][1];
        int[][] a = new int[n][end + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= end; j++) {
                if (i == 0 && j < task[0][1]) {
                    a[i][j] = 0;
                } else if (i == 0 && j >= task[0][1]) {
                    a[i][j] = task[0][2];
                } else if (j < task[i][1]) {
                    a[i][j] = a[i - 1][j];
                } else {
                    a[i][j] = Math.max(a[i - 1][j], a[i - 1][task[i][0] - 1] + task[i][2]);
                }
            }

        }
        return a[n - 1][end];
    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    public static void sort(int[][] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j][1] > array[j + 1][1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * 交换
     *
     * @param a
     * @param i
     * @param j
     */
    public static void swap(int[][] a, int i, int j) {
        int temp = a[j][0];
        a[j][0] = a[i][0];
        a[i][0] = temp;
        temp = a[j][1];
        a[j][1] = a[i][1];
        a[i][1] = temp;
        temp = a[j][2];
        a[j][2] = a[i][2];
        a[i][2] = temp;
    }

    public static void main(String[] args) {
        int[][] array = {{0, 3, 2},
                {1, 5, 5},
                {3, 7, 1},
                {5, 6, 3},
                {8, 9, 4},
                {7, 11, 5},
                {7, 10, 2},
                {14, 16, 3},
                {15, 19, 4},
                {20, 30, 5}};
        int vaule = intervalScheduling(array);
        System.out.println(vaule);
    }

}
