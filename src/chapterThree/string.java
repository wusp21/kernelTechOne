package chapterThree;

import java.util.Scanner;

/**
 * @Author: wusp
 * @Date: 2020/12/6-15:35
 * @Description:
 * @version: 1.0
 */
public class string {
    public static void main(String[] args) {
        int[] app ={1,2,3,4,56,7};
        for (int i : app) {
            switch (i){
                case 1:
                    System.out.println("lsy,1120");
                    break;
                case 2:
                    System.out.println("hwy,1231");
                    break;
                case 3:
                    System.out.println("zyy,0510");
                    break;
                default:
                    System.out.println("3%一百个");
                    break;
            }

        }

    }
}
