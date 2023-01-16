import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * The type Animal.
 */
public abstract class Animal {
    /**
     * The Name.
     */
    protected final String name;
    /**
     * The Eyes.
     */
    protected final int eyes;
    /**
     * The Legs.
     */
    protected final int legs;
    /**
     * The Ears.
     */
    protected final int ears;

    /**
     * Instantiates a new Animal.
     *
     * @param ab the ab
     */
    public Animal(AnimalBuilder ab)
    {
        this.name = ab.name;
        this.eyes = ab.eyes;
        this.ears = ab.ears;
        this.legs = ab.legs;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets eyes.
     *
     * @return the eyes
     */
    public int getEyes() {
        return eyes;
    }

    /**
     * Gets legs.
     *
     * @return the legs
     */
    public int getLegs() {
        return legs;
    }

    /**
     * Gets ears.
     *
     * @return the ears
     */
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

    /**
     * The type Animal builder.
     */
    static abstract class AnimalBuilder
    {
        /**
         * The Name.
         */
        @NotNull
        @Size(min = 1,max = 20,message = "min size = 1, max size = 20")
        protected String name;
        /**
         * The Eyes.
         */
        @NotNull
        @Min(value = 2,message = "min eyes = 2")
        protected int eyes;
        /**
         * The Legs.
         */
        @NotNull
        @Min(value = 2,message = "min legs = 2")
        protected int legs;
        /**
         * The Ears.
         */
        @NotNull
        @Min(value = 2, message = "min ears = 2")
        protected int ears;

        /**
         * Sets name.
         *
         * @param name the name
         * @return the name
         */
        public AnimalBuilder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets eyes.
         *
         * @param eyes the eyes
         * @return the eyes
         */
        public AnimalBuilder setEyes(int eyes) {
            this.eyes = eyes;
            return this;
        }

        /**
         * Sets legs.
         *
         * @param legs the legs
         * @return the legs
         */
        public AnimalBuilder setLegs(int legs) {
            this.legs = legs;
            return this;
        }

        /**
         * Sets ears.
         *
         * @param ears the ears
         * @return the ears
         */
        public AnimalBuilder setEars(int ears) {
            this.ears = ears;
            return this;
        }

        /**
         * Build animal.
         *
         * @return the animal
         */
        abstract public Animal build();
    }
}
