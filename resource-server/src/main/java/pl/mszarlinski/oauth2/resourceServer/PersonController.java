package pl.mszarlinski.oauth2.resourceServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mszarlinski on 2015-10-12.
 */
@RequestMapping(value = "/person")
@RestController
public class PersonController {

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    /**
     * This method is secured in config
     */
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody final Person person) {
        return personRepository.saveAndFlush(person);
    }

    /**
     * This method is secured with annotation
     */
    @PreAuthorize("#oauth2.hasScope('write') and hasRole('ROLE_KILLER')")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.DELETE, value = "/{personId}")
    public void delete(@PathVariable final Long personId) {
        personRepository.delete(personId);
    }
}
