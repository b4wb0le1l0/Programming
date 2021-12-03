package attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class PoisonPowder extends StatusMove {

    public PoisonPowder () {

        super(Type.POISON, 0.0D, 75.0D);
    }

    @Override
    protected String describe() {
        return "использует Poison Powder";
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        Effect.poison(pokemon);
    }
}
