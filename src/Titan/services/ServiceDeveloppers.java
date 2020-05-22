/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Titan.services;

import Titan.Statics;
import Titan.model.Developpers;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


//import java.util.stream;

/**
 *
 * @author Lenovo
 */
public class ServiceDeveloppers {
    
    
     public ArrayList<Developpers> devs;
    public ArrayList<Developpers> devvs;
     public static ServiceDeveloppers instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    
    
     private ServiceDeveloppers() {
         req = new ConnectionRequest();
    }

    public static ServiceDeveloppers getInstance() {
        if (instance == null) {
            instance = new ServiceDeveloppers();
        }
        return instance;
    }
    
    
    
    
     public ArrayList<Developpers> parseDeveloppers(String jsonText){
       
        
        
        try {
            //tasks=new ArrayList<>();
            devs=new ArrayList<>();
         
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
          //  Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
              //  Task t = new Task();
                 Developpers dev = new Developpers();
                
                float id = Float.parseFloat(obj.get("id").toString());
                dev.setId((int)id);
                                
                dev.setFirstname(obj.get("firstname").toString());
                dev.setLastname(obj.get("lastname").toString());
                
                devs.add(dev);
            }
            
             
            
            // Developpers dev = devvs.stream().filter(Developpers -> Developpers.getId()==1).findAny().orElse(null);
            
        } catch (IOException ex) {
            
        }
        return devs;
    }
    
    
     
     
      public ArrayList<Developpers> getAlldeveloppers(){
     //   String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+"developper";
        
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                devs = parseDeveloppers(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return devs;
    }
    
  
      
      
      
       public Developpers finduser(int id ) {
 ArrayList<Developpers> users=ServiceDeveloppers.getInstance().getAlldeveloppers();
    for (Developpers customer : users) {
        if (customer.getId()==id) {
            return customer;
        }
    }
    return null;
}
      
      
      
      
      
      /*
        public Developpers getdeveloppers(int id){
           // int id=1;
     //   String url = Statics.BASE_URL+"/tasks/";
     devvs = parseDeveloppers(new String(req.getResponseData()));
    // ArrayList resultObjects = ...;
        List<Object> results = devvs.Cast<Object>().ToList();
     
      devvs = parseDeveloppers(new String(req.getResponseData()));
    // List<Developpers> list = new ArrayList<Developpers>(devvs.asList());
      
     Developpers dev = devvs.stream().filter(Developpers -> 1==Developpers.getId()).findAny().orElse(null);
     
        
        return dev;
    }
      
      */
      
      
      
      
      
      public boolean affectDevelopper(int idf , int id) {
      //   int idf=43;
        // int id=1;
          String url = Statics.BASE_URL + "affectUserr/" + id + "/" + idf;
      //  String url = Statics.BASE_URL + "affectUserr/"+ idf + "/" + id ;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

      
      
      
    
}
