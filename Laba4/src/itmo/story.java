package itmo;

import itmo.heroes.*;
import itmo.utility.MoodSign;

public class story {
    public static void main(String [] arg) {

        carlson caruch = new carlson();
        baby tiny = new baby();
        car car = new car();
        VacuumCleaner pulesos = new VacuumCleaner();
        mother mom = new mother();
        doctor doc = new doctor();
        stamps marki = new stamps();
        father dad = new father();
        bosse Bosse = new bosse();
        betan Betan = new betan();
        frakenBok Bok = new frakenBok();

        System.out.println("\nСцена 1\n");

        caruch.Laughed();
        caruch.Kick(tiny.getName(), MoodSign.LIGHTLY);
        car.New(MoodSign.NEW);
        tiny.NotDonated(car.getName(), MoodSign.UPSET);
        caruch.Sullenly();
        pulesos.isOn(MoodSign.NORMALY);
        mom.Forget(pulesos.getName(), MoodSign.FORGETFUL);
        mom.StopCleaning();
        caruch.LookAt(pulesos.getName());
        caruch.Scream(MoodSign.HAPPY);
        caruch.Rush(pulesos.getName());
        caruch.Grab(pulesos.getName());

        System.out.println("\nСцена 2\n");

        tiny.Visiting(caruch.getName());
        mom.Visit(doc.getName());
        mom.BeLate();
        mom.Back();
        tiny.SitandConsider(marki.getName());
        mom.InvitetoDinner();
        mom.WhoaTheTable(dad.getName(), Bosse.getName(), Betan.getName(), tiny.getName());
        dad.Solvetosmth(mom.getName());
        dad.SubmidAd();
        Bok.CalltoParents();
        Bok.BokIs();
    }
}
