package helper;

public class StringHelper {

    /**
     * This method will return the string represent the property after extracted the
     * given string
     * 
     * Pattern: [property]
     * 
     * @param source
     * @return property
     */
    public static String extractPropertyFromString(String source) {
        String extractedString = source.substring(1, source.length() - 1);
        return extractedString.length() > 0 ? extractedString : null;
    }

}
