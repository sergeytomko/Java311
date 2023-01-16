import java.util.Objects;

public abstract class Animal implements Comparable {
    protected String name;
    protected int eyes;
    protected int legs;
    protected int ears;
    protected String type;

    public Animal(AnimalBuilder ab)
    {
        this.name = ab.name;
        this.eyes = ab.eyes;
        this.ears = ab.ears;
        this.legs = ab.legs;
        this.type = "none";
    }

    public Animal(String name, int eyes, int legs, int ears) {
        this.name = name;
        this.eyes = eyes;
        this.legs = legs;
        this.ears = ears;
        this.type = "none";
    }

    public Animal() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setEyes(int eyes) {
        this.eyes = eyes;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public void setEars(int ears) {
        this.ears = ears;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getEyes() {
        return eyes;
    }

    public int getLegs() {
        return legs;
    }

    public int getEars() {
        return ears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return eyes == animal.eyes && legs == animal.legs && ears == animal.ears && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, eyes, legs, ears);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", eyes=" + eyes +
                ", legs=" + legs +
                ", ears=" + ears +
                '}';
    }

    static abstract class AnimalBuilder
    {
        protected String name;
        protected int eyes;
        protected int legs;
        protected int ears;

        public AnimalBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public AnimalBuilder setEyes(int eyes) {
            this.eyes = eyes;
            return this;
        }

        public AnimalBuilder setLegs(int legs) {
            this.legs = legs;
            return this;
        }

        public AnimalBuilder setEars(int ears) {
            this.ears = ears;
            return this;
        }

        abstract public Animal build();
    }
}
