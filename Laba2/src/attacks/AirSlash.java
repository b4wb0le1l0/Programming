package attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

import java.util.Random;

public class AirSlash extends SpecialMove {

    public AirSlash () {

        super(Type.FLYING, 75.0D, 95.0D);
    }

    @Override
    protected String describe() {
        return "использует Air Slash";
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {

        Random rand = new Random();
        int value = rand.nextInt((10 - 0) + 1) + 0;

        if (value <= 3)
        {
            Effect.flinch(pokemon);
        }
        else
        {
            value = 0;
        }
    }
}
