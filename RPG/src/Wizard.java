import java.awt.Color;

import javax.swing.ImageIcon;

public class Wizard extends Character{
	
	public Wizard() {
		super();
	}
	
	public Wizard(int x, int y) {
		//x, y, width, health, damage, tag, name
		super(x, y, 180, 5, 2, 4, "wizard", "Wizard Monkey", new Color(150, 75, 196), new Fireball());
	}
}
