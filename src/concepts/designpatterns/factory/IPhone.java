package concepts.designpatterns.factory;

public class IPhone implements Phone {


    @Override
    public void getSpec() {
        System.out.println("Most secured");
    }
}
