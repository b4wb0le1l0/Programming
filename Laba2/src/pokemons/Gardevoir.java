package pokemons;

import attacks.PoisonPowder;
import ru.ifmo.se.pokemon.Type;

public class Gardevoir extends Kirlia {

    public Gardevoir (String var1, int var2) {

        super(var1, var2);

        PoisonPowder at4 = new PoisonPowder();

        setType(Type.PSYCHIC, Type.FAIRY);
        setStats(68.0D, 65.0D, 65.0D, 125.0D, 115.0D, 80.0D);
        addMove(at4);
    }
}
