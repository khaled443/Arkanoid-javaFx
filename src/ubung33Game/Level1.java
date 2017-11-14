package ubung33Game;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Level1 {
	
	Arkanoid game = new Arkanoid();
    public static  List<Rectangle> recs = new ArrayList<Rectangle>();
    
	public Level1(){
		for (int i = 0; i < 11; i++) {
			recs.add(new Rectangle(60,20));
			recs.get(i).setX(i*70+25);
			recs.get(i).setY(100);
			recs.get(i).setFill(Color.DARKKHAKI);

		}	
		for (Rectangle rectangle : recs) {
			game.groupLevel.getChildren().add(rectangle);

		}
		
	}

}
