public class LinearEquation {
    private int x1; //instance variables
    private int y1;
    private int x2;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2){ //constructor
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public double distance(){ //finds distance between 2 points
        return roundedToHundredths(Math.hypot((x2-x1), (y2-y1)));
    }
    public double slope(){ //finds slope of 2 points
        return roundedToHundredths(y2-y1)/(x2-x1);
    }
    public int deltaY(){ //finds change in y
        return y2-y1;
    }
    public int deltaX(){ //finds change in x
        return x2-x1;
    }
    public double yIntercept(){ //finds y-int by solving for b in y=mx+b
        return y1-(slope()*x1);
    }
    public String equation() { //checks if slope is negative to prevent double negatives or negatives in delta x
        int deltaX = deltaX();
        int deltaY = deltaY();
        if (deltaX() < 0) {
            deltaX = deltaX() * -1;
            deltaY = deltaY() * -1;
        }
        if ((double)deltaY/deltaX == 1) { //checks if slope is 1 and leaves just x if it is
            return "y = " + "x + " + yIntercept();
        }else if ((double)deltaY/deltaX == -1) { //checks if slope is -1 and leaves -x if it is
            return "y = " + "-" + "x + " + yIntercept();
        }else if (deltaY % deltaX == 0){
            return "y = "+deltaY/deltaX+"x + " + yIntercept();
        }else return "y = "+deltaY+"/"+deltaX+"x + " + yIntercept();
    }
    public String lineInfo(){ //returns all info above
        return "The two points are: ("+x1+","+" "+y1+")"+" and "+"("+x2+","+" "+y2+")"+"\nThe equation of the line between these two points is: "+equation()+"\nThe slope of this line is: "+slope()+"\nThe y-intercept of the line is: "+yIntercept()+"\nThe distance between the two points is: "+distance();
    }
    public String coordinateForX(double yValue){
        return "("+yValue+", "+(roundedToHundredths(yValue*slope())+yIntercept())+")";
    }
    public double roundedToHundredths(double toRound){ //rounds
        return 0.01*Math.floor(toRound*100);
    }
}
