package com.library.management.service;

import com.library.management.entity.Author;
import com.library.management.entity.Book;
import com.library.management.entity.Publisher;
import com.library.management.payloads.BookDto;
import com.library.management.repository.AuthorRepo;
import com.library.management.repository.LibraryRepository;
import com.library.management.repository.PublisherRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;


@SpringBootTest
class LibraryServiceImplTest {

    @Mock
    LibraryRepository libraryRepository;

    @Mock
    AuthorRepo authorRepo;

    @Mock
    PublisherRepo publisherRepo;

    @InjectMocks
    LibraryServiceImpl libraryServiceImpl;


    @Test
    void addBook() {
        BookDto bookDto=new BookDto("ABC","Test","Test","Test");
        Author author=new Author();
        author.setAuthorName("ABC");
        author.setAuthorId(1);
        when(authorRepo.findByAuthorName(bookDto.getAuthorName())).thenReturn(author);
        Publisher publisher=new Publisher();
        publisher.setPublisherName("XYZ");
        publisher.setPublisherId(1);
        when(publisherRepo.findByPublisherName(bookDto.getPublisherName())).thenReturn(publisher);
        Book book=new Book();
        book.setBookName(bookDto.getBookName());
        book.setPublishDate(bookDto.getPublishDate());
        book.setPublisherId(publisher);
        book.setAuthorId(author);
        when(libraryRepository.save(book)).thenReturn(book);
        assertEquals(bookDto,libraryServiceImpl.addBook(bookDto));
    }

    @Test
    void getBookById() {

    }

    @Test
    void getAllBooks() {
    }

    @Test
    void deleteBook() {
    }

    @Test
    void getBookByAuthorName() {
    }

    @Test
    void getBookByPublisherName() {
    }
}