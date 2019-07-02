package com.cn.passself.lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/course-schedule/description
 * 拓扑排序
 */
public class Lintcode615 {

    /**
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses,int[][] prerequisites){
        if(numCourses == 0 || prerequisites.length ==0){
            return true;
        }

        int[] inDegree = new int[numCourses];
        List[] edge = new ArrayList[numCourses];

        for (int i = 0;i < numCourses; i++)
            edge[i] = new ArrayList<Integer>();

        for(int i = 0; i < prerequisites.length; i++){
            inDegree[prerequisites[i][0]] += 1;
            edge[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            count++;
            int curCourse = queue.poll();
            int n = edge[curCourse].size();
            for(int i = 0; i < n; i++){
                int pointer = (int)edge[curCourse].get(i);
                inDegree[pointer] -= 1;
                if(inDegree[pointer] == 0){
                    queue.add(pointer);
                }
            }
        }
        System.out.println(count);
        return numCourses == count;
    }
}
