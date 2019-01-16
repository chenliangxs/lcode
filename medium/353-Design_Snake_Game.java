/**
Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.

The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.

Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.

When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

Example:

Given width = 3, height = 2, and food = [[1,2],[0,1]].

Snake snake = new Snake(width, height, food);

Initially the snake appears at position (0,0) and the food at (1,2).

|S| | |
| | |F|

snake.move("R"); -> Returns 0

| |S| |
| | |F|

snake.move("D"); -> Returns 0

| | | |
| |S|F|

snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

| |F| |
| |S|S|

snake.move("U"); -> Returns 1

| |F|S|
| | |S|

snake.move("L"); -> Returns 2 (Snake eats the second food)

| |S|S|
| | |S|

snake.move("U"); -> Returns -1 (Game over because snake collides with border)
**/
class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */

    //char[][] board;
    int width;
    int height;
    int[][] food;
    List<int[]> snake;
    int curFoodIndex;
    Set<String> path;

    public SnakeGame(int width, int height, int[][] food) {
        //board = new char[height][width];
        this.width = width;
        this.height = height;
        this.food = food;
        curFoodIndex = 0;
        snake = new LinkedList<>();
        snake.add(new int[]{0, 0});
        path = new HashSet<>();
        path.add("0,0");
    }

    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
        @return The game's score after the move. Return -1 if game over.
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int nextRow = snake.get(snake.size() - 1)[0];
        int nextCol = snake.get(snake.size() - 1)[1];
        if(direction.equals("U")) {
            nextRow -= 1;
        } else if(direction.equals("L")) {
            nextCol -= 1;
        } else if(direction.equals("R")) {
            nextCol += 1;
        } else {
            nextRow += 1;
        }
        if(nextRow < 0 || nextCol < 0 || nextRow >= height || nextCol >= width) {
            return -1;
        }
        String tmp = nextRow + "," + nextCol;
        snake.add(new int[]{nextRow, nextCol});
        if(curFoodIndex < food.length && nextRow == food[curFoodIndex][0] && nextCol == food[curFoodIndex][1]) {
            curFoodIndex++;
            while(curFoodIndex < food.length && path.contains(food[curFoodIndex][0] + "," + food[curFoodIndex][1])) {
                curFoodIndex++;
            }
            path.add(tmp);
            return snake.size() - 1;
        }
        String toRemove = snake.get(0)[0] + "," + snake.get(0)[1];
        snake.remove(0);
        path.remove(toRemove);
        if(path.contains(tmp)) {
            return -1;
        }
        path.add(tmp);
        return snake.size() - 1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
