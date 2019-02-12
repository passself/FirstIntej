package com.cn.passself.tree;

/*udpate for git*/
public class Sort {

    private static int[] array = {23, 11, 7, 29, 33, 59, 8, 20, 9, 3, 2, 6, 10, 44, 83, 28, 5, 1, 0, 36};

    public static void main(String[] args) {

        for(int i = 0; i< selectSort(array).length; i++){
            System.out.print(selectSort(array)[i]+"->");
        }
        System.out.println();
        for(int i = 0; i< bubble(array).length; i++){
            System.out.print(bubble(array)[i]+"-");
        }
    }

    public static int[] selectSort(int[] array){
        if(array.length == 0){
            return array;
        }

        for(int i=0;i<array.length-1;i++){
            // 定义最大数字的下标，默认为0
            int maxIndex = 0;

            for(int j=0; j <array.length-i; j++){
                //找到比自己大的数就更新下标
                if(array[maxIndex]<array[j]){
                    maxIndex = j;
                }
            }
            //将找到最大的数与最后一个数字交换
            int temp = array[array.length-i-1];
            array[array.length-i-1] = array[maxIndex];
            array[maxIndex] = temp;
        }
        return array;
    }

    public static int[] bubble(int[] array) {
        if(array == null || array.length == 0){
            return array;
        }

        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0;j<array.length - i-1;j++){
                if (array[j]>array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j]= temp;
                }
            }
        }
        return array;
    }


}
