//Basic Game Application
//Version 2
// Basic Object, Image, Movement
// Astronaut moves to the right.
// Threaded

//K. Chun 8/2018

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.*;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.JPanel;


//*******************************************************************************
// Class Definition Section

public class BasicGameApp implements Runnable, KeyListener {

   //Variable Definition Section
   //Declare the variables used in the program 
   //You can set their initial values too
   
   //Sets the width and height of the program window
	final int WIDTH = 1000;
	final int HEIGHT = 700;

   //Declare the variables needed for the graphics
	public JFrame frame;
	public Canvas canvas;
   public JPanel panel;
   
	public BufferStrategy bufferStrategy;

	public Image background;
	public Image carpic1;
	public Image carpic2;
	public Image carpic3;
	public Image duckpic;
public Image carpic4;
public Image winscreen;
public Image losescreen;
public boolean isWinning;
public boolean isLosing;
public boolean isWinningLevel2;
public int LevelCounter;
private Car duck;

	public Car[] cars = new Car[5];



	public static void main(String[] args) {
		BasicGameApp ex = new BasicGameApp();
		new Thread(ex).start();
	}



	public BasicGameApp() {
      
      setUpGraphics();
       
		isWinning = false;
		isLosing = false;
		isWinningLevel2 = false;
		LevelCounter = 1;
		background = Toolkit.getDefaultToolkit().getImage("Crossy_Road_Background.jpeg");
		winscreen = Toolkit.getDefaultToolkit().getImage("win_screen.png");
		losescreen = Toolkit.getDefaultToolkit().getImage("game_over_screen.jpeg");
		carpic1 = Toolkit.getDefaultToolkit().getImage("Cartoon_Car.png");
		cars[1] = new Car(500,100);
		carpic2 = Toolkit.getDefaultToolkit().getImage("RedCartoonCar.png");
		cars[2] = new Car(300,212);
		carpic3 = Toolkit.getDefaultToolkit().getImage("YellowCartoonCar.png");
		cars[3] = new Car(650,500);
		carpic4 = Toolkit.getDefaultToolkit().getImage("bluecartooncar.png");
		cars[4] = new Car(100, 375);
		duck = new Car(365, 600);
		duck.isControlled = true;
		duck.height = 75;
		duck.width = 50;
		duckpic = Toolkit.getDefaultToolkit().getImage("crossyroadcharacter.png");

	}

   

	public void run() {


		while (true) {

         moveThings();
         render();
         pause(20);
		}
	}


	public void moveThings()
	{
      cars[1].wrap();
	  cars[2].car3wrap();
	  cars[3].car3wrap();
	  cars[4].wrap();
	  duck.wrap();

		if (duck.rec.intersects(cars[1].rec)){
			isLosing = true;
		}
		else if(duck.rec.intersects(cars[2].rec)){
			isLosing = true;
		}
		else if(duck.rec.intersects(cars[3].rec)){
			isLosing = true;
		}
		else if(duck.rec.intersects(cars[4].rec)){
			isLosing = true;
		}

	  if (duck.ypos <= 30){
		  isWinning = true;
		  LevelCounter = 2;
	  }

	  if (duck.ypos <= 30 && LevelCounter = 2){
		  isWinningLevel2 = false;
	  }

	}
	

   public void pause(int time ){

			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {

			}
   }
   private void setUpGraphics() {
      frame = new JFrame("Application Template");
   
      panel = (JPanel) frame.getContentPane();
      panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
      panel.setLayout(null);
   

      canvas = new Canvas();  
      canvas.setBounds(0, 0, WIDTH, HEIGHT);
      canvas.setIgnoreRepaint(true);
	  canvas.addKeyListener(this);
   
      panel.add(canvas);
   
      // frame operations
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setResizable(false);
      frame.setVisible(true);

      canvas.createBufferStrategy(2);
      bufferStrategy = canvas.getBufferStrategy();
      canvas.requestFocus();
      System.out.println("DONE graphic setup");
   
   }

	private void render() {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);

		if(isWinning == false) {
			if(isLosing == true){
				g.drawImage(losescreen, 0, 0, WIDTH, HEIGHT, null);
			}
			else {
				g.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
				g.drawImage(carpic1, cars[1].xpos, cars[1].ypos, cars[1].width, cars[1].height, null);
				g.drawImage(carpic2, cars[2].xpos, cars[2].ypos, cars[2].width, cars[2].height, null);
				g.drawImage(carpic3, cars[3].xpos, cars[3].ypos, cars[3].width, cars[3].height, null);
				g.drawImage(carpic4, cars[4].xpos, cars[4].ypos, cars[4].width, cars[4].height, null);
				g.drawImage(duckpic, duck.xpos, duck.ypos, duck.width, duck.height, null);
			}
		}
		else{
			g.drawImage(winscreen,0,0, WIDTH, HEIGHT,null);
		}

		g.dispose();

		bufferStrategy.show();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		if(e.getKeyCode() == 38){
			System.out.println("going up");
			duck.isNorth = true;
		}
		if(e.getKeyCode() == 39){
			System.out.println("going right");
			duck.isEast = true;
		}
		if(e.getKeyCode() == 37){
			System.out.println("going left");
			duck.isWest = true;
		}
		if(e.getKeyCode() == 40){
			System.out.println("going down");
			duck.isSouth = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 38){
			System.out.println("going up");
			duck.isNorth = false;
		}
		if(e.getKeyCode() == 40){
			System.out.println("going down");
			duck.isSouth = false;
		}
		if(e.getKeyCode() == 37){
			System.out.println("going left");
			duck.isWest = false;
		}
		if(e.getKeyCode() == 39){
			System.out.println("going right");
			duck.isEast = false;
		}
	}
}