package StringInmutable;

public class Main {

    public static void main(String[] args) {
        String s = "Hello";
        String s4 = "Hello";
        String s2 = s + " World";
        String s1 = "Hello World";
        if(s2 == s1){
            System.out.println("s2 and s1 have same reference");
        } else {
            System.out.println("s2 and s1 have different reference");
        }
        if(s2.equals(s1)){
            System.out.println("s2 and s1 have same content");
        } else {
            System.out.println("s2 and s1 have different content");
        }

        if(s == s1){
            System.out.println("s and s1 have same reference");
        } else {
            System.out.println("s and s1 have different reference");
        }
        if(s.equals(s1)){
            System.out.println("s and s1 have same content");
        } else {
            System.out.println("s and s1 have different content");
        }

        if(s == s4){
            System.out.println("s and s4 have same reference");
        } else {
            System.out.println("s and s4 have different reference");
        }
        if(s.equals(s4)){
            System.out.println("s and s4 have same content");
        } else {
            System.out.println("s and s4 have different content");
        }

        changeString(s);

    }

    public static void changeString(String s){
        s = "World1";
        if(s.equals("World1")){
            System.out.println("s is World1");
        } else {
            System.out.println("s is not World1");
        }
    }
}