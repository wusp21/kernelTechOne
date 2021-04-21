package chapterThree;

import javafx.beans.binding.When;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author: wusp
 * @Date: 2020/12/15-9:17
 * @Description:
 * @version: 1.0
 */
public class test {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        int dayOfMonth = today.getDayOfMonth();
        int dayOfWeek = today.getDayOfWeek().getValue();
        System.out.println("一  二  三  四  五  六  七  ");
        LocalDate begin = today.minusDays(dayOfMonth - 1);
        int beginDayOfWeek = begin.getDayOfWeek().getValue();
        for (int i = 0; i <beginDayOfWeek ; i++) {
            System.out.print("  ");
        }
        while (begin.getMonth() == today.getMonth()){
            System.out.print(begin.getDayOfMonth());
            if (begin.getDayOfWeek().getValue() == 7){
                System.out.println("");
            }else {
                System.out.print(" ");
            }
            begin = begin.plusDays(1);
        }
    }
}
