import java.util.ArrayList;

public class NotationStack<T> implements StackInterface<T> {

	private int top;
	private T[] data;

	public NotationStack(int size) {
		data = (T[]) new Object[size];
		top = -1;
	}

	public NotationStack() {

		data = (T[]) new Object[20];
		top = -1;
	}

	public NotationStack(ArrayList<T> list) {
		data = (T[]) new Object[list.size()];
		top = -1;
		for (int i = 0; i < list.size(); i++) {
			data[i] = (T) list.get(i);
			top++;
		}
	}

	@Override
	public boolean isEmpty() {
		if (top == -1)
			return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if (top == data.length - 1)
			return true;
		return false;
	}

	@Override
	public T pop() throws StackUnderflowException {
		T element;
		if (!isEmpty()) {
			element = data[top];
			data[top] = null;
			top--;

			return element;
		} else
			throw new StackUnderflowException();
	}

	@Override
	public T top() throws StackUnderflowException {
		T element;
		if (!isEmpty())
			element = data[top];
		else
			throw new StackUnderflowException();

		return element;
	}

	@Override
	public int size() {

		return top + 1;
	}

	@Override
	public boolean push(T e) throws StackOverflowException {
		if (!isFull()) {
			data[top + 1] = e;
			top++;
			return true;
		} else
			throw new StackOverflowException();
	}

	@Override
	public String toString() {
		String str = "";
		for (T e : data) {
			if (e == null)
				return str;
			str += e;
		}
		return str;
	}

	@Override
	public String toString(String delimiter) {
		String str = "";
		for (int i = 0; i < size(); i++) {

			if (i == size() - 1)
				return str + data[i];

			str += data[i] + delimiter;

		}
		return str;
	}
}
