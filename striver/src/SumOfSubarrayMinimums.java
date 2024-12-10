import java.util.*;
public class SumOfSubarrayMinimums {

    public static int[] findNse(int[] arr){
        int[] nse = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            nse[i] = stack.isEmpty()? arr.length : stack.peek();

            stack.push(i);
        }
        return nse;
    }

    public static int[] findPse(int[] arr){
        int[] pse = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++){
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                stack.pop();
            }

            pse[i] = stack.isEmpty()? -1 : stack.peek();

            stack.push(i);
        }

        return pse;
    }

    public static int mininumSum(int[] arr){
        int[] nse = findNse(arr);
        int[] pse  = findPse(arr);

        int total = 0;
        int mod = (int) (1e9 + 7);

        for(int i = 0; i < arr.length; i++){
            int left = i - pse[i];
            int right = nse[i] - i;

            total = (int) (total + (right * left * 1L * arr[i]) % mod) % mod;
        }
        return total;
    }



    public static void main(String[] args) {
        int[] arr = {11,81,94,43,3};

        int mininumSum = mininumSum(arr);
        System.out.println(mininumSum);

    }
}
