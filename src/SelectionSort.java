import java.util.Arrays;

/**
 * 选择排序 每次全部遍历选出最小的 放在最前
 */
public class SelectionSort {

    private static void selectSort(int array[]) {

        int n = array.length;
        for (int i = 0; i < n; i ++) {

            int currentMinIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[currentMinIndex] > array[j]) {
                    currentMinIndex = j;
                }
            }
            if (i != currentMinIndex) {
                ArraysUtil.exchangeElement(array, i, currentMinIndex);
            }
        }

    }

    public static void main(String[] args) {
        int[] array = ArraysUtil.generateDisorderArray(0, 100, 15);
        System.out.println(Arrays.toString(array));
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
