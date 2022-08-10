package com.example.PT08_2072009.Dao;

import com.example.PT08_2072009.Model.Movie;
import com.example.PT08_2072009.Model.User;
import com.example.PT08_2072009.Model.Watchlist;
import com.example.PT08_2072009.Util.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class WatchListDao implements DaoInterface<Watchlist> {
    @Override
    public List<Watchlist> getData() {
        List<Watchlist> wList;
        Session s = MyConnection.getsession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Watchlist.class);
        cq.from(Watchlist.class);
        wList = s.createQuery(cq).getResultList();
        s.close();
        return wList;

    }
    @Override
    public void addData(Watchlist data) {
        Session s = MyConnection.getsession();
        s.save(data);
        s.close();
    }

    @Override
    public void deleteData(Watchlist data) {
        Session s = MyConnection.getsession();
        s.delete(data);
        s.close();
    }

    public void updateData(Watchlist data) {
        Session s = MyConnection.getsession();
        s.update(data);
        s.close();
    }
    public List<Watchlist> filterData(User userSelect) {
        List<Watchlist> wList;
        Session s = MyConnection.getsession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Watchlist.class);
        Root<Watchlist> root = cq.from(Watchlist.class);
        Predicate p1 = cb.equal(root.get("userByUserIdUser"),userSelect);
        cq.where(p1);
        wList = s.createQuery(cq).getResultList();
        s.close();
        return wList;
    }
}
