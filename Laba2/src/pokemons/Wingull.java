package pokemons;

import attacks.Confide;
import attacks.DoubleTeam;
import attacks.Rest;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Wingull extends Pokemon {

    public Wingull (String var1, int var2) {

        super(var1, var2);

        Confide at1 = new Confide();
        Rest at2 = new Rest(40.0D);
        DoubleTeam at3 = new DoubleTeam();

        setType(Type.WATER, Type.FLYING);
        setStats(40.0D, 30.0D, 30.0D, 55.0D, 30.0D, 85.0D);
        setMove(at1, at2, at3);
    }
}
