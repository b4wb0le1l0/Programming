package itmo;

public class VacuumCleaner extends parent {

    public VacuumCleaner() {
        super("Пылесос");
        Join(getName());
    }

    public void isOn(MoodTypeorSign value) {
        if (value == MoodTypeorSign.TURNEDOFF) {
            setName("Выключенный Пылесос");
        }
        else {
            setName("Пылесос");
        }
    }
}
