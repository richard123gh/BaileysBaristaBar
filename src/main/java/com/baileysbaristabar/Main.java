package com.baileysbaristabar;

import com.baileysbaristabar.controllers.BaristasCon;
import com.baileysbaristabar.controllers.ClassesCon;
import com.baileysbaristabar.controllers.EnrollmentCon;
import com.baileysbaristabar.repository.BaristasDAO;
import com.baileysbaristabar.repository.ClassesDAO;
import com.baileysbaristabar.repository.EnrollmentInfoDAO;
import com.baileysbaristabar.service.BaristaService;
import com.baileysbaristabar.service.ClassesService;
import com.baileysbaristabar.service.EnrollmentService;
import com.baileysbaristabar.utils.HibernateUtil;
import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();

        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.enableDevLogging();
        }).start();

        BaristasDAO baristasDAO = new BaristasDAO();
        BaristaService baristaService = new BaristaService(baristasDAO);
        BaristasCon baristasCon = new BaristasCon(baristaService);

        app.get("/baristas", baristasCon.getAllBaristas);
        app.patch("/baristas/login", baristasCon.checkUserCredentials);

        ClassesDAO classesDAO = new ClassesDAO();
        ClassesService classesService = new ClassesService(classesDAO);
        ClassesCon classesCon = new ClassesCon(classesService);

        app.get("/classes", classesCon.getAllClasses);
        app.get("/classes/class_name", classesCon.getClassName);
        app.post("/classes", classesCon.addNewClass);
        app.get("/classes/class_name/enrolled", classesCon.getEnrolledNumber);
        app.patch("/classes/enrolled", classesCon.updateEnrolledNumber);
        app.patch("/classes/completed", classesCon.updateCompleted);

        EnrollmentInfoDAO enrollmentInfoDAO = new EnrollmentInfoDAO();
        EnrollmentService enrollmentService = new EnrollmentService(enrollmentInfoDAO);
        EnrollmentCon enrollmentCon = new EnrollmentCon(enrollmentService);

        app.get("/enrollment", enrollmentCon.getAllEnrollment);
        app.get("/enrollment/class_name", enrollmentCon.getEnrollmentByClass);
        app.get("/enrollment/barista_username", enrollmentCon.getEnrollmentByBarista);
        app.post("/enrollment", enrollmentCon.addNewEnrollment);
        app.patch("/enrollment", enrollmentCon.updateEnrollment);
        app.get("/enrollment/class_name/class_rep", enrollmentCon.getClassRep);
        app.patch("/enrollment/class_name/class_rep", enrollmentCon.updateClassRep);
//        app.patch("/enrollment/class_name/barista_username/status", enrollmentCon.deleteEnrollmentByBarista);
        app.get("/enrollment/class_name/barista_username/status", enrollmentCon.getStatusByBarista);
        app.patch("/enrollment/class_name/barista_username/status", enrollmentCon.updateStatusByBarista);





//        Classes c = new Classes(
//                "cwahfee",
//                1181500200000L,
//                0,
//                "how to accent with coffee",
//                0,
//                "stirring constantly",
//                false
//        );
//        ClassesDAO classesDao = new ClassesDAO();
//        System.out.println(classesDao.updateCompleted("cwahfee", true));


//        BaristasDAO baristasDao = new BaristasDAO();
//        System.out.println(baristasDao.checkUserCredentials("BaileyPerson", "password"));

    }
}

