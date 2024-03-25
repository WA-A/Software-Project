package org.example;

public class batool {
   private int id;
   private String name;
   private int b;
   batool() {
       id = 9;
       name=null;
       b=0;
   }
   public void setId(int id){
       this.id=id;
   }
    public void setId(String name){
        this.name=name;
    }
    public int getId(){
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    public int getB(){
       return this.b;
    }
}
