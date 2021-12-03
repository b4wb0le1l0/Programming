package attacks;

import ru.ifmo.se.pokemon.*;

public class Rest extends StatusMove {

    private double HP;
    private double Attack;
    private double Defense;
    private double SpAtk;
    private double SpDef;
    private double Speed;

    public Rest (double hp) {
        super(Type.PSYCHIC, 0.0D, 0.0D, 0, 2);
        this.HP = hp;
    }

    @Override
    protected String describe() {
        return "использует Rest";
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        Effect.sleep(pokemon);

        this.Attack = pokemon.getStat(Stat.ATTACK);
        this.Defense = pokemon.getStat(Stat.DEFENSE);
        this.SpAtk = pokemon.getStat(Stat.SPECIAL_ATTACK);
        this.SpDef = pokemon.getStat(Stat.SPECIAL_DEFENSE);
        this.Speed = pokemon.getStat(Stat.SPEED);

        pokemon.setStats(this.HP, this.Attack, this.Defense, this.SpAtk, this.SpDef, this.Speed);
    }
}
