import java.util.Arrays;

/**
 * 自底向上的归并排序
 */
public class MergeSortBU {

    private static void mergeSortBU(int[] array) {
        int n = array.length;
        for (int size = 1; size < n; size += size) {
            for (int i = 0; i + size < n; i += size + size) {
                MergeSort.merge(array, i, i + size - 1,i + size + size - 1 > n ? n : i + size + size - 1);
            }
        }
    }


    public static void main(String[] args) {
        int[] array = ArraysUtil.generateDisorderArray(0, 100, 15);
        System.out.println(Arrays.toString(array));
        mergeSortBU(array);
        System.out.println(Arrays.toString(array));
    }
}
