import javax.swing.ImageIcon;

public class DartProj extends Weapon{
	
	public DartProj() {
		super();
	}
	
	public DartProj(Character c) {
		super(10, 50, 5, c);
		this.setImg(new ImageIcon(getTag() + "proj" + getOrient() + ".png"));
	}
	
	public void move() {
		if(getOrient() == "") {
			setDy(-getSpeed());
			setW(10);
			setH(50);
		} else if(getOrient() == "D") {
			setDy(getSpeed());
			setW(10);
			setH(50);
		} else if(getOrient() == "R") {
			setDx(getSpeed());
			setW(50);
			setH(10);
		} else if(getOrient() == "L") {
			setDx(-getSpeed());
			setW(50);
			setH(10);
		}
		setX(getX()+getDx());
		setY(getY()+getDy());
	}
}
