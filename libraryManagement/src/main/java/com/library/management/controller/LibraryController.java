package com.library.management.controller;

import com.library.management.payloads.BookDto;
import com.library.management.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/library")
public class LibraryController {
    @Autowired
    LibraryService libraryService;

    @PostMapping("/addBook")
    public ResponseEntity<BookDto> addBooks(@RequestBody BookDto bookDto)
    {
        BookDto addBook=this.libraryService.addBook(bookDto);
        return new ResponseEntity<>(addBook, HttpStatus.CREATED);
    }
}
