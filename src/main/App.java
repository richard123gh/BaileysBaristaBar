package com.baileysbaristabar;

import com.baileysbaristabar.controllers.BaristasCon;
import com.baileysbaristabar.service.BaristaService;
import com.baileysbaristabar.service.BaristaServiceInterface;
import io.javalin.Javalin;

public class App 
{
    public static void main( String[] args ) {
        HibernateUtil.getSessionFactory();

        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.enableDevLogging();
        });

        app.get("/Baristas", new BaristasCon(new BaristaService(new BaristasDAO())).getAllBaristas);

        app.patch("/Baristas/{barista_username}/{barista_password}", new BaristasCon(new BaristaService(new BaristasDAO())).checkUserCredentials);

        app.start();

    }
}
