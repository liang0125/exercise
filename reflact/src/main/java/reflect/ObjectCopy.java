package reflect;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author:lorrie
 * Create:2019/2/28
 */

/**
 * 复制对象的属性
 * 1.将source中的属性名和类型与target中的属性名和类型相同的值赋值给target
 * 2. 比如：
 * source :
 * int age
 * String name
 * Date birthday
 *
 * target:
 * int age
 * String school
 * Date birthday
 *
 * 结果：
 * source (age, birthday ) copy  target(age, birthday)
 */
public class ObjectCopy {
    public static void copy(Object source,Object target){
        Class src=source.getClass();
        Class tar=target.getClass();
        Field[] srcFields=src.getDeclaredFields();
        Field[] tarFields=tar.getDeclaredFields();
        for(Field f:srcFields){
            f.setAccessible(true);
            String setMethod="set"+f.getName().substring(0,1).toUpperCase()+(f.getName().substring(1).length()>1?f.getName().substring(1):"");
           for(Field tf:tarFields){
                tf.setAccessible(true);
                if(f.getName()==tf.getName()&&f.getType()==tf.getType()){
                    try {
                        Method method=tar.getMethod(setMethod,f.getType());
                        method.invoke(target,f.get(source));
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
               else {
                    continue;
               }

            }
        }
    }

    public static void main(String[] args) {
        Person person=new Person(20,"Jack");
        Student student=new Student();
        copy(person,student);
        System.out.println(person.toString());
        System.out.println(student.toString());
    }
}
class Person {
    private int age;
    private String name;
    private String look;

    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", look='" + look + '\'' +
                '}';
    }
}
class Student{
    private int age;
    private String name;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}