package command.choiceStyle;

import command.compensation.CompensableCommand;
import javafx.beans.property.ObjectProperty;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class ChoiceColor implements CompensableCommand {
	
	private Color backup;
	
	private ColorPicker colorPicker;
	private ObjectProperty<Color> color;

	public ChoiceColor(ObjectProperty<Color> color) {
		this.color = color;
		this.colorPicker = new ColorPicker(color.get());
	}

	@Override
	public void execute() {
		backup = colorPicker.getValue();
		color.set(colorPicker.getValue());
	}

	@Override
	public void compensate() {
		color.set(backup);
	}

}
