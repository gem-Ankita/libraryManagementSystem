package com.library.management.service;

import com.library.management.payloads.BookDto;

import java.util.List;

public interface LibraryService {
    BookDto addBook(BookDto bookDto);

    BookDto getBookById(Integer bookId);

    List<BookDto> getAllBooks(Integer pageNumber,Integer pagesize,String sortBy);

    void deleteBook(Integer bookId);

    BookDto getBookByAuthorName(String bookName);

    BookDto getBookByPublisherName(String publisherName);
}
