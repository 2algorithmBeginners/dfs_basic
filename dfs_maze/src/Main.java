public class Main {
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

    public static int maze_dfs(int [][] array, int x, int y, int answer) {
        printList(new int[] {x, y});
        int ret = -1;
        answer ++;
        if( x == array.length - 1 && y == array[0].length - 1) {
            return answer;
        }

        int tmp;
        int xtmp;
        int ytmp;
        for(int i = 0; i < ways.length; i ++) {
            xtmp = x + ways[i][0];
            ytmp = y + ways[i][1];

            if(xtmp > -1 && xtmp < array.length && ytmp > -1 && ytmp < array[0].length){
                if(array[xtmp][ytmp] == 1) {
                    array[x][y] = 0;
                    tmp = maze_dfs(array, xtmp, ytmp, answer);
                    array[x][y] = 1;
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
