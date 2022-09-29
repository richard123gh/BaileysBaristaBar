package com.baileysbaristabar.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

public class HibernateUtil {

    private static Session session;
    private static SessionFactory sessionFactory;
    private static Transaction transaction;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

    public static Session getSession(){
        if(session == null){
            session = getSessionFactory().openSession();
        }
        return session;
    }

    public static void beginTransaction(){
        session = getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public static void endTransaction(){
        transaction.commit();
        session.close();
    }

}
