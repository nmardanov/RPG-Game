
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.*; 
import java.util.Queue;
import java.util.LinkedList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private int key; 
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private Player p;
	private ArrayList <Character> selectList;
	private ArrayList <Weapon> projList;
	private Queue <Enemy> enemies;
	private Character player1;
	private String pog, fileName;
	private ImageIcon grass, sand, ouch;
	private File file;
	private int poggers;
	private int count;
	private int subpos;
	private int score;
	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		p = new Player();
		key =-1; 
		selectList = setSelectList();
		projList = new ArrayList <Weapon> ();
		enemies = new LinkedList();
		pog = "SELECT YOUR MONKEY";
		fileName = "saveFile.txt";
		poggers = 0;
		count = 0;
		subpos = 1;
		score = 0;
		file = new File(fileName);
		grass = new ImageIcon("grass.png");
		sand = new ImageIcon("sand.png");
		ouch = new ImageIcon("ouch.png");
		
		addEnemies();
	}

	public ArrayList <Character> setSelectList() {
		ArrayList <Character> temp = new ArrayList <Character> ();
		
		temp.add(new Dart(screenSize.width-1420, screenSize.height-650));
		temp.add(new Wizard(screenSize.width-1120, screenSize.height-650));
		temp.add(new Cannon(screenSize.width-820, screenSize.height-650));
		
		return temp;
	}
	
	public void createFile() {
		//create the file
		
		try {
			if(file.createNewFile()) {
				System.out.println("Yay new file" + file.getName());
			} else {
				System.out.println("File already exists");
			}
		}
		
		catch(IOException e) {
			System.out.println("An error has occurred.");
			e.printStackTrace();
		}
	}
	
	public void writeToFile() {
		//write info to the save file
		
		try {
			FileWriter myWriter = new FileWriter(fileName);
			//myWriter.write("sample");
			
			myWriter.close();
		}
		
		catch(IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
	
	public void readFile() {
		//read from the save file to open the game
		
		try {
			Scanner sc = new Scanner(file);
			
			while(sc.hasNext()) {
				if(sc.next().equals("WIN")) {
					System.out.println("WIN");
				}
			}
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void addEnemies() {
		enemies.add(new BalloonShoot((int)(Math.random()*(screenSize.width+1)), (int)(Math.random()*(screenSize.height+1)), 1));
		enemies.add(new BalloonFast((int)(Math.random()*(screenSize.width+1)), (int)(Math.random()*(screenSize.height+1)), 1));
		enemies.add(new BalloonReg((int)(Math.random()*(screenSize.width+1)), (int)(Math.random()*(screenSize.height+1)), 4));
		enemies.add(new BalloonReg((int)(Math.random()*(screenSize.width+1)), (int)(Math.random()*(screenSize.height+1)), 2));
		enemies.add(new BalloonReg((int)(Math.random()*(screenSize.width+1)), (int)(Math.random()*(screenSize.height+1)), 2));
		enemies.add(new BalloonReg((int)(Math.random()*(screenSize.width+1)), (int)(Math.random()*(screenSize.height+1)), 1));
		enemies.add(new BalloonReg((int)(Math.random()*(screenSize.width+1)), (int)(Math.random()*(screenSize.height+1)), 3));
		enemies.add(new BalloonReg((int)(Math.random()*(screenSize.width+1)), (int)(Math.random()*(screenSize.height+1)), 1));
		enemies.add(new BalloonReg((int)(Math.random()*(screenSize.width+1)), (int)(Math.random()*(screenSize.height+1)), 2));
		enemies.add(new Moab((int)(Math.random()*(screenSize.width+1)), (int)(Math.random()*(screenSize.height+1)), 50, 1, ""));
	}
	
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	

	
	
	
	public void paint(Graphics g){ 
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 

		Graphics g2d = back.createGraphics();
		
		g2d.clearRect(0,0,getSize().width, getSize().height);
		
		count++;
		
		switchLevel(g2d);
		
		twoDgraph.drawImage(back, null, 0, 0);
	}





	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}





	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub\
		

		
		key= e.getKeyCode();
		System.out.println(key);
		
		//r for reset, always available
		if(key == 82) {
			reset();
		}
		
		//start game
		if(poggers==1&&key==32) {
			poggers++;
		}
		
		//d to test screens
		if(key==65) {
			poggers++;
			enemies.clear();
			addEnemies();
		}
		
		//arrows for movement
		if(key == 39) {
			player1.setDx(player1.getSpeed());;
		} else if(key == 37) {
			player1.setDx(-player1.getSpeed());;
		} else if(key == 38) {
			player1.setDy(-player1.getSpeed());;
		} else if(key == 40) {
			player1.setDy(player1.getSpeed());;
		}
		
		//space to shoot
		if(poggers > 1 && key == 32) {
			if(player1 instanceof Dart) {
				projList.add(new DartProj(player1));
			} else if(player1 instanceof Wizard) {
				projList.add(new Fireball(player1));
			} else if(player1 instanceof Cannon) {
				projList.add(new Bomb(player1));
			}
			
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		key= e.getKeyCode();
		
		if(key == 39) {
			player1.setDx(0);
		} else if(key == 37) {
			player1.setDx(0);
		} else if(key == 38) {
			player1.setDy(0);
		} else if(key == 40) {
			player1.setDy(0);
		}
		
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		int mX=arg0.getX();
		int mY=arg0.getY();
		if(poggers==0) {
			//select monkey code
			Rectangle mouseLoc = new Rectangle(mX, mY, 1, 1);
			Rectangle dartSel = new Rectangle(selectList.get(0).getX(), selectList.get(0).getY(), selectList.get(0).getW(), selectList.get(0).getH());
			Rectangle wizSel = new Rectangle(selectList.get(1).getX(), selectList.get(1).getY(), selectList.get(1).getW(), selectList.get(1).getH());
			Rectangle cannonSel = new Rectangle(selectList.get(2).getX(), selectList.get(2).getY(), selectList.get(2).getW(), selectList.get(2).getH());
		
			if(mouseLoc.intersects(dartSel)) {
				player1 = new Dart(500, 500);
				player1.setW(60);
				player1.setH(72);
				poggers++;
			} else if(mouseLoc.intersects(wizSel)) {
				player1 = new Wizard(500, 500);
				player1.setW(60);
				player1.setH(72);
				poggers++;
			} else if(mouseLoc.intersects(cannonSel)) {
				player1 = new Cannon(500, 500);
				player1.setW(60);
				player1.setH(72);
				poggers++;
			} 
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent arg0) {
		int mX=arg0.getX();
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}
	
	public void switchLevel(Graphics g2d) {
		switch(poggers) {
		case 0:
		//Character select + start screen
			g2d.setColor(Color.white);
			g2d.setFont(new Font("Arial", Font.BOLD, 72));
			if(count%50==0&&subpos<pog.length()) {
				subpos++;
			}
			g2d.drawString(pog.substring(0,subpos), screenSize.width-1450, screenSize.height/5);
			
			
			for(Character c:selectList) {
				c.drawChar(g2d);
			}
			
			break;
		case 1:
		//Selected character stats + start
			g2d.setColor(Color.white);
			g2d.setFont(new Font("Arial", Font.BOLD, 72));
			g2d.drawImage(player1.getImg().getImage(), screenSize.width/7, screenSize.width/10, screenSize.width*600/1920, screenSize.height*720/1080, this);
			g2d.drawString("PRESS SPACE TO BEGIN", screenSize.width*900/1920, screenSize.height*750/1080);
			g2d.setColor(player1.getColor());
			g2d.drawString(player1.getName(), screenSize.width*900/1920, screenSize.height*400/1080);
			g2d.setFont(new Font("Arial", Font.BOLD, 60));
			g2d.drawString("Health: " + player1.getHealth(), screenSize.width*900/1920, screenSize.height*470/1080);
			g2d.drawString("Damage: " + player1.getDmg(), screenSize.width*900/1920, screenSize.height*540/1080);
			
			break;
		case 2:
		//Level 1: grass
			g2d.drawImage(grass.getImage(), 0, 0, screenSize.width, screenSize.height, this);
			playGame(g2d);
			if(enemies.isEmpty() && player1.getHealth()>0) {
				poggers = 3;
				addEnemies();
				projList.clear();
				player1.setX(100);
				player1.setY(500);
				player1.setProjx(player1.getX()+50);
				player1.setProjy(player1.getY()+42);
			}
			break;
		case 3:
		//Level 2: sand
			g2d.drawImage(sand.getImage(), 0, 0, screenSize.width, screenSize.height, this);
			playGame(g2d);
			if(enemies.isEmpty() && player1.getHealth()>0) {
				poggers = 4;
				addEnemies();
				projList.clear();
				player1.setX(100);
				player1.setY(500);
				player1.setProjx(player1.getX()+50);
				player1.setProjy(player1.getY()+42);
			}
			break;
		case 4:
		//Level 4: ouch
			g2d.drawImage(ouch.getImage(), 0, 0, screenSize.width, screenSize.height, this);
			playGame(g2d);
			if(enemies.isEmpty() && player1.getHealth()>0) {
				poggers = 6;
				addEnemies();
			}
			break;
		case 5:
		//Death screen
			g2d.setColor(Color.white);
			g2d.setFont(new Font("Arial", Font.BOLD, 72));
			g2d.drawString("YOU'RE STINKY", 500, 500);
			break;
		case 6:
		//Win screen
			g2d.setColor(Color.white);
			g2d.setFont(new Font("Arial", Font.BOLD, 72));
			g2d.drawString("YOU SHOWER", 500, 500);
			break;
		}
	}
	
	public void removeI(ArrayList <Weapon> list) {
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getX()>=1920 || list.get(i).getX() <= 0 || list.get(i).getY()>=1080 || list.get(i).getY() <= 0) {
				list.remove(i);
			}
		}
	}
	
	public void playGame(Graphics g2d) {
		g2d.drawImage(player1.getImg().getImage(), player1.getX(), player1.getY(), player1.getW(), player1.getH(), this);
		player1.setOrientation();
		player1.move();
		if(poggers == 3) {
			
			Rectangle toprect = new Rectangle(852, 0, 214, 450);
			Rectangle botrect = new Rectangle(852, 630, 214, 450);
			Rectangle playerloc = new Rectangle(player1.getX(), player1.getY(), player1.getW(), player1.getH());
			
			if(playerloc.intersects(toprect) || playerloc.intersects(botrect)) {
				player1.setX(player1.getX()-player1.getDx());
				player1.setY(player1.getY()-player1.getDy());
			}
		} else if(poggers == 4) {
			
			Rectangle puddle = new Rectangle(652, 388, 565, 245);
			Rectangle playerloc = new Rectangle(player1.getX(), player1.getY(), player1.getW(), player1.getH());
			
			if(playerloc.intersects(puddle)) {
				player1.setX(player1.getX()-player1.getDx());
				player1.setY(player1.getY()-player1.getDy());
			}
		}
		if(!enemies.isEmpty()) {
			if(enemies.element() instanceof Moab) {
				enemies.element().setOrientation();
			}
			if(enemies.element() instanceof BalloonShoot) {
				if(count % 150 == 0) {
					projList.add(new EnemyProj(enemies.element()));
				}
			}
			enemies.element().drawChar(g2d);	
			enemies.element().move(player1.getX(), player1.getY());
			if(enemies.element().playerCol(player1)) {
				player1.setHealth(player1.getHealth()-1);
				enemies.remove();
				if(player1.getHealth()<=0) {
					poggers = 5;
				}
			}
			
		}
		
		
		player1.drawHearts(g2d);
		g2d.setFont(new Font("Times New Roman", Font.BOLD, 40));
		g2d.drawString("Enemies remaining: " + enemies.size(), 1500, 50);
		
		for(Weapon i : projList) {
			i.move();
			g2d.drawImage(i.getImg().getImage(), i.getX(), i.getY(), i.getW(), i.getH(), this);	
			if(!enemies.isEmpty()) {
				if(i.collision(enemies.element()) && !(i instanceof EnemyProj)) {
					i.setX(10000); 
					if(enemies.element() instanceof Moab) {
						if(enemies.element().checkRemove(1)) {
							enemies.remove();
						}	
					} else if(enemies.element() instanceof Balloon) {
						if(enemies.element().checkRemove(player1.getDmg())) {
							enemies.remove();
						}	
					}
				}
				if(i.collision(player1) && i instanceof EnemyProj) {
					i.setX(10000);
					player1.setHealth(player1.getHealth()-1);
					if(player1.getHealth()<=0) {
						poggers = 5;
					}
				}
			}
			
		}
		
		removeI(projList);
	}

	public void reset() {
		selectList = setSelectList();
		poggers = 0;
		count = 0;
		subpos = 1;
		player1 = null;
		projList = new ArrayList <Weapon> (); 
		enemies.clear();
		addEnemies();
	}
	
}
