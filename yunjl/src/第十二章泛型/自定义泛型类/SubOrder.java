package 第十二章泛型.自定义泛型类;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yunjl
 * @create 2021-04-14 21:38
 */
public class SubOrder extends Order<Integer> {  //SubOrder:不是泛型类


    public static <E> List<E> copyFromArrayToList(E[] arr) {

        ArrayList<E> list = new ArrayList<>();

        for (E e : arr) {
            list.add(e);
        }
        return list;

    }
}
