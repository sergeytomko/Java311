import java.util.Objects;

/**
 * The type Eagle.
 */
public class Eagle extends Animal {
    private final int wings;

    /**
     * Instantiates a new Eagle.
     *
     * @param eb the eb
     */
    public Eagle(EagleBuilder eb)
    {
        super(eb);
        this.wings = eb.wings;
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

    /**
     * Gets wings.
     *
     * @return the wings
     */
    public int getWings() {
        return wings;
    }


    /**
     * The type Eagle builder.
     */
    public final static class EagleBuilder extends AnimalBuilder
    {
        private int wings;

        /**
         * Sets wings.
         *
         * @param wings the wings
         */
        public void setWings(int wings) {
            this.wings = wings;
        }


        @Override
        public Animal build() {
            return new Eagle(this);
        }
    }
}
