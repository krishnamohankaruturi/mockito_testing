package org.example.annotationsupport.stubbing;

import org.example.annotationsupport.Book;
import org.example.annotationsupport.BookRepository;
import org.example.annotationsupport.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StubBookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;


    @Test
    public void totalBooksPriceTest() {
        List<String> bookIDs = new ArrayList<>();
        bookIDs.add("1234");
        bookIDs.add("1235");
        Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());
        when(bookRepository.findBookByBookId("1234")).thenReturn(book1);
        when(bookRepository.findBookByBookId("1235")).thenReturn(book2);

        //Another way to do stubbing.
        //doReturn(book1).when(bookRepository).findBookByBookId("1234");
        //doReturn(book2).when(bookRepository).findBookByBookId("1235");

        int totalCost = bookService.calculateTotalCost(bookIDs);
        Assertions.assertEquals(900,totalCost);
    }

}
