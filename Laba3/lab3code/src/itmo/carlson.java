package itmo;

public class carlson extends parent {

    public carlson() {
        super("Карлсон");
        Join(getName());
    }

    public void Kick(String value, MoodTypeorSign value2) {
        if (value2 == MoodTypeorSign.LIGHTLY) {
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

    public void Scream(MoodTypeorSign value) {
        if (value == MoodTypeorSign.HAPPY) {
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
