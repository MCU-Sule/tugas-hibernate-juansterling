package com.example.PT08_2072009.Dao;

import javafx.collections.ObservableList;

import java.util.List;

public interface DaoInterface<T> {
    List<T> getData();
    void addData(T data);
    void deleteData(T data);
}
