package safety;

import java.util.regex.Pattern;

import exceptions.InvalidFieldException;

/**
 * This class is a validated model and will be used to describe the name of the
 * vehicle model
 * As the vehicle model's name will be limited by the input, we are inspired by
 * the idea of Domain Driven Design that
 * Validated Model will act as a Container of model's name value but it will be
 * validated
 * 
 * @property value
 */
public class ValidatedModel {

    /**
     * If this value is null, then it is not a valid value
     */
    final String value;

    public ValidatedModel(String value) throws InvalidFieldException {
        if (isValid(value)) {
            this.value = value;
        } else {
            this.value = null;
            throw new InvalidFieldException("Ten model khong hop le");
        }
    }

    /**
     * Validate the input
     * 
     * @param input
     * @return true if the input is valid, false if the input is invalid
     */
    private boolean isValid(String input) {
        String validRegex = "^[A-Za-z0-9]*$";

        return Pattern.matches(validRegex, input);
    }

    /**
     * This method will be called for checking the validation of the model outside
     * this class
     * 
     * @return
     */
    public boolean isValid() {
        return value == null ? false : isValid(value);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ValidatedModel) {
            return value.equals(((ValidatedModel) obj).value);
        } else if (obj instanceof String) {
            return value.equals(obj);
        } else {
            return false;
        }
    }

}
