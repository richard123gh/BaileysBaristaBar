package com.baileysbaristabar.repository;

import com.baileysbaristabar.entities.Classes;
import com.baileysbaristabar.utils.HibernateUtil;

import java.util.List;

public class ClassesDAO implements ClassesDAOInterface {


    @Override
    public List<Classes> getAllClasses() {
        HibernateUtil.beginTransaction();
        List<Classes> allClasses = HibernateUtil.getSession().createQuery("from classes", Classes.class).getResultList();
        HibernateUtil.endTransaction();
        return allClasses;
    }

    @Override
    public Classes getClassName(String class_name) {
        HibernateUtil.beginTransaction();
        Classes returnClass = HibernateUtil.getSession().createQuery("from classes where class_name = :class_name", Classes.class).setParameter("class_name", class_name).getSingleResult();
        HibernateUtil.endTransaction();
        return returnClass;
    }

    @Override
    public Classes addNewClass(Classes class_name) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(class_name);
        HibernateUtil.endTransaction();
        return class_name;
    }

    @Override
    public Classes updateClass(Classes class_name) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().update(class_name);
        HibernateUtil.endTransaction();
        return class_name;
    }

    @Override
    public boolean deleteClass(Classes class_name) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().delete(class_name);
        HibernateUtil.endTransaction();
        return true;
    }

    @Override
    public Classes addStartDate(Classes start_date) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(start_date);
        HibernateUtil.endTransaction();
        return start_date;
    }

    @Override
    public Classes updateStartDate(Classes start_date) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().update(start_date);
        HibernateUtil.endTransaction();
        return start_date;
    }

    @Override
    public Classes getEnrolledNumber(String class_name) {
        HibernateUtil.beginTransaction();
        Classes returnEnrolledNumber = HibernateUtil.getSession().createQuery("select enrolled_number from classes where class_name = :class_name", Classes.class).setParameter("class_name", class_name).getSingleResult();
        HibernateUtil.endTransaction();
        return returnEnrolledNumber;
    }

    @Override
    public Classes addEnrolledNumber(Classes enrolled_number) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(enrolled_number);
        HibernateUtil.endTransaction();
        return enrolled_number;
    }

    @Override
    public Classes updateEnrolledNumber(Classes enrolled_number) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().update(enrolled_number);
        HibernateUtil.endTransaction();
        return enrolled_number;
    }

    @Override
    public Classes addClassChallenge(Classes class_challenge) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(class_challenge);
        HibernateUtil.endTransaction();
        return class_challenge;
    }

    @Override
    public Classes updateClassChallenge(Classes class_challenge) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().update(class_challenge);
        HibernateUtil.endTransaction();
        return class_challenge;
    }

    @Override
    public Classes getAcceptedNumber(Classes challenge_accepted_num) {
        HibernateUtil.beginTransaction();
        Classes returnAcceptedNumber = HibernateUtil.getSession().createQuery("select challenge_accepted_num from classes where class_name = :class_name", Classes.class).setParameter("class_name", class_name).getSingleResult();
        HibernateUtil.endTransaction();
        return returnAcceptedNumber;
    }

    @Override
    public Classes updateAcceptedNumber(Classes challenge_accepted_num) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().update(challenge_accepted_num);
        HibernateUtil.endTransaction();
        return challenge_accepted_num;
    }

    @Override
    public Classes addClassSkill(Classes skill) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(skill);
        HibernateUtil.endTransaction();
        return skill;
    }

    @Override
    public Classes updateClassSkill(Classes skill) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().update(skill);
        HibernateUtil.endTransaction();
        return skill;
    }

    @Override
    public boolean classCompleted(Classes class_completed) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().update(class_completed);
        HibernateUtil.endTransaction();
        return true;
    }
}
