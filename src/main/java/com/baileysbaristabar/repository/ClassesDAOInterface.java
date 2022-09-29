package com.baileysbaristabar.repository;

import java.util.List;

import com.baileysbaristabar.entities.Classes;

public interface ClassesDAOInterface {

    List<Classes> getAllClasses();

    Classes getClassName(String class_name);

    Classes addNewClass(Classes class_name);

    Classes updateClass(Classes class_name);

    boolean deleteClass(Classes class_name);

    Classes addStartDate(Classes start_date);

    Classes updateStartDate(Classes start_date);

    Classes getEnrolledNumber(String class_name);

    Classes addEnrolledNumber(Classes enrolled_number);

    Classes updateEnrolledNumber(Classes enrolled_number);

    Classes addClassChallenge(Classes class_challenge);

    Classes updateClassChallenge(Classes class_challenge);

    Classes getAcceptedNumber(Classes challenge_accepted_num);

    Classes updateAcceptedNumber(Classes challenge_accepted_num);

    Classes addClassSkill(Classes skill);

    Classes updateClassSkill(Classes skill);

    boolean classCompleted(Classes class_completed);

}
