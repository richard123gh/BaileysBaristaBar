package com.baileysbaristabar.controllers;

import com.baileysbaristabar.entities.Classes;
import com.baileysbaristabar.service.ClassesService;
import com.baileysbaristabar.service.ClassesServiceInterface;
import com.google.gson.Gson;

import java.util.List;

import io.javalin.http.Handler;

public class ClassesCon {

    private Gson gson;

    private ClassesServiceInterface classService;

    public ClassesCon(ClassesService classService) {
        this.classService = classService;
        this.gson = new Gson();
    }

    public Handler getAllClasses = ctx -> {
        List<Classes> classes = classService.getAllClasses();
        ctx.result(gson.toJson(classes));
        ctx.status(200);
    };

    public Handler getClassName = ctx -> {
        String class_name = ctx.pathParam("class_name");
        Classes classes = classService.getClassName(class_name);
        ctx.result(gson.toJson(classes));
        ctx.status(200);
    };

    public Handler addNewClass = ctx -> {
        Classes c = gson.fromJson(ctx.body(), Classes.class);
        classService.addNewClass(c);
        ctx.status(201);
    };

    public Handler getEnrolledNumber = ctx -> {
        String class_name = ctx.pathParam("class_name");
        Classes classes = classService.getEnrolledNumber(class_name);
        ctx.result(gson.toJson(classes));
        ctx.status(200);
    };

    public Handler updateEnrolledNumber = ctx -> {
        Classes enrolled_number = gson.fromJson(ctx.body(), Classes.class);
        classService.updateEnrolledNumber(enrolled_number);
        ctx.status(201);
    };

    public Handler updateCompleted = ctx -> {
        String class_name = ctx.pathParam("class_name");
        boolean class_completed = Boolean.parseBoolean(ctx.pathParam("class_completed"));
        classService.updateCompleted(class_name, class_completed);
        ctx.status(201);
    };

}
