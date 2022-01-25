package concepts.designpatterns.factory;

public class AndroidPhone implements Phone{

    @Override
    public void getSpec() {
        System.out.println("Most popular");
    }
}
