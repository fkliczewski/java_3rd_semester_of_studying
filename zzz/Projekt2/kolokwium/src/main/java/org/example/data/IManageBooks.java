package org.example.data;

import java.util.List;
import java.util.Map;

public interface IManageBooks {
    List<Book> getByTitle(List<Book> books, String title);
    List<String> getDescriptions(List<Book> books);
    Map<Integer, List<Book>> groupByPublicationYear(List<Book> books);
    double getTotalPrice(List<Book> books);
}
