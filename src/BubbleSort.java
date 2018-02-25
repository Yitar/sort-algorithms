import java.util.Arrays;

/**
 * 冒泡排序 永远使用最大的数向后交换
 * 优化1：当前循环内如果没有发生交换，则说明排序完成
 * 优化2：当前元素交换至某一位置后，后面的数没有发生过交换，说明该数组部分有序，只需要关心从开始到这个位置之间数的交换
 */
public class BubbleSort {

    private static void bubbleSort(int[] array) {
        int exchangeIndex = array.length;
        int k;
        while (exchangeIndex > 0) {
            for (int i = 0; i < exchangeIndex; i++) {
                k = exchangeIndex;
                exchangeIndex = 0;
                for (int j = 1; j < k; j++) {
                    if (array[j - 1] > array[j]) {
                        ArraysUtil.exchangeElement(array, j - 1, j);
                        exchangeIndex = j;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] array = ArraysUtil.generateDisorderArray(9, 15, 5);
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
