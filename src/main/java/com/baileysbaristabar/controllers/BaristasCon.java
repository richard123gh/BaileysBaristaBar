package com.baileysbaristabar.controllers;

import com.baileysbaristabar.entities.Baristas;
import com.baileysbaristabar.service.BaristaService;
import com.baileysbaristabar.service.BaristaServiceInterface;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.javalin.http.Handler;

public class BaristasCon {
    private Gson gson;
    private BaristaServiceInterface baristaService;

    public BaristasCon(BaristaService baristaService) {
        this.baristaService = baristaService;
        this.gson = new Gson();
    }

    public Handler getAllBaristas = ctx -> {
        List<Baristas> baristas = baristaService.getAllBaristas();
        ctx.result(gson.toJson(baristas));
        ctx.status(200);
    };
//https://github.com/cam634/Tech-Project-InGen/blob/main/ingen/src/main/java/com/ingen/controllers/EmployeeController.java
    public Handler checkUserCredentials = ctx -> {
        try {
            Gson gson = new Gson();
            Baristas baristaCred = gson.fromJson(ctx.body(), Baristas.class);
            Baristas baristas = baristaService.checkUserCredentials(baristaCred.getBaristaUsername(), baristaCred.getBaristaPassword());
            ctx.result(gson.toJson(baristas));
            ctx.status(200);
        } catch (Exception e) {
            Map<String, String> message = new HashMap<>();
            message.put("message", e.getMessage());
            String messageJson = this.gson.toJson(message);
            ctx.result(messageJson);
            e.printStackTrace();
            ctx.status(400);
        }
    };

}
