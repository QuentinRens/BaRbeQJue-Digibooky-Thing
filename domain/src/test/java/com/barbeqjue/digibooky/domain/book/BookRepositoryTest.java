package com.barbeqjue.digibooky.domain.book;

import com.barbeqjue.digibooky.domain.Author;
import com.barbeqjue.digibooky.domain.book.Book;
import com.barbeqjue.digibooky.domain.book.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import java.util.List;

public class BookRepositoryTest {


    @Test
    public void getBookByTitle_givenAStringPartOfTitle_ShouldReturnAllBooksWithThatStringInTheTitle() {

        // given
        Book book1 = new Book("123456789", "This is a BookTitle", new Author("John", "Doe"));
        Book book2 = new Book("987654321", "This is a BookTitle2", new Author("Jane", "Doe"));
        BookRepository bookRepository = new BookRepository();
        bookRepository.storeBook(book1);
        bookRepository.storeBook(book2);

        // when
        List<Book> actualResult = bookRepository.getBookByTitle("Title2");

        // then
        Assertions.assertThat(actualResult).containsOnly(book2);
    }
}