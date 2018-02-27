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

        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(array, l, mid);
        mergeSort(array, mid + 1, r);
        merge(array, l, mid, r);


    }

    private static void merge(int[] array, int l, int mid, int r) {

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
        int[] array = ArraysUtil.generateDisorderArray(0, 100, 15);
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
