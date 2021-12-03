package itmo;

public class mother extends parent {

    public mother() {
        super("Мама");
        Join(getName());
    }

    public void Forget(String value, MoodTypeorSign value2) {
        if (value2 == MoodTypeorSign.FORGETFUL) {
            System.out.println(getName() + " забыла унести " + value + " из комнаты.");
        }
        else {
            System.out.println(getName() + " унесла " + value + " из комнаты.");
        }
    }

    public void StopCleaning() {
        System.out.println(getName() + " закончила убирать.");
    }
}
