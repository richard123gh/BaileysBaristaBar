package com.baileysbaristabar.service;

import com.baileysbaristabar.entities.Baristas;
import com.baileysbaristabar.repository.BaristasDAOInterface;

import java.util.List;

public class BaristaService implements BaristaServiceInterface {
    private BaristaService baristaDao;

    @Override
    public List<Baristas> getAllBaristas() {
        return baristaDao.getAllBaristas();
    }

    @Override
    public List<Baristas> checkUserCredentials(String inputUser, String inputPass) {
        return baristaDao.checkUserCredentials(inputUser, inputPass);

    }
}
