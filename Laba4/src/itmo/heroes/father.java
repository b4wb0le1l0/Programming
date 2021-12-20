package itmo.heroes;

import itmo.utility.alive;

public class father extends alive {

    public father() {
        super("Папа");
        Join(getName());
    }

    public void Solvetosmth(String value) {
        System.out.println(getName() + " и " + value + " решили нанять домработницу.");
    }

    public void SubmidAd() {
        System.out.println("На следующий день они дали объявление в газете.");
    }
}
