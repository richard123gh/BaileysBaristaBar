package com.baileysbaristabar.service;

import com.baileysbaristabar.entities.Baristas;
import com.baileysbaristabar.repository.BaristasDAO;
import com.baileysbaristabar.repository.BaristasDAOInterface;

import java.util.List;

public class BaristaService implements BaristaServiceInterface {
    private BaristasDAO baristaDao;

    public BaristaService(BaristasDAO baristaDao){
        this.baristaDao = baristaDao;
    }

    @Override
    public List<Baristas> getAllBaristas() {
        return baristaDao.getAllBaristas();
    }

    @Override
    public Baristas checkUserCredentials(String inputUser, String inputPass) {
        return baristaDao.checkUserCredentials(inputUser, inputPass);

    }
}
