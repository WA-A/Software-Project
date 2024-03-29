package org.example;

public class Calender {
    private String serviceProviderName;
    private int packegeId;
    private String date;
    private String startAt;
    private String endAt;
    private String eventTitle;
    public Calender(){
        date=null;
        startAt=null;
        endAt=null;
        serviceProviderName=null;
        eventTitle=null;
    }
    public Calender(String date,String serviceProviderName,String startAt,String endAt,String eventTitle){
       this.date=date;
       this.serviceProviderName=serviceProviderName;
        this.endAt=endAt;
       this.startAt=startAt;
       this.eventTitle=eventTitle;
    }
     public String getServiceProviderName(){
         return this.serviceProviderName;
     }
     public String getDate(){
        return this.date;
     }
     public String getEventTitle(){
        return this.eventTitle;
     }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }
    public int getPackegeId(){
        return this.packegeId;
    }
    public void setPackegeId(int id){
        this.packegeId=id;
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
