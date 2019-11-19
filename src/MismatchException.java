import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MismatchException {
    public static void main (String [] Args){
        /**interactive loop*/
        while(menu() != true) {
            int [] array = new int[4];//will hold grades

            scanGrades(array);//scan grades

            printGrades(array);//print grades

            gradeAverages(array);//process and display average
        }
    }
    /**Calculates and prints average*/
    private static void gradeAverages(int[] array) {
        DecimalFormat nf = new DecimalFormat("##0.00");//0.00 formatter
        int sum = 0;//holds sum
        for (int index = 0; index < array.length; index++){//sum loop
            sum = sum + array[index];
        }
        System.out.println("Student Average:\t \t"+nf.format(sum/4)+"\n");//print average
    }

    /**scan in grades into array*/
    private static void scanGrades(int[] array) {
        for (int index = 0; index < array.length; index++) {//scan loop
            System.out.print("Enter four grades between 0 and 100:\t");//prompt user
            array[index] = processInput(0, 100, 1);//processing input
        }
    }

    /**Prints array*/
    private static void printGrades(int[] array) {
        System.out.print("Entered grades are:\t \t");
        for(int index = 0; index < array.length;index++ ){//display loop
            if (index == array.length-1)
                System.out.println(array[index]);//last index
            else
                System.out.print(array[index]+", ");//values at index
        }
    }

    /**Main menu*/
    private static boolean menu() {
        System.out.println("*********************");
        System.out.println("******Main Menu******");
        System.out.println("*********************");
        System.out.println("0 - Exit Program" +
                "\n1 - Run Program");
        if (processInput(0,1, 0)== 0)
            return true;
        else
            return false;
    }

    /**user choice processing*/
    private static int processInput(int smallest, int largest, int bSwitch) {
        Scanner inputInt = new Scanner(System.in);//new scanner
        boolean isInt = false;
        int choice = -1;

        while (isInt != true) {//data validation
            try {
                choice = inputInt.nextInt();//scan

                if (choice >= smallest && choice <= largest)//if good
                    isInt = true;//exit loop
                else {//if not good
                    isInt = false;//stay in loop
                    System.out.print("Incorrect input, re-enter 0 or 1:\t");
                }
            }catch (InputMismatchException ex){//data validation
                if (bSwitch == 0)
                    System.out.print("Incorrect input, re-enter 0 or 1:\t");//error message 0
                else
                    System.out.print("Incorrect input, re-enter valid grades:\t");//error message 0
                isInt = false;//stay in loop
                inputInt.nextLine();//empty scanner
            }
        }
        return choice;//return valid choice only
    }
}
