import java.util.Stack;

public class LargestRectangleInHistrogram {

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

    public static int areaInHistogramNaive(int[] arr){
        int[] nse = findNse(arr);
        int[] pse = findPse(arr);

        int maxArea = 0;
        for(int i = 0; i < arr.length; i++){
            maxArea = Math.max(maxArea, arr[i] * (nse[i] - pse[i] - 1));
        }

        return maxArea;
    }

    public static int areaInHistogram(int[] arr){
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            while (!st.isEmpty() && arr[i] < arr[st.peek()]){
                int elm = st.pop();
                int previousSmallerIdx = (!st.isEmpty())? st.peek() : -1;
                maxArea = Math.max(maxArea, arr[elm] * (i - previousSmallerIdx - 1));
            }
            st.push(i);
        }

        while (!st.isEmpty()){
            int nse = arr.length;
            int idx = st.pop();
            int pse = (st.isEmpty())? -1 : st.peek();

            maxArea = Math.max(maxArea, arr[idx] * (nse - pse - 1));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};

        int maxArea = areaInHistogram(arr);
        System.out.println(maxArea);
    }
}
