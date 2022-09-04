package Daily;

import org.junit.Test;

/**
 * @Author Slek
 * @Date 2022/9/4 21:51
 * @Description 二进制矩阵中的特殊位置
 * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
 */
public class LC_1582 {

    /**
     * 1、统计每行l，每列c包含的1的个数
     */
    public int numSpecial(int[][] mat) {
        int LINE = mat.length;
        int COL = mat[0].length;
        int res = 0;

        int[] r = new int[LINE];
        int[] c = new int[COL];
        for (int i = 0; i < LINE; i++) {
            for (int j = 0; j < COL; j++) {
                r[i] += mat[i][j];              //核心逻辑
                c[j] += mat[i][j];
            }
        }
        for (int i = 0; i < LINE; i++) {
            for (int j = 0; j < COL; j++) {
                if (mat[i][j] == 1 && r[i] == 1 && c[j] == 1) res++;
            }
        }
        return res;
    }

    public int numSpecial_true(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int ans = 0;
        int[] r = new int[n];
        int[] c = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                r[i] += mat[i][j];
                c[j] += mat[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && r[i] == 1 && c[j] == 1) ans++;
            }
        }
        return ans;
    }


    @Test
    public void test() {
        int[][] mat = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 0, 0, 0}
        };

        System.out.println(numSpecial(mat));
    }
}
