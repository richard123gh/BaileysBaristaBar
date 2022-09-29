package com.baileysbaristabar.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "classes")
public class Classes {
    @Id
    @GeneratedValue
    @Column(name = "class_name")
    private String class_name;
    @Column(name = "start_date")
    private Date start_date;
    @Column(name = "num_enrolled")
    private int num_enrolled;
    @Column(name = "class_challenge")
    private String class_challenge;
    @Column(name = "challenge_accepted_num")
    private int challenge_accepted_num;
    @Column(name = "skill")
    private String skill;
    @Column(name = "class_completed")
    private boolean class_completed;

    public Classes(){}

    public Classes(String class_name, Date start_date, int num_enrolled, String class_challenge, int challenge_accepted_num, String skill, boolean class_completed){
        this.class_name = class_name;
        this.start_date = start_date;
        this.num_enrolled = num_enrolled;
        this.class_challenge = class_challenge;
        this.challenge_accepted_num = challenge_accepted_num;
        this.skill = skill;
        this.class_completed = class_completed;
    }

    public String getClassName(){
        return class_name;
    }

    public void setClassName(String class_name){
        this.class_name = class_name;
    }

    public Date getStartDate(){
        return start_date;
    }

    public void setStartDate(Date start_date){
        this.start_date = start_date;
    }

    public int getNumEnrolled(){
        return num_enrolled;
    }

    public void setNumEnrolled(int num_enrolled){
        this.num_enrolled = num_enrolled;
    }

    public String getClassChallenge(){
        return class_challenge;
    }

    public void setClassChallenge(String class_challenge){
        this.class_challenge = class_challenge;
    }

    public int getChallengeAcceptedNum(){
        return challenge_accepted_num;
    }

    public void setChallengeAcceptedNum(int challenge_accepted_num){
        this.challenge_accepted_num = challenge_accepted_num;
    }

    public String getSkill(){
        return skill;
    }

    public void setSkill(String skill){
        this.skill = skill;
    }

    public boolean getClassCompleted(){
        return class_completed;
    }

    public void setClassCompleted(boolean class_completed){
        this.class_completed = class_completed;
    }

    public String toString(){
        return "Class Name: " + class_name + " Start Date: " + start_date + " Number Enrolled: " + num_enrolled + " Class Challenge: " + class_challenge + " Challenge Accepted Number: " + challenge_accepted_num + " Skill: " + skill + " Class Completed: " + class_completed;
    }
}
