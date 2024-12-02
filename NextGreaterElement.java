import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreaterElementNaive(int[] arr){
        int[] res = new int[arr.length];
        Arrays.fill(res, -1);

        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if(arr[i] < arr[j]){
                    res[i] = arr[j];
                    break;
                }
            }
        }

        return res;
    }

    public static int[] nextGreaterElement(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];

        for(int i = arr.length - 1; i >= 0; i--){
            while (!st.isEmpty() && st.peek() <= arr[i]) st.pop();

            if(st.isEmpty()) res[i] = -1;
            else res[i] = st.peek();

            st.push(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {6, 0, 8, 1, 3};

        System.out.println(Arrays.toString(nextGreaterElementNaive(arr)));
        System.out.println(Arrays.toString(nextGreaterElement(arr)));
    }
}
