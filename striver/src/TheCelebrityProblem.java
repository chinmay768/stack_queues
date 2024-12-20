public class TheCelebrityProblem {

    public static int findCelebrityNaive(int[][] matrix){
        int[] knowMe = new int[matrix.length];
        int[] iKnow = new int[matrix.length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(matrix[i][j] == 1){
                    knowMe[j]++;
                    iKnow[i]++;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            if(knowMe[i] == matrix.length - 1 && iKnow[i] == 0)
                return i;
        }

        return -1;
    }

    public static int findCelebrity(int[][] matrix){
        int top = 0;
        int bottom = matrix.length-1;

        while (top < bottom){
            if(matrix[top][bottom] == 1){
                top++;
            }else if(matrix[bottom][top] == 1){
                bottom--;
            }else{
                top++;
                bottom--;
            }
        }

        if(top > bottom) return -1;

        for (int i = 0; i < matrix.length; i++){
            if(i == top) continue;
            if(matrix[top][i] == 0 && matrix[i][top] == 1){

            }else{
                return -1;
            }
        }

        return top;
    }

    public static void main(String[] args) {
        int[][] mat = { {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0} };

        int celeb = findCelebrity(mat);
        System.out.println(celeb);
    }
}
