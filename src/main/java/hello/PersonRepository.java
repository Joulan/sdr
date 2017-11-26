package hello;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.math.BigInteger;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "personRel", path = "persons")
public interface PersonRepository extends JpaRepository<Person, BigInteger> {

    List<Person> findByLastName(@Param("name") String name);

}