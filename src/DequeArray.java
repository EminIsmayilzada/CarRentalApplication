import java.util.Arrays;
import java.util.NoSuchElementException;

public class DequeArray<T> implements DequeInterface<T> {
	private T[] deque;
	private int frontIndex;
	private int backIndex;
	private static final int DEFAULT_CAPACITY=50000;

	
	public DequeArray() {
		this(DEFAULT_CAPACITY);
		
		}
	@SuppressWarnings("unchecked")
	public DequeArray(int capacity) {
		deque =(T[]) new Object[capacity];
		frontIndex = 0;
        backIndex = capacity -1;
		
	}
	@Override
	public void addToBack(T newEntry) {
		ensureCapacity();
		backIndex=(backIndex + 1) % deque.length;
		deque [backIndex]= newEntry;
		
	}
	@Override
	public void addToFront(T newEntry) {
		if (backIndex== deque.length-1) {
            ensureCapacity();
        }
        frontIndex = (frontIndex-1+deque.length)%deque.length;
        deque[frontIndex] = newEntry;
    }
		
	
	@Override
	public T removeFront() {
		if (isEmpty())
			throw new NoSuchElementException();
		T front = deque[frontIndex];
		deque[frontIndex]=null;
		frontIndex=(frontIndex+1)%deque.length;
		return front;
	}
	@Override
	public T removeBack() {
		if (isEmpty())
			throw new NoSuchElementException();
		T back = deque[backIndex];
		deque[backIndex]= null;
		backIndex=(backIndex-1)%deque.length;
		return back;
	}
	@Override
	public T getFront() {
		if (isEmpty())
			return null;
		else 
		return deque[frontIndex];
	}
	@Override
	public T getBack() {
		if (isEmpty())
			return null;
		else 
		return deque[backIndex];
	}
	@Override
	public boolean isEmpty() {
		return frontIndex==( (backIndex + 1) % deque.length) ;
	}
	@Override
	public void clear() {
		Arrays.fill(deque, null);
        frontIndex = -1;
        backIndex = -1;
		
	}
	private void ensureCapacity() {
		if (frontIndex== ( (backIndex + 2) % deque. length)) {
		T [] oldQueue = deque;
		int oldSize = oldQueue.length;
		int newSize =2 * oldSize;
		@SuppressWarnings("unchecked")
		T [ ] tempQueue = (T []) new Object [newSize] ;
		deque= tempQueue;}
		}
	}
	
	

