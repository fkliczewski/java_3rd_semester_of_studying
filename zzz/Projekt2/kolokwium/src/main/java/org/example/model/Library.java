package org.example.model;

import org.example.data.Book;
import org.example.data.IHaveData;

import java.util.List;

public class Library implements IHaveData<Book> {

    private List <Book> data;

    public Library(List<Book> data) {
        this.data = data;
    }

    @Override
    public List<Book> getData() {
        return data;
    }

    @Override
    public void showData() {
        for(Book b : data){
            System.out.println(b.getDescription());
        }
    }
}
