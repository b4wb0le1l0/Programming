package pokemons;

import attacks.AirSlash;
import attacks.BraveBird;
import attacks.NightSlash;
import attacks.RockTomb;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Passimian extends Pokemon {

    public Passimian (String var1, int var2) {

        super(var1, var2);

        RockTomb at1 = new RockTomb();
        NightSlash at2 = new NightSlash();
        BraveBird at3 = new BraveBird();
        AirSlash at4 = new AirSlash();

        setType(Type.FIGHTING);
        setStats(100.0D, 120.0D, 90.0D, 40.0D, 60.0D, 80.0D);
        setMove(at1, at2, at3, at4);
    }
}
