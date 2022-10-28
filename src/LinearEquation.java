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
    } //distance formula
    public double slope(){ //finds slope of 2 points
        return roundedToHundredths(((double) y2-y1)/((double) x2-x1));
    }
    public int deltaY(){ //finds change in y
        return y2-y1;
    } //change in y
    public int deltaX(){ //finds change in x
        return x2-x1;
    } //change in x
    public double yIntercept(){ //finds y-int by solving for b in y=mx+b
        return roundedToHundredths(y1-(slope()*x1));
    }
    public String equation() { //checks if slope is negative to prevent double negatives or negatives in delta x
        int deltaX = deltaX();
        int deltaY = deltaY();
        String isYIntNegative = " + ";
        String yInt = "";
        double yIntValue = yIntercept();
        if (yIntercept()<0){ //checks for negative y-int and converts the sign if so
            isYIntNegative = " - ";
            yIntValue = yIntercept() * -1;
        }
        if (yIntercept() != 0){ //non-zero y-ints will have their signs properly put in
            yInt = isYIntNegative+yIntValue;
        }
        if (deltaX() < 0) { //checks if there is double negative in delta y over delta x and makes it positive if it is
            deltaX = deltaX() * -1;
            deltaY = deltaY() * -1;
        }
        if ((double) deltaY / deltaX == 1) { //checks if slope is 1 and leaves just x if it is
            return "y = " + "x"+yInt;
        } else if ((double) deltaY / deltaX == -1) { //checks if slope is -1 and leaves -x if it is
            return "y = -x"+yInt;
        }  else if ((double)deltaY/deltaX == 0) { //checks if slope is 0 and removes the slope and x entirely if it is
            return "y = " + yIntercept();
        }else if (deltaY % deltaX == 0) { //checks if slope can be reduced
            return "y = " + deltaY / deltaX + "x"+yInt;
        } return "y = " + deltaY + "/" + deltaX + "x"+yInt; //otherwise will leave them as is
    }
    public String lineInfo(){ //returns all info above
        return "The two points are: ("+x1+","+" "+y1+")"+" and "+"("+x2+","+" "+y2+")"+"\nThe equation of the line between these two points is: "+equation()+"\nThe slope of this line is: "+roundedToHundredths(slope())+"\nThe y-intercept of the line is: "+yIntercept()+"\nThe distance between the two points is: "+distance();
    }
    public String coordinateForX(double yValue){ //gives the y-value given a corresponding x-value
        return "("+yValue+", "+(roundedToHundredths(yValue*slope()+yIntercept()))+")";
    }
    public double roundedToHundredths(double toRound){ //rounds
        return (double) Math.round(toRound * 100.0) / 100.0;
    }
}
