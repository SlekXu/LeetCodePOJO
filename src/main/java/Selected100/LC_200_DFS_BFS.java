package Selected100;

import org.junit.Test;

/*岛屿数量
 *
 *
 * * */
public class LC_200_DFS_BFS {

    /**
     * 利用深度优先遍历
     */
    public int numIslands_DFS(char[][] grid) {
        return 0;
    }


    @Test
    public void test() {
        char[][] grid_1 = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int islands_1 = numIslands_DFS(grid_1);

        char[][] grid_2 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int islands_2 = numIslands_DFS(grid_2);
    }
}
