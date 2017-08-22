package com.cn.passself.random;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by shx on 2017/8/2.
 */
public class WeightRandom {

    private Pair[] options;
    private double[] cumulativeProbabilities;
    private Random rnd;

    public WeightRandom(Pair[] options){
        this.options = options;
        this.rnd = new Random();
        prepare();
    }

    private void prepare(){
        int weights = 0;
        for (Pair pair:options){
            weights += pair.getWeight();
        }
        cumulativeProbabilities = new double[options.length];
        int sum = 0;
        for (int i = 0; i < options.length; i++) {
            sum += options[i].getWeight();
            cumulativeProbabilities[i] = sum/(double)weights;
        }
    }

    public Object nextItem(){
        double randomValue = rnd.nextDouble();
        int index = Arrays.binarySearch(cumulativeProbabilities,randomValue);
        if (index < 0){
            index = -index -1;
        }
        return options[index].getItem();
    }
}
