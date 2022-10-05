package com.baileysbaristabar.entities;

import com.baileysbaristabar.utils.HibernateUtil;

import javax.persistence.*;

@Entity
@Table(name = "enrollmentInfo")
public class EnrollmentInfo {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "class_name")
    private String class_name;
    @Column(name = "barista_username")
    private String barista_username;
    @Column(name = "class_rep")
    private String class_rep;
    @Column(name = "skill_endorsed")
    private boolean skill_endorsed;
    @Column(name = "challenge_accepted")
    private boolean challenge_accepted;
    @Column(name = "status")
    private String status;

    public EnrollmentInfo(){}

    public EnrollmentInfo(String class_name, String barista_username, String class_rep, boolean skill_endorsed, boolean challenge_accepted, String status){
        this.class_name = class_name;
        this.barista_username = barista_username;
        this.class_rep = class_rep;
        this.skill_endorsed = skill_endorsed;
        this.challenge_accepted = challenge_accepted;
        this.status = status;
    }

    public EnrollmentInfo(int id, String class_name, String barista_username, String class_rep, boolean skill_endorsed, boolean challenge_accepted, String status){
        this.id = id;
        this.class_name = class_name;
        this.barista_username = barista_username;
        this.class_rep = class_rep;
        this.skill_endorsed = skill_endorsed;
        this.challenge_accepted = challenge_accepted;
        this.status = status;
    }

    public String getClassName(){
        return class_name;
    }

    public void setClassName(String class_name){
        this.class_name = class_name;
    }

    public String getBaristaUsername(){
        return barista_username;
    }

    public void setBaristaUsername(String barista_username){
        this.barista_username = barista_username;
    }

    public String getClassRep(){
        return class_rep;
    }

    public void setClassRep(String class_rep){
        this.class_rep = class_rep;
    }

    public boolean getSkillEndorsed(){
        return skill_endorsed;
    }

    public void setSkillEndorsed(boolean skill_endorsed){
        this.skill_endorsed = skill_endorsed;
    }

    public boolean getChallengeAccepted(){
        return challenge_accepted;
    }

    public void setChallengeAccepted(boolean challenge_accepted){
        this.challenge_accepted = challenge_accepted;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String toString(){
        return "Class Name: " + class_name +
                " Barista Username: " + barista_username +
                " Class Rep: " + class_rep +
                " Skill Endorsed: " + skill_endorsed +
                " Challenge Accepted: " + challenge_accepted +
                " Status: " + status;
    }
}
