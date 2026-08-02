import java.util.*;
class ArrayStack{
    static int capacity;
    static int[] stack;
    static int top=-1;

    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        System.out.println("Enter stack capacity");
        capacity = scan.nextInt();
        if(capacity<=0){
            System.out.println("Invalid capacity");
            return;
        }
        stack = new int[capacity];
        boolean flag = true;
        while (flag) { 
            System.out.println("\n Select the option");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Size");
            System.out.println("5. Is Empty");
            System.out.println("6. Is Full");
            System.out.println("7. Exit");
            var option = scan.nextInt();
            switch(option){
                case 1-> {System.out.println("Enter value: "); push(scan.nextInt());}
                case 2-> pop();
                case 3-> top();
                case 4 -> size();
                case 5-> isEmpty();
                case 6 -> isFull();
                case 7 -> flag=false;
                default -> System.out.println("Invalid Option");
            }
        }
        scan.close();
    }

    private static void push(int data){
        if(top==capacity-1){
            System.out.println("Error! Stack is already full");
        }else{
            stack[++top]=data;
        }
    }

    private static void pop(){
        if(top==-1)
            System.out.println("Error! Stack is empty");
        else
           System.out.printf("Element popped: %d",stack[top--]);
    }

    private static void top(){
        if(top==-1)
            System.out.println("Error! Stack is empty");
        else
            System.out.printf("Top Element: %d",stack[top]);
    }

    private static void size(){
        System.out.printf("Stack current size: %d",top+1);
    }

    private static void isEmpty(){
        System.out.println("Stack is empty: " + (top==-1));
    }

    private static void isFull(){
        System.out.println("Stack is full: " + (top==capacity-1));
    }
}