package ubung33Game;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Details {
	Arkanoid game = new Arkanoid();
	int lives;
	int  score;
	Label labelLives;
	Label labelScore;

	public Details(int lives , int score){
		this.lives=lives;
		this.score=score;
		generator();
		livesMethode(lives);
		scoreMethode(score);
		
	}
	
	private void generator() {
		
	Rectangle rec = new Rectangle(80,8);
	rec.setFill(Color.WHITE);
	rec.setX(25);
	rec.setY(22);
	
	game.groupDetails.getChildren().add(rec);
	
			
		
		
	}
	
	private void livesMethode(int lives){
		this.lives=lives;
		
		labelLives = new Label(" x "+Integer.toString(lives));
		labelLives.setTranslateY(17);
		labelLives.setTranslateX(110);
		
		labelLives.setTextFill(Color.WHITE);
		game.groupDetails.getChildren().add(labelLives);
	}

	private void scoreMethode(int score){
		this.score=score;
		labelLives= new Label("Score : " + Integer.toString(score));
		labelLives.setTranslateX(700);
		labelLives.setTranslateY(17);
		labelLives.setTextFill(Color.WHITE);
		
		game.groupDetails.getChildren().add(labelLives );	
		
		
	}
	
	
	

}
