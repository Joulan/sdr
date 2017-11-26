package hello;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

/**
 * Author: Joulan
 * Date: 26.11.2017.
 */
@Component
@RepositoryEventHandler(Person.class)
public class PersonDataRestEventHandler {

    @HandleBeforeCreate
    public void applyUserInformationUsingSecurityContext(Person person) throws Exception {
        if (person.getFirstName().equalsIgnoreCase("Jason")) {
            throw new Exception("Not supportable FirstName");
        }
    }

}
