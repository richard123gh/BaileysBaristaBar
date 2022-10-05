package com.baileysbaristabar.repository;

import java.util.List;

import com.baileysbaristabar.entities.Baristas;
import com.baileysbaristabar.entities.Classes;

public interface BaristasDAOInterface {

    List<Baristas> getAllBaristas();

    Baristas checkUserCredentials(String inputUser, String inputPass);

    Baristas getBaristaByUsername(String inputUser);

//    Baristas updateEnrolledNum(String inputUser);

}
