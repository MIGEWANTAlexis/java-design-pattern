package command.choiceStyle;

import command.compensation.CompensableCommand;
import view.GuiConfig;
import view.PaintStyle;

public class ChoiceStyle implements CompensableCommand {
	
	private PaintStyle backup;

	@Override
	public void execute() {
		backup = GuiConfig.paintStyle.get();
		if (backup == PaintStyle.SOLID) {
			GuiConfig.paintStyle.set(PaintStyle.GRADIENT);
		} else {
			GuiConfig.paintStyle.set(PaintStyle.SOLID);
		}
	}

	@Override
	public void compensate() {
		GuiConfig.paintStyle.set(backup);	
	}
}
