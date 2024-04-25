import java.awt.*;

public class Car {


    //VARIABLE DECLARATION SECTION
    //Here's where you state which variables you are going to use.
    public String name;                //holds the name of the hero
    public int xpos;                //the x position
    public int ypos;                //the y position
    public int dx;                    //the speed of the hero in the x direction
    public int dy;                    //the speed of the hero in the y direction
    public int width;
    public int height;
    public boolean isAlive;            //a boolean to denote if the hero is alive or dead.
    public Rectangle rec;

    public boolean isCrashing;
    public boolean isWrapping;
    public boolean isNorth;
    public boolean isSouth;
    public boolean isEast;
    public boolean isWest;
    public boolean isControlled;
    public boolean isLeft;
    public boolean isBouncing;

    // METHOD DEFINITION SECTION

    // Constructor Definition
    // A constructor builds the object when called and sets variable values.


    //This is a SECOND constructor that takes 3 parameters.  This allows us to specify the hero's name and position when we build it.
    // if you put in a String, an int and an int the program will use this constructor instead of the one above.
    public Car(int pXpos, int pYpos) {
        xpos = pXpos;
        ypos = pYpos;
        dx = 10;
        dy = 0;
        width = 100;
        height = 70;
        isAlive = true;
        rec = new Rectangle(xpos, ypos, width, height);
        isCrashing = false;
        isWrapping = false;
        isBouncing = false;
        isNorth = false;
        isEast = false;
        isSouth = false;
        isWest = false;
        isControlled = false;
        isLeft = true;

    } // constructor

    //The move method.  Everytime this is run (or "called") the hero's x position and y position change by dx and dy
    public void bounce() {
        if (isControlled) {

            if (isNorth == false && isSouth == false) {
                dy = 0;
            } else if (isNorth == true) {
                dy = -5;
            } else {
                dy = 5;
            }

            if (isWest == false && isEast == false) {
                dx = 0;
            } else if (isWest == true) {
                dx = -5;
            } else {
                dx = 5;
            }
        }

        if (xpos < 0 || xpos > 1000 - width) {
            dx = -dx;
        }
        if (ypos < 0 || ypos > 700 - height) {
            dy = -dy;
        }
        xpos = xpos + dx;
        ypos = ypos + dy;
        rec = new Rectangle(xpos, ypos, width, height);

    }

    public void wrap() {
        if (isControlled) {
            if (isNorth == false && isSouth == false) {
                dy = 0;
            } else if (isNorth == true) {
                dy = -5;
            } else {
                dy = 5;
            }

            if (isWest == false && isEast == false) {
                dx = 0;
            } else if (isWest == true) {
                dx = -5;
            } else {
                dx = 5;
            }
        }
       // else {
         //   dy = 0;
          //  dx = 7;
      //  }

        if (xpos < -40) {
            xpos = 1000 - width;
        }
        if (xpos > 1000 - width) {
            xpos = 0;
        }
        if (ypos < -40) {
            ypos = 700 - height;
        }
        if (ypos > 700 - height) {
            ypos = 0;
        }
        xpos = xpos + dx;
        ypos = ypos + dy;
        rec = new Rectangle(xpos, ypos, width, height);
    }

    public void car3wrap() {
        //dy = 0;
     //   dx = -7;

        if (xpos < -40) {
            xpos = 1000 - width;
        }
        if (xpos > 1000 - width) {
            xpos = 0;
        }
        if (ypos < -40) {
            ypos = 700 - height;
        }
        if (ypos > 700 - height) {
            ypos = 0;
        }
        xpos = xpos + dx;
        ypos = ypos + dy;
        rec = new Rectangle(xpos, ypos, width, height);
    }
}










