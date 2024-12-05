import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {

    public static int[] nextGreaterElementNaive(int[] arr){
        int[] nge = new int[arr.length];
        Arrays.fill(nge, -1);

        for(int i = 0; i < arr.length; i++){
            for (int j = i + 1; j <= i + arr.length; j++){
                int idx = j % arr.length;
                if(arr[idx] > arr[i]){
                    nge[i] = arr[idx];
                    break;
                }
            }
        }
        return nge;
    }

    public static int[] nextGreaterElement(int[] arr){
        int[] nge = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        int n = arr.length;
        for (int i = 2 * n; i >= 0; i--){
            while (!st.isEmpty() && st.peek() <= arr[i % n]){
                st.pop();
            }

            if(i < n){
                nge[i] = st.isEmpty()? -1 : st.peek();
            }

            st.push(arr[i % n]);
        }
        return nge;
    }

    public static void main(String[] args) {
        int[] arr = {2, 10, 12, 1, 11};

        int[] res = nextGreaterElement(arr);
        System.out.println(Arrays.toString(res));
    }
}
