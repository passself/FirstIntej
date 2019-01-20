package com.cn.passself.test;

/**
 * Created by shx on 2018/7/22.
 */
public class TestDemo {
    private int count;
    public static void main(String[] args){
        TestDemo demo = new TestDemo(88);
        System.out.println(demo.count);

        int i = 0;
        for(foo('A');foo('B')&&(i<2);foo('C')){
            i ++;
            foo('D');
        }
        //ABDCBDCB

        int[] numbers = {10,20,15,0,6,7,2,1,-5,55};

        quickSort(0,numbers.length-1,numbers);
        for (int j=0;j<numbers.length;j++){
            System.out.printf(numbers[j]+"->");
        }
        int[] numbers2 = {10,20,15,0,6,7,2,1,-5,55};
        System.out.println();
        int[] sortArray = selectedSort(numbers2);
        for (int j=0;j<sortArray.length;j++){
            System.out.printf(sortArray[j]+"-");
        }
    }


    public static int[] selectedSort(int[] array){
        if (array == null || array.length == 0){
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j =i+1; j < array.length; j++) {
                if (array[i] > array[j]){
                    /*int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;*/
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }

    TestDemo(int a){
        count = a;
    }

    static boolean foo(char c){
        System.out.println(c);
        return true;
    }

    public static int getMiddle2(int low,int high,int[] array){
        if (array == null || array.length ==0){
            return 0;
        }
        int temp = array[low];

        while (low < high){
            while (low<high && temp < array[high]){
                high --;
            }

            array[low] = array[high];//比中轴小的记录移到低端
            while (low<high && temp>array[low]){
                low ++;
            }
            array[high] = array[low];//比中轴大的记录到高端

            array[low] = temp;
        }
        return low;
    }

    public static int getMiddle(int low,int high,int[] array){
        if(array == null || array.length<2){
            return 0;
        }
        int temp = array[low];

        while(low<high){

            while(low<high && temp<array[high]){
                high --;
            }
            array[low]=array[high];
            while(low<high && temp>array[low]){
                low ++;
            }
            array[high]=array[low];
            array[low]= temp;
        }
        return low;
    }

    public static void quickSort(int low,int high,int[] array){
        if (low < high){
            int middle = getMiddle(low,high,array);
            quickSort(low,middle-1,array);
            quickSort(middle+1,high,array);
        }
    }
}
