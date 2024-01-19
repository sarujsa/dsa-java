package saruj.algies.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class HeapsortTest {

    private Integer[] array1 = new Integer[]
            {9,8,7,6,5,4,3,2,1};
    private Integer[] array2 = new Integer[]
            {9,1,8,2,7,3,6,4,5};
    private Integer[] array3 = new Integer[]
            {1,2,3,4,5,6,7,8,9};
    private Integer[] array4 = new Integer[]
            {555,9,1,345,89,12,900,32,31,56,0,17,23,89,98,9,8,7,9,13};

    @Test
    public void test1() {
        Integer[] data = Arrays.copyOf(array1, array1.length);
        Heapsort.sort(data);
        Assertions.assertArrayEquals(data, array3);
    }

    @Test
    public void test2() {
        Integer[] data = Arrays.copyOf(array2, array2.length);
        Heapsort.sort(data);
        Assertions.assertArrayEquals(data, array3);
    }

    @Test
    public void test3() {
        Integer[] data = Arrays.copyOf(array3, array3.length);
        Heapsort.sort(data);
        Assertions.assertArrayEquals(data, array3);
    }

    @Test
    public void test4() {
        Integer[] data = Arrays.copyOf(array4, array4.length);
        Heapsort.sort(data);
        Arrays.sort(array4);
        Assertions.assertArrayEquals(data, array4);
    }

}