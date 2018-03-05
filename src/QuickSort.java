import java.time.Duration;
import java.time.LocalTime;
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

    private static void quickSort2Ways(int array[]) {

        int n = array.length;
        sort2(array, 0, n - 1);
    }

    private static void sort2(int[] array, int l, int r) {

        if (r - l <= 15) {
            InsertionSort.insertionSort(array, l, r);
            return;
        }

        int p = partition2(array, l, r);
        sort2(array, l, p - 1);
        sort2(array, p + 1, r);

    }

    private static void quickSort3Ways(int array[]) {

        int n = array.length;
        quickSort3Ways(array, 0, n - 1);
    }

    private static void quickSort3Ways(int[] array, int l, int r) {
        if (r - l <= 15) {
            InsertionSort.insertionSort(array, l, r);
            return;
        }

        ArraysUtil.exchangeElement(array, l, new Random().ints(l, r).findFirst().orElse(l));
        int v = array[l];
        //[l + 1...lt] < v, [lt + 1...i) = v, [gt...r] > v
        int lt = l, gt = r + 1, i = l;
        while (i < gt) {
            if (array[i] < v) {
                ArraysUtil.exchangeElement(array, lt + 1, i);
                lt++;
                i++;
            } else if (array[i] > v) {
                ArraysUtil.exchangeElement(array, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        ArraysUtil.exchangeElement(array, lt, l);
        quickSort3Ways(array, l, lt - 1);
        quickSort3Ways(array, gt, r);

    }

    private static void sort(int[] array, int l, int r) {

        if (r - l <= 15) {
            InsertionSort.insertionSort(array, l, r);
            return;
        }

        int p = partition(array, l, r);
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
        //you may need set maximum stack size with jvm option -Xss
        int[] array = ArraysUtil.generateDisorderArray(0, 100000000, 1000000);
        int[] array2 = new int[array.length];
        int[] array3 = new int[array.length];
        System.arraycopy(array, 0, array2, 0, array.length);
        System.arraycopy(array, 0, array3, 0, array.length);
        System.out.println(Arrays.toString(array3));
        LocalTime start1 = LocalTime.now();
        quickSort(array);
        LocalTime end1 = LocalTime.now();
        System.out.println("quick basic " + Duration.between(end1, start1));
        quickSort2Ways(array2);
        LocalTime end2 = LocalTime.now();
        System.out.println("quick 2 ways " + Duration.between(end2, end1));
        quickSort3Ways(array3);
        LocalTime end3 = LocalTime.now();
        System.out.println("quick 3 ways" + Duration.between(end3, end2));
    }
}
