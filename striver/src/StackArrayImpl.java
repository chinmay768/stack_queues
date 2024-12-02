public class StackArrayImpl {

    static int top = -1;
    static int stackSize = 10;
    static int[] stack = new int[stackSize];

    public static void push(int data){
        if(top >= stackSize) return;

        top++;
        stack[top] = data;
    }

    public static int top(int data) {
        if(top == -1) return -1;

        return stack[top];
    }

    public static void main(String[] args) {
        System.out.println("hellos");
    }
}
