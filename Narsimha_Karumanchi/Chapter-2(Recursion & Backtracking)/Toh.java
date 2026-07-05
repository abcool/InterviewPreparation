import java.util.Scanner;
class Toh{
    public static void main(String[] args) {
        System.out.println("Enter the number of disks");
        var scan = new Scanner(System.in);
        var n = scan.nextInt();
        scan.close();
        printToh(n,'S','A','D');
    }
    private static void printToh(int n, char s, char a, char d){
        if(n==1){
            System.out.printf("Move disk %d from %c to %c \n",n, s,d);
            return;
        }
        printToh(n-1, s, d, a);
        System.out.printf("Move disk %d from %c to %c \n",n, s,d);
        printToh(n-1, a, s, d);
    }
}