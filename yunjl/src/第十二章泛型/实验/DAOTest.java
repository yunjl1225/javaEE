package 第十二章泛型.实验;

import java.util.List;

/**
 定义一个测试类：
     创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方法来操作 User 对象，
     使用 Junit 单元测试类进行测试。
 * @author Yunjl
 * @create 2021-04-14 23:29
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();

        dao.save("1001",new User(1001,34,"周杰伦"));
        dao.save("1002",new User(1002,20,"昆凌"));
        dao.save("1003",new User(1003,25,"蔡依林"));

        dao.update("1003",new User(1003,30,"方文山"));

        //数据修改
        dao.update("1003",new User(1202264,4586,"lisdjk"));
        //数据删除
        dao.delete("1002");

        List<User> list = dao.list();
//        System.out.println(list);
        //或者
        list.forEach(System.out::println);


    }
}
