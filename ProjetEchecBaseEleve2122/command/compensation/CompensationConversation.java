package command.compensation;

import command.conversation.AbstractConversation;

public class CompensationConversation extends AbstractConversation<CompensableCommand, CompensableCommand> {

	@Override
	public void exec(CompensableCommand cmd) {
		cmd.execute();
		undos.push(cmd);
		redos.clear();
	}

	@Override
	public void undo() {
		CompensableCommand latestCmd = undos.pop();
		if (latestCmd == null) return; 
		latestCmd.compensate();
		redos.push(latestCmd);
	}

	@Override
	public void redo() {
		CompensableCommand latestCmd = redos.pop();
		if (latestCmd == null) return; 
		latestCmd.execute();
		undos.push(latestCmd);
	}

}
