package hello;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Author: Joulan
 * Date: 26.11.2017.
 */
@Component("beforeCreatePersonValidator")
public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Person person = (Person) obj;
        if (checkInputString(person.getFirstName())) {
            errors.rejectValue("firstName", "firstName.empty", "FirstName is empty");
        }

        if (checkInputString(person.getLastName())) {
            errors.rejectValue("lastName", "lastName.empty", "LastName is empty");
        }

        if (person.getFirstName().equalsIgnoreCase("Jason")) {
            errors.rejectValue("firstName", "firstName.notSupportable", new Object[]{1, "ex2"},"Not supportable firstName");
        }
    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }

}
