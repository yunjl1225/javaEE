package 第十五章反射;

/**
 * @author Yunjl
 * @create 2021-04-16 21:48
 */
public class Person {
    private String name;
    public  int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private  Person(String name) {
        this.name = name;
    }
    public Person() {

    }

    public void show(){
        System.out.println("你好");
    }
    private String showNation(String nation ){
        System.out.println("我的国籍是："+nation);
        return nation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
