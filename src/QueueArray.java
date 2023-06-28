import java.util.Arrays;
import java.util.NoSuchElementException;
public class QueueArray<T> implements QueueInterface <T> {
	private T[] queue;
	private int frontIndex;
	private int backIndex;
	private static final int DEFAULT_CAPACITY=500000;
	@SuppressWarnings("unchecked")
	public QueueArray() {
		this.queue= (T[]) new Object[DEFAULT_CAPACITY];
		this.frontIndex = 0;
        this.backIndex = -1;
		}
	 @SuppressWarnings("unchecked")
	public QueueArray(int capacity) {
	        this.queue = (T[]) new Object[capacity];
	        this.frontIndex = 0;
	        this.backIndex = -1;
	 }
	 
	 @Override 
	public void enqueue(T newEntry) {
		ensureCapacity();
		backIndex=(backIndex + 1) % queue.length;
		queue [backIndex]= newEntry;
		
		
	}
	private void ensureCapacity() {
		if (frontIndex== ( (backIndex + 2) % queue. length)) {
		T [] oldQueue = queue;
		int oldSize = oldQueue.length;
		int newSize =2 * oldSize;
		@SuppressWarnings("unchecked")
		T [ ] tempQueue = (T []) new Object [newSize] ;
		queue= tempQueue;}
		
	}
	@Override
	public T dequeue() {
		if (isEmpty())
			return null;
		else {
			T front = queue[frontIndex];
			queue[frontIndex]=null;
			frontIndex=(frontIndex+1)%queue.length;
			return front;
			
			}			
		}
			
	@Override
	public T getFront()   {
		if (isEmpty())
			return null;
		else 
			return queue[frontIndex];
		}
	
	@Override
	public boolean isEmpty() {
		return frontIndex==( (backIndex + 1) % queue. length) ;
	   }
	@Override
	public void clear() {
		Arrays.fill(queue, null);
		this.frontIndex = 0;
        this.backIndex = -1;
	}

    public int size() {
        if (isEmpty()) {
            return 0;
        } else if (frontIndex <= backIndex) {
            return backIndex - frontIndex + 1;
        } else {
            return queue.length - frontIndex + backIndex + 1;
        }
    }
	}



