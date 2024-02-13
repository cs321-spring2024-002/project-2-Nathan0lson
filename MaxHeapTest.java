import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class MaxHeapTest {
  
  @Test
  public void testInsertion() {
    MaxHeap<Integer> heap = new MaxHeap<Integer>();
    heap.insert(5);
    heap.insert(3);
    heap.insert(8);
    heap.insert(1);
    heap.insert(6);
    heap.insert(9);
    
    assertEquals(new Integer(9), heap.getMax());
  }
  
  @Test
  public void testSorting() {
    MaxHeap<Integer> heap = new MaxHeap<Integer>();
    heap.insert(5);
    heap.insert(3);
    heap.insert(8);
    heap.insert(1);
    heap.insert(6);
    heap.insert(9);
    
    Integer[] sortedArray = {9, 8, 6, 5, 3, 1};
    Integer[] extractedArray = new Integer[sortedArray.length];
    for (int i = 0; i < extractedArray.length; i++) {
      extractedArray[i] = heap.extractMax();
    }
    
    assertTrue(Arrays.equals(sortedArray, extractedArray));
  }
}