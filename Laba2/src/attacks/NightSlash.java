package attacks;

import ru.ifmo.se.pokemon.*;
import java.util.Random;

public class NightSlash extends PhysicalMove {

    public NightSlash () {

        super(Type.DARK, 70.0D, 10.0D);
    }

    @Override
    protected String describe() {
        return "использует Night Slash";
    }

    // Night Slash deals damage and has an increased critical hit ratio (1⁄8 instead of 1⁄24).

    @Override
    protected double calcCriticalHit(Pokemon pokemon, Pokemon pokemon1) {
        Random r = new Random();

        int value = r.nextInt((7 - 0) + 1) + 0;

        if (value == 1)
        {
            return 2.0D;
        }
        else
        {
            return 1.0D;
        }
    }
}
