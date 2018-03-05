import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序算法
 */
public class QuickSort {

    private static void quickSort(int array[]) {

        int n = array.length;
        sort(array, 0, n - 1);
    }

    private static void sort(int[] array, int l, int r) {

        if (r - l <= 15) {
            InsertionSort.insertionSort(array, l, r);
            return;
        }

        int p = partition2(array, l, r);
        sort(array, l, p - 1);
        sort(array, p + 1, r);


    }

    //快速排序BASIC
    private static int partition(int[] array, int l, int r) {

        int randomInt = new Random(System.currentTimeMillis()).ints(l, r).findFirst().orElse(l);
        ArraysUtil.exchangeElement(array, l, randomInt);
        int v = array[l];

        //array[l...j) < V, array(j...r] >= V
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (array[i] < v) {
                ArraysUtil.exchangeElement(array, i, ++j);
            }
        }
        ArraysUtil.exchangeElement(array, l, j);
        return j;
    }

    //双路快速排序，解决大量重复元素带来的算法时间复杂度退化问题
    private static int partition2(int array[], int l, int r) {
        int randomInt = new Random(System.currentTimeMillis()).ints(l, r).findFirst().orElse(l);
        ArraysUtil.exchangeElement(array, l, randomInt);
        int v = array[l];

        //array[l + 1...i) <= v, array(j...r] >= v;
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && array[i] <= v) i++;
            while (j >= l + 1 && array[j] >= v) j--;
            if (i > j) break;
            ArraysUtil.exchangeElement(array, i, j);
            i++;
            j--;
        }
        ArraysUtil.exchangeElement(array, l, j);
        return j;

    }

    public static void main(String[] args) {
        int[] array = ArraysUtil.generateDisorderArray(0, 100, 15);
        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
