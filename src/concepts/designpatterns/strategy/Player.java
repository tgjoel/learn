package concepts.designpatterns.strategy;

public class Player {
    String type;
    Behaviour behaviour;

    public Player(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Behaviour getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(Behaviour behaviour) {
        this.behaviour = behaviour;
    }

    public String getCurrentStrategy() {
        return this.behaviour.getStrategy();
    }
}
