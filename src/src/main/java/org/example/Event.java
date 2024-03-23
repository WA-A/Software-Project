package org.example;

public class Event {
    private int packegeId;
   private String eventTitle;
 private   String date;
  private  String location;
   private String startAt;
 private  String endAt;
 private int numOfInvitees;
 private String serviceProviderName;
 private String userName;

public Event(){
    this.packegeId=0;
    this.eventTitle= null;
    this.location=null;
    this.date = null;
    this.startAt = null;
    this.endAt = null;
    this.numOfInvitees=0;
    this.serviceProviderName= null;
   this.userName=null;
}
    public Event(int packegeId,String userName,String eventTitle,String location, String date, String startAt, String endAt,int numOfInvitees,String serviceProviderName) {
        this.packegeId=packegeId;
        this.userName=userName;
        this.eventTitle= eventTitle;
        this.location=location;
        this.date = date;
        this.startAt = startAt;
        this.endAt = endAt;
        this.numOfInvitees=numOfInvitees;
        this.serviceProviderName=serviceProviderName;
    }
    public void setEventTitle(String eventTitle) {
    this.eventTitle=eventTitle;
    }
    public void setUserName(String userName) {
        this.userName=userName;
    }
    public void setPackegeId(int packegeId) {
        this.packegeId=packegeId;
    }
    public void setocation(String location) {
    this.location=location;
    }
    public void setNumOfInvitees(int numOfInvitees)
    {
       this.numOfInvitees=numOfInvitees;
    }
    public String getLocation(){
    return this.location;}
    public int getNumOfInvitees(){
    return this.numOfInvitees;}
    public String getEventTitle(){
    return this.eventTitle;}


        public String getServiceProviderName(){
        return this.serviceProviderName;
    }
    public String getDate(){
        return this.date;
    }
    public String getUserName(){
        return this.userName;
    }
    public int getPackegeId(){
    return this.packegeId;
    }
    public String getEndAt(){
        return this.endAt;
    }
    public String getStartAt(){
        return this.startAt;
    }
    public void setServiceProviderName(String serviceProviderName){
        this.serviceProviderName=serviceProviderName;
    }
    public void setDate(String date){
        this.date=date;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }
    public void setStartAt(String startAt){
        this.startAt=startAt;
    }
}



