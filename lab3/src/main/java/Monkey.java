import java.util.Objects;

public class Monkey extends Animal {
    private int hands;
    private int fingers;

    public Monkey(MonkeyBuilder mb)
    {
        super(mb);
        this.hands = mb.hands;
        this.fingers = mb.fingers;
        this.type = "monkey";
    }

    public Monkey(String name, int eyes, int legs, int ears, int hands, int fingers) {
        super(name, eyes, legs, ears);
        this.hands = hands;
        this.fingers = fingers;
        this.type = "monkey";
    }

    public Monkey() {}

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
                ", type='" + type + '\'' +
                '}';
    }

    public void setHands(int hands) {
        this.hands = hands;
    }

    public void setFingers(int fingers) {
        this.fingers = fingers;
    }

    public int getHands() {
        return hands;
    }

    public int getFingers() {
        return fingers;
    }

    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(o.getClass().getName());
    }
    public final static class MonkeyBuilder extends AnimalBuilder
    {
        private int hands;
        private int fingers;

        public void setHands(int hands) {
            this.hands = hands;
        }

        public void setFingers(int fingers) {
            this.fingers = fingers;
        }

        @Override
        public Animal build() {
            return new Monkey(this);
        }
    }
}
