package 第十一章集合.Collection接口;

import java.util.Objects;

/**
 *
 * 其中Person类中重写了hashCode()和equal()方法
 * @author Yunjl
 * @create 2021-04-14 1:01
 */
public class Person {
    public  String name;
    private int age;

    public Person() {
    }

    public Person(int age,String name) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
