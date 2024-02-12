public class MaxHeap {

    private Task[] heap;
    private int size;

    public MaxHeap() {
        heap = new Task[10];
        size = 0;
    }

    public MaxHeap(Task[] tasks) {
        heap = tasks;
        size = tasks.length;
        buildMaxHeap();
    }

    public void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest;
        if (l < size && heap[l].getKey() > heap[i].getKey()) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < size && heap[r].getKey() > heap[largest].getKey()) {
            largest = r;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    public Task max() {
        return heap[0];
    }

    public Task extractMax() {
        if (size < 1) {
            return null;
        }
        Task max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return max;
    }

    public void insert(Task task) {
        if (size == heap.length) {
            Task[] newHeap = new Task[heap.length * 2];
            System.arraycopy(heap, 0, newHeap, 0, heap.length);
            heap = newHeap;
        }
        int i = size;
        size++;
        while (i > 0 && heap[parent(i)].getKey() < task.getKey()) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = task;
    }

    public void increaseKey(int i, int key) {
        if (key < heap[i].getKey()) {
            return;
        }
        heap[i].setKey(key);
        while (i > 0 && heap[parent(i)].getKey() < heap[i].getKey()) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void buildMaxHeap() {
        for (int i = parent(size - 1); i >= 0; i--) {
            heapify(i);
        }
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        Task temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}