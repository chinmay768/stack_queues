import java.util.*;

public class SlidingWindowMaximum {

    public static int[] slidingWindowMaxNaive(int[] arr, int k){
        int[] res = new int[arr.length - k + 1];

        for(int i = 0; i <= arr.length - k; i++){
            int currMax = arr[i];
            for(int j = i; j <= i + 3 - 1; j++ ){
                if(arr[j] > currMax)
                    currMax = arr[j];
            }
            res[i] = currMax;
        }
        return res;
    }

    public static int[] slidingWindowMax(int[] arr, int k){
        int[] res = new int[arr.length - k + 1];

        Deque<Integer> st = new ArrayDeque<>();

        for(int i = 0; i < arr.length; i++){
            if(i >= k - 1 && !st.isEmpty() && st.getFirst() <= i - k){
                st.removeFirst();
            }

            while (!st.isEmpty() && arr[st.getLast()] <= arr[i]){
                st.removeLast();
            }
            st.offer(i);
            if(i >= k - 1) res[i - k + 1] = arr[st.getFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        int k = 1;

        int[] res = slidingWindowMax(arr, k);
        System.out.println(Arrays.toString(res));
    }
}
