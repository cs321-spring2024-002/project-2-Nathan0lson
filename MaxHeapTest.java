import static org.junit.Assert.*;

import org.junit.Test;

public class MaxHeapTest {
    @Test
    public void testIsEmpty() {
        MaxHeap heap = new MaxHeap();
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testIsNotEmpty() {
        MaxHeap heap = new MaxHeap();
        heap.insert(new Task(1, TaskInterface.TaskType.FEEDING, 0, "task"));
        assertFalse(heap.isEmpty());
    }

    @Test
    public void testInsert() {
        MaxHeap heap = new MaxHeap();
        heap.insert(new Task(1, TaskInterface.TaskType.FEEDING, 0, "task1"));
        heap.insert(new Task(2, TaskInterface.TaskType.FISHING, 0, "task2"));

        assertEquals(heap.extractMax().getTaskType(), TaskInterface.TaskType.FISHING);
        assertEquals(heap.extractMax().getTaskType(), TaskInterface.TaskType.FEEDING);
    }

    @Test
    public void testExtractMax1() {
        MaxHeap heap = new MaxHeap();
        heap.insert(new Task(1, TaskInterface.TaskType.FEEDING, 0, "task1"));
        heap.insert(new Task(2, TaskInterface.TaskType.FISHING, 0, "task2"));

        assertEquals(heap.extractMax().getTaskType(), TaskInterface.TaskType.FISHING);
        assertEquals(heap.extractMax().getTaskType(), TaskInterface.TaskType.FEEDING);
    }

    @Test
    public void testExtractMax2() {
        MaxHeap heap = new MaxHeap();
        heap.insert(new Task(1, TaskInterface.TaskType.FEEDING, 0, "task1"));
        heap.insert(new Task(2, TaskInterface.TaskType.FISHING, 0, "task2"));
        heap.insert(new Task(3, TaskInterface.TaskType.FARM_MAINTENANCE, 0, "task3"));

        assertEquals(heap.extractMax().getTaskType(), TaskInterface.TaskType.FARM_MAINTENANCE);
        assertEquals(heap.extractMax().getTaskType(), TaskInterface.TaskType.FISHING);
        assertEquals(heap.extractMax().getTaskType(), TaskInterface.TaskType.FEEDING);
    }

    @Test
    public void testIncreaseKey1() {
        MaxHeap heap = new MaxHeap();
        heap.insert(new Task(1, TaskInterface.TaskType.FEEDING, 0, "task1"));
        heap.insert(new Task(2, TaskInterface.TaskType.FISHING, 0, "task2"));

        heap.increaseKey(1, 3);

        assertEquals(heap.extractMax().getTaskType(), TaskInterface.TaskType.FEEDING);
        assertEquals(heap.extractMax().getTaskType(), TaskInterface.TaskType.FISHING);
    }

    @Test
    public void testIncreaseKey2() {
        MaxHeap heap = new MaxHeap();
        heap.insert(new Task(1, TaskInterface.TaskType.FEEDING, 0, "task1"));
        heap.insert(new Task(2, TaskInterface.TaskType.FISHING, 0, "task2"));
        heap.insert(new Task(3, TaskInterface.TaskType.FARM_MAINTENANCE, 0, "task3"));

        heap.increaseKey(2, 4);

        assertEquals(heap.extractMax().getTaskType(), TaskInterface.TaskType.FISHING);
        assertEquals(heap.extractMax().getTaskType(), TaskInterface.TaskType.FARM_MAINTENANCE);
        assertEquals(heap.extractMax().getTaskType(), TaskInterface.TaskType.FEEDING);
    }

    @Test
    public void testInsertAscending() {
        MaxHeap heap = new MaxHeap();
        heap.insert(new Task(1, TaskInterface.TaskType.FEEDING, 0, "task1"));
        heap.insert(new Task(2, TaskInterface.TaskType.FISHING, 0, "task2"));
        heap.insert(new Task(3, TaskInterface.TaskType.FARM_MAINTENANCE, 0, "task3"));
        heap.insert(new Task(4, TaskInterface.TaskType.FORAGING, 0, "task4"));
        heap.insert(new Task(5, TaskInterface.TaskType.MINING, 0, "task5"));

        assertTrue(checkIfMaxHeap(heap.getHeap()));
        assertTrue(checkIfSorted(extractAll(heap)));
    }

    @Test
    public void testInsertDescending() {
        MaxHeap heap = new MaxHeap();
        heap.insert(new Task(5, TaskInterface.TaskType.FEEDING, 0, "task1"));
        heap.insert(new Task(4, TaskInterface.TaskType.FISHING, 0, "task2"));
        heap.insert(new Task(3, TaskInterface.TaskType.FARM_MAINTENANCE, 0, "task3"));
        heap.insert(new Task(2, TaskInterface.TaskType.FORAGING, 0, "task4"));
        heap.insert(new Task(1, TaskInterface.TaskType.MINING, 0, "task5"));

        assertTrue(checkIfMaxHeap(heap.getHeap()));
        assertTrue(checkIfSorted(extractAll(heap)));
    }

    @Test
    public void testInsertRandom() {
        MaxHeap heap = new MaxHeap();
        heap.insert(new Task(3, TaskInterface.TaskType.FEEDING, 0, "task1"));
        heap.insert(new Task(1, TaskInterface.TaskType.FISHING, 0, "task2"));
        heap.insert(new Task(2, TaskInterface.TaskType.FARM_MAINTENANCE, 0, "task3"));
        heap.insert(new Task(5, TaskInterface.TaskType.FORAGING, 0, "task4"));
        heap.insert(new Task(4, TaskInterface.TaskType.MINING, 0, "task5"));

        assertTrue(checkIfMaxHeap(heap.getHeap()));
        assertTrue(checkIfSorted(extractAll(heap)));
    }

    // Helper methods
    private Task[] extractAll(MaxHeap heap) {
        int size = heap.size;
        Task[] extracted = new Task[size];
        for (int i = 0; i < size; i++) {
            extracted[i] = heap.extractMax();
        }
        return extracted;
    }

    private static boolean checkIfMaxHeap(Task[] h) {
        for (int i = 0; i < h.length; i++) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            if (h[i] != null && h[left] != null && h[right] != null) {
                if (h[i].compareTo(h[left]) < 0) {
                    System.out.println("checkIfMaxHeap failed!");
                    return false;
                }
                if (h[i].compareTo(h[right]) < 0) {
                    System.out.println("checkIfMaxHeap failed!");
                    return false;
                }
            }
        }
        System.out.println("checkIfMaxHeap passed!");
        return true;
    }

    private static boolean checkIfSorted(Task[] h) {
        for (int i = 0; i < h.length-1; i++) {
            if (h[i].compareTo(h[i+1]) < 0) {
                System.out.println("checkIfSorted failed!");
                return false;
            }
        }
        System.out.println("checkIfSorted passed!");
        return true;
    }
}