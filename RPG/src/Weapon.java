import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Weapon {

	private int x, y, w, h, dx, dy, speed, dmg;
	private ImageIcon img;
	private String tag, orient;
	
	public Weapon() {
		x=0;
		y=0;
		w=0;
		h=0;
		dx=0;
		dy=0;
		speed = 0;
		img = new ImageIcon("");
		tag = "";
		orient = "";
	}
	
	public Weapon(int w, int h, int spd, Character c) {
		this.x = c.getProjx();
		this.y = c.getProjy();
		this.w = w;
		this.h = h;
		this.orient = c.getOrient();
		this.tag = c.getTag();
		speed = spd;
		dx = 0;
		dy = 0;
		img = new ImageIcon(tag + "proj.png");
		
	}
	
	public void move() {
		if(orient == "") {
			dy = -speed;
		} else if(getOrient() == "D") {
			dy = speed;
		} else if(getOrient() == "R") {
			dx = speed;
		} else if(getOrient() == "L") {
			dx = -speed;
		}
		x+=dx;
		y+=dy;
	}
	
	public Boolean collision(Character c) {
		Rectangle projloc = new Rectangle(x+(w/2), y+(h/2), 1, 1);
		Rectangle charloc = new Rectangle(c.getX(), c.getY(), c.getW(), c.getH());
		
		if(projloc.intersects(charloc)) {
			return true;
		}
		return false;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}
	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public String getOrient() {
		return orient;
	}
	
	public void setOrient(String orient) {
		this.orient = orient;
	}
	
	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
