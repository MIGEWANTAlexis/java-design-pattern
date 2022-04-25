package command.conversation;

import command.Command;

public abstract class AbstractConversation<C extends Command, S> implements Conversation<C> {
	protected final Stack<S> undos, redos;
	
	public AbstractConversation() {
		this.undos = new Stack<S>();
		this.redos = new Stack<S>();
	}

	@Override 
	public String toString() {
		return String.format(
			"%s{undos:%s, redos:%s}", 
			getClass().getSimpleName(), 
			undos, 
			redos
		);
	}
}
