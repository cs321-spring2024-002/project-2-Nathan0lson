public class MyPriorityQueue extends MaxHeap implements PriorityQueueInterface {
	@Override
	public void enqueue(Task task) {
		super.insert(task);
	}

	@Override
	public Task dequeue() {
		return super.extractMax(); // cast the returned object from the parent MaxHeap class to Task
	}

	@Override
	public boolean isEmpty() {
		return super.isEmpty(); // call the isEmpty method from the parent MaxHeap class
	}

	@Override
	public void update(int timeToIncrementPriority, int maxPriority) {
		for(int i = 0; i < size; i++) {
			Task task = heap[i];
			task.incrementWaitingTime();
			if (task.getWaitingTime() >= timeToIncrementPriority) {
				task.resetWaitingTime();
				if (task.getPriority() < maxPriority) {
					task.setPriority(task.getPriority() + 1);
					increaseKey(i, task.getPriority());
				}
			}
		}
	}
}