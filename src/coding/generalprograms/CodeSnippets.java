package coding.generalprograms;

import coding.generalprograms.pojo.People;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class CodeSnippets {

    //1 Errors handling in java
    public static void main(String[] args) {

        A a = new B();
        B b = new B();

//        try { test(); }
//        catch (Exception ex) { System.out.print("exception "); }
//        System.out.print("end ");

       Map<People, Boolean> peopleBooleanMap = new HashMap<>();
       People people1 = new People(10,"AAA");
       People people2 = new People(10,"AAA");
       peopleBooleanMap.put(people1, true);
       peopleBooleanMap.put(people2, true);
        //System.out.println(peopleBooleanMap.size());

         //addMethod(10,10);
         //addMethod(10,10);
       // System.out.println(String.class.getClassLoader());
        // prints null as string is in bootstrap class path and bootstrap is not written in java,
        // hence its object cannot be retrived
       // System.out.println(CodeSnippets.class.getClassLoader()); // present in application class loader.
//       try {
//           checkException();
//       } catch (Exception e) {
//           System.out.println("Mains catch block");
//       }
//        System.out.println("Main continues");
    }

    private static void checkException() throws Exception {
        try {
            System.out.println("In try block");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("In catch block");
            //throw new Exception();
        } finally {
            System.out.println("In finally block");
            //throw new Exception();
        }
        System.out.println("After catch block");
    }

    static void addMethod(float f, int i) {
        System.out.println(f + " " + i);
    }

    static void addMethod(int f, float i) {
        System.out.println(f + " " + i);
    }

    static void test() throws Error {
        if (true) throw new AssertionError();
        System.out.print("test ");
    }

    static int test1() {
      try {
          return 1;
      } catch (Exception e) {
         // return 2;
      }
      return 3;
    }



}

    class A {
        int i;
//        public A() {
//            System.out.println("Inside A");
//        }
        public A(int i) {
            System.out.println("Inside Param A");
        }
//        public void display() throws IOException{
//            System.out.println();
//        }
    }
    class B extends A {
        public B() {
            super(0); // Either there should be default constructor in the superclass or need to call the super
            System.out.println("Inside B");
        }
//        public void display() { //throws Exception {
//            System.out.println();
//        }
    }

class A1 {
    public void display() throws IOException {
        System.out.println();
    }
}
class B1 extends A1 {
    public void display() throws FileNotFoundException { //throws Exception {
        System.out.println();
    }
}

