package safety;

import java.util.Scanner;

import exceptions.InvalidFieldException;

public class ValidatedInteger {
    private final int value;

    private ValidatedInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static class Builder {

        private int value;
        private Integer lowerBound;
        private Integer upperBound;

        public Builder setLowerBound(int lowerBound) {
            this.lowerBound = lowerBound;
            return this;
        }

        public Builder setUpperBound(int upperBound) {
            this.upperBound = upperBound;
            return this;
        }

        public ValidatedInteger build(int value) throws InvalidFieldException {
            this.value = value;
            ValidatedInteger validatedInteger = new ValidatedInteger(value);

            try {
                if (this.upperBound != null && this.value >= this.upperBound) {
                    throw new InvalidFieldException("Gia tri nhap vao phai nho hon hoac bang " + this.upperBound);
                }

                if (this.lowerBound != null && this.value <= this.lowerBound) {
                    throw new InvalidFieldException("Gia tri nhap vao phai lon hon hoac bang " + this.lowerBound);
                }
            } catch (Exception e) {
                validatedInteger = null;
                throw e;
            }
            return validatedInteger;
        }

        public ValidatedInteger build(Scanner scanner) throws InvalidFieldException, Exception {
            this.value = scanner.nextInt();
            ValidatedInteger validatedInteger = new ValidatedInteger(value);

            try {
                if (this.upperBound != null && this.value >= this.upperBound) {
                    throw new InvalidFieldException("Gia tri nhap vao phai nho hon hoac bang " + this.upperBound);
                }

                if (this.lowerBound != null && this.value <= this.lowerBound) {
                    throw new InvalidFieldException("Gia tri nhap vao phai lon hon hoac bang " + this.lowerBound);
                }
            } catch (Exception e) {
                validatedInteger = null;
                throw e;
            }
            return validatedInteger;
        }
    }
}
