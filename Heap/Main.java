public class Main{
    public static void main(String[] args) {
        Heap heap = new Heap();

        for(int index = 0; index < 10; index++)
            heap.insert(index);
        
        System.err.println(heap.printHeap());
        // System.out.println(heap.peek());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.err.println(heap.printHeap());
    }

}