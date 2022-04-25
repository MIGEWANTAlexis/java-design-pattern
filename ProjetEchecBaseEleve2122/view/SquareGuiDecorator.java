package view;

import java.util.Arrays;

import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.paint.Color;
import shared.GUICoord;

public class SquareGuiDecorator implements ChessSquareGui {
	
	public SquareGui squareGui;
	
	
	public SquareGuiDecorator(SquareGui squareGui) {
		super();
		this.squareGui = squareGui;
		GuiConfig.paintStyle.addListener(new ChangeListener<PaintStyle>() {
			@Override
			public void changed(ObservableValue<? extends PaintStyle> observable, PaintStyle oldValue, PaintStyle newValue) {
				squareGui.paint();
			}
		});
		
		for(ObjectProperty<Color> color : Arrays.asList(GuiConfig.whiteSquareColor, GuiConfig.blackSquareColor)) {
			color.addListener(new ChangeListener<Color>() {
				@Override
				public void changed(ObservableValue<? extends Color> arg0, Color arg1, Color arg2) {
					squareGui.paint();
				}
			});
		}
	}

	@Override
	public GUICoord getCoord() {
		return squareGui.getCoord();
	}

	@Override
	public void resetColor(boolean isLight) {
		squareGui.resetColor(isLight);
	}

	@Override
	public void paint() {
		squareGui.paint();
	}

}
