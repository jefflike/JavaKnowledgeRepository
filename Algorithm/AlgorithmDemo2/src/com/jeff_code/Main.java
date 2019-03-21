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

            flag = binarySearch(A, B[i]);
            if(!flag){
                temp.add(B[i]);
            }

            flag = false;
        }

        System.out.println(temp);
    }

    static boolean binarySearch(int[] array, int num){//
        int min = 0;
        int max = array.length - 1;
        if(num < array[min] || num > array[max] || min > max){
            return false;
        }
        while (min <= max){
            int mid = (max + min) / 2;
            if((max + min) % 2 != 0){
                mid += 1;
            }
            if(num > array[mid]){
                min = mid + 1;
            }else if(num < array[mid]){
                max = mid - 1;
            }else if(num == array[mid]){
                return true;
            }
        }
        return false;
    }
}

