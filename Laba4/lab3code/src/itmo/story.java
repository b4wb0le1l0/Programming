package itmo;

public class story {
    public static void main(String [] arg) {

        carlson g1 = new carlson();
        baby g2 = new baby();
        car g3 = new car();
        VacuumCleaner g4 = new VacuumCleaner();
        mother g5 = new mother();

        System.out.println();

        g1.Laughed();
        g1.Kick(g2.getName(), MoodTypeorSign.LIGHTLY);
        g3.New(MoodTypeorSign.NEW);
        g2.NotDonated(g3.getName());
        g1.Sullenly();
        g4.isOn(MoodTypeorSign.GOOD);
        g5.Forget(g4.getName(), MoodTypeorSign.FORGETFUL);
        g5.StopCleaning();
        g1.LookAt(g4.getName());
        g1.Scream(MoodTypeorSign.HAPPY);
        g1.Rush(g4.getName());
        g1.Grab(g4.getName());
    }
}
