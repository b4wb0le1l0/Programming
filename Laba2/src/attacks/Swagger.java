package attacks;

import ru.ifmo.se.pokemon.*;

public class Swagger extends StatusMove {

    public Swagger () {

        super(Type.NORMAL, 0.0D, 85.0D);
    }

    @Override
    protected String describe() {
        return "использует Swagger";
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.ATTACK, 2);
        Effect.confuse(pokemon);
    }
}
