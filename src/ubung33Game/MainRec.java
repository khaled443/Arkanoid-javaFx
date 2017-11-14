package ubung33Game;

import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class MainRec {
	Arkanoid game=new Arkanoid();
	 private double stepX; //
	 private double stepY;
	 private Rectangle rec; //reference on a circle

	 public MainRec(){
		 rec = new Rectangle(360, 450,90, 8);
		 rec.setFill(Color.WHITE);
		 rec.setTranslateX(0);
		 game.group.getChildren().add(rec);
		 
	 
	 }
	public double getStepX() {
		return stepX;
	}
	public void setStepX(double stepX) {
		this.stepX = stepX;
	}
	public double getStepY() {
		return stepY;
	}
	public void setStepY(double stepY) {
		this.stepY = stepY;
	}
	public Rectangle getRec() {
		return rec;
	}
	public void setRec(Rectangle rec) {
		this.rec = rec;
	}
	 
}
