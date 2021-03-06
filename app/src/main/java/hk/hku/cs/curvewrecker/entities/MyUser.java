package hk.hku.cs.curvewrecker.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LZ on 15/12/3.
 */
public class MyUser implements Serializable {
    private int uid;
    private String name;
    private int gender;                                     // 0 for male, 1 for female
    private int imgPath;
    private int title;
    private int targetFinished;
    private int targetNotFinished;
    private MyTime sleepTime;                               //current target time of sleep per day
    private MyTime studyTime;                               //current target time of study per day
    private MyRank myRank;
    private MyDress myDress;
    private MyMission crtMission;
    private MyAttributes myAttributes;
    private ArrayList<MyPlan> myPlanList;                   //used by calender
    private ArrayList<MyTarget> myTargetList;               //used by setting daily object
    private ArrayList<MyStar> myStarList;                   //used by counting total star
    private ArrayList<MyFriend> myFriendsList;
    private MyTarget sleepTarget;                           //to determine today sleepTarget statues, after today, it will be add to the targetlist
    private MyTarget studyTarget;                           //similar as the above
                                                            //Thus,the total time should be the total target time in list plus today's target

    private float totalStudyTime;                           //study time from the first day to last day
    private int totalDay;                                   //day from the first day


    public MyUser(){
        uid = 0;
        name = "";
        gender = 0;
        imgPath = 0;
        title = 0;
        sleepTime = new MyTime();
        studyTime = new MyTime();
        targetFinished = 0;
        targetNotFinished = 0;
        myRank = new MyRank();
        myDress = new MyDress();
        crtMission = new MyMission();
        myAttributes = new MyAttributes();
        myPlanList = new ArrayList<>();
        myTargetList = new ArrayList<>();
        myStarList = new ArrayList<>();
        myFriendsList = new ArrayList<>();
        sleepTarget = new MyTarget(0);
        studyTarget = new MyTarget(1);
        totalStudyTime = 0;
        totalDay = 1;

    }

    public MyUser(String name, int imgPath,  int sleepMin,int sleepHour) {
        uid = 0;
        this.name = name;
        gender = 0;
        this.imgPath = imgPath;
        title = 0;
        sleepTime = new MyTime(sleepMin,sleepHour);
        studyTime = new MyTime(0,1);
        targetFinished = 0;
        targetNotFinished = 0;
        myRank = new MyRank();
        myDress = new MyDress();
        crtMission = new MyMission();
        myAttributes = new MyAttributes();
        myPlanList = new ArrayList<>();
        myTargetList = new ArrayList<>();
        myStarList = new ArrayList<>();
        myFriendsList = new ArrayList<>();
        sleepTarget = new MyTarget(0, new MyTime(sleepMin,sleepHour));
        studyTarget = new MyTarget(1,new MyTime(0,1));
        totalStudyTime = 0;
        totalDay = 1;
    }

    public void initialFakeData(){

    //        uid = 1111;
    //        name = "testUser";
    //        gender = 0;
    //        imgPath = 0;
    //        title = 0;
    //        sleepTime = new MyTime(0,8);
    //        studyTime = new MyTime(0,2);
    //        targetFinished = 3;
    //        targetNotFinished = 2;
    //        myRank = new MyRank();
    //        myRank.initialFakeData();
    //        myDress = new MyDress();
    //        crtMission = new MyMission();
    //        myAttributes = new MyAttributes(0,10,1,2,2,2);
    //        myPlanList = new ArrayList<>();
    //        myTargetList = new ArrayList<>();


            MyTarget tempT1;
            for(int d = 1; d < 14; d++){
                tempT1 = new MyTarget(0);
                tempT1.setTargetTime(new MyTime(0, 0));
                tempT1.setActualTime(new MyTime(0, 0));
                tempT1.setDate(new MyTime(d, 12, 2015));
                tempT1.setStatus(1);
                myTargetList.add(tempT1.copy());
            }

            MyTarget tempT2 = new MyTarget(1);
            for(int d = 5; d < 11; d++){
                tempT2 = new MyTarget(1);
                tempT2.setTargetTime(new MyTime(0, 0));
                tempT2.setActualTime(new MyTime(0, 0));
                tempT2.setDate(new MyTime(d, 12, 2015));
                tempT2.setStatus(1);
                myTargetList.add(tempT2.copy());
            }


            //myTargetList.add(tempT2);


            myStarList = new ArrayList<>();
           // MyStar tempS1 = new MyStar(new MyTime(3,12,2015));
           // myStarList.add(tempS1.copy());
            MyStar tempS2 = new MyStar(new MyTime(8,12,2015));
            myStarList.add(tempS2.copy());
            MyStar tempS3 = new MyStar(new MyTime(11,12,2015));
            myStarList.add(tempS3.copy());
    //        myFriendsList = new ArrayList<>();
    //        MyFriend tempF1 = new MyFriend(2111,"friend1",1,0,1,3,3,sleepTime.copy(),studyTime.copy(),myAttributes.copy(),34);
    //        MyFriend tempF2 = new MyFriend(2112,"friend2",0,0,2,5,4,sleepTime.copy(),studyTime.copy(),myAttributes.copy(),23);
    //        myFriendsList.add(tempF1);
    //        myFriendsList.add(tempF2);
    //        sleepTarget = new MyTarget(0, sleepTime.copy());
    //        studyTarget = new MyTarget(1, studyTime.copy());
    //        sleepTarget.setActualTime(new MyTime(0,8));
    //        studyTarget.setActualTime(new MyTime(0,1));
    //
    //        totalDay = 11;


    }

    public int getUid(){
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitleName(){
        switch (this.title){
            case 1:
                return "Rank 1";
            case 2:
                return "Rank 2";
            case 3:
                return "Rank 3";
            case 4:
                return "Rank 4";
            default:
                return "Error";
        }
    }

    public int getTitle() {

        return title;

    }

    public void updateTitle(){
        this.title = this.getMyAttributes().getLevel()/10+1;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public MyTime getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(MyTime sleepTime) {
        this.sleepTime = sleepTime;
    }

    public MyTime getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(MyTime studyTime) {
        this.studyTime = studyTime;
    }

    public int getTargetFinished() {
        return targetFinished;
    }

    public void setTargetFinished(int targetFinished) {
        this.targetFinished = targetFinished;
    }

    public int getTargetNotFinished() {
        return targetNotFinished;
    }

    public void setTargetNotFinished(int targetNotFinished) {
        this.targetNotFinished = targetNotFinished;
    }


    public MyMission getCrtMission() {
        return crtMission;
    }

    public void setCrtMission(MyMission crtMission) {
        this.crtMission = crtMission;
    }

    public MyAttributes getMyAttributes() {
        return myAttributes;
    }

    public void setMyAttributes(MyAttributes myAttributes) {
        this.myAttributes = myAttributes;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getImgPath() {
        return imgPath;
    }

    public void setImgPath(int imgPath) {
        this.imgPath = imgPath;
    }

    public MyRank getMyRank() {
        return myRank;
    }

    public void setMyRank(MyRank myRank) {
        this.myRank = myRank;
    }

    public MyDress getMyDress() {
        return myDress;
    }

    public void setMyDress(MyDress myDress) {
        this.myDress = myDress;
    }


    public ArrayList<MyPlan> getMyPlanList() {
        return myPlanList;
    }

    public void setMyPlanList(ArrayList<MyPlan> myPlanList) {
        this.myPlanList = myPlanList;
    }


    // add a plan to the plan list
    public void addMyPlan(MyPlan newPlan){
        this.myPlanList.add(newPlan);
    }

    public void addMyPlan(MyPlan newPlan, int index){
        this.myPlanList.add(index, newPlan);
    }

    public ArrayList<MyTarget> getMyTargetList() {
        return myTargetList;
    }

    public void setMyTargetList(ArrayList<MyTarget> myTargetList) {
        this.myTargetList = myTargetList;
    }

    //add a target to my target list
    public void addMyTarget(MyTarget newTarget){
        this.myTargetList.add(newTarget);
    }

    public void addMyTarget(MyTarget newTarget, int index){
        this.myTargetList.add(index,newTarget);
    }

    public ArrayList<MyStar> getMyStarList() {
        return myStarList;
    }

    public void setMyStarList(ArrayList<MyStar> myStarList) {
        this.myStarList = myStarList;
    }

    public void addMyStar(MyStar newStar){
        this.myStarList.add(newStar);
    }

    // add a star to my star list
    public void addMyStar(MyStar newStar, int index){
        this.myStarList.add(index,newStar);
    }

    public ArrayList<MyFriend> getMyFriendsList() {
        return myFriendsList;
    }

    public void setMyFriendsList(ArrayList<MyFriend> myFriendsList) {
        this.myFriendsList = myFriendsList;
    }

    //add a friend to my friend list
    public void addMyFriend(MyFriend newFriend){
        this.myFriendsList.add(newFriend);
    }

    public void addMyFriend(MyFriend newFriend,int index){
        this.myFriendsList.add(index, newFriend);
    }

    public int getNumOfFriends(){
        return this.getMyFriendsList().size();
    }

    public MyTarget getSleepTarget() {
        return sleepTarget;
    }

    public void setSleepTarget(MyTarget sleepTarget) {
        this.sleepTarget = sleepTarget;
    }

    public MyTarget getStudyTarget() {
        return studyTarget;
    }

    public void setStudyTarget(MyTarget studyTarget) {
        this.studyTarget = studyTarget;
    }


    public float getTotalStudyTime() {
        return totalStudyTime;
    }

    public void setTotalStudyTime(float totalStudyTime) {
        this.totalStudyTime = totalStudyTime;
    }

    public int getTotalDay() {
        return totalDay;
    }

    public void setTotalDay(int totalDay) {
        this.totalDay = totalDay;
    }

    public MyUser copy(){
        MyUser newUser = new MyUser();

        newUser.setName(this.name);
        newUser.setCrtMission(this.crtMission.copy());
        newUser.setGender(this.gender);
        newUser.setImgPath(this.imgPath);
        newUser.setMyAttributes(this.myAttributes.copy());
        newUser.setMyDress(this.myDress.copy());
        newUser.setMyRank(this.myRank.copy());
        newUser.setSleepTarget(this.sleepTarget.copy());
        newUser.setStudyTarget(this.studyTarget.copy());
        newUser.setSleepTime(this.sleepTime.copy());
        newUser.setStudyTime(this.studyTime.copy());
        newUser.setTitle(this.title);
        newUser.setTargetFinished(this.targetFinished);
        newUser.setTargetNotFinished(this.targetNotFinished);
        newUser.setUid(this.uid);
        for(MyFriend p : this.myFriendsList){
            newUser.addMyFriend(p);
        }
        for(MyPlan p : this.myPlanList){
            newUser.addMyPlan(p);
        }
        for(MyTarget p : this.myTargetList){
            newUser.addMyTarget(p);
        }
        for(MyStar p : this.myStarList){
            newUser.addMyStar(p);
        }
        newUser.setTotalStudyTime(this.totalStudyTime);
        newUser.setTotalDay(this.totalDay);

        return newUser;

    }

}
