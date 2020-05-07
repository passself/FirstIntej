package com.cn.passself.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 * 岛屿数量
 */
public class Leet200 {

    private int rows;
    private int cols;

    /**
     * BFS
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        boolean[][] marked = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果是岛屿中的一个点，并且没有被访问过
                // 从坐标为 (i,j) 的点开始进行广度优先遍历
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    LinkedList<Integer> queue = new LinkedList<>();
                    // 小技巧：把坐标转换为一个数字
                    // 否则，得用一个数组存，在 Python 中，可以使用 tuple 存
                    queue.addLast(i * cols + j);
                    // 注意：这里要标记上已经访问过
                    marked[i][j] = true;
                    while (!queue.isEmpty()) {
                        int cur = queue.removeFirst();
                        int curX = cur / cols;
                        int curY = cur % cols;
                        // 得到 4 个方向的坐标
                        for (int k = 0; k < 4; k++) {
                            int newX = curX + directions[k][0];
                            int newY = curY + directions[k][1];
                            // 如果不越界、没有被访问过、并且还要是陆地，我就继续放入队列，放入队列的同时，要记得标记已经访问过
                            if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                                queue.addLast(newX * cols + newY);
                                // 【特别注意】在放入队列以后，要马上标记成已经访问过，语义也是十分清楚的：反正只要进入了队列，你迟早都会遍历到它
                                // 而不是在出队列的时候再标记
                                // 【特别注意】如果是出队列的时候再标记，会造成很多重复的结点进入队列，造成重复的操作，这句话如果你没有写对地方，代码会严重超时的
                                marked[newX][newY] = true;
                            }
                        }
                    }
                }
            }

        }
        return count;
    }


    private boolean inArea(int x, int y) {
        // 等于号这些细节不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    /**
     * 并查集
     * 1.实现合并函数
     * 2.循环元素值 并判断左侧和右侧是否为陆地
     * 是：合并元素值
     * 否：不做处理
     *
     * 3.将海洋对应的nums数组位置置为-2
     * @param grid
     * @return
     */
    public int numIslands2(char[][] grid) {
        if(grid.length == 0) return 0;
        int x = grid.length;
        int y = grid[0].length;

        int[] nums = new int[x * y];
        Arrays.fill(nums, -1);
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(grid[i][j] == '1') {
                    grid[i][j] = '0';

                    //判断下侧是否有陆地
                    if(i < (x - 1) && grid[i + 1][j] == '1') {
                        union(nums, i * y + j, (i + 1) * y + j);
                    }

                    //判断右侧是否有陆地
                    if(j < (y - 1) && grid[i][j + 1] == '1') {
                        union(nums, i * y + j, i * y + j + 1);
                    }
                } else {
                    nums[i * y + j] = -2;
                }
            }
        }

        int count = 0;
        for(int num : nums) {
            if(num == -1) count++;
        }

        return count;
    }

    public int find(int[] parents, int i) {
        if(parents[i] == -1) {
            return i;
        }

        return find(parents, parents[i]);
    }

    public void union(int[] parents, int x, int y) {
        int xset = find(parents, x);
        int yset = find(parents, y);
        if(xset != yset) {
            parents[xset] = yset;
        }
    }

}
