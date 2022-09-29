package com.baileysbaristabar.controllers;

import com.baileysbaristabar.entities.Baristas;
import com.baileysbaristabar.service.BaristaServiceInterface;
import com.google.gson.Gson;

import java.util.List;
import io.javalin.http.Handler;

public class BaristasCon {
    private Gson gson;
    private BaristaServiceInterface baristaService;

    public BaristasCon(BaristaServiceInterface baristaService) {
        this.baristaService = baristaService;
        this.gson = new Gson();
    }

    public Handler getAllBaristas = ctx -> {
        List<Baristas> baristas = baristaService.getAllBaristas();
        ctx.result(gson.toJson(baristas));
        ctx.status(200);
    };

    public Handler checkUserCredentials = ctx -> {
        String inputUser = ctx.formParam("inputUser");
        String inputPass = ctx.formParam("inputPass");
        List<Baristas> baristas = baristaService.checkUserCredentials(inputUser, inputPass);
        ctx.result(gson.toJson(baristas));
        ctx.status(200);
    };

}
