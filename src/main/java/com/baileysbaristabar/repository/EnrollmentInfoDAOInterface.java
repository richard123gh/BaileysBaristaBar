package com.baileysbaristabar.repository;

import com.baileysbaristabar.entities.Baristas;
import com.baileysbaristabar.entities.Classes;
import com.baileysbaristabar.entities.EnrollmentInfo;

import java.util.List;

public interface EnrollmentInfoDAOInterface {

    List<EnrollmentInfo> getAllEnrollment();

    List<EnrollmentInfo> getEnrollmentByClass(String class_name);

    List<EnrollmentInfo> getEnrollmentByBarista(String barista_username);

    EnrollmentInfo addNewEnrollment(EnrollmentInfo enrollment);

    EnrollmentInfo updateEnrollment(EnrollmentInfo enrollment);

    EnrollmentInfo getClassRep(String class_name);

    EnrollmentInfo updateClassRep(String class_name, String barista_username);

    EnrollmentInfo deleteEnrollmentByBarista(String class_name, String barista_username, String status);

    EnrollmentInfo getStatusByBarista(String class_name);

    EnrollmentInfo updateStatusByBarista(String class_name, String barista_username, String status);




}
