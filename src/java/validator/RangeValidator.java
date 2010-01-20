/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package validator;

import domain.Range;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Przemysław Pająk <bespider@gmail.com>
 */
public class RangeValidator implements Validator {

    public boolean supports(Class aClass) {
        return aClass.equals(Range.class);
    }

    public void validate(Object obj, Errors errors) {
        Range range = (Range)obj;

        if (range == null) {
            errors.rejectValue("name", "field.required", null,
                    "Wartość wymagana.");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.required", "Pole wymagane");
    }
}
