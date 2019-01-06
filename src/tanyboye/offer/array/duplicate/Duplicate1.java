package tanyboye.offer.array.duplicate;

/**
 * @author: chengbg
 * @date: 2019/1/6
 * 在一个长度为n的数组里的所有数字都在0~n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * 例如：输入长度为7的数组{2，3，1，0，2，5，3}，那么对应的输出是重复的数字2或者3。
 **/
public class Duplicate1 {
    public static int duplicate(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] < 0 || array[i] > len - 1) {
                return -1;
            }
        }
        for (int i = 0; i < len; i++) {
            while (array[i] != i) {
                if (array[i] == array[array[i]]) {
                    return array[i];
                }
                swap(array, i, array[i]);
            }
        }
        return -1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 0, 2, 5, 3};
        int duplicate = duplicate(array);
        System.out.println(duplicate);
    }
}
