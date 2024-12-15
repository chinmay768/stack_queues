import java.util.Stack;

public class MaximalRectangle {

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

    public static int maximalRectangle(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        int[][] prefixSum = new int[n][m];
        int maxArea = 0;

        //i = col and j = row
        for(int i = 0; i < m; i ++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                sum += arr[j][i];
                if(arr[j][i] == 0){
                    sum = 0;
                }
                prefixSum[j][i] = sum;
            }
        }

        for(int i = 0; i < arr.length; i++){
            maxArea = Math.max(maxArea, areaInHistogram(prefixSum[i]));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1}};

        int maxArea = maximalRectangle(arr);
        System.out.println(maxArea);
    }
}
