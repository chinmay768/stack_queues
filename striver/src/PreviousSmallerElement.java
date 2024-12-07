import java.util.Arrays;
import java.util.Stack;

public class PreviousSmallerElement {

    public static int[] previousSmallerElementNaive(int[] arr){
        int[] pse = new int[arr.length]; //previous smaller element
        Arrays.fill(pse, -1);

        for( int i = 0; i < arr.length; i++){
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] < arr[i]){
                    pse[i] = arr[j];
                    break;
                }
            }
        }

        return pse;
    }

    public static int[] previousSmallerElement(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[arr.length];

        for(int i = 0 ; i < arr.length; i++){
            while (!st.isEmpty() && st.peek() >= arr[i]){
                st.pop();
            }

            pse[i] = st.isEmpty()? -1 : st.peek();

            st.push(arr[i]);
        }
        return pse;
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 8, 5, 10, 8};
        int[] pse = previousSmallerElement(arr);

        System.out.println(Arrays.toString(pse));
    }
}
