package model.noStrategy.pieces;

import shared.ModelCoord;
import shared.PieceSquareColor;

public class PionBlanc extends AbstractPion {

	public PionBlanc(PieceSquareColor pieceSquareColor, ModelCoord coord) {
		super(pieceSquareColor, coord);
	}

	@Override
	public boolean pionMovement(int yFinal) {
		return yFinal - this.getY() < 0;
	}

	@Override
	public boolean getTakingPion(int xFinal, int yFinal) {
		boolean ret = false;

		if ((yFinal == this.getY()-1 && xFinal == this.getX()+1) 
				|| (yFinal == this.getY()-1 && xFinal == this.getX()-1)) {
			ret = true;
		}
		return ret;
	}
	
}
