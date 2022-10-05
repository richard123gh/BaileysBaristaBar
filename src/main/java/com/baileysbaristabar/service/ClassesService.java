package com.baileysbaristabar.service;

import com.baileysbaristabar.entities.Classes;
import com.baileysbaristabar.repository.ClassesDAO;

import java.util.List;

public class ClassesService implements ClassesServiceInterface {

    private ClassesDAO classDao;

    public ClassesService(ClassesDAO classDao){
        this.classDao = classDao;
    }

    @Override
    public List<Classes> getAllClasses() {
        return classDao.getAllClasses();
    }

    @Override
    public Classes getClassName(String class_name) {
        return classDao.getClassName(class_name);
    }

    @Override
    public Classes addNewClass(Classes c) {
        return classDao.addNewClass(c);
    }

    @Override
    public Classes getEnrolledNumber(String class_name) {
        return classDao.getEnrolledNumber(class_name);
    }

    @Override
    public Classes updateEnrolledNumber(Classes enrolled_number) {
        return classDao.updateEnrolledNumber(enrolled_number);
    }

    @Override
    public Classes updateCompleted(String class_name, boolean class_completed) {
        return classDao.updateCompleted(class_name, class_completed);
    }


}
