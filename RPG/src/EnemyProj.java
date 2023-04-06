import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class EnemyProj extends Weapon{
	
	public EnemyProj() {
		super();
	}
	
	public EnemyProj(Enemy e) {
		super(50, 50, 3, e);
		setX(e.getX());
		setY(e.getY()+5);
		
		if(e.getDx()>0) {
			setOrient("R");
		} else if(e.getDx()<0) {
			setOrient("L");	
		} else if(e.getDy()>0) {
			setOrient("D");
		} else if(e.getDy()<0) {
			setOrient("");	
		}
		
		this.setImg(new ImageIcon("airball" + this.getOrient() + ".png"));
	}
	
}
