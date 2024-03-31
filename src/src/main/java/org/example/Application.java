package org.example;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Application {
protected static final List<Admin> admins= new ArrayList<>();
protected static final List<ServiceProvider> servicesProviders =new ArrayList<>();
protected static final List<User> users =new ArrayList<>();
 protected static final List<Packege> packeges =new ArrayList<>();
protected static final List<Event> events=new ArrayList<>();
 protected static final List<Calender> calenders=new ArrayList<>();
 protected static final List<Message> messages=new ArrayList<>();
 private static final Logger logger = Logger.getLogger(Application.class.getName());

public Application(){
 Admin a1=new Admin();
 a1.setUsername("wasan");
 a1.setPassword("123456");
 a1.setLogged(false);
 admins.add(a1);
 ServiceProvider s1=new ServiceProvider();
 s1.setUsername("abdullah");
 s1.setPassword("112233");
 s1.setEmail("abdullah@gmail.com");
 s1.setPhoneNum("0598022314");
 s1.setLogged(false);
 ServiceProvider s2=new ServiceProvider();
 s2.setUsername("mohammad");
 s2.setPassword("123123");
 s2.setEmail("mohammad@gmail.com");
 s2.setPhoneNum("0599239760");
 s2.setLogged(false);
 ServiceProvider s3=new ServiceProvider();
 s3.setUsername("ali");
 s3.setPassword("234234");
 s3.setEmail("ali@gmail.com");
 s3.setPhoneNum("0595220165");
 s3.setLogged(false);
 servicesProviders.add(s1);
 servicesProviders.add(s2);
 servicesProviders.add(s3);
 User u1=new User();
 u1.setUsername("sameh");
 u1.setPassword("223344");
 u1.setEmail("sameh@gmail.com");
 u1.setPhoneNum("0598553051");
 u1.setLogged(false);
 User u2=new User();
 u2.setUsername("ghazi");
 u2.setPassword("345345");
 u2.setEmail("ghazi@gmail.com");
 u2.setPhoneNum("0599349035");
 u2.setLogged(false);
 User u3=new User();
 u3.setUsername("basel");
 u3.setPassword("334455");
 u3.setEmail("basel@gmail.com");
 u3.setPhoneNum("0599679325");
 u3.setLogged(false);
 users.add(u1);
 users.add(u2);
 users.add(u3);
 Packege p1=new Packege();
 p1.setId(1);
 p1.setServiceProviderName(s1.getUsername());
 p1.setLocation("Nablus");
 p1.setCapacity(200);
 p1.setPlaceName("Moon sign");
 p1.setPrice(2500);
 p1.setServicesDes("video conferencing technology,simultaneous translation service");
 Packege p2=new Packege();
 p2.setId(2);
 p2.setServiceProviderName(s2.getUsername());
 p2.setLocation("Ramallah");
 p2.setCapacity(300);
 p2.setPrice(3500);
 p2.setPlaceName("Golden tree");
 p2.setServicesDes("video conferencing technology,simultaneous translation service,providing a logistics center");
 Packege p3=new Packege();
 p3.setId(3);
 p3.setServiceProviderName(s3.getUsername());
 p3.setPlaceName("Al-andalos");
 p3.setCapacity(400);
 p3.setLocation("Tulkarim");
 p3.setPrice(5550);
 p3.setServicesDes("video conferencing technology,simultaneous translation service,providing a logistics center,registration and documentation services");
 Packege p4=new Packege();
 p4.setId(4);
 p4.setServiceProviderName(s2.getUsername());
 p4.setLocation("Jenin");
 p4.setCapacity(550);
 p4.setPrice(6000);
 p4.setPlaceName("5 stars");
 p4.setServicesDes("video conferencing technology,simultaneous translation service,providing a logistics center,registration and documentation services");
 Packege p5=new Packege();
 p5.setId(5);
 p5.setServiceProviderName(s3.getUsername());
 p5.setLocation("Jerico");
 p5.setCapacity(130);
 p5.setPrice(7000);
 p5.setPlaceName("Rozana");
 p5.setServicesDes("video conferencing technology,simultaneous translation service,providing a logistics center,registration and documentation services,food and drinks,meet and greet service for participants");
 packeges.add(p1);
 packeges.add(p2);
 packeges.add(p3);
 packeges.add(p4);
 packeges.add(p5);
 Event e1=new Event();
 e1.setPackegeId(p1.getId());
 e1.setEventTitle("Event 1");
 e1.setUserName(u1.getUsername());
 e1.setServiceProviderName(p1.getServicesProviderName());
 e1.setLocation(p1.getLocation());
 e1.setNumOfInvitees(170);
 e1.setDate("10/12/2022");
 e1.setStartAt("1:00");
 e1.setEndAt("2:30");
 Event e2=new Event();
 e2.setPackegeId(p2.getId());
 e2.setEventTitle("Event 2");
 e2.setUserName(u2.getUsername());
 e2.setServiceProviderName(p2.getServicesProviderName());
 e2.setLocation(p2.getLocation());
 e2.setNumOfInvitees(300);
 e2.setDate("20/9/2023");
 e2.setStartAt("3:00");
 e2.setEndAt("5:00");
 Event e3=new Event();
 e3.setPackegeId(p3.getId());
 e3.setEventTitle("Event 3");
 e3.setUserName(u3.getUsername());
 e3.setServiceProviderName(p3.getServicesProviderName());
 e3.setLocation(p3.getLocation());
 e3.setNumOfInvitees(320);
 e3.setDate("9/8/2023");
 e3.setStartAt("12:00");
 e3.setEndAt("1:30");
 Event e4=new Event();
 e4.setPackegeId(p2.getId());
 e4.setEventTitle("Event 4");
 e4.setUserName(u2.getUsername());
 e4.setServiceProviderName(p2.getServicesProviderName());
 e4.setLocation(p2.getLocation());
 e4.setNumOfInvitees(250);
 e4.setDate("10/5/2024");
 e4.setStartAt("3:00");
 e4.setEndAt("5:00");
 Event e5=new Event();
 e5.setPackegeId(p1.getId());
 e5.setEventTitle("Event 4");
 e5.setUserName(u1.getUsername());
 e5.setServiceProviderName(p1.getServicesProviderName());
 e5.setLocation(p1.getLocation());
 e5.setNumOfInvitees(100);
 e5.setDate("1/4/2024");
 e5.setStartAt("4:00");
 e5.setEndAt("5:30");
 events.add(e1);
 events.add(e2);
 events.add(e3);
 events.add(e4);
 events.add(e5);
 Calender c1=new Calender();
 c1.setEventTitle(e1.getEventTitle());
 c1.setDate(e1.getDate());
 c1.setStartAt(e1.getStartAt());
 c1.setEndAt(e1.getEndAt());
 c1.setServiceProviderName(e1.getServiceProviderName());
 c1.setPackegeId(e1.getPackegeId());
 Calender c2=new Calender();
 c2.setEventTitle(e2.getEventTitle());
 c2.setDate(e2.getDate());
 c2.setStartAt(e2.getStartAt());
 c2.setEndAt(e2.getEndAt());
 c2.setPackegeId(e2.getPackegeId());
 c2.setServiceProviderName(e2.getServiceProviderName());
 Calender c3=new Calender();
 c3.setEventTitle(e3.getEventTitle());
 c3.setDate(e3.getDate());
 c3.setStartAt(e3.getStartAt());
 c3.setEndAt(e3.getEndAt());
 c3.setPackegeId(e3.getPackegeId());
 c3.setServiceProviderName(e3.getServiceProviderName());
Calender c4=new Calender();
c4.setEventTitle(e4.getEventTitle());
c4.setDate(e4.getDate());
c4.setStartAt(e4.getStartAt());
c4.setEndAt(e4.getEndAt());
c4.setPackegeId(e4.getPackegeId());
c4.setServiceProviderName(e4.getServiceProviderName());
Calender c5=new Calender();
c5.setEventTitle(e5.getEventTitle());
c5.setDate(e5.getDate());
c5.setStartAt(e5.getStartAt());
c5.setEndAt(e5.getEndAt());
c5.setPackegeId(e5.getPackegeId());
c5.setServiceProviderName(e5.getServiceProviderName());
calenders.add(c1);
calenders.add(c2);
calenders.add(c3);
calenders.add(c4);
calenders.add(c5);
    }
public Admin checkAdmin(String username,String password){

 for(Admin a: admins){
  if(a.getUsername().equals(username)&& a.getPassword().equals(password)){
   logger.info("The admin is found");
   a.setLogged(true);
   return a;
  }
 }
 logger.info("The admin is not found");
 return null;
}

public ServiceProvider checkServiceProvider(String username,String password){

 for(ServiceProvider s: servicesProviders){
  if(s.getUsername().equals(username)&& s.getPassword().equals(password)){
   logger.info("The Service Provider is found");
   s.setLogged(true);
   return s;
  }
 }
 logger.info("The Service Provider is not found");
 return null;
}
 public User checkUser(String username,String password){

  for(User u: users){
   if(u.getUsername().equals(username)&& u.getPassword().equals(password)){
    logger.info("The is found");
    u.setLogged(true);
    return u;
   }
  }
  logger.info("The User is not found");
  return null;
 }
 public static final void sendMessage(String message, String serviceProviderName) {
  Message s=new Message();
  s.setMessage(message);
  s.setServiceProviderName(serviceProviderName);
  messages.add(s);
 }
 public String registerUser(){
  Scanner scanner = new Scanner(System.in);
 User u=new User();
logger.info("Enter your name: ");
 String userName=scanner.next();
 u.setUsername(userName);
  logger.info("Enter your password: ");
  String password= scanner.next();
 u.setPassword(password);
  logger.info("Enter your email: ");
  String email= scanner.next();
 u.setEmail(email);
  logger.info("Enter your phone-number: ");
  String phoneNumber= scanner.next();
 u.setPhoneNum(phoneNumber);
 u.setLogged(true);
 return "The user is registerd Successfully";
 }


 public Packege getPackageById(int id) {
  for (Packege pkg : packeges) {
   if (pkg.getId() == id) {
    return pkg;
   }
  }
  return null;
 }

}


