package cn.hz.iving.java;

import android.util.Log;

public class Utils {

    /**
     * 整数在内存的表现形式
     *
     * @param number
     */
    public static void printIntBinaryInMemory(int number) {
        int numberSizeinMemory = 32;
        int[] binaryArray = new int[numberSizeinMemory];
        if (number >=0) {
            number = number;
        } else {
            number = -number - 1;
        }


        int tmp = number;
        for (int i = 0; i < 32; i++) {
            int binary = tmp % 2;
            binaryArray[numberSizeinMemory - i - 1] = binary;
            tmp = tmp / 2;
        }
        print(binaryArray);


    }

    private static void print(int[] binaryArray) {
        StringBuilder sb = new StringBuilder();
        for (int b : binaryArray) {
            sb.append(b);

        }
        Log.d("Utils", "print sb=" + sb);

    }


}
