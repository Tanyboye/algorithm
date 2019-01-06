package tanyboye.offer._04_FindInPartiallySortedMatrix;

/**
 * @author: chengbg
 * @date: 2019/1/6
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 **/
public class Find {
    /**
     * 使用2次二分法
     *
     * @param array  目标数组
     * @param number 待查找数
     * @return
     */
    public static boolean find(int[][] array, int number) {
        if (array == null || array.length == 0) {
            return false;
        }
        int len = array.length;
        int low = 0;
        int high = len - 1;
        int mid = (low + high) / 2;
        while (low != high) {
            if (array[mid][0] == number) {
                return true;
            } else if (array[mid][0] < number) {
                low = mid + 1;
                mid = (low + high) / 2;
            } else if (array[mid][0] > number) {
                high = mid - 1;
                mid = (low + high) / 2;
            }
        }
        int k = mid - 1;
        len = array[k].length;
        low = 0;
        high = len - 1;
        mid = (low + high) / 2;
        while (low != high) {
            if (array[k][mid] == number) {
                return true;
            } else if (array[k][mid] < number) {
                low = mid + 1;
                mid = (low + high) / 2;
            } else if (array[k][mid] > number) {
                high = mid - 1;
                mid = (low + high) / 2;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        boolean result = find(array, 7);
        System.out.println(result);
    }
}
