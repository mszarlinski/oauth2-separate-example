package pl.mszarlinski.oauth2.resourceServer;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mszarlinski on 2015-10-12.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
}
