import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class MaxHeapTest {
    @Test
    public void testIsEmpty() {
        MaxHeap heap = new MaxHeap();
        assertTrue(heap.isEmpty());

        heap.insert(new Task(1, "Task 1"));
        assertFalse(heap.isEmpty());
    }

    @Test
    public void testInsert() {
        MaxHeap heap = new MaxHeap();
        heap.insert(new Task(2, "Task 2"));
        heap.insert(new Task(1, "Task 1"));

        // Check the heap array
        Task[] heapArray = heap.getHeap();
        assertEquals(2, heapArray.length);
        assertEquals(2, heapArray[0].getPriority());
        assertEquals(1, heapArray[1].getPriority());
    }

    @Test
    public void testExtractMax1() {
        MaxHeap heap = new MaxHeap();
        heap.insert(new Task(2, "Task 2"));
        heap.insert(new Task(1, "Task 1"));

        assertEquals(2, heap.extractMax().getPriority());
        assertEquals(1, heap.extractMax().getPriority());
    }

    @Test
    public void testExtractMax2() {
        MaxHeap heap = new MaxHeap();
        heap.insert(new Task(3, "Task 3"));
        heap.insert(new Task(2, "Task 2"));
        heap.insert(new Task(1, "Task 1"));

        assertEquals(3, heap.extractMax().getPriority());
        assertEquals(2, heap.extractMax().getPriority());
        assertEquals(1, heap.extractMax().getPriority());
    }

    @Test
    public void testIncreaseKey1() {
        MaxHeap heap = new MaxHeap();
        heap.insert(new Task(2, "Task 2"));
        heap.insert(new Task(1, "Task 1"));

        heap.increaseKey(1, 3);

        // Check the heap array
        Task[] heapArray = heap.getHeap();
        assertEquals(2, heapArray.length);
        assertEquals(3, heapArray[0].getPriority());
        assertEquals(2, heapArray[1].getPriority());
    }

    @Test
    public void testIncreaseKey2() {
        MaxHeap heap = new MaxHeap();
        heap.insert(new Task(3, "Task 3"));
        heap.insert(new Task(2, "Task 2"));
        heap.insert(new Task(1, "Task 1"));

        heap.increaseKey(2, 4);

        // Check the heap array
        Task[] heapArray = heap.getHeap();
        assertEquals(3, heapArray.length);
        assertEquals(4, heapArray[0].getPriority());
        assertEquals(3, heapArray[1].getPriority());
        assertEquals(2, heapArray[2].getPriority());
    }

    @Test
    public void testCheckIfMaxHeap() {
        MaxHeap heap = new MaxHeap();
        heap.insert(new Task(3, "Task 3"));
        heap.insert(new Task(2, "Task 2"));
        heap.insert(new Task(1, "Task 1"));

        assertTrue(checkIfMaxHeap(heap.getHeap()));
    }

    @Test
    public void testCheckIfSorted() {
        Task[] array = { new Task(3, "Task 3"), new Task(2, "Task 2"), new Task(1, "Task 1") };
        assertTrue(checkIfSorted(array));
    }

    @Test
    public void testInsertAscending() {
        MaxHeap heap = new MaxHeap();
        for (int i = 1; i <= 5; i++) {
            heap.insert(new Task(i, "Task " + i));
        }

        assertTrue(checkIfMaxHeap(heap.getHeap()));
        assertTrue(checkIfSorted(extractAll(heap)));
    }

    @Test
    public void testInsertDescending() {
        MaxHeap heap = new MaxHeap();
        for (int i = 5; i >= 1; i--) {
            heap.insert(new Task(i, "Task " + i));
        }

        assertTrue(checkIfMaxHeap(heap.getHeap()));
        assertTrue(checkIfSorted(extractAll(heap)));
    }

    @Test
    public void testInsertRandom() {
        MaxHeap heap = new MaxHeap();
        for (int i = 1; i <= 5; i++) {
            heap.insert(new Task((int) (Math.random() * 10) + 1, "Task " + i));
        }

        assertTrue(checkIfMaxHeap(heap.getHeap()));
        assertTrue(checkIfSorted(extractAll(heap)));
    }

    // Helper methods
    private Task[] extractAll(MaxHeap heap) {
        int size = heap.getSize();
        Task[] extracted = new Task[size];
        for (int i = 0; i < size; i++) {
            extracted[i] = heap.extractMax();
        }
        return extracted;
    }
	
	private static boolean checkIfMaxHeap(Task[] h) {
		for (int i = 0; i < h.length/2; i++) {
			int left = i * 2 + 1;
			int right = i * 2 + 2; 
			if ((left < h.length) && (h[i].compareTo(h[left]) < 0)) {
				System.out.println("checkIfMaxHeap failed!");
				return false;
			}
			if ((right < h.length) && (h[i].compareTo(h[right]) < 0)) {
				System.out.println("checkIfMaxHeap failed!");
				return false;
			}
		}
		System.out.println("checkIfMaxHeap passed!");
		return true;
	}

	private static boolean checkIfSorted(int[] output) {
		for (int i = 0; i < output.length - 1; i++) {
			if (output[i] < output[i+1]) {
				System.out.println("checkIfSorted failed!");
				return false;
			}
		}
		System.out.println("checkIfSorted passed!");
		return true;
	}
}