import javax.swing.ImageIcon;

public class BalloonFast extends Balloon{

	public BalloonFast() {
		super();
	}
	
	public BalloonFast(int x, int y, int healthv) {
		super(x, y, healthv, 2, "balloonf");
		setImg(new ImageIcon(getTag() + ".gif"));
	}
	
	public void setNextImg() {
		setImg(new ImageIcon(getHealth()+"balloonf.gif"));
	}
}
