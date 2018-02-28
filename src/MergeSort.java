import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

/**
 * 归并排序，数组分治，合并为有序新数组
 */
public class MergeSort {

    private static void mergeSort(int[] array) {

        int n = array.length;
        mergeSort(array, 0, n - 1);
    }

    private static void mergeSort(int[] array, int l, int r) {

        //数组小到一定返回，使用插入排序
        if (r - l <= 3) {
            InsertionSort.insertionSort(array, l, r);
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(array, l, mid);
        mergeSort(array, mid + 1, r);
        //两部分分别有序，无序归并
        if (array[mid] > array[mid + 1]) {
            merge(array, l, mid, r);
        }


    }

    static void merge(int[] array, int l, int mid, int r) {

        //Arrays.copyOfRange 包括from 不包括to
        int[] aux = Arrays.copyOfRange(array, l, r + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                int[] temp = Arrays.copyOfRange(aux, j - l, r - l + 1);
                System.arraycopy(temp, 0, array, k, r - j + 1);
                break;
            }
            if (j > r) {
                int[] temp = Arrays.copyOfRange(aux, i - l, mid - l + 1);
                System.arraycopy(temp, 0, array, k, mid - i + 1);
                break;
            }
            if (aux[i - l] > aux[j - l]) {
                array[k] = aux[j - l];
                j++;
            } else if (aux[i - l] < aux[j - l]) {
                array[k] = aux[i - l];
                i++;
            }
        }

    }

    public static void main(String[] args) {
        int[] array = ArraysUtil.generateDisorderArray(0, 100000, 10000);
        System.out.println(Arrays.toString(array));
        LocalTime start = LocalTime.now();
        mergeSort(array);
        LocalTime end = LocalTime.now();
        System.out.println(Arrays.toString(array));
        System.out.println(Duration.between(start, end));

    }
}
