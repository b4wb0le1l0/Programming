
import pokemons.*;
import ru.ifmo.se.pokemon.*;


public class Back {
    public static void main(String[] arg) {

        Battle b = new Battle();

        Passimian i1 = new Passimian("Бебра", 47);
        Wingull i2 = new Wingull("Морген", 47);
        Pelipper i3 = new Pelipper("Дося", 47);

        Ralts j1 = new Ralts("Мишка Фредэ", 47);
        Kirlia j2 = new Kirlia("Шелби", 47);
        Gardevoir j3 = new Gardevoir("Макавто", 47);

        b.addAlly(i1);
        b.addAlly(i2);
        b.addAlly(i3);

        b.addFoe(j1);
        b.addFoe(j2);
        b.addFoe(j3);

        b.go();
    }
}
