package command.compensation;

import command.Command;

public interface CompensableCommand extends Command  {
	void compensate();
}
