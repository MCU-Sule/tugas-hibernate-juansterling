package com.example.PT08_2072009.Dao;

import com.example.PT08_2072009.Model.Movie;
import com.example.PT08_2072009.Util.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MovieDao implements DaoInterface<Movie> {
    @Override
    public List<Movie> getData() {
        List<Movie> mList;
        Session s = MyConnection.getsession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Movie.class);
        cq.from(Movie.class);
        mList = s.createQuery(cq).getResultList();
        s.close();
        return mList;
    }

    @Override
    public void addData(Movie data) {
        Session s = MyConnection.getsession();
        s.save(data);
        s.close();
    }

    @Override
    public void deleteData(Movie data) {
        Session s = MyConnection.getsession();
        s.delete(data);
        s.close();
    }
    public List<Movie> filterData(String data) {
        List<Movie> mList;
        Session s = MyConnection.getsession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Movie.class);
        Root<Movie> root = cq.from(Movie.class);
        Predicate p1 = cb.like(root.get("genre"),"%"+ data + "%");
        cq.where(p1);
        mList = s.createQuery(cq).getResultList();
        s.close();
        return mList;
    }
    public void updateData(Movie data) {
        Session s = MyConnection.getsession();
        s.update(data);
        s.close();
    }
}
