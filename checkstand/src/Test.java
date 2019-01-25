/**
 * Author:lorrie
 * Create:2019/1/25
 */
public class Test {
    public static void main(String[] args) {
        String str1 = "Hello" ;
        String str = new String("Hello") ;
        System.out.println(str1.equals(str));
        System.out.println("Hello".equals(str));
        System.out.println(str.equals("hello"));
    }
}
