package ubung33Game;


import java.util.Optional;
import java.util.Random;

import javax.swing.plaf.PanelUI;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Arkanoid extends Application{
	
	public static Group group = new Group();
	public static Group groupDetails = new Group();
	public static Group groupLevel = new Group();
	public static Group groupBonus = new Group();
    boolean running,  goEast, goWest , started;
    int counter=0;
    int levelCounter=0;
    SmallBall ball;
    MainRec mainRec ;
	Level1 lev;
	Details details;
	int lives=3;
	int score;
	Random randomBonus = new Random();
	Bonus b;
	 Scene scene;

	

	
    
	int RectangularSpeed=8;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		final BorderPane borderPane;
		final Pane pane;
		final Pane paneDetails;
		final Pane paneLevel;
		final Pane paneBonus;
	    primaryStage.setResizable(false);
		started=false;

		primaryStage.setTitle("Arkanoid Game");
		pane= new Pane(group);
		paneDetails= new Pane(groupDetails);
		paneLevel = new Pane(groupLevel);
		paneBonus= new Pane(groupBonus);
		
		
		pane.setPrefSize(800, 500);
        borderPane= new BorderPane();
        scene= new Scene(borderPane, 800 , 500, Color.ANTIQUEWHITE);
	
        
        
        //Image
//        pane.setStyle("-fx-background-image: url(https://cdn.pixabay.com/photo/2017/04/10/10/08/universe-2218012_960_720.jpg)");

        ImageView iv = new ImageView();   
        Image img= new Image("file:a.jpg");

        iv.setImage(img);
    
        iv.setFitWidth(pane.getWidth());
        iv.setFitHeight(pane.getHeight());
        

        
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(iv, pane, paneDetails,paneLevel, paneBonus);
        borderPane.setCenter(stackPane);        
        //Image end
        
        
        
        
        newGame();
        primaryStage.setScene(scene);
		primaryStage.show();
		
//Ball Start		
		
		
		new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				ball.getEllipse().setCenterX(ball.getEllipse().getCenterX()+ball.getStepX());
                ball.getEllipse().setCenterY(ball.getEllipse().getCenterY()+ball.getStepY());
                //foq
                if (ball.getEllipse().getCenterY()-ball.getEllipse().getRadiusY()<0) {
                    ball.setStepY(ball.getStepY()*-1);
                }
                //yasar
                if (ball.getEllipse().getCenterX()-ball.getEllipse().getRadiusX()<0) {
                    ball.setStepX(ball.getStepX()*-1);
                }
                //yamin

                if (ball.getEllipse().getCenterX()>scene.getWidth()-ball.getEllipse().getRadiusX()) {
                	ball.setStepX(ball.getStepX()*-1);
                }
                //taht
                
              
                
                
                if (ball.getEllipse().getCenterY()+50==scene.getHeight()-ball.getEllipse().getRadiusY()) {
                	 if (ball.getEllipse().getCenterX()-400<mainRec.getRec().getTranslateX()+55 && ball.getEllipse().getCenterX()-400>mainRec.getRec().getTranslateX()-45) {
						if (ball.getEllipse().getCenterX()-400==mainRec.getRec().getTranslateX()) {
                    		 ball.setStepY(ball.getStepY()*-1);
                  //الطابة بتطنج عاليمين
						}
						if (ball.getEllipse().getCenterX()-400>mainRec.getRec().getTranslateX()
								&& ball.getEllipse().getCenterX()-400<mainRec.getRec().getTranslateX()+22) {
                    		 ball.setStepY(ball.getStepY()*-1);
                    		 ball.setStepX(1);
						}	 
						if (ball.getEllipse().getCenterX()-400>mainRec.getRec().getTranslateX()+22)
								 {
                    		 ball.setStepY(ball.getStepY()*-1);
                    		 ball.setStepX(4);
						}
       	         //الطابة بتطنج عاليسار
	 
						
						if (ball.getEllipse().getCenterX()-400<mainRec.getRec().getTranslateX()
								&& ball.getEllipse().getCenterX()-400>mainRec.getRec().getTranslateX()-22) {
							
                    		 ball.setStepY(ball.getStepY()*-1);
                    		 ball.setStepX(-1);
						}	
						if (ball.getEllipse().getCenterX()-400<mainRec.getRec().getTranslateX()-22) {
							ball.setStepY(ball.getStepY()*-1);
                   		 ball.setStepX(-4);
						}
					}
                     
				}
                
          //حذف المسطليل
                if (ball.getEllipse().getCenterY()-ball.getEllipse().getRadiusY()<120&&
                		ball.getEllipse().getCenterY()-ball.getEllipse().getRadiusY()>100) {
                	for (int i = 0; i < lev.recs.size(); i++) {
						if (lev.recs.get(i).getX()<ball.getEllipse().getCenterX()&&lev.recs.get(i).getX()+60>ball.getEllipse().getCenterX()) {
							groupLevel.getChildren().remove(i);
//	راندوم للبونوس
						
							int bo= randomBonus.nextInt(6)+1;
							if (bo==1) {
								b= new Bonus(1, lev.recs.get(i).getX(), lev.recs.get(i).getY());
								bonusAnimation(b.getNode(),1);
								groupDetails.getChildren().clear();
								newDetails();
							}else if (bo==2) {
								b= new Bonus(2, lev.recs.get(i).getX(),lev.recs.get(i).getY());
								bonusAnimation(b.getNode(),2);
								groupDetails.getChildren().clear();
								newDetails();
								
							}
//							bonusAnimation(b.getNode());
							lev.recs.remove(i);
							score= score+10;
							groupDetails.getChildren().clear();
	                   		 ball.setStepY(ball.getStepY()*-1);
							newDetails();
							

							
							
						}
                	}					
				}                

                if (groupLevel.getChildren().size()==0) {
					groupLevel.getChildren().clear();
					winnAlert();
					stop();
				}                
     //وقت الطابة بتوقع
                if (ball.getEllipse().getCenterY()>scene.getHeight()-ball.getEllipse().getRadiusY()) {

                	group.getChildren().clear();
                	groupDetails.getChildren().clear();
                	

                	if (lives>0) {
                		counter=0;
                    	started=false;
                    	lives--;
                    	newGame();
					}else {
						alert();
						stop();
					}
                	
                	
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
			}
			
		}.start();;
//Ball End
		
//bonus Movment
		
		
		
		
//Start Mainrec
		
		//$$$$$$$$$$$$$$$$$$$$$$$$$ لتحريك المضرب $$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		
		 scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
	            @Override
	            public void handle(KeyEvent event) {
	                switch (event.getCode()) {
	                    
	                    case LEFT:  goWest  = true; break;
	                    case RIGHT: goEast  = true; break;
	                    case SHIFT: running = true; break;
	                    case SPACE : started =true; break;
	                }
	            }
	        });
	        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
	            @Override
	            public void handle(KeyEvent event) {
	                switch (event.getCode()) {

	                    case LEFT:  goWest  = false; break;
	                    case RIGHT: goEast  = false; break;
	                    case SHIFT: running = false; break;
	                }
	            }
	        });	
	        
	        
	        //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		
	        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
				
           int dx = 0, dy = 0;

                if (goEast)  mainRec.getRec().setTranslateX(mainRec.getRec().getTranslateX()+RectangularSpeed);
                if (goEast&& started==false && mainRec.getRec().getTranslateX()<=348 ) {
                	
               	ball.getEllipse().setCenterX(ball.getEllipse().getCenterX()+RectangularSpeed);
				}
                if (goWest)  mainRec.getRec().setTranslateX(mainRec.getRec().getTranslateX()-RectangularSpeed);
                if (goWest&& started==false && mainRec.getRec().getTranslateX()>=-359) { ball.getEllipse().setCenterX(ball.getEllipse().getCenterX()-RectangularSpeed);
                
                }

                if (running){
                	RectangularSpeed=18 ;
                }else if (running==false) {
					RectangularSpeed=7;
				}
                if (counter==0&&started==false ) {
					ball.setStepX(0);
					ball.setStepY(0);
				}else if (started==true&& counter==0) {
					counter++;
					
					ball.setStepX(0);
					ball.setStepY(-4);
					
				}
                //حدود المربع على اليمين
               if (mainRec.getRec().getTranslateX()>348) {
            	   mainRec.getRec().setTranslateX(348);
				//حدود المربع على اليسار
			}
               if (mainRec.getRec().getTranslateX()<-359) {
            	   mainRec.getRec().setTranslateX(-359);
					
			}
               
               

            }
        };
        timer.start();
//End mainRec
	}
	
//Bonus animaion start
	private void bonusAnimation(Node n,int x){
		if (x==1) {
			new AnimationTimer() {
				
				@Override
				public void handle(long now) {

					n.setTranslateY(n.getTranslateY()+1);

					 if (n.getTranslateY()<scene.getHeight()-50 && n.getTranslateY()>scene.getHeight()-90) {
						 if (n.getTranslateX()-350-mainRec.getRec().getTranslateX()>-20 && n.getTranslateX()-350-mainRec.getRec().getTranslateX()<92) {
							 groupDetails.getChildren().clear();
							 groupBonus.getChildren().remove(n);
							 lives++;
							 newDetails();
							 stop();
						}
						 
						 				 
				 }
					
				}
			}.start();
		}else if (x==2) {
			new AnimationTimer() {
				
				@Override
				public void handle(long now) {

					n.setTranslateY(n.getTranslateY()+1);

					 if (n.getTranslateY()<scene.getHeight()-50 && n.getTranslateY()>scene.getHeight()-90) {
						 if (n.getTranslateX()-350-mainRec.getRec().getTranslateX()>-20 && n.getTranslateX()-350-mainRec.getRec().getTranslateX()<92) {
							 groupDetails.getChildren().clear();
							 groupBonus.getChildren().remove(n);
							 score=score+50;
							 newDetails();
							 stop();
						}
						 
						 				 
				 }
					
				}
			}.start();
		}
		
	}
	
	
	
	private void alert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		
		alert.setTitle("Alert");
		
		alert.setHeaderText("GAME OVER");
		
		String s ="Good luck next time !! ";
		
		alert.setContentText(s);
		alert.show();
		
	}
	
	private void winnAlert(){
Alert alert = new Alert(AlertType.INFORMATION);
		
		alert.setTitle("Alert");
		
		alert.setHeaderText("Congratulations!!!!!");
		
		String s ="You won the First Level!!  Score: "+Integer.toString(score);
		
		
		
		
		
		alert.setContentText(s);
		
		
		alert.show();
	}
	private void newGame(){
		
		 ball = new SmallBall();
		 mainRec = new MainRec();

		 newDetails();
		 if (levelCounter==0) {
			 lev= new Level1();
				levelCounter++;
		}
		

	}
	private void newDetails(){
		details= new Details(lives , score);
	}
	
	
	public static void main(String[] args) {
		Application.launch(args);			
	}
	
	

}
