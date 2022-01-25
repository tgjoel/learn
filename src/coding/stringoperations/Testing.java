package coding.stringoperations;


import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.function.ToIntBiFunction;

public class Testing {
    public static void main(String[] args)  {
//        A a = new A();
//        System.out.println(">>");
//        B b = new B();
//        System.out.println(">>");
//        A b2 = new B();
//        System.out.println(">>");
//        C c = new C();
//        System.out.println(">>");
//        B c2 = new C();

    }
    static Integer getAsc(String s) {
        return s.length();
    }
}

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
class Parent implements Serializable {
    String name;
    //Parent() {  /// >>>>>>>>>>>>>>>>  This is required if the child class is not having the constructor
    //}

     Parent(String name) {
        this.name = name;
    }
    void method1() {
        System.out.println("Parent -> method1");
    }
    public static void method11() {
        System.out.println("Parent -> method1");
    }
}

class Child extends Parent {
    Child(String name) {
        super(name);
    }

    void method1()  {
        System.out.println("Parent -> method1");
    }
}
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 class A {
    public A() {
        System.out.println("Hi!");
    }
}
 class B extends A {
     public B() {
         System.out.println("Bye!");
     }
 }

 class C extends B {
    public C() {
        System.out.println("See you!");
    }
 }

//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
class Base{

    public String getX() {
        return "2";
    }

    public void method(int i) {
        System.out.println("Value is : " + i);
    }
}

abstract class MyBase {
    abstract void amethod();
    static  int i;
}

class Bean {
    interface inter {
        void beanInterFace();
    }

    class Beanl implements inter {
        public void beanInterFace() {

        }
    }
}
