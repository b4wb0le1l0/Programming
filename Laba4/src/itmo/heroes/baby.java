package itmo.heroes;

import itmo.utility.MoodSign;
import itmo.utility.alive;

public class baby extends alive {

    public baby() {
        super("Малыш");
        Join(getName());
    }

    public void NotDonated(String value, MoodSign value2) {
        setType(value2);
        if (getType() == MoodSign.UPSET) {
            System.out.println("Увы "+ value + " не была подарена " + getName() + "у.");
        }
        else {
            System.out.println(value + " не была подарена " + getName() + "у.");
        }
    }

     public void Visiting(String value) {
        System.out.println(getName() + " гостит у " + value + "а.");
     }

     public void SitandConsider(String value) {
        System.out.println(getName() + " сидел и рассматривал оригинальные" + value + " у себя дома.");
     }
}
