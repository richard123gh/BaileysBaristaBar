package com.baileysbaristabar.repository;

import com.baileysbaristabar.entities.Baristas;
import com.baileysbaristabar.entities.Classes;
import com.baileysbaristabar.utils.HibernateUtil;

import java.util.List;

public class EnrollmentInfoDAO implements EnrollmentInfoDAOInterface{


    @Override
    public List<Classes> getAllClasses() {
        HibernateUtil.beginTransaction();
        List<Classes> allClasses = HibernateUtil.getSession().createQuery("from enrollmentInfo", Classes.class).getResultList();
        HibernateUtil.endTransaction();
        return allClasses;
    }

    @Override
    public String getClassByName(String class_name) {
        HibernateUtil.beginTransaction();
        String returnClass = HibernateUtil.getSession().createQuery("from enrollmentInfo where class_name = :class_name", String.class).setParameter("class_name", class_name).getSingleResult();
        HibernateUtil.endTransaction();
        return returnClass;
    }

    @Override
    public List<Baristas> getBaristasByClass(String class_name) {
        HibernateUtil.beginTransaction();
        List<Baristas> returnBaristas = HibernateUtil.getSession().createQuery("select barista_username from enrollmentInfo where class_name = :class_name", Baristas.class).setParameter("class_name", class_name).getResultList();
        HibernateUtil.endTransaction();
        return returnBaristas;
    }

    @Override
    public String getClassRepByClass(String class_name) {
        HibernateUtil.beginTransaction();
        String returnClassRep = HibernateUtil.getSession().createQuery("select class_rep from enrollmentInfo where class_name = :class_name", String.class).setParameter("class_name", class_name).getSingleResult();
        HibernateUtil.endTransaction();
        return returnClassRep;
    }

    @Override
    public List<Classes> getClassesByBarista(String barista_name) {
        HibernateUtil.beginTransaction();
        List<Classes> returnClasses = HibernateUtil.getSession().createQuery("select class_name from enrollmentInfo where barista_username = :barista_username", Classes.class).setParameter("barista_username", barista_name).getResultList();
        HibernateUtil.endTransaction();
        return returnClasses;
    }

    // is this method needed?  what about just endorsed ones?
//    @Override
//    public List<Classes> getSkillsByBarista(String barista_name) {
//        return null;
//    }

    @Override
    public List<Classes> getChallengesByBarista(String barista_name) {
        HibernateUtil.beginTransaction();
        List<Classes> returnChallenges = HibernateUtil.getSession().createQuery("select challenge_name from enrollmentInfo where barista_username = :barista_username", Classes.class).setParameter("barista_username", barista_name).getResultList();
        HibernateUtil.endTransaction();
        return returnChallenges;
    }

    @Override
    public String getChallengesByClass(String class_name) {
        HibernateUtil.beginTransaction();
        String returnChallenges = HibernateUtil.getSession().createQuery("select challenge_name from enrollmentInfo where class_name = :class_name", String.class).setParameter("class_name", class_name).getSingleResult();
        HibernateUtil.endTransaction();
        return returnChallenges;
    }

    @Override
    public String getSkillsByClass(String class_name) {
        HibernateUtil.beginTransaction();
        String returnSkills = HibernateUtil.getSession().createQuery("select skills from enrollmentInfo where class_name = :class_name", String.class).setParameter("class_name", class_name).getSingleResult();
        HibernateUtil.endTransaction();
        return returnSkills;
    }

    @Override
    public List<Classes> getSkillsEndorsedByBarista(String barista_name) {
        return null;
    }

    @Override
    public List<Classes> getSkillsEndorsedByClass(String class_name) {
        return null;
    }

    @Override
    public List<Classes> getChallengesAcceptedByBarista(String barista_name) {
        return null;
    }

    @Override
    public List<Classes> getChallengesAcceptedByClass(String class_name) {
        return null;
    }

    @Override
    public List<Classes> getClassesCompletedByBarista(String barista_name) {
        return null;
    }

    @Override
    public List<Classes> getBaristasDroppedByClass(String class_name) {
        return null;
    }

    @Override
    public int getNumDroppedByBarista(String barista_name) {
        return 0;
    }

    @Override
    public int getNumDroppedByClass(String class_name) {
        return 0;
    }
}
