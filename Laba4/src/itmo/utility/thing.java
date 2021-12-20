package itmo.utility;

import java.util.Objects;

public abstract class thing implements UsefulInterface {

    private String NAME;
    private MoodSign SIGN = MoodSign.NORMALY;

    public thing(String name) {
        this.NAME = name;
    }

    public thing(String name, MoodSign type) {
        this.NAME = name;
        this.SIGN = type;
    }

    public void Join(String name) {
        System.out.println(name + " в истории!");
    }

    public String getName() {
        return this.NAME;
    }

    public void setName(String name) {
        this.NAME = name;
    }

    public MoodSign getType() {
        return this.SIGN;
    }

    public void setType(MoodSign value) {
        this.SIGN = value;
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                "Type of mood: " + getType();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof thing)) return false;
        thing thing = (thing) o;
        return Objects.equals(getName(), thing.getName()) && SIGN == thing.SIGN;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), SIGN);
    }
}
