package pokemons;

import attacks.WoodHammer;
import ru.ifmo.se.pokemon.Type;

public class Kirlia extends Ralts {

    public Kirlia (String var1, int var2) {

        super(var1, var2);

        WoodHammer at3 = new WoodHammer();

        setType(Type.PSYCHIC, Type.FAIRY);
        setStats(38.0D, 35.0D, 35.0D, 65.0D, 55.0D, 50.0D);
        addMove(at3);
    }
}
