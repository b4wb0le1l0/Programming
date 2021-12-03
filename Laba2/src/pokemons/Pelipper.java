package pokemons;

import attacks.Confide;
import attacks.DoubleTeam;
import attacks.EnergyBall;
import attacks.Rest;
import ru.ifmo.se.pokemon.Type;

public class Pelipper extends Wingull {

    public Pelipper (String var1, int var2) {

        super(var1, var2);

        Confide at1 = new Confide();
        Rest at2 = new Rest(60.0D);
        DoubleTeam at3 = new DoubleTeam();
        EnergyBall at4 = new EnergyBall();

        setType(Type.WATER, Type.FLYING);
        setStats(60.0D, 50.0D, 100.0D, 95.0D, 70.0D, 65.0D);
        setMove(at1, at2, at3, at4);

    }
}
