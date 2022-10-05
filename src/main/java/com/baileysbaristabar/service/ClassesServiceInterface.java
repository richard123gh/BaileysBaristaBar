package com.baileysbaristabar.service;

import com.baileysbaristabar.entities.Classes;

import java.util.List;

public interface ClassesServiceInterface {

    List<Classes> getAllClasses();

    Classes getClassName(String class_name);

    Classes addNewClass(Classes c);

    Classes getEnrolledNumber(String class_name);

    Classes updateEnrolledNumber(Classes enrolled_number);

    Classes updateCompleted(String class_name, boolean class_completed);

}
