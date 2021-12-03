package itmo;

import java.util.Objects;

public abstract class parent implements UsefulInterface {

    private String name;
    private MoodTypeorSign MOOD = MoodTypeorSign.GOOD;

    public parent(String name) {
        this.name = name;
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

    public MoodTypeorSign getType() {
        return this.MOOD;
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                "Type of mood: " + getType();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof parent)) return false;
        parent parent = (parent) o;
        return Objects.equals(getName(), parent.getName()) && MOOD == parent.MOOD;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), MOOD);
    }
}
