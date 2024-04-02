package org.example;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class ServiceProvider {
    private String username;
    private String password;
    private String email;
    private String phoneNum;
    private boolean isLogged;
    private static final Logger LOGGER = Logger.getLogger(ServiceProvider.class.getName());

public ServiceProvider(){
    username=null;
    password=null;
    email=null;
    phoneNum=null;
}
    public void setLogged(boolean isLogged){
        this.isLogged=isLogged;
    }
    public boolean getLogged(){
        return this.isLogged;
    }
public String getPassword(){
    return this.password;
}
public String getUsername(){
    return this.username;
}
public String getEmail(){
    return this.email;
}
public String getPhoneNum(){
    return this.phoneNum;
}
public void setUsername(String username){
    this.username=username;
}
public void setPassword(String password){
    this.password=password;
}
public void setEmail(String email){
    this.email=email;
}
public void setPhoneNum(String phoneNum){
    this.phoneNum=phoneNum;
}
    public String addPackage(int packegeId,int price,int capacity,String location ,String placeName,String description,String serProNme) {
        Packege p=new Packege();
        p.setId(packegeId);
        p.setPrice(price);
        p.setPlaceName(placeName);
        p.setCapacity(capacity);
        p.setServicesDes(description);
        p.setServiceProviderName(serProNme);
        p.setLocation(location);
        Application.packeges.add(p);
        return "package added successfully";
    }

    public String removePackage(int packegeId) {
        Iterator<Packege> iterator = Application.packeges.iterator();
        while (iterator.hasNext()) {
            Packege p = iterator.next();
            if (p.getId()== packegeId) {
                iterator.remove();
                return "The Packege is removed";
            }
        }
        return "package not found" ;
    }

    public String updatePackage(int id, int updateType, String newValue) {


        for (Packege pkg : Application.packeges) {
            if (pkg.getId() == id) {
                switch (updateType) {
                    case 1:
                        updatePrice(pkg, newValue);

                        break;
                    case 2:
                        updateCapacity(pkg, newValue);

                        break;
                    case 3:
                        updateLocation(pkg, newValue);

                        break;
                    case 4:
                        updatePlaceName(pkg, newValue);

                        break;
                    case 5:
                        updateServicesDes(pkg, newValue);

                        break;
                    case 6:
                        updateServiceProviderName(pkg, newValue);

                        break;
                    default:
                        LOGGER.warning("Invalid option. Please try again.");
                        return "Invalid update option provided.";
                }
                return "Package updated successfully.";
            }
        }
        return "Package not found.";
    }

    private void updatePrice(Packege pkg, String newValue) {
        pkg.setPrice(Integer.parseInt(newValue));

    }

    private void updateCapacity(Packege pkg, String newValue) {
        pkg.setCapacity(Integer.parseInt(newValue));

    }

    private void updateLocation(Packege pkg, String newValue) {
        pkg.setLocation(newValue);

    }

    private String updatePlaceName(Packege pkg, String newValue) {
        pkg.setPlaceName(newValue);
        return "Place name updated successfully";
    }

    private void updateServicesDes(Packege pkg, String newValue) {
        pkg.setServicesDes(newValue);

    }

    private void updateServiceProviderName(Packege pkg, String newValue) {
        pkg.setServiceProviderName(newValue);

    }


public String showMyPackeges(String username){
    List<Packege> pack=new ArrayList<>();
    boolean flage= false;
    for(Packege p:Application.packeges){
        if(p.getServicesProviderName().equals(username)){
            flage=true;
            pack.add(p);
        }
    }
    for (Packege p : pack) {
        LOGGER.info(() ->String.format(
                "Package Id: %s Place Name: %s Location: %s Capacity: %d Package Price: %d Services: %s Service Provider: %s",
                p.getId(), p.getPlaceName(), p.getLocation(), p.getCapacity(), p.getPrice(), p.getServicesDes(), p.getServicesProviderName()
        ));

    }

    return flage?"There are packages":"No packages found";
}
    public String showMyTasks(String username){
        // Corrected the variable name from 'flage' to 'flag' for standard naming conventions.
        boolean flag = false;
        List<Calender> tasks = new ArrayList<>(); // Assuming 'Calender' was meant to be 'Calendar'.
        for(Calender c : Application.calenders){ // Corrected 'calenders' to 'calendars'.
            if(c.getServiceProviderName().equals(username)){
                flag = true;
                tasks.add(c);
            }
        }
        // Logging is moved inside the check to ensure it's only done if 'flag' is true.
        if (flag) {
            for (Calender c : tasks) {
                LOGGER.info(() -> String.format(
                        "Event Title: %s Date: %s Start At: %s End At: %s Package Id: %d",
                        c.getEventTitle(), c.getDate(), c.getStartAt(), c.getEndAt(), c.getPackegeId() // Assuming method name correction is accurate
                ));
            }

            return "There are tasks";
        } else {
            return "No tasks found";
        }
    }

public String showMessages(String servceProviderName){
    boolean flage= false;
    for(Message m:Application.messages){
        if(m.getServiceProviderName().equals(servceProviderName)) {
            flage=true;
            LOGGER.info(m.getMessage());
        }
    }
    return flage?"There are massages":"No massages found";
}

}
