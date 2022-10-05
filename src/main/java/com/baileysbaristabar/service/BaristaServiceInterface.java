package com.baileysbaristabar.service;

import com.baileysbaristabar.entities.Baristas;

import java.util.List;

public interface BaristaServiceInterface {
    List<Baristas> getAllBaristas();
    Baristas checkUserCredentials(String inputUser, String inputPass);
}
