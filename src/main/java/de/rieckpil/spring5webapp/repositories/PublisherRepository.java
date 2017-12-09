package de.rieckpil.spring5webapp.repositories;

import de.rieckpil.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
