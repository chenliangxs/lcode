An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

Example:

Input:
[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2

Output: 6


=======================================

public int minArea(char[][] image, int x, int y) {
        if(image.length == 0 || image[0].length == 0) return 0;
        int[] boundary = {x, x, y, y};
        dfs(image, x, y, boundary);
        return (boundary[3] - boundary[2] + 1) * (boundary[1] - boundary[0] + 1);
    }
    public void dfs(char[][] image, int x, int y, int[] boundary){
        boundary[0] = Math.min(boundary[0], x);
        boundary[1] = Math.max(boundary[1], x);
        boundary[2] = Math.min(boundary[2], y);
        boundary[3] = Math.max(boundary[3], y);
        int[] dir = {1, 0, -1, 0, 0, 1, 0, -1};
        image[x][y] = '0';
        for(int d = 0; d < dir.length; d+=2){
            int row = x + dir[d];
            int col = y + dir[d + 1];
            if(row >= 0 && row < image.length && col >=0 && col < image[0].length){
                if(image[row][col] == '1'){
                    dfs(image, row, col, boundary);
                }
            }
        }
    }