package com.library.management.repository;

import com.library.management.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepo extends JpaRepository<Author,Integer> {

   Author findByAuthorName(String authorName);

}
