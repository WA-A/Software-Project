package org.example;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
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

    public String updatePackage(int id) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for input
        boolean updated = false;

        for (Packege pkg : Application.packeges) {
            if (pkg.getId() == id) {
                updated = updateAttributes(pkg, scanner);
                return updated ? "Package updated successfully." : "No updates made.";
            }
        }
        return "Package not found.";
    }

    private boolean updateAttributes(Packege pkg, Scanner scanner) {
        while (true) {
            LOGGER.info("Enter the type you want to modify");
            LOGGER.info("""
             1. price
             2. capacity
             3. location
             4. place name
             5. services
             6. service provider name
             7. exit
             """);


            int key = Integer.parseInt(scanner.nextLine()); // Read the choice as an integer

            if (key == 7) {
                break; // Exit the loop
            }

            LOGGER.info("Enter the new value:");
            String newValue = scanner.nextLine(); // Read the new value from user

            switch (key) {
                case 1:
                    pkg.setPrice(Integer.parseInt(newValue));
                    return true;
                case 2:
                    pkg.setCapacity(Integer.parseInt(newValue));
                    return true;
                case 3:
                    pkg.setLocation(newValue);
                    return true;
                case 4:
                    pkg.setPlaceName(newValue);
                    return true;
                case 5:
                    pkg.setServicesDes(newValue);
                    return true;
                case 6:
                    pkg.setServiceProviderName(newValue);
                    return true;
                default:
                    LOGGER.warning("Invalid option. Please try again.");
                    break;
            }
        }
        return false;
    }
public void showMyPackeges(String username){
    List<Packege> pack=new ArrayList<>();
    String space="    ";
    for(Packege p:Application.packeges){
        if(p.getServicesProviderName().equals(username)){
            pack.add(p);
        }
    }
    for(Packege p: pack){
        LOGGER.info("Packege Id: "+p.getId()+space+"Place Name: "+p.getPlaceName()+space+"Location: "+p.getLocation()+space+"Capacity: "+p.getCapacity()+space+"Packege Price: "+p.getPrice()+space+"Services: "+p.getServicesDes()+space+"Service Provider: "+p.getServicesProviderName());
    }
}
public void showMyTasks(String username){
    List<Calender> cal=new ArrayList<>();
    String space="    ";
    for(Calender c:Application.calenders){
        if(c.getServiceProviderName().equals(username)){
            cal.add(c);
        }
    }
    for(Calender c: cal){
        LOGGER.info("Event Title: "+c.getEventTitle()+space+"Date: "+c.getDate()+space+"Start At: "+c.getStartAt()+space+"End At: "+c.getEndAt()+space+"Packege Id: "+c.getPackegeId());
    }
}
public void showMessages(String servceProviderName){
    for(Message m:Application.messages){
        if(m.getServiceProviderName().equals(servceProviderName)) {
            LOGGER.info(m.getMessage());
        }
    }
}

}
