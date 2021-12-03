package itmo;

public class car extends parent {

    public car() {
        super("Машина");
        Join(getName());
    }

    public void New(MoodTypeorSign value) {
        if (value == MoodTypeorSign.NEW) {
            setName("Новая Машина");
        }
        else {
            setName("Машина");
        }
    }
}
