import java.util.*;/**
 * Heap
 */
public class Heap {
    private final ArrayList<Integer> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    public void insert(int val) {
        heap.add(val);

        upHeapify(getSize()- 1);
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    private void upHeapify(int index){
        if(index == 0) {
            return;
        }

        int parentIndex = (index - 1) / 2;

        if(heap.get(parentIndex) < heap.get(index)) {
            swap(parentIndex, index);
            upHeapify(parentIndex);
        }
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("heap empty");
            return -1;
        }

        return heap.get(0);
    }

    public int remove() {
        if(isEmpty()) {
            System.out.println("heap empty");
            return -1;
        }

        int val = heap.get(0);
        swap(0, getSize() - 1);
        heap.remove(getSize() - 1);

        downHeapify(0);

        return val;
    }

    private void downHeapify(int index) {
        if(index >= getSize()) return;

        int maxIndex = index;

        int leftIndex = 2 * index + 1, rightIndex = 2 * index + 2;

        if(leftIndex < getSize() && heap.get(leftIndex) > heap.get(maxIndex)) {
            maxIndex = leftIndex;
        }

        if(rightIndex < getSize() && heap.get(rightIndex) > heap.get(maxIndex)) {
            maxIndex = rightIndex;
        }

        if(maxIndex != index) {
            swap(index, maxIndex);
            downHeapify(maxIndex);
        }
    }

    private int getSize() {
        return heap.size();
    }

    private ArrayList<ArrayList<Integer>> getHeap() {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        if(isEmpty()) {
            System.out.println("Heap is Empty");
            return res;
        }
        
        q.offer(0);

        while(!q.isEmpty()) {
            ArrayList<Integer> subset = new ArrayList<>();
            int size = q.size();

            for(int i = 0; i < size; i++) {
                int index = q.poll();

                int leftIndex = 2 * index + 1, rightIndex = 2 * index + 2;

                if(leftIndex < getSize()) {
                    q.offer(leftIndex);
                }

                if(rightIndex < getSize()) {
                    q.offer(rightIndex);
                }

                subset.add(heap.get(index));
            }

            res.add(subset);
        }
        return res;
    }

    public void printHeap() {        
        System.out.println(getHeap());
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }
}