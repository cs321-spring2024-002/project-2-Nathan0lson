public class MyPriorityQueue extends MaxHeap implements PriorityQueueInterface {

	@Override
	public void enqueue(Object task) {
		super.add(task); // call the add method from the parent MaxHeap class
	}

	@Override
	public Task dequeue() {
		return (Task) super.removeMax(); // cast the returned object from the parent MaxHeap class to Task
	}

	@Override
	public boolean isEmpty() {
		return super.isEmpty(); // call the isEmpty method from the parent MaxHeap class
	}

	@Override
	public void update(int timeToIncrementPriority, int maxPriority) {
		for (int i = 0; i < super.size(); i++) { // loop through all elements in the queue
			Task task = (Task) super.get(i); // cast the object to Task
			int waitingTime = task.getWaitingTime(); // get the time since the task was added
			if (waitingTime >= timeToIncrementPriority && task.getPriority() < maxPriority) {
				task.setPriority(task.getPriority() + 1); // increase the priority of the task
			}
		}
		super.rebuildHeap(); // rebuild the heap after updating the priorities
	}
}