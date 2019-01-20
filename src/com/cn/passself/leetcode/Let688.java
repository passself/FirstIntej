package com.cn.passself.leetcode;

import java.util.Arrays;

/**
 * Created by shx on 2019/1/20.
 */
public class Let688 {

        public static double knightProbability(int N, int K, int r, int c) {
            int [][] moves = {{1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2},{-2,1},{-2,-1}};
            double [][] tempDp = new double[N][N];
            for(double [] row : tempDp){
                Arrays.fill(row, 1);
            }

            for(int step = 0; step<K; step++){
                double [][] innerDp = new double[N][N];
                for(int i = 0; i<N; i++){
                    for(int j = 0; j<N; j++){
                        for(int [] move : moves){
                            int row = i + move[0];
                            int col = j + move[1];
                            if(isInnerBoard(row, col, N)){
                                innerDp[row][col] += tempDp[i][j];
                            }
                        }
                    }
                }
                tempDp = innerDp;
            }
            return tempDp[r][c]/Math.pow(8,K);
        }

        private static boolean isInnerBoard(int row, int col, int len){
            return row>=0 && row<len && col>=0 && col<len;
        }

    public static void main(String[] args) {
        double probability = knightProbability(3,2,0,0);
        System.out.printf("probability is:"+probability);
    }
}
