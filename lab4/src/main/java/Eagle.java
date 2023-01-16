import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

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
        @NotNull
        @Min(value = 2,message = "min wings = 2")
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
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<EagleBuilder>> constraintViolations = validator.validate(this);
            StringBuilder exceptions = new StringBuilder("\n");
            for(ConstraintViolation constraintViolation : constraintViolations) {
                String fieldName = constraintViolation.getPropertyPath().toString().toUpperCase();
                exceptions.append(fieldName).append(" ").append(constraintViolation.getMessage()).append("\n");
            }
            if(constraintViolations.size() > 0)throw new IllegalArgumentException(String.valueOf(exceptions));
            return new Eagle(this);
        }
    }
}
