import java.util.Scanner;

/**
 * Created by Oleg on 27.11.2016.
 */
public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static int m, n;
    private static boolean sure;

    public static void main(String[] args) {

        if (args.length == 2) {
            sure = setNumbers(args);
        }
        while (!sure){
            System.out.println("Enter two positive numbers separated comma and press enter:");
            if(scan.hasNext()) {
                String[] values = scan.nextLine().split(",");
                sure = setNumbers(values);
            }
        }

        My_Array arr = new My_Array(m, n);

        while (sure){
            System.out.println("Enter " + m * n + " numbers separated comma and press enter:");
            if(scan.hasNext()) {
                String[] values = scan.nextLine().split(",");
                sure = !arr.addValue(values);
            }
        }

        arr.print();
        arr.removeColumnsWithMinValue();
        arr.print();
    }

    private static boolean setNumbers(String[] size){
        try{
            m = Integer.parseInt(size[0].trim());
            n = Integer.parseInt(size[1].trim());
        }catch (Exception ex){
            System.out.println("You wrote the wrong values, try again!");
        }
        return (m > 0 &&n > 0);
    }
}
