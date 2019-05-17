package com.cn.passself.lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.lintcode.com/problem/max-points-on-a-line/solution
 *
 * 解法 https://www.lintcode.com/problem/max-points-on-a-line/note/172933
 *
 * 这道题给了我们一堆二维点，然后让我们求最大的共线点的个数，
 * 根据初中数学我们知道，两点确定一条直线，而且可以写成y = ax + b的形式，
 * 所有共线的点都满足这个公式。所以这些给定点两两之间都可以算一个斜率，
 * 每个斜率代表一条直线，对每一条直线，带入所有的点看是否共线并计算个数，
 * 这是整体的思路。但是还有两点特殊情况需要考虑，二是当两个点重合时，无法确定一条直线，
 * 但这也是共线的情况，需要特殊处理。二是斜率不存在的情况，
 * 由于两个点(x1, y1)和(x2, y2)的斜率k表示为(y2 - y1) / (x2 - x1)，那么当x1 = x2时斜率不存在，
 * 这种共线情况需要特殊处理。我们需要用到哈希表来记录斜率和共线点个数之间的映射，
 * 其中第一种重合点的情况我们假定其斜率为INT_MIN，
 * 第二种情况我们假定其斜率为INT_MAX，这样都可以用map映射了。
 * 我们还需要顶一个变量duplicate来记录重合点的个数，最后只需和哈希表中的数字相加即为共线点的总数
 */
public class Lintcode186 {

    class Point{
        int x;
        int y;
        Point(){
            x = 0;
            y = 0;
        }
        Point(int a, int b){
            x = a;
            y = b;
        }
    }

    public int maxPoints(Point[] points){
        if (points== null){
            return 0;
        }
        int max = 0;

        for (int i = 0; i < points.length; i++) {
            Map<String,Integer> hashMap = new HashMap<>();
            int maxPoints = 0,cover = 0,vertical= 0;

            for (int j = i+1; j < points.length; j++) {
                if (points[i].x == points[j].x){
                    if (points[i].y == points[j].y){
                        cover++;
                    }else {
                        vertical++;
                    }
                    continue;
                }
                int dx = points[i].x - points[j].x;
                int dy = points[i].y - points[j].y;
                int tmp = gcd(dx,dy);
                dx /= tmp;
                dy /= tmp;
                String kLine = dy + "/" + dx;

                if (!hashMap.containsKey(kLine)){
                    hashMap.put(kLine,0);
                }
                hashMap.put(kLine,hashMap.get(kLine)+1);
                maxPoints = Math.max(maxPoints,hashMap.get(kLine));
            }
            maxPoints = Math.max(maxPoints,vertical);
            max = Math.max(max,maxPoints+cover+1);
        }
        return max;
    }

    int gcd(int a,int b){
        if (b ==0){
            return a;
        }else {
            return gcd(b,a%b);
        }
    }
}
