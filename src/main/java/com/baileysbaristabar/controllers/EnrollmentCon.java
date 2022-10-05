package com.baileysbaristabar.controllers;

import com.baileysbaristabar.entities.EnrollmentInfo;
import com.baileysbaristabar.service.EnrollmentService;
import com.baileysbaristabar.service.EnrollmentServiceInterface;
import com.google.gson.Gson;
import io.javalin.http.Handler;

import java.util.List;

public class EnrollmentCon {

    private Gson gson;

    private EnrollmentServiceInterface enrollmentService;

    public EnrollmentCon(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
        this.gson = new Gson();
    }

    public Handler getAllEnrollment = ctx -> {
        List<EnrollmentInfo> enrollmentInfoList = enrollmentService.getAllEnrollment();
        ctx.result(gson.toJson(enrollmentInfoList));
        ctx.status(200);
    };

    public Handler getEnrollmentByClass = ctx -> {
        String class_name = ctx.pathParam("class_name");
        List<EnrollmentInfo> enrollmentInfoList = enrollmentService.getEnrollmentByClass(class_name);
        ctx.result(gson.toJson(enrollmentInfoList));
        ctx.status(200);
    };

    public Handler getEnrollmentByBarista = ctx -> {
        String barista_username = ctx.pathParam("barista_username");
        List<EnrollmentInfo> enrollmentInfoList = enrollmentService.getEnrollmentByBarista(barista_username);
        ctx.result(gson.toJson(enrollmentInfoList));
        ctx.status(200);
    };

    public Handler addNewEnrollment = ctx -> {
        EnrollmentInfo enrollmentInfo = gson.fromJson(ctx.body(), EnrollmentInfo.class);
        enrollmentService.addNewEnrollment(enrollmentInfo);
        ctx.status(201);
    };

    public Handler updateEnrollment = ctx -> {
        EnrollmentInfo enrollmentInfo = gson.fromJson(ctx.body(), EnrollmentInfo.class);
        enrollmentService.updateEnrollment(enrollmentInfo);
        ctx.status(201);
    };

    public Handler getClassRep = ctx -> {
        String class_name = ctx.pathParam("class_name");
        EnrollmentInfo class_rep = enrollmentService.getClassRep(class_name);
        ctx.result(gson.toJson(class_rep));
        ctx.status(200);
    };

    public Handler updateClassRep = ctx -> {
        String class_name = ctx.pathParam("class_name");
        String class_rep = ctx.pathParam("class_rep");
        enrollmentService.updateClassRep(class_name, class_rep);
        ctx.status(201);
    };

//    public Handler deleteEnrollmentByBarista = ctx -> {
//        String class_name = ctx.pathParam("class_name");
//        String barista_username = ctx.pathParam("barista_username");
//        String status = ctx.pathParam("status");
//        enrollmentService.deleteEnrollmentByBarista(class_name, barista_username, status);
//        ctx.status(201);
//    };

    public Handler getStatusByBarista = ctx -> {
        String class_name = ctx.pathParam("class_name");
        String barista_username = ctx.pathParam("barista_username");
        EnrollmentInfo status = enrollmentService.getStatusByBarista(class_name, barista_username);
        ctx.result(gson.toJson(status));
        ctx.status(200);
    };

    public Handler updateStatusByBarista = ctx -> {
        String class_name = ctx.pathParam("class_name");
        String barista_username = ctx.pathParam("barista_username");
        String status = ctx.pathParam("status");
        enrollmentService.updateStatusByBarista(class_name, barista_username, status);
        ctx.status(201);
    };



}
