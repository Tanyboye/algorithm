package tanyboye.sort;

/**
 * @author: chengbg
 * @date: 2019/2/27
 * 冒泡排序
 **/
public class BubbleSort {
    public static void bubbleSort(int[] array) {
        if (array == null) {
            return;
        }
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * 增加标志位
     * 如果数组已经有序，则结束，避免无谓的循环遍历
     *
     * @param array
     */
    public static void bubbleSort2(int[] array) {
        if (array == null) {
            return;
        }
        int len = array.length;
        int flag = 0;
        for (int i = 0; i < len; i++) {
            flag = 0;
            for (int j = 0; j < len - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = 1;
                }
            }
            if (flag == 0) {
                return;
            }
        }
    }

    /**
     * 局部排序
     * 如果部分数组已经达到有序状态，则不需要再对这部分进行遍历
     * @param array
     */
    public static void bubbleSort3(int[] array) {
        if (array == null) {
            return;
        }
        int len = array.length;
        int end = len; //最后一次交换的位置
        int index = len; //当前交换的位置
        while (end > 0) {
            index = 0;
            for (int j = 0; j < len - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    index = j + 1;
                }
            }
            end = index;
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
