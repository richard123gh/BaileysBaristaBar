package com.baileysbaristabar.repository;

import java.util.List;

import com.baileysbaristabar.entities.Classes;

public interface ClassesDAOInterface {

    List<Classes> getAllClasses();

    Classes getClassName(String class_name);

    Classes addNewClass(Classes class_name);

    Classes getEnrolledNumber(String class_name);

    Classes updateEnrolledNumber(Classes enrolled_number);

    Classes updateCompleted(String class_name, boolean class_completed);

}
