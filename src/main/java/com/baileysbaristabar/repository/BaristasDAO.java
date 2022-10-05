package com.baileysbaristabar.repository;

import java.util.List;
import javax.persistence.Query;
import com.baileysbaristabar.utils.HibernateUtil;
import com.baileysbaristabar.entities.Baristas;
import com.baileysbaristabar.entities.Classes;


public class BaristasDAO implements BaristasDAOInterface {


    @Override
    public List<Baristas> getAllBaristas() {
        HibernateUtil.beginTransaction();
        List<Baristas> allBaristas = HibernateUtil.getSession().createQuery("from Baristas", Baristas.class).getResultList();
        HibernateUtil.endTransaction();
        return allBaristas;
    }

    @Override
    public Baristas checkUserCredentials(String inputUser, String inputPass) {
        HibernateUtil.beginTransaction();
        Baristas returnBaristas = HibernateUtil.getSession().createQuery("from Baristas where barista_username = :barista_username and barista_password = :barista_password", Baristas.class).setParameter("barista_username", inputUser).setParameter("barista_password", inputPass).uniqueResult();
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

    //figure this one out later - first, get enrollment status working
//    @Override
//    public Baristas updateEnrolledNum(String inputUser) {
//        HibernateUtil.beginTransaction();
//        Baristas returnBarista = HibernateUtil.getSession().createQuery("from enrollmentInfo where status = 'enrolled'", Baristas.class).setParameter("barista_username", inputUser).getSingleResult();
//        HibernateUtil.endTransaction();
//        return returnBarista;
//    }
}
