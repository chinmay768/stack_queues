public class TrappingRainWater {

    static int trappingRainWaterNaive(int[] arr){
        int res = 0;

        int[] prefixMax = new int[arr.length];
        prefixMax[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }

        int[] suffixMax = new int[arr.length];
        suffixMax[arr.length - 1]  = arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 0; i--){
            suffixMax[i] = Math.max(suffixMax[i + 1], arr[i]);
        }

        for(int i = 0; i < arr.length; i++){
            res += Math.min(prefixMax[i], suffixMax[i]) - arr[i];
        }

        return res;
    }

    static int trappingRainWater(int[] arr){
        int left = 0;
        int right = arr.length -1;
        int lMax = 0;
        int rMax = 0;

        int res = 0;
        while (left < right){
            if(arr[left] <= arr[right]){
                if(lMax > arr[left]){
                    res += lMax - arr[left];
                }else {
                    lMax = arr[left];
                }

                left++;
            }else{
                if(rMax > arr[right]){
                    res += rMax - arr[right];
                }else{
                    rMax = arr[right];
                }
                right--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int res = trappingRainWater(arr);
        System.out.println(res);
    }
}
