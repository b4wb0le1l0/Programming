package itmo.heroes;

import itmo.utility.MoodSign;
import itmo.utility.alive;

public class mother extends alive {

    public mother() {
        super("Мама");
        Join(getName());
    }

    public void Forget(String value, MoodSign value2) {
        setType(value2);
        if (getType() == MoodSign.FORGETFUL) {
            System.out.println(getName() + " забыла унести " + value + " из комнаты.");
        }
        else {
            System.out.println(getName() + " унесла " + value + " из комнаты.");
        }
    }

    public void StopCleaning() {
        System.out.println(getName() + " закончила убирать.");
    }

    public void Visit(String value) {
        System.out.println(getName() + " на приёме у " + value + "а.");
    }

    public void BeLate() {
        System.out.println(getName() + " задержалась дольше, чем рассчитывала.");
    }

    public void Back() {
        System.out.println(getName() + " вернулась.");
    }

    public void InvitetoDinner() {
        System.out.println(getName() + " позвала всех обедать.");
    }

    public void WhoaTheTable(String value1, String value2, String value3, String value4) {
        System.out.println(getName() + " и "+ value1 + " сели за стол вместе с " + value2 + ", " + value3 + " и " + value4 + ".");
    }
}
