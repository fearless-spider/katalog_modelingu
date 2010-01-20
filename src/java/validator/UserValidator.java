/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package validator;

import dao.UserDAO;
import domain.User;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.apache.commons.validator.EmailValidator;

/**
 *
 * @author Przemysław Pająk <bespider@gmail.com>
 */
public class UserValidator implements Validator {

    UserDAO userDAO;
    
    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean supports(Class aClass) {
        return aClass.equals(User.class);
    }

    public void validate(Object obj, Errors errors) {
        User user = (User)obj;

        if (user == null) {
            errors.rejectValue("username", "field.required", null,"Wartość wymagana.");
        }
        if(user.getId() == 0) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "field.required", "Pole wymagane");
            if(!errors.hasFieldErrors("username")) {
                if(userDAO.getUserByName(user.getUsername()) != null) {
                    errors.rejectValue("username", "exists", "Użytkownik istnieje w bazie!");
                }
                if(user.getUsername().length() <= 5) {
                    errors.rejectValue("username", "not_match", "Musi być dluższa niż 5 znaków");
                }
            }
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required", "Pole wymagane");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmpassword", "field.required", "Pole wymagane");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required", "Pole wymagane");

        if(!errors.hasFieldErrors("password")) {
            if(user.getPassword().length() <= 5) {
                errors.rejectValue("password", "not_match", "Musi być dłuższe niż 5 znaków!");
            }
        }
        
        if(!errors.hasFieldErrors("confirmpassword")) {
            if(!user.getPassword().equals(user.getConfirmpassword())) {
                    System.err.println("eeeee");
                errors.rejectValue("password", "not_match", "Hasła różnią się!");
                errors.rejectValue("confirmpassword", "not_match", "Hasła różnią się!");
            } else {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(user.getPassword().getBytes(),0, user.getPassword().length());
                    String hashedPass = new BigInteger(1,messageDigest.digest()).toString(16);
                    if (hashedPass.length() < 32) {
                        hashedPass = "0" + hashedPass;
                    }
                    user.setPassword(hashedPass);
                    user.setConfirmpassword("1");
                } catch(Exception e)
                {
                    System.err.println("eeeee");
                }
            }
        }

        if(!errors.hasFieldErrors("email")) {
            if(!EmailValidator.getInstance().isValid(user.getEmail())) {
                errors.rejectValue("email", "not_match", "Podaj prawidlowy adres e-mail!");
            }
        }

    }
}
