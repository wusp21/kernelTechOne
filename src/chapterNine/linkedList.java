package chapterNine;

import java.util.*;

/**
 * @Author: wusp
 * @Date: 2020/11/11-15:10
 * @Description:
 * @version: 1.0
 */
public class linkedList{
    public static void main(String[] args) {
        List<String> apd = new LinkedList<>();
        String a = "a";
        apd.add(a);
        apd.add("b");
        apd.add("c");
        if(apd instanceof RandomAccess){
            System.out.println("bingo");
        }else {
            System.out.println("NO");
        }
        ListIterator<String> iterator = apd.listIterator();

        System.out.println("next"+iterator.next());
        iterator.add("d");
        iterator.add("e");
        iterator.next();
        iterator.remove();
        System.out.println("next"+iterator.previous());
        System.out.println("list"+apd);

    }


}
