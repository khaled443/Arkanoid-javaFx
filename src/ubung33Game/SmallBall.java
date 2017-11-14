package ubung33Game;



import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class SmallBall {

	Arkanoid game=new Arkanoid();
	 private double stepX; //
	 private double stepY;
	 private Ellipse c; //reference on a circle
	 boolean isStarted=false;
	 
	public SmallBall(){
		
		Ellipse ball = new Ellipse(400.0, 440.0, 6.0, 6.0);
		ball.setStrokeWidth(1);
		ball.setFill(Color.GOLDENROD);
		MovingEllipse(ball, 0, -4);

		game.group.getChildren().add(ball);
				
	}
	
    
	public boolean isStarted() {
		return isStarted;
	}
	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}

	public void   MovingEllipse(Ellipse c, double dx, double dy){
        this.c = c;
        stepX = dx;
        stepY = dy;
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
    public Ellipse getEllipse() {
        return c;
    }
    public void setEllipse(Ellipse c) {
        this.c = c;
    }
    double getDistance(Ellipse e){
        double x = c.getCenterX() - e. getCenterX();
        double y = c.getCenterY() - e. getCenterY();
        return Math.sqrt(x * x + y * y);
    }
    double getDistance(double coordX, double coordY){
        double x = c.getCenterX() - coordX;
        double y = c.getCenterY() - coordY;
        return Math.sqrt(x * x + y * y);
    }
}
