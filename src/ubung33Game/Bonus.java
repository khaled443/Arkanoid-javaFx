package ubung33Game;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class Bonus {
	Arkanoid game = new Arkanoid();
    private Node  n;
    int number;
    double stepX;
    double stepY;
    
    
    public Bonus(int number , double x , double y){
    	if (number==1) {
    		liveGenerater(x , y);
			
		}else if (number ==2) {
			scoreGenerator(x , y );
			
		}
    }
    
    
    
    private void liveGenerater(double x , double y){
    	  Image heartImage = new Image("file:heart.png");
          n = new ImageView(heartImage);
          n.setTranslateX(x);
          n.setTranslateY(y);
          MovingNodes(n, 0, 10);
    	
          game.groupBonus.getChildren().add(n);

    }
    private void scoreGenerator(double x , double y){
	  	  Image heartImage = new Image("file:plus.png");
	      n = new ImageView(heartImage);
	      n.setTranslateX(x);
	      n.setTranslateY(y);
	      MovingNodes(n, 0, 10);
	
      game.groupBonus.getChildren().add(n);
    	
    }
    public void   MovingNodes(Node n, double setpX, double setpY){
        this.n = n;
        this.stepX = stepX;
        this.stepY = stepX;
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
    public Node getNode() {
        return n;
    }
    public void setNode(Ellipse c) {
        this.n = n;
    }

}
