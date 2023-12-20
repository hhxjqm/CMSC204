import java.util.ArrayList;

public class NotationQueue<T> implements QueueInterface<T>{

	private int front, rear;
	private T[] data;
	
	public NotationQueue(int size) {
		data = (T[]) new Object[size];
		front = -1;
		rear = -1;
	}
	
	public NotationQueue() {
		data = (T[]) new Object[20];
		front = -1;
		rear = -1;
	}
	
	public NotationQueue(ArrayList list) {
		data = (T[]) new Object[list.size()];
		front = 0;
		rear = -1;
		for (int i = 0; i < list.size(); i++) {
			data[i] = (T) list.get(i);
			
		
			rear++;
		}
	}
	
	
	@Override
	public boolean isEmpty() {
		if(front > rear)
			return true;
		else
			return false;
	}

	@Override
	public boolean isFull() {
		
		if(front > rear) {
			if (front -1 == rear)
				return true;
			else
				return false;
		}
		
		if(rear-front == data.length-1)
			return true;
		else
			return false;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T element;
		if(isEmpty())
			throw new QueueUnderflowException();
		else {
			element = data[front];
			data[front] = null;
			front = (front +1) % data.length;
		}
		return element;
	}

	@Override
	public int size() {
		
		return rear-front+1;
	}

	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if(isFull()) 
			throw new QueueOverflowException();
		else {
			data[rear+1] = e;
			rear = (rear + 1) % data.length;
			if(front == -1)
				front = 0;
			return true;
		}
		
	}

	@Override
	public String toString() {
		   String str = "";
	        for (T e : data) {
	        	if(e == null) 
	        	   return str;
	            str += e;
	        }
	        return str;
	}
	
	@Override
	public String toString(String delimiter) {
		String str = "";
        for(int i = 0; i < size(); i++) {
        	
        		if(i == size()-1)
        			return str + data[ (front+i)% size() ];
        	
        		str += data[(front+i)% size()] + delimiter;
        	
        }
        return str;
	}

	@Override
	public void fill(ArrayList<T> list) {
		for (int i = 0; i < list.size(); i++) {
			data[i] = list.get(i);
		}
		
	}

}
