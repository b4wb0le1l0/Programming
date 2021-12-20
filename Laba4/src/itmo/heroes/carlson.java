package itmo.heroes;

import itmo.utility.MoodSign;
import itmo.utility.alive;

public class carlson extends alive {

    public carlson() {
        super("Карлсон");
        Join(getName());
    }

    public void Kick(String value, MoodSign value2) {
        setType(value2);
        if (getType() == MoodSign.LIGHTLY) {
            System.out.println(getName() + " легонько толкнул " + value + "a в спину.");
        }
        else {
            System.out.println(getName() + " толкнул " + value + "a в спину.");
        }
    }

    public void Laughed() {
        System.out.println(getName() + " расхохотался.");
    }

    public void Sullenly() {
        System.out.println(getName() + " надулся.");
    }

    public void LookAt(String value) {
        System.out.println(getName() + " посмотрел на " + value);
    }

    public void Scream(MoodSign value) {
        setType(value);
        if (getType() == MoodSign.HAPPY) {
            System.out.println(getName() + " вскрикнул от радости.");
        }
        else {
            System.out.println(getName() + " вскрикнул.");
        }
    }

    public void Rush(String value) {
        System.out.println(getName() + " кинулся к " + value + "у.");
    }

    public void Grab(String value) {
        System.out.println(getName() + " вцепился в " + value + ".");
    }
}
