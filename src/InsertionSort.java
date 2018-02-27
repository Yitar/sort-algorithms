import java.util.Arrays;

/**
 * 插入排序 假设第一个元素组成的数组为有序的，将后面的元素插入前面的数组中元素顺序比较，交换至合适的位置。
 * 优化：要插入的元素与有序数据的元素比较，如果小，复制要插入的元素，有序数据的元素进行移位操作，最后赋值。
 */
public class InsertionSort {

    private static void insertionSort(int[] array) {

        int n = array.length;
        for (int i = 1; i < n; i++) {
            int current = array[i];
            int j = i;
            for (; j > 0 && array[j - 1] > current; j--) {
                array[j] = array[j - 1];
            }
            array[j] = current;
        }

    }

    static void insertionSort(int[] array, int l, int r) {

        for (int i = l + 1; i <= r; i++) {
            int current = array[i];
            int j = i;
            for (; j > l && array[j - 1] > current; j--) {
                array[j] = array[j - 1];
            }
            array[j] = current;
        }
    }


    public static void main(String[] args) {
        int[] array = ArraysUtil.generateDisorderArray(0, 100, 15);
        System.out.println(Arrays.toString(array));
        insertionSort(array, 5, 10);
        System.out.println(Arrays.toString(Arrays.copyOfRange(array, 5, 11)));
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
