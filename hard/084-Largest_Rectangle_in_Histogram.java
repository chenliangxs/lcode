// Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
//
//
// Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//
//
//
//
// The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
// =========================================================


public int largestRectangleArea(int[] heights) {
    Deque<Integer> stack = new ArrayDeque<>();
    int max = 0;
    for(int i=0; i<=heights.length;i++){
        int curHeight = (i == heights.length)? 0:heights[i];
        if(stack.isEmpty() || heights[stack.peek()] < curHeight){
            stack.offerFirst(i);
        }else{
            while(!stack.isEmpty() && heights[stack.peekFirst()] >= curHeight){
                int h = stack.pollFirst();
                if(stack.isEmpty()){
                    max = Math.max(max, heights[h] * i);
                }else{
                    max = Math.max(max, heights[h] * (i - stack.peekFirst() -1));
                }
            }
            stack.offerFirst(i);
        }
    }
    return max;
}
