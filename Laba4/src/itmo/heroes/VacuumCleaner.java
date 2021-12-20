package itmo.heroes;

import itmo.utility.MoodSign;
import itmo.utility.thing;

public class VacuumCleaner extends thing {

    public VacuumCleaner() {
        super("Пылесос");
        Join(getName());
    }

    public void isOn(MoodSign value) {
        setType(value);
        if (getType() == MoodSign.TURNEDOFF) {
            setName("Выключенный Пылесос");
        }
        else {
            setName("Пылесос");
        }
    }
}
