package itmo.heroes;

import itmo.utility.MoodSign;
import itmo.utility.alive;

public class frakenBok extends alive {

    public frakenBok() {
        super("Фрэкен Бок");
        Join(getName());
    }

    public void CalltoParents() {
        System.out.println("Позвонила по объявлению только одна женщина, её звали " + getName() + ".");
    }

    public void BokIs() {
        System.out.print(getName() + " оказалась ");
        setType(MoodSign.INCLEMENT);
        if (getType() == MoodSign.INCLEMENT) {
            System.out.print(" суровой ");
        }
        setType(MoodSign.ELDERY);
        if (getType() == MoodSign.ELDERY) {
            System.out.print(" пожилой дамой ");
        }
        setType(MoodSign.HIGH);
        if (getType() == MoodSign.HIGH) {
            System.out.print(" высокого роста, ");
        }
        setType(MoodSign.HEAVY);
        if (getType() == MoodSign.HEAVY) {
            System.out.print(" грузной и ");
        }
        setType(MoodSign.RESOLUTE);
        if (getType() == MoodSign.RESOLUTE) {
            System.out.print(" решительной дамой.");
        }
    }
}
