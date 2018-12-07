
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6

================================================
public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] heights = new int[matrix[0].length];
        int max = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    heights[j] = heights[j]+1;
                }else{
                    heights[j] = 0;
                }
            }
            max = Math.max(max, maxRectangle(heights));
        }
        return max;
    }
    public int maxRectangle(int[] array){
        if(array.length == 0) return 0;
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<=array.length; i++){
            int height = (i==array.length)?0:array[i];
            if(stack.isEmpty() || array[stack.peekFirst()] < height){
                stack.offerFirst(i);
            }else{
                while(!stack.isEmpty() && array[stack.peekFirst()] >= height){
                    int index = stack.pollFirst();
                    if(stack.isEmpty()){
                        max = Math.max(max, array[index] * i);
                    }else{
                        max = Math.max(max, array[index] * (i - stack.peekFirst() - 1));
                    }
                }
                stack.offerFirst(i);
            }
        }
        return max;
    }

=====================================================
matrix[i][j] = 0 dp[i][j] = 0;

dp[i][j]