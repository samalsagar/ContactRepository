package in.nit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.entity.ContactDetails;

public interface ContactDetailsRepository extends JpaRepository<ContactDetails, Serializable> {

}
