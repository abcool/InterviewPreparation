import java.util.*;
class Factorial{
    public static void main(String[] args) {
        System.out.println("Enter a number");
        var scan = new Scanner(System.in);
        var number = scan.nextInt();
        System.out.printf("Factorial of %d is %d \n",number,factorial(number));
    }

    private static int factorial(int number){
        if(number<=1)
            return number;
        else
            return number*factorial(number-1);
    }
}