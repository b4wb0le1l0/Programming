package itmo;

public class baby extends parent {

    public baby() {
        super("Малыш");
        Join(getName());
    }

    public void NotDonated(String value) {
        if (getType() == MoodTypeorSign.UPSET) {
            System.out.println("Увы "+ value + " не была подарена " + getName() + "у.");
        }
        else {
            System.out.println(value + " не была подарена " + getName() + "у.");
        }
    }
}
