package saruj.ds;

import org.junit.jupiter.api.Test;

public class BinaryMaxHeapTest {

    @Test
    public void testInsert1() {
        BinaryMaxHeap bmh = new BinaryMaxHeap();
        for(int i = 0; i < 10; i++) {
            bmh.add(i);
            System.out.println(bmh);
        }
    }

    @Test
    public void testPoll1() {

    }

    @Test
    public void testHeapify1() {

    }

}
