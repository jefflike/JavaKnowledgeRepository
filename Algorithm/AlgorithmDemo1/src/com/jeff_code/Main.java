package com.jeff_code;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个有序数组A，另一个无序数组B，请打印B中的所有不在A中的数，A数组长度为N，B数组长度为M。
 */
public class Main {

    public static void main(String[] args) {
        // 有序数组A
        int[] A = {1, 2, 5, 8, 12};
        // 无序数组B
        int[] B = {10, 3, 2, 5, 1, 7};
        // 临时数组
        List<Integer> temp = new ArrayList<>();
        // 标志位
        boolean flag = false;

        // 遍历B，每个B中的数再遍历A进行对比，是否相等
        for (int i = 0; i < B.length; i++) {

            for (int j = 0; j < A.length; j++) {
                if(B[i] == A[j]){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                temp.add(B[i]);
            }

            flag = false;
        }

        System.out.println(temp);
    }
}

/*
Tips: 1. 我们不要在for循环里写remove操作；
2. array是不可以进行add或者remove操作的，创建时大小就已经固定了；
3. Arrays.aList()返回的是一个List集合；
4. 循环完记得把标志位换回来。
 */