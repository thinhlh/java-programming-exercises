package safety;

import java.util.Scanner;

import exceptions.InvalidFieldException;

public class ValidatedDouble {
    private final Double value;

    private ValidatedDouble(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public static class Builder {

        private double value;
        private Double lowerBound;
        private Double upperBound;

        public Builder setLowerBound(Double lowerBound) {
            this.lowerBound = lowerBound;
            return this;
        }

        public Builder setUpperBound(Double upperBound) {
            this.upperBound = upperBound;
            return this;
        }

        public ValidatedDouble build(double value) throws InvalidFieldException {
            this.value = value;
            ValidatedDouble validatedDouble = new ValidatedDouble(value);

            try {
                if (this.upperBound != null && this.value >= this.upperBound) {
                    throw new InvalidFieldException("Gia tri nhap vao phai nho hon hoac bang " + this.upperBound);
                }

                if (this.lowerBound != null && this.value <= this.lowerBound) {
                    throw new InvalidFieldException("Gia tri nhap vao phai lon hon hoac bang " + this.lowerBound);
                }
            } catch (Exception e) {
                validatedDouble = null;
                throw e;
            }
            return validatedDouble;
        }

        public ValidatedDouble build(Scanner scanner) throws InvalidFieldException, Exception {
            this.value = scanner.nextDouble();
            ValidatedDouble validatedDouble = new ValidatedDouble(value);

            try {
                if (this.upperBound != null && this.value >= this.upperBound) {
                    throw new InvalidFieldException("Gia tri nhap vao phai nho hon hoac bang " + this.upperBound);
                }

                if (this.lowerBound != null && this.value <= this.lowerBound) {
                    throw new InvalidFieldException("Gia tri nhap vao phai lon hon hoac bang " + this.lowerBound);
                }
            } catch (Exception e) {
                validatedDouble = null;
                throw e;
            }
            return validatedDouble;
        }
    }
}
