package com.cagreda.springwebapp.repositories;

import com.cagreda.springwebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository <Author, Long> {
}
