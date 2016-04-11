//U10316053 µ{¬fºú
import java.util.Random;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.animation.PathTransition;
import javafx.util.Duration;
public class Bean_Play extends Circle{
	private int mEndLevel;
	Bean_Play(double centerX,double centerY,double radius,Paint fill){
		super(centerX,centerY,radius,fill);
	}
	public void startMoveBall(int endLevel){
		mEndLevel = endLevel;
		move();
	}
	private void move(){
		Path path=new Path(); 
		double endX = this.getCenterX();
		double endY = this.getCenterY();
		Random ran = new Random();
		
		path.getElements().add(new MoveTo(this.getCenterX(), this.getCenterY()));

		for(int i=0;i<mEndLevel;i++){
			if(Math.abs(ran.nextInt())%2==0){
				endX = endX+25;
				endY = endY+19;
			}else{
				endX = endX-25;
				endY = endY+19;
			}
			path.getElements().add(new LineTo(endX, endY));
		}
		path.getElements().add(new LineTo(endX, endY+70));
		PathTransition pt=new PathTransition();
        pt.setDuration(Duration.millis(5000));
        pt.setPath(path);
        pt.setNode(this);
        pt.setOrientation(PathTransition.OrientationType.NONE);
        pt.setCycleCount(1);
        pt.setAutoReverse(false);
        pt.play();
	}
}
