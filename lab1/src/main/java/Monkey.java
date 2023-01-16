import java.util.Objects;

/**
 * The type Monkey.
 */
public class Monkey extends Animal {
    private final int hands;
    private final int fingers;

    /**
     * Instantiates a new Monkey.
     *
     * @param mb the mb
     */
    public Monkey(MonkeyBuilder mb)
    {
        super(mb);
        this.hands = mb.hands;
        this.fingers = mb.fingers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monkey)) return false;
        if (!super.equals(o)) return false;
        Monkey monkey = (Monkey) o;
        return hands == monkey.hands && fingers == monkey.fingers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hands, fingers);
    }

    @Override
    public String toString() {
        return "Monkey{" +
                "hands=" + hands +
                ", fingers=" + fingers +
                ", name='" + name + '\'' +
                ", eyes=" + eyes +
                ", legs=" + legs +
                ", ears=" + ears +
                '}';
    }

    /**
     * Gets hands.
     *
     * @return the hands
     */
    public int getHands() {
        return hands;
    }

    /**
     * Gets fingers.
     *
     * @return the fingers
     */
    public int getFingers() {
        return fingers;
    }

    /**
     * The type Monkey builder.
     */
    public final static class MonkeyBuilder extends AnimalBuilder
    {
        private int hands;
        private int fingers;

        /**
         * Sets hands.
         *
         * @param hands the hands
         */
        public void setHands(int hands) {
            this.hands = hands;
        }

        /**
         * Sets fingers.
         *
         * @param fingers the fingers
         */
        public void setFingers(int fingers) {
            this.fingers = fingers;
        }

        @Override
        public Animal build() {
            return new Monkey(this);
        }
    }
}
