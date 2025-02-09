package concepts.designpatterns.strategy;

public class StrategyClientClass {

    /*
        Example of the counterstrike game
        Before bomb is planted, Terrorist -> attack | CounterTerrorist -> Defend
        After bomb is planted, Terrorist -> defend | CounterTerrorist -> attack

        Example :  An employee can have different roles to perform at time.
    */

    public static void main(String[] args) {

        System.out.println("Before bomb is planted!!");
        Player terrorist = new Player("Terrorist");
        terrorist.setBehaviour(new AttackingBehaviour());
        Player counterTerrorist = new Player("Counter_Terrorist");
        counterTerrorist.setBehaviour(new DefensiveBehaviour());
        System.out.println("Terrorist: " + terrorist.getCurrentStrategy());
        System.out.println("CounterTerrorist:  " + counterTerrorist.getCurrentStrategy());

        System.out.println("!!After bomb is planted");
        terrorist.setBehaviour(new DefensiveBehaviour());
        counterTerrorist.setBehaviour(new AttackingBehaviour());
        System.out.println("Terrorist: " + terrorist.getCurrentStrategy());
        System.out.println("CounterTerrorist:  " + counterTerrorist.getCurrentStrategy());

    }
}
