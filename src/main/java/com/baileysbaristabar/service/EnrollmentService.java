package com.baileysbaristabar.service;

import com.baileysbaristabar.entities.EnrollmentInfo;
import com.baileysbaristabar.repository.EnrollmentInfoDAO;

import java.util.List;

public class EnrollmentService implements EnrollmentServiceInterface{

    private EnrollmentInfoDAO enrollmentDao;

    public EnrollmentService(EnrollmentInfoDAO enrollmentInfoDAO) {
        this.enrollmentDao = enrollmentInfoDAO;
    }


    @Override
    public List<EnrollmentInfo> getAllEnrollment() {
        return enrollmentDao.getAllEnrollment();
    }

    @Override
    public List<EnrollmentInfo> getEnrollmentByClass(String class_name) {
        return enrollmentDao.getEnrollmentByClass(class_name);
    }

    @Override
    public List<EnrollmentInfo> getEnrollmentByBarista(String barista_username) {
        return enrollmentDao.getEnrollmentByBarista(barista_username);
    }

    @Override
    public EnrollmentInfo addNewEnrollment(EnrollmentInfo enrollment) {
        return enrollmentDao.addNewEnrollment(enrollment);
    }

    @Override
    public EnrollmentInfo updateEnrollment(EnrollmentInfo enrollment) {
        return enrollmentDao.updateEnrollment(enrollment);
    }

    @Override
    public EnrollmentInfo getClassRep(String class_name) {
        return enrollmentDao.getClassRep(class_name);
    }

    @Override
    public EnrollmentInfo updateClassRep(String class_name, String class_rep) {
        return enrollmentDao.updateClassRep(class_name, class_rep);
    }

//    @Override
//    public EnrollmentInfo deleteEnrollmentByBarista(String class_name, String barista_username, String status) {
//        return enrollmentDao.deleteEnrollmentByBarista(class_name, barista_username, status);
//    }

    @Override
    public EnrollmentInfo getStatusByBarista(String class_name, String barista_username) {
        return enrollmentDao.getStatusByBarista(class_name);
    }

    @Override
    public EnrollmentInfo updateStatusByBarista(String class_name, String barista_username, String status) {
        return enrollmentDao.updateStatusByBarista(class_name, barista_username, status);
    }
}
