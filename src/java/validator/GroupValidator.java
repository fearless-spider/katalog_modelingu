/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package validator;

import domain.Grupa;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Przemysław Pająk <bespider@gmail.com>
 */
public class GroupValidator implements Validator {

    public boolean supports(Class aClass) {
        return aClass.equals(Grupa.class);
    }

    public void validate(Object obj, Errors errors) {
        Grupa group = (Grupa)obj;

        if (group == null) {
            errors.rejectValue("name", "field.required", null,
                    "Wartość wymagana.");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.required", "Pole wymagane");
    }
}
