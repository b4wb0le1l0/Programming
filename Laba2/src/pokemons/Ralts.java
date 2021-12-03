package pokemons;

import attacks.Swagger;
import attacks.SwordsDance;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Ralts extends Pokemon {

    public Ralts (String var1, int var2) {

        super(var1, var2);

        SwordsDance at1 = new SwordsDance();
        Swagger at2 = new Swagger();

        setType(Type.PSYCHIC, Type.FAIRY);
        setStats(28.0D, 25.0D, 25.0D, 45.0D, 35.0D, 40.0D);
        setMove(at1, at2);
    }
}
