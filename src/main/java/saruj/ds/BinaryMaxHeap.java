package saruj.ds;


import java.util.ArrayList;
import java.util.Optional;

public class BinaryMaxHeap {
    @Override
    public String toString() {
        return "BinaryMaxHeap{" +
                arrayList +
                '}';
    }

    private final ArrayList<Integer> arrayList;

    public BinaryMaxHeap() {
        arrayList = new ArrayList<>();
    }

    public BinaryMaxHeap(ArrayList<Integer> array) {
        this.arrayList = array;
        heapify();
    }

    private void heapify() {
        if(arrayList.isEmpty()) {
            return;
        }
        for(int i = Math.floorDiv(arrayList.size(),2); i >= 0; i--) {
            downheap(i);
        }
    }

    public void add(Integer elem) {
        arrayList.add(elem);
        upheap(arrayList.size()-1);
    }

    private void upheap(int index) {
        if(index == 0) {
            return;
        }
        int parentIndex = Math.floorDiv(index-1, 2);
        if(arrayList.get(parentIndex) < arrayList.get(index)) {
            int tmp = arrayList.get(index);
            arrayList.set(index, arrayList.get(parentIndex));
            arrayList.set(parentIndex, tmp);
            upheap(parentIndex);
        }
    }

    public Optional<Integer> poll() {
        if(arrayList.isEmpty()) {
            return Optional.empty();
        } else {
            final var retVal = Optional.of(arrayList.get(0));
            arrayList.set(0, arrayList.get(arrayList.size()-1));
            arrayList.remove(arrayList.size()-1);
            if(!arrayList.isEmpty()) {
                downheap(arrayList.size() - 1);
            }
            return retVal;
        }
    }

    private void downheap(int index) {
        int leftChildInd = 2*index + 1;
        int rightChildInd = leftChildInd + 1;
        int largest = index;
        if(leftChildInd < arrayList.size()
                && arrayList.get(leftChildInd) > arrayList.get(index)) {
            largest = leftChildInd;
        }

        if(rightChildInd < arrayList.size()
                && arrayList.get(rightChildInd) > arrayList.get(largest)) {
            largest = rightChildInd;
        }

        if(largest != index) {
            int tmp = arrayList.get(index);
            arrayList.set(index, arrayList.get(largest));
            arrayList.set(largest, tmp);
            downheap(largest);
        }
    }

}
