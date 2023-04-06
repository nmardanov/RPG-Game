import javax.swing.ImageIcon;

public class Moab extends Enemy{

	public Moab() {
		super();
	}
	
	public Moab(int x, int y, int healthv, int spd, String tag) {
		super(x, y, 70, 100, healthv, 1, spd, tag+"moab", "MOAB");
	}
	
	public void setOrientation() {
		if(getDx()>0&&getDy()>0) {
			setImg(new ImageIcon(getTag()+"DR.png"));
			setOrient("DR");
			setW(75);
			setH(75);
		} else if(getDx()>0&&getDy()<0) {
			setImg(new ImageIcon(getTag()+"UR.png"));
			setOrient("UR");
			setW(75);
			setH(75);
		} else if(getDx()<0&&getDy()<0) {
			setImg(new ImageIcon(getTag()+"UL.png"));
			setOrient("UL");
			setW(75);
			setH(75);
		} else if(getDx()<0&&getDy()>0) {
			setImg(new ImageIcon(getTag()+"DL.png"));
			setOrient("DL");
			setW(75);
			setH(75);
		} else if(getDx()>0) {
			setImg(new ImageIcon(getTag()+"R.png"));
			setOrient("R");
			setW(100);
			setH(70);
		} else if(getDx()<0) {
			setImg(new ImageIcon(getTag()+"L.png"));
			setOrient("L");
			setW(100);
			setH(70);
		} else if(getDy()<0) {
			setImg(new ImageIcon(getTag()+".png"));
			setOrient("");
			setW(70);
			setH(100);
		} else if(getDy()>0) {
			setImg(new ImageIcon(getTag()+"D.png"));
			setOrient("D");
			setW(70);
			setH(100);
		}
	}
}
