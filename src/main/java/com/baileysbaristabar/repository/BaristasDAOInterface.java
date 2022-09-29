package com.baileysbaristabar.repository;

import java.util.List;

import com.baileysbaristabar.entities.Baristas;
import com.baileysbaristabar.entities.Classes;

public interface BaristasDAOInterface { //need to update these to refer to the field in the baristas table

    List<Baristas> getAllBaristas();

    List<Baristas> checkUserCredentials(String inputUser, String inputPass);

    Baristas getBaristaByUsername(String inputUser);



}
