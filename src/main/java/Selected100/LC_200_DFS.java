package Selected100;

import org.junit.Test;

/*岛屿数量
 *
 *
 * * */
public class LC_200_DFS {

    /**
     * 利用DFS深度优先遍历
     * 1、判断是否越界
     * 2、如何去除已经遍历过的位置
     */
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    int area = getArea(grid, r, c);
                    res ++;
                }
            }
        }
        return res;
    }

    private int getArea(char[][] grid, int r, int c) {
        if (!inGrid(grid, r, c)) {
            return 0;
        }

        if (grid[r][c] != '1') {  //此处不是陆地
            return 0;
        }

        grid[r][c] = '2';   //标记为2，表示已经遍历过

        return 1
                + getArea(grid, r - 1, c)      //向(r,c)的前后左右遍历
                + getArea(grid, r + 1, c)
                + getArea(grid, r, c - 1)
                + getArea(grid, r, c + 1);
    }


    /*判断(r,c)是否越界*/
    private boolean inGrid(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }


    @Test
    public void test() {
        char[][] grid_1 = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int islands_1 = numIslands(grid_1);
        System.out.println(islands_1);


        char[][] grid_2 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int islands_2 = numIslands(grid_2);
        System.out.println(islands_2);
    }
}
