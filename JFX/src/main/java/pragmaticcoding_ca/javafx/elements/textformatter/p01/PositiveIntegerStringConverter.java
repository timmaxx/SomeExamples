package pragmaticcoding_ca.javafx.elements.textformatter.p01;

import javafx.util.converter.IntegerStringConverter;

public class PositiveIntegerStringConverter extends IntegerStringConverter {

    @Override
    public Integer fromString(String value) {
        int result = super.fromString(value);
        if (result < 0) {
            throw new RuntimeException("Negative number");
        }
        return result;
    }

    @Override
    public String toString(Integer value) {
        if (value < 0) {
            return "0";
        }
        return super.toString(value);
    }

}
