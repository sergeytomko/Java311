import java.util.Objects;

public class Eagle extends Animal {
    private int wings;

    public Eagle(EagleBuilder eb)
    {
        super(eb);
        this.wings = eb.wings;
        this.type = "eagle";
    }

    public Eagle(String name, int eyes, int legs, int ears, int wings, boolean canFly) {
        super(name, eyes, legs, ears);
        this.wings = wings;
        this.type = "eagle";
    }

    public Eagle() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Eagle)) return false;
        if (!super.equals(o)) return false;
        Eagle eagle = (Eagle) o;
        return wings == eagle.wings;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wings);
    }

    @Override
    public String toString() {
        return "Eagle{" +
                "wings=" + wings +
                ", name='" + name + '\'' +
                ", eyes=" + eyes +
                ", legs=" + legs +
                ", ears=" + ears +
                '}';
    }

    public void setWings(int wings) {
        this.wings = wings;
    }

    public int getWings() {
        return wings;
    }


    public final static class EagleBuilder extends AnimalBuilder
    {
        private int wings;

        public void setWings(int wings) {
            this.wings = wings;
        }

        @Override
        public Animal build() {
            return new Eagle(this);
        }
    }
}
