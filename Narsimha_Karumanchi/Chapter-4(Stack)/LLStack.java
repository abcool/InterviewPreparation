import java.util.*;
class LLStack{
    static LinkedList<Integer> stack = new LinkedList<>();
    static int top=-1;
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        boolean flag=true;
        while (flag) { 
            System.out.println("\n Select the option");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Size");
            System.out.println("5. Is Empty");
            System.out.println("6. Exit");
            var option = scan.nextInt();
            switch(option){
                case 1-> {System.out.println("Enter value: "); push(scan.nextInt());}
                case 2-> pop();
                case 3-> top();
                case 4 -> size();
                case 5-> isEmpty();
                case 6 -> flag=false;
                default -> System.out.println("Invalid Option");
            }
        }
         scan.close();
    }
    private static void push(int data){
        stack.addFirst(data);
        top++;
    }

    private static void pop(){
        if(top==-1)
            System.out.println("Error! Stack is empty");
        else{
           System.out.printf("Element popped: %d",stack.removeFirst());
            top--;
        }
    }
    private static void top(){
        if(top==-1)
            System.out.println("Error! Stack is empty");
        else{
           System.out.printf("Element popped: %d",stack.getFirst());
        }
        
    }
    private static void size(){
        System.out.printf("Stack current size: %d",top+1);
    }
    private static void isEmpty(){
        System.out.println("Stack is empty: " + (top==-1));
    }
}