package org.example;

public class Message {
private String mes ;
private String serviceProviderName;
Message(){
    mes=null;
    serviceProviderName=null;
}
    public void setMessage(String message) {
    this.mes=message;
    }

    public void setServiceProviderName(String serviceProviderName) {
    this.serviceProviderName=serviceProviderName;
    }

    public String getServiceProviderName() {
    return this.serviceProviderName;
    }

    public String getMessage() {
    return this.mes;
    }
}
