package 第十一章集合.Collection接口;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 区分List中remove(int index)和remove(Object obj)

 * @author Yunjl
 * @create 2021-04-13 19:21
 */
public class ListExer {
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }
    private static void updateList(List list) {
        list.remove(2);     //删除索引为2 的数据
        list.remove(new Integer(2));    //  删除值为2 的数据
    }
}
