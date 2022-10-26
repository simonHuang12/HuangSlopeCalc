import java.util.Scanner;
public class LinearEquationRunner {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Linear Equation Calculator");

        System.out.print("Enter the first coordinate: "); //first coords
        String firstCoord = scanner.nextLine();
        int x1 = Integer.parseInt(firstCoord.substring(1, firstCoord.indexOf(", ")));
        int y1 = Integer.parseInt(firstCoord.substring(firstCoord.indexOf(", ") + 2, firstCoord.length() - 1));

        System.out.print("Enter the second coordinate: "); //second coords
        String secondCoord = scanner.nextLine();
        int x2 = Integer.parseInt(secondCoord.substring(1, secondCoord.indexOf(", ")));
        int y2 = Integer.parseInt(secondCoord.substring(secondCoord.indexOf(", ") + 2, secondCoord.length() - 1));

        System.out.println();

        if (x1 == x2) { //checks for undef slope
            System.out.println("The equation will be a vertical line: x = " + x1);
        } else {
            LinearEquation equation = new LinearEquation(x1, y1, x2, y2);
            System.out.println(equation.lineInfo());
            System.out.println();

            System.out.print("Enter an x-value: ");
            double xValue = scanner.nextDouble();
            System.out.println();
            System.out.println("The y-value for this point is: " + equation.coordinateForX(xValue));
            System.out.println();
        }
    }
}
