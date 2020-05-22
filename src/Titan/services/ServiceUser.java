/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Titan.services;

import Titan.Statics;
import Titan.model.User;
import Titan.model.login;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class ServiceUser {
      public ArrayList<User> pro;
     public User US ;
     public ServiceUser SU;
    
     public static ServiceUser instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    
    
     private ServiceUser() {
         req = new ConnectionRequest();
    }

    public static ServiceUser getInstance() {
        if (instance == null) {
            instance = new ServiceUser();
        }
        return instance;
    }
    
    
    
    
    
    
       public ArrayList<User> parseUser(String jsonText){
        try {
            //tasks=new ArrayList<>();
            pro=new ArrayList<>();
            
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            System.out.println("id: "+tasksListJson.get("id")); 
            System.out.println("nom: "+tasksListJson.get("firstname"));
           System.out.println("prenom: "+tasksListJson.get("lastname")); 
            System.out.println("role: "+tasksListJson.get("role"));
           
          //  String x=  tasksListJson.get("todo").toString();
            User US = new User();
           
            
            
             float id = Float.parseFloat(tasksListJson.get("id").toString());
            US.setId((int)id);
            
         //  US.setFirstname(tasksListJson.get("firstname").toString());
            
           //   US.setLastname(tasksListJson.get("lastname").toString());
            
         
              US.setRole(tasksListJson.get("role").toString());
            
         //   Map<String,Object> list = ( Map<String,Object>)tasksListJson.get("root");
           // for(Map<String,Object> obj : list){
              //  Task t = new Task();
            //  System.out.println("lissst:"+list );
         
                     
               
                pro.add(US);
          //  }
            
            
        } catch (IOException ex) {
            
        }
        return pro ;
    }
    
    
    
    
    
    
    
     public User Login(login l) {
         
         //String ss="Aanis";
          //String sss="0000";
        String url = Statics.BASE_URL +"loginMobilee/" + l.getUsername() + "/" + l.getPassword();
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                if   ( req.getResponseCode() == 200 ) //Code HTTP 200 OK
                { //req.removeResponseListener(this);
                
                  pro = parseUser(new String(req.getResponseData()));
                  
                   US = pro.get(0);
                  
                req.removeResponseListener(this);
                }
              
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return US;
    }
    
    
     
     
     
     public User current() {
         
         //String ss="Aanis";
          //String sss="0000";
        String url = Statics.BASE_URL +"currentuser";
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                if   ( req.getResponseCode() == 200 ) //Code HTTP 200 OK
                { //req.removeResponseListener(this);
                
                  pro = parseUser(new String(req.getResponseData()));
                  
                   US = pro.get(0);
                  
                req.removeResponseListener(this);
                }
              
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return US;
    }
     
     
     
    
}
