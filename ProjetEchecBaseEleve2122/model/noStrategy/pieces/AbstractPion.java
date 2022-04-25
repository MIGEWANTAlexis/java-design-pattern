package model.noStrategy.pieces;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import model.ModelFactory;
import shared.ActionType;
import shared.ModelCoord;
import shared.PieceSquareColor;

public abstract class AbstractPion extends AbstractPiece {

	public AbstractPion(PieceSquareColor pieceSquareColor, ModelCoord coord) {
		super(pieceSquareColor, coord);
	}
	
	public abstract boolean pionMovement(int yFinal);
	
	public abstract boolean getTakingPion(int xFinal, int yFinal);

	@Override
	public boolean isAlgoMoveOk(ModelCoord finalCoord, ActionType actionType) {
		int xFinal = finalCoord.getCol() -'a';
		int yFinal = 8 - finalCoord.getLigne();


		if (actionType == ActionType.TAKE) {
			// Déplacement d'1 case en diagonale avec prise
			return getTakingPion(xFinal, yFinal);
		}
		
		// Déplacement vertical sans prise  
		// d'1 case si le pion a déjà bougé, de 2 cases sinon
		// vers le haut ou vers le bas selon sa couleur
		if ((xFinal == this.getX()) && (Math.abs(yFinal - this.getY()) <= 1 || (Math.abs(yFinal - this.getY()) <= 2 && !this.hasMoved()))) {
			return pionMovement(yFinal);
		}
		
		return false;
	}

	@Override
	public List<ModelCoord> getMoveItinerary(ModelCoord finalCoord) {
		int yFinal = 8 - finalCoord.getLigne();
		int yEtape = (this.getY() + yFinal) / 2; // Y est la ligne entre départ et arrivée
		List<ModelCoord> ret = Collections.emptyList();
		ModelCoord coordEtape = new ModelCoord((char)('a'+this.getX()), (8-yEtape)); // et X est dans la même colonne
		if (this.getY() == yFinal - 2 || this.getY() == yFinal + 2) {
			ret = new LinkedList<ModelCoord>();
			ret.add(coordEtape);
		}
		return ret;
	}
	
	@Override
	public ActionType doMove(ModelCoord finalCoord){
		ActionType ret = ActionType.UNKNOWN;
		ret = super.doMove(finalCoord);

		if(this.getY() == ModelFactory.nbLigne.get()-1 || this.getY() == 0) {
			ret = ActionType.PROMOTION;
		}
		return ret;
	}
	


}
