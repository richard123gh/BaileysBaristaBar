package com.baileysbaristabar.repository;

import com.baileysbaristabar.entities.Baristas;
import com.baileysbaristabar.entities.Classes;
import com.baileysbaristabar.entities.EnrollmentInfo;
import com.baileysbaristabar.utils.HibernateUtil;

import java.util.List;

public class EnrollmentInfoDAO implements EnrollmentInfoDAOInterface{

    public List<EnrollmentInfo> getAllEnrollment(){
        HibernateUtil.beginTransaction();
        List<EnrollmentInfo> allEnrollment = HibernateUtil.getSession().createQuery("from EnrollmentInfo", EnrollmentInfo.class).getResultList();
        HibernateUtil.endTransaction();
        return allEnrollment;
    }

    @Override
    public List<EnrollmentInfo> getEnrollmentByClass(String class_name) {
        HibernateUtil.beginTransaction();
        List<EnrollmentInfo> enrollmentByClass = HibernateUtil.getSession().createQuery("from EnrollmentInfo where class_name = :class_name", EnrollmentInfo.class).setParameter("class_name", class_name).getResultList();
        HibernateUtil.endTransaction();
        return enrollmentByClass;
    }

    @Override
    public List<EnrollmentInfo> getEnrollmentByBarista(String barista_username) {
        HibernateUtil.beginTransaction();
        List<EnrollmentInfo> enrollmentByBarista = HibernateUtil.getSession().createQuery("from EnrollmentInfo where barista_username = :barista_username", EnrollmentInfo.class).setParameter("barista_username", barista_username).getResultList();
        HibernateUtil.endTransaction();
        return enrollmentByBarista;
    }

    @Override
    public EnrollmentInfo addNewEnrollment(EnrollmentInfo enrollment) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(enrollment);
        HibernateUtil.endTransaction();
        return enrollment;
    }

    @Override
    public EnrollmentInfo updateEnrollment(EnrollmentInfo enrollment) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().update(enrollment);
        HibernateUtil.endTransaction();
        return enrollment;
    }

    @Override
    public EnrollmentInfo getClassRep(String class_name) {
        HibernateUtil.beginTransaction();
        EnrollmentInfo classRep = HibernateUtil.getSession().createQuery("from EnrollmentInfo where class_name = :class_name and class_rep = :class_rep", EnrollmentInfo.class).setParameter("class_name", class_name).setParameter("class_rep", "Y").getSingleResult();
        HibernateUtil.endTransaction();
        return classRep;
    }

    @Override
    public EnrollmentInfo updateClassRep(String class_name, String barista_username) {
        HibernateUtil.beginTransaction();
        EnrollmentInfo classRep = HibernateUtil.getSession().createQuery("from EnrollmentInfo where class_name = :class_name and class_rep = :class_rep", EnrollmentInfo.class).setParameter("class_name", class_name).setParameter("class_rep", "Y").getSingleResult();
        classRep.setClassRep("N");
        HibernateUtil.getSession().update(classRep);
        EnrollmentInfo newClassRep = HibernateUtil.getSession().createQuery("from EnrollmentInfo where class_name = :class_name and barista_username = :barista_username", EnrollmentInfo.class).setParameter("class_name", class_name).setParameter("barista_username", barista_username).getSingleResult();
        newClassRep.setClassRep("Y");
        HibernateUtil.getSession().update(newClassRep);
        HibernateUtil.endTransaction();
        return newClassRep;
    }

    //this might only be needed to update the number?  might just need the classname and enrollment number
    @Override
    public EnrollmentInfo deleteEnrollmentByBarista(String class_name, String barista_username, String status) {
        HibernateUtil.beginTransaction();
        EnrollmentInfo enrollment = HibernateUtil.getSession().createQuery("from EnrollmentInfo where class_name = :class_name and barista_username = :barista_username", EnrollmentInfo.class).setParameter("class_name", class_name).setParameter("barista_username", barista_username).getSingleResult();
        enrollment.setStatus(status);
        HibernateUtil.getSession().update(enrollment);
        HibernateUtil.endTransaction();
        return enrollment;
    }

    @Override
    public EnrollmentInfo getStatusByBarista(String class_name) {
        HibernateUtil.beginTransaction();
        EnrollmentInfo enrollment = HibernateUtil.getSession().createQuery("from EnrollmentInfo where class_name = :class_name", EnrollmentInfo.class).setParameter("class_name", class_name).getSingleResult();
        HibernateUtil.endTransaction();
        return enrollment;
    }

    @Override
    public EnrollmentInfo updateStatusByBarista(String class_name, String barista_username, String status) {
        HibernateUtil.beginTransaction();
        EnrollmentInfo enrollment = HibernateUtil.getSession().createQuery("from EnrollmentInfo where class_name = :class_name and barista_username = :barista_username", EnrollmentInfo.class).setParameter("class_name", class_name).setParameter("barista_username", barista_username).getSingleResult();
        enrollment.setStatus(status);
        HibernateUtil.getSession().update(enrollment);
        HibernateUtil.endTransaction();
        return enrollment;
    }


}
