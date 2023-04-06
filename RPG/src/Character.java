import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Character {

	private int x,y,w,h,dx,dy,health,dmg,level,projx,projy,speed; 
	private ImageIcon img;
	private String name, tag, orient;
	private Color charcolor;
	private Weapon weapon;
	
	public Character() {
		x = 0;
		y = 0;
		w = 0;
		h = 0;
		dx = 0;
		dy = 0;
		speed = 0;
		projx = 0;
		projy = 0;
		health = 0;
		dmg = 0;
		img = new ImageIcon("");
		level = 1;
		orient = "";
		name = "";
	}
	
	public Character(int xv, int yv, int hv, int healthv, int dmgv, int spd, String tag, String namev, Color c, Weapon wv) {
		x = xv;
		y = yv;
		w = 150;
		h = hv;
		dx = 0;
		dy = 0;
		speed = spd;
		projx = 0;
		projy = 0;
		health = healthv;
		dmg = dmgv;
		img = new ImageIcon(tag + ".png");
		level = 1;
		name = namev;
		charcolor = c;
		weapon = wv;
		orient = "";
		this.tag = tag;
	}

	public void upgradeMonkey() {
		level++;
	}
	
	public void move() {
		x+=dx;
		y+=dy;
		
		if(x+w>=1900 || x<=20) {
			x-=dx;
		} else if(y+h>=1060 || y<=20) {
			y-=dy;
		} 
	}

	public void setOrientation() {
		if(dx>0) {
			img = (new ImageIcon(tag+"R.png"));
			orient = "R";
			w = 72;
			h = 60;
			projx = x+50;
			projy = y+42;
		} else if(dx<0) {
			img = (new ImageIcon(getTag()+"L.png"));
			orient = "L";
			w = 72;
			h = 60;
			projx = x-50;
			projy = y+10;
		} else if(dy<0) {
			img = (new ImageIcon(getTag()+".png"));
			orient = "";
			w = 60;
			h = 72;
			projx = x+30;
			projy = y-30;
		} else if(dy>0) {
			img = (new ImageIcon(getTag()+"D.png"));
			orient = "D";
			w = 60;
			h = 72;
			projx = x+10;
			projy = y+50;
		}
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

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
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
	
	public String getName() {
		return name;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public String getTag() {
		return tag;
	}
	
	public Color getColor() {
		return charcolor;
	}
	
	public void drawChar(Graphics g2d) {
		g2d.drawImage(img.getImage(), x, y, w, h, null);
	}
	
	public void drawHearts(Graphics g2d) {
		for(int i=0; i<health; i++) {
			g2d.drawImage(new ImageIcon("heart.png").getImage(), 50+60*i, 50, 50, 50, null);
		}
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	
	public String getOrient() {
		return orient;
	}
	
	public void setOrient(String orient) {
		this.orient = orient;
	}
	
	public int getProjx() {
		return projx;
	}

	public void setProjx(int projx) {
		this.projx = projx;
	}

	public int getProjy() {
		return projy;
	}

	public void setProjy(int projy) {
		this.projy = projy;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
