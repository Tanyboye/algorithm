package tanyboye.offer._03_02_DuplicationInArrayNoEdit;

/**
 * @author: chengbg
 * @date: 2019/1/6
 * 在一个长度为 n+1 的数组里的所有数字都在 1~n 的范围内，所以数组中至少有一个数字是重复的。
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * 例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的输出是重复的数字2或者3。
 **/
public class Duplicate {
    public static int duplicate(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int len = array.length;
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            if (array[i] < 0 || array[i] > len - 1) {
                return -1;
            }
            a[i] = -1;
        }
        for (int i = 0; i < len; i++) {
            if (array[i] == a[array[i]]) {
                return array[i];
            } else {
                a[array[i]] = array[i];
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
