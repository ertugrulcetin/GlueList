import org.junit.Test;

import java.util.Arrays;

public class ArrayDataShiftingTests {


    @Test
    public void testSimpleShifting() {

        String[] arr = new String[4];
        arr[0] = "ertu";
        arr[1] = "can";
        arr[2] = "bensu";
        arr[3] = "selin";

        int index = 2;
        int numMove = arr.length - index - 1;
        if (numMove > 0) {
            System.arraycopy(arr, index + 1, arr, index, numMove);
            arr = Arrays.copyOf(arr, arr.length - 1);
        }

        String a = Arrays.toString(arr);
        System.out.println(a);
    }
}
