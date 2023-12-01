package org.example.annotationsupport;

import java.util.List;

public interface BookRepository {
    List<Book> findNewBooks(int days);

    Book findBookByBookId(String bookID);

    void save(Book book);
}
