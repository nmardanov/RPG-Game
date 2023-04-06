import java.awt.Color;

import javax.swing.ImageIcon;

public class Dart extends Character{
	
	public Dart() {
		super();
	}
	
	public Dart(int x, int y) {
		//x, y, width, health, damage, tag, name
		super(x, y, 180, 5, 1, 3, "dart", "Dart Monkey", new Color(148, 109, 50), new DartProj());
	}
}
