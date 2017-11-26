package hello;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.math.BigInteger;

@RepositoryRestResource(collectionResourceRel = "addressRel", path = "address")
public interface AddressRepository extends JpaRepository<Address, BigInteger> {

}