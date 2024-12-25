import java.util.Stack;

public class ValidateStackSequences {

    public static boolean validateStackSequencesNaive(int[] pushed, int[] popped){
        Stack<Integer> st = new Stack<>();

        int popIdx = 0;
        for(int i = 0; i < pushed.length; i++){
            st.push(pushed[i]);

            while (!st.isEmpty() &&st.peek() == popped[popIdx]){
                st.pop();
                popIdx++;
            }
        }

        return st.isEmpty();
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped){
        int top = -1;
        int j = 0;
        for(int i = 0; i < pushed.length; i++){
            top++;
            pushed[top] = pushed[i];

            while (top >= 0 && pushed[top] == popped[j]){
                top--;
                j++;
            }
        }

        return top == -1;
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,3,5,1,2};

        System.out.println(validateStackSequences(pushed, popped));
    }
}
