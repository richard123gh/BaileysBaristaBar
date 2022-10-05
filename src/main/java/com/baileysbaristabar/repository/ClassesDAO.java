package com.baileysbaristabar.repository;

import com.baileysbaristabar.entities.Classes;
import com.baileysbaristabar.utils.HibernateUtil;

import java.util.List;

public class ClassesDAO implements ClassesDAOInterface {


    @Override
    public List<Classes> getAllClasses() {
        HibernateUtil.beginTransaction();
        List<Classes> allClasses = HibernateUtil.getSession().createQuery("from Classes", Classes.class).getResultList();
        HibernateUtil.endTransaction();
        return allClasses;
    }

    @Override
    public Classes getClassName(String class_name) {
        HibernateUtil.beginTransaction();
        Classes returnClass = HibernateUtil.getSession().createQuery("from Classes where class_name = :class_name", Classes.class).setParameter("class_name", class_name).getSingleResult();
        HibernateUtil.endTransaction();
        return returnClass;
    }

    @Override
    public Classes addNewClass(Classes c) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(c);
        HibernateUtil.endTransaction();
        return c;
    }

    @Override
    public Classes getEnrolledNumber(String class_name) {
        HibernateUtil.beginTransaction();
        Classes returnEnrolledNumber = HibernateUtil.getSession().createQuery("select enrolled_number from Classes where class_name = :class_name", Classes.class).setParameter("class_name", class_name).getSingleResult();
        HibernateUtil.endTransaction();
        return returnEnrolledNumber;
    }

    @Override
    public Classes updateEnrolledNumber(Classes enrolled_number) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().update(enrolled_number);
        HibernateUtil.endTransaction();
        return enrolled_number;
    }

    @Override
    public Classes updateCompleted(String class_name, boolean class_completed) {
        HibernateUtil.beginTransaction();
        Classes returnClass = HibernateUtil.getSession().createQuery("from Classes where class_name = :class_name", Classes.class).setParameter("class_name", class_name).getSingleResult();
        returnClass.setClassCompleted(class_completed);
        HibernateUtil.getSession().update(returnClass);
        HibernateUtil.endTransaction();
        return returnClass;
    }
}
