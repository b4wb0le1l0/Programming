package attacks;

import ru.ifmo.se.pokemon.*;

import java.util.Random;

public class EnergyBall extends SpecialMove {

    public EnergyBall () {

        super(Type.GRASS, 90.0D, 100.0D);
    }

    @Override
    protected String describe() {
        return "использует Energy Ball";
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {

        Random rand = new Random();
        int value = rand.nextInt((9 - 0) + 1) + 0;

        if (value <= 3)
        {
            pokemon.setMod(Stat.SPECIAL_DEFENSE, -1);
        }
        else
        {
            value = 0;
        }
    }
}
