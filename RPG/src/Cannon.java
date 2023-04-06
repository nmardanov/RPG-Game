import java.awt.Color;

import javax.swing.ImageIcon;

public class Cannon extends Character{
	
	public Cannon() {
		super();
	}
	
	public Cannon(int x, int y) {
		//x, y, width, health, damage, tag, name
		super(x, y, 180, 10, 3, 2, "cannon", "Cannon Monkey", new Color(94, 93, 92), new Bomb());
	}
	
	public void setOrientation() {
		if(getDx()>0) {
			setImg(new ImageIcon(getTag()+"R.png"));
			setOrient("R");
			setW(72);
			setH(60);
			setProjx(getX()+57);
			setProjy(getY()+15);
		} else if(getDx()<0) {
			setImg(new ImageIcon(getTag()+"L.png"));
			setOrient("L");
			setW(72);
			setH(60);
			setProjx(getX()-15);
			setProjy(getY()+15);
		} else if(getDy()<0) {
			setImg(new ImageIcon(getTag()+".png"));
			setOrient("");
			setW(60);
			setH(72);
			setProjx(getX()+15);
			setProjy(getY()-15);
		} else if(getDy()>0) {
			setImg(new ImageIcon(getTag()+"D.png"));
			setOrient("D");
			setW(60);
			setH(72);
			setProjx(getX()+15);
			setProjy(getY()+57);
		}
	}
}
