package 第十一章集合.练习;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 1.请从键盘随机输入10个整数保存到List中，并按倒序、从大到小的顺序显示出来
 *
 * @author Yunjl
 * @create 2021-04-14 16:25
 */
public class Exer1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[10];

        ArrayList list = new ArrayList();

        System.out.println("请输入10个整数：");
        for (int i = 0; i < 10; i++) {
            arr[i] = scan.nextInt();
            list.add(arr[i]);
        }
        Collections.reverse(list);
        System.out.println(list);

    }
}
