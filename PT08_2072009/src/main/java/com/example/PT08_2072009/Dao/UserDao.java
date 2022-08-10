package com.example.PT08_2072009.Dao;

import com.example.PT08_2072009.Model.Movie;
import com.example.PT08_2072009.Model.User;
import com.example.PT08_2072009.Util.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements DaoInterface<User> {
    @Override
    public List<User> getData() {
        List<User> uList;
        Session s = MyConnection.getsession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(User.class);
        cq.from(User.class);
        uList = s.createQuery(cq).getResultList();
        s.close();
        return uList;
    }

    @Override
    public void addData(User data) {
        Session s = MyConnection.getsession();
        s.save(data);
        s.close();
    }

    @Override
    public void deleteData(User data) {
        Session s = MyConnection.getsession();
        Transaction t  = s.beginTransaction();
        try {
            s.delete(data);
            t.commit();
        }catch (Exception e){
            System.out.println(e);
            t.rollback();
        }
        s.close();
    }
    public void updateData(User data) {
        Session s = MyConnection.getsession();
        s.update(data);
        s.close();
    }
}
