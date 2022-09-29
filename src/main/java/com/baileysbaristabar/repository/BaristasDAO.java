package com.baileysbaristabar.repository;

import java.util.List;
import javax.persistence.Query;
import com.baileysbaristabar.utils.HibernateUtil;
import com.baileysbaristabar.entities.Baristas;
import com.baileysbaristabar.entities.Classes;

// This class is a DAO (Data Access Object) that will be used to access the Baristas table in the database
// It implements the BaristasDAOInterface
// It will be used to access the Baristas table in the database
public class BaristasDAO implements BaristasDAOInterface {


    @Override
    public List<Baristas> getAllBaristas() {
        HibernateUtil.beginTransaction();
        List<Baristas> allBaristas = HibernateUtil.getSession().createQuery("from Baristas", Baristas.class).getResultList();
        HibernateUtil.endTransaction();
        return allBaristas;
    }

    @Override
    public List<Baristas> checkUserCredentials(String inputUser, String inputPass) {
        HibernateUtil.beginTransaction();
        List<Baristas> returnBaristas = HibernateUtil.getSession().createQuery("from Baristas where barista_username = :barista_username and barista_password = :barista_password", Baristas.class).setParameter("barista_username", inputUser).setParameter("barista_password", inputPass).getResultList();
        HibernateUtil.endTransaction();
        return returnBaristas;
    }

    @Override
    public Baristas getBaristaByUsername(String inputUser) {
        HibernateUtil.beginTransaction();
        Baristas returnBarista = HibernateUtil.getSession().createQuery("from Baristas where barista_username = :barista_username", Baristas.class).setParameter("barista_username", inputUser).getSingleResult();
        HibernateUtil.endTransaction();
        return returnBarista;
    }
}
