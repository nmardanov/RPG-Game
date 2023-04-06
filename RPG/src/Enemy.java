import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy extends Character{

	public Enemy() {
		super();
	}
	
	public Enemy(int xv, int yv, int wv, int hv, int healthv, int dmgv, int spd, String tag, String namev) {
		super(xv, yv, hv, healthv, dmgv, spd, tag, namev, null, null);
		this.setW(wv);
	}
	
	public void move(int targx, int targy) {
		if(getX()<targx) {
			setX(getX()+getSpeed());
			setDx(1);
		} else if(getX()>targx) {
			setX(getX()-getSpeed());
			setDx(-1);
		}
		if(getY()<targy) {
			setY(getY()+getSpeed());
			setDy(1);
		} else if(getY()>targy) {
			setY(getY()-getSpeed());
			setDy(-1);
		}
		
		if(Math.abs(targx-getX())<=75) {
			setDx(0);
		} else if(Math.abs(targy-getY())<=75){
			setDy(0);
		}
	}
	
	public Boolean playerCol(Character c) {
		Rectangle enemyloc = new Rectangle(getX()+(getW()/2), getY()+(getH()/2), 1, 1);
		Rectangle playerloc = new Rectangle(c.getX(), c.getY(), c.getW(), c.getH());
		
		if(enemyloc.intersects(playerloc)) {
			return true;
		}
		return false;
	}
	
	public Boolean checkRemove(int dmg) {
		setHealth(getHealth()-dmg);
		
		if(getHealth()<=0) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
