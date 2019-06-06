package com.cagreda.springwebapp.repositories;

import com.cagreda.springwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
