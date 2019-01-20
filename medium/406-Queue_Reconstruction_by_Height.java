/**
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.


Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
**/
public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, new Comparator<int[]>(){
        public int compare(int[] i1, int[] i2) {
            if(i1[0] == i2[0]) {
                return i1[1] - i2[1];
            }
            return i1[0] - i2[0];
        }
    });
    int len = people.length;
    int[][] res = new int[len][2];
    for(int i = 0; i < len; i++) {
        Arrays.fill(res[i], -1);
    }
    for(int[] p : people) {
        int height = p[0];
        int count = p[1];
        int x = 0;
        for(int i = 0; i < len; i++) {
            if(x == count && res[i][0] == -1) {
                res[i][0] = height;
                res[i][1] = count;
            }
            if(res[i][0] >= height || res[i][0] == -1) {
                x++;
            }
        }
    }
    return res;
}
