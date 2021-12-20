package itmo.heroes;

import itmo.utility.MoodSign;
import itmo.utility.thing;

public class car extends thing {

    public car() {
        super("Машина");
        Join(getName());
    }

    public void New(MoodSign value) {
        setType(value);
        if (getType() == MoodSign.NEW) {
            setName("Новая Машина");
        }
        else {
            setName("Машина");
        }
    }
}
