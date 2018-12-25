package backtrack;

/**
 * @author:chengbg
 * @date:2018/12/25
 * 假设有n个任务由k个可并行工作的机器完成。完成任务i需要的时间为 。试设计一个算法找出完成这
 * 个任务的最佳调度，使得完成全部任务的时间最早。
 * 例如，输入为
 * 7 3
 * 2 14 4 16 6 5 3
 * 表示有7个任务，有3台可并行工作的机器。每个任务需要的完成时间在第二行。
 * 输出文件示例
 * 17
 */
public class OptimalScheduling {
    private static int[] task = {1, 5, 4, 7, 12, 6, 9, 8};
    private static int[] t;
    private static int n;//任务数
    private static int k;//机器数
    private static int min;//当前的最优解

    /**
     * t[i]表示第i个机器工作的时间
     *
     * @param dep  当前已加入任务的数量
     * @param time 需要的时间
     */
    public static void search(int dep, int time) {
        if (time > min) {//大于最小时间，剪枝
            return;
        }
        if (dep >= n) {//全部任务都加入进来
            if (time < min) {
                min = time;
            }
            return;
        }
        for (int i = 0; i < k; i++) {
            if (t[i] + task[dep] <= min) {//如果加入新任务之后的时间大于最小时间，剪枝
                t[i] = t[i] + task[dep];
                search(dep + 1, Math.max(time, t[i]));
                t[i] = t[i] - task[dep];//回溯
            }
        }

    }

    public static void main(String[] args) {
        k = 3;
        n = task.length;
        //初始化最小上界（全部任务由一个机器完成）
        for (int i = 0; i < n; i++) {
            min += task[i];
        }
        t = new int[k];
        for (int i = 0; i < k; i++) {
            t[i] = 0;
        }
        search(0, 0);
        System.out.println(min);
    }
}
