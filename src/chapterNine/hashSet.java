package chapterNine;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: wusp
 * @Date: 2020/11/11-17:13
 * @Description:
 * @version: 1.0
 */
public class hashSet {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        long totalTime = 0;
        try {
            System.out.println("请输入：");
            Scanner in = new Scanner(System.in);
            while (in.hasNext()){
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime =System.currentTimeMillis()- callTime;
                totalTime+=callTime;
            }
        }catch (Exception e){}
        Iterator<String> iterator = words.iterator();
        for (int i=0;i<20&&iterator.hasNext();i++){
            System.out.println(iterator.next());
        }
        System.out.println("....");
        System.out.println(words.size()+"distinct words."+totalTime+"milliseconds.");
    }
}
