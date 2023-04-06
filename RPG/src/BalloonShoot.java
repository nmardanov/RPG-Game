import javax.swing.ImageIcon;

public class BalloonShoot extends Balloon{

	public BalloonShoot() {
		super();
	}
	
	public BalloonShoot(int x, int y, int healthv) {
		super(x, y, healthv, 1, "balloons");
	}
	
	public void setNextImg() {
		setImg(new ImageIcon(getHealth()+"balloons.png"));
	}
	
}
