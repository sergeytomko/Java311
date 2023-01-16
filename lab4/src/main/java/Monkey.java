import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

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
        @NotNull
        @Min(value = 2, message = "min hands = 2")
        private int hands;
        @NotNull
        @Min(value = 10, message = "min fingers = 10")
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
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<MonkeyBuilder>> constraintViolations = validator.validate(this);
            StringBuilder exceptions = new StringBuilder("\n");
            for(ConstraintViolation constraintViolation : constraintViolations) {
                String fieldName = constraintViolation.getPropertyPath().toString().toUpperCase();
                exceptions.append(fieldName).append(" ").append(constraintViolation.getMessage()).append("\n");
            }
            if(constraintViolations.size() > 0)throw new IllegalArgumentException(String.valueOf(exceptions));
            return new Monkey(this);
        }
    }
}
