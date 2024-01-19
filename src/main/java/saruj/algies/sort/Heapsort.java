package saruj.algies.sort;

public class Heapsort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        heapify(array);
        sort(array, array.length-1);
    }

    private static <T extends Comparable<T>> void sort(T[] array, int endIndex) {
        if(endIndex <= 0) {
            return;
        }
        T tmp = array[endIndex];
        array[endIndex] = array[0];
        array[0] = tmp;

        downheap(array, 0, endIndex);
        sort(array, endIndex-1);
    }

    private static <T extends Comparable<T>> void heapify(T[] array) {
        for(int i = Math.floorDiv(array.length, 2); i >= 0; i--) {
            downheap(array, i, array.length);
        }
    }

    private static <T extends Comparable<T>> void downheap(
            T[] array, final int index, final int excludeFromIndex) {
        final int leftChild = 2*index + 1;
        final int rightChild = leftChild + 1;
        int indexOfLargest = index;
        if(leftChild < excludeFromIndex
            && array[leftChild].compareTo(array[index]) > 0) {
                indexOfLargest = leftChild;
        }
        if(rightChild < excludeFromIndex
            && array[rightChild].compareTo(array[indexOfLargest]) > 0) {
            indexOfLargest = rightChild;
        }
        if(indexOfLargest != index) {
            T tmp = array[index];
            array[index] = array[indexOfLargest];
            array[indexOfLargest] = tmp;
            downheap(array, indexOfLargest, excludeFromIndex);
        }
    }


}
