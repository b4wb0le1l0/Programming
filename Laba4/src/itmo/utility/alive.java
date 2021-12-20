package itmo.utility;

import java.util.Objects;

public abstract class alive implements UsefulInterface {

    private String name;
    private MoodSign MOOD = MoodSign.NORMALY;

    public alive(String name) {
        this.name = name;
    }

    public alive(String name, MoodSign MOOD) {
        this.name = name;
        this.MOOD = MOOD;
    }

    public void Join(String name) {
        System.out.println(name + " в истории!");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MoodSign getType() {
        return this.MOOD;
    }

    public void setType(MoodSign value) {
        this.MOOD = value;
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                "Type of mood: " + getType();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof alive)) return false;
        alive family = (alive) o;
        return Objects.equals(getName(), family.getName()) && MOOD == family.MOOD;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), MOOD);
    }
}
