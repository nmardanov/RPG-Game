import javax.swing.ImageIcon;

public class Balloon extends Enemy{

	public Balloon() {
		super();
	}
	
	public Balloon(int x, int y, int healthv, int spd, String tag) {
		super(x, y, 50, 60, healthv, 1, spd, healthv+tag, "BLOONS");
	}
	
	public void setNextImg() {
		setImg(new ImageIcon(getHealth()+"balloon.png"));
	}
	
	public Boolean checkRemove(int dmg) {
		setHealth(getHealth()-dmg);
		
		if(getHealth()<=0) {
			return true;
		} else {
			setNextImg();
			return false;
		}
	}
}
