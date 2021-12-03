package attacks;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class BraveBird extends PhysicalMove {

    private double attack;

    public BraveBird () {

        super(Type.FLYING, 120.0D, 100.0D);
    }

    @Override
    protected String describe() {
        return "использует Brave Bird";
    }

    @Override
    protected void applySelfDamage(Pokemon pokemon, double v) {
        this.attack = pokemon.getStat(Stat.ATTACK);
        super.applySelfDamage(pokemon, this.attack * 1/3);
    }
}
