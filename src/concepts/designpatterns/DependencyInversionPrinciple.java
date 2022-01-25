package concepts.designpatterns;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// A. High-level modules should not depend on low-level modules.
// Both should depend on abstractions.

// B. Abstractions should not depend on details.
// Details should depend on abstractions.


public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        // low-level module
//        Relationships relationships = new Relationships();
//        relationships.addParentAndChild(parent, child1);
//        relationships.addParentAndChild(parent, child2);

        String sentence = "this is a sample input for the problem";
        String longestWord = Arrays.stream(sentence.split(" "))
                .filter(s -> s.length() % 2 == 0)
                .max(Comparator.comparingInt(String::length))
                .orElse(" ");

        Languages ap;
        for(Languages a: Languages.values()){
        System.out.println(a+" "+ a.getcoders() +"coders.");
    }
    }
}

enum Languages{
    Python(10-10+10*10), Java(9+9*9-9), Angular(12*12-12-12);
    private int coders;
    Languages(int p)
    {
        coders = p;
    }
    int getcoders()
    {
        return coders;
    }
}


enum Relationship {
    PARENT,
    CHILD,
    SIBLING
}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }
}

interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
}

//class Relationships implements RelationshipBrowser {
//    public List<Person> findAllChildrenOf(String name) {
//
//        return relations.stream()
//                .filter(x -> Objects.equals(x.getValue0().name, name)
//                        && x.getValue1() == Relationship.PARENT)
//                .map(Triplet::getValue2)
//                .collect(Collectors.toList());
//    }
//
//    // Triplet class requires javatuples
//    private List<Triplet<Person, Relationship, Person>> relations =
//            new ArrayList<>();
//
//    public List<Triplet<Person, Relationship, Person>> getRelations() {
//        return relations;
//    }
//
//    public void addParentAndChild(Person parent, Person child) {
//        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
//        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
//    }
//}

class Research {
//    public Research(Relationships relationships) {
//        // high-level: find all of john's children
//        List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
//        relations.stream()
//                .filter(x -> x.getValue0().name.equals("John")
//                        && x.getValue1() == Relationship.PARENT)
//                .forEach(ch -> System.out.println("John has a child called " + ch.getValue2().name));
//    }
//
//    public Research(RelationshipBrowser browser) {
//        List<Person> children = browser.findAllChildrenOf("John");
//        for (Person child : children)
//            System.out.println("John has a child called " + child.name);
//    }
}