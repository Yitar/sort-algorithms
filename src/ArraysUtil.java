import java.util.Random;

class ArraysUtil {

    static void exchangeElement(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    static int[] generateDisorderArray(int start, int end, int length) {

        assert (start <= end);
        Random random = new Random(System.currentTimeMillis());
        return random.ints(start, end).limit(length).toArray();
    }
}
