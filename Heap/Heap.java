
import java.util.*;

public class Heap{
    private int heapSize;
    private final ArrayList<Integer> heap;


    public Heap() {
        heapSize = 0;
        heap = new ArrayList();
    }

    public Heap(int k) {
        heapSize = 0;
        heap = new ArrayList();
    }
 
    public void insert(int val) {
        heap.add(val);
        heapSize++;

        heapifyUp(heapSize - 1);
    }

    private void heapifyUp(int index) {
        if(index == 0) {
            return;
        }
        int parent = (index - 1) / 2;

        if(heap.get(parent) < heap.get(index)) {

            swap(parent, index);
            heapifyUp(parent);
        }
    } 

    public ArrayList<ArrayList<Integer>> printHeap() {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        q.offer(0);

        while(!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> subset = new ArrayList();

            for (int idx = 0; idx < size; idx++) {
                int parent = q.poll();
                subset.add(parent);
                int leftChild = 2 * parent + 1, rightChild = 2 * parent + 2;
                
                if(leftChild < heapSize) {
                    q.offer(leftChild);
                }

                if(rightChild < heapSize) {
                    q.offer(rightChild);
                }
            }

            res.add(subset);
        }

        return res;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
            heap.set(index1, heap.get(index2));
            heap.set(index2, temp);
    }
    
    public int peek() {
        if(heapSize == 0) throw new Error("heap is Empty");
        
        return heap.get(0);
    }

    public int pop(){
        int popped = heap.get(0);
        heap.set(0, heap.get(heapSize - 1));
        heapSize--;

        if(heapSize != 0)
            heapifyDown(0);

        return popped;
    }

    private void heapifyDown(int parent){
        if(parent >= heapSize) return;

        int leftChild = 2 * parent + 1, rightChild = 2 * parent + 2;

        if(leftChild < heapSize && heap.get(leftChild) > heap.get(parent)) {
            swap(leftChild, parent);
            parent = leftChild;
        }

        else if(rightChild < heapSize && heap.get(rightChild) > heap.get(parent)) {
            swap(rightChild, parent);
            parent = rightChild;
        }

        heapifyDown(parent);
    }
}