public class Main {

    /*
     * our game marker can only moves up, left, down, and right.
     * let's assign those moves in two-dimensional array.
     * with this array, we can easily iterate the implementation for each moves
     */
    public static int[][] ways = {
        {-1, 0},
        {0, -1},
        {1, 0},
        {0, 1},
    };

    public static void main(String[] args) {
        int [][] maze = new int[][] {
                {1, 0, 1, 1, 1, 1},
                {1, 0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1, 1},
                {1, 1, 1, 0, 0, 1},
        };

        System.out.println(
                "maze walkthrough: " + maze_dfs(maze, 0, 0, 0) + "!"
        );
    }

    /*
     * recursive method for dfs.
     * our marker makes recursive moves.
     * if there is place which marker can move, we do next recursion on next place.
     */
    public static int maze_dfs(int [][] array, int x, int y, int answer) {
        printList(new int[] {x, y});
        int ret = -1;
        answer ++;
        if( x == array.length - 1 && y == array[0].length - 1) {
            return answer;
        }

        int tmp;
        int xtmp; // To assign next step
        int ytmp; // To assign next step
        /*
         * you may use 4 step of if & else to watch all possible step!
         * but we already assigned ways. and the codes are exactly same.
         * by using for-loop we can make code more DRY.
         */
        for(int i = 0; i < ways.length; i ++) {
            xtmp = x + ways[i][0];
            ytmp = y + ways[i][1];

            if(xtmp > -1 && xtmp < array.length && ytmp > -1 && ytmp < array[0].length){
                if(array[xtmp][ytmp] == 1) {
                    array[x][y] = 0; // to avoid returning step which causes infinite loop.
                    tmp = maze_dfs(array, xtmp, ytmp, answer);
                    array[x][y] = 1; // after travel we need to recover for using next iteration.
                    // if we found the way to out. just return answer!
                    if(tmp != -1)
                        return tmp;
                }
            }
        }

        return ret;
    }

    // helper function for print
    public static void printList(int[] list){
        for(int i = 0; i < list.length; i ++)
            System.out.print(list[i] + "-");
        System.out.println();
    }
}
