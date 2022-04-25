package command.conversation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Consumer;

public class Stack<T> {
	private final Deque<T> stack = new ArrayDeque<>();
	
	public T pop() {
		return stack.pollLast();
	}
	
	public void push(T cmd) {
		stack.addLast(cmd);
	}

	public void clear() {
		stack.clear();
	}
	
	public void forEachFifo(Consumer<? super T> action) {
		stack.stream().forEachOrdered(action);
	}

	@Override
	public String toString() {
		return stack.toString();
	}
}
