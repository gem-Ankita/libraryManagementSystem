package com.library.management.service;

import com.library.management.entity.Author;
import com.library.management.entity.Book;
import com.library.management.entity.Publisher;
import com.library.management.payloads.BookDto;
import com.library.management.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService{

    @Autowired
    LibraryRepository libraryRepository;

    @Override
    public BookDto addBook(BookDto bookDto) {
        Book book=new Book();
        Author author=new Author();
        Publisher publisher=new Publisher();
        publisher.setPublisherName(bookDto.getPublisherName());
        author.setAuthorName(bookDto.getAuthorName());
        book.setBookName(bookDto.getBookName());
        book.setPublishDate(bookDto.getPublishDate());
        book.setAuthorId(author);
        book.setPublisherId(publisher);
        libraryRepository.save(book);

        return bookDto;
    }

    @Override
    public BookDto getBookById(Integer bookId) {
        return null;
    }

    @Override
    public List<BookDto> getAllBooks() {
        return null;
    }

    @Override
    public void deleteBook(Integer bookId) {

    }
}
