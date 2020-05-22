/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Titan.gui;

import Titan.entities.Feature;
import Titan.entities.UserStory;
import Titan.services.ServiceFeature;
import Titan.services.ServiceUser;
import Titan.services.ServiceUserStory;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author Lenovo
 */
public class afficheUserStory extends Form {
    
    public afficheUserStory (int idf,Form previous) {
        
        ServiceUser.getInstance().current();
        setTitle("List User Story");
        setLayout(BoxLayout.y());
       // Container InfoContainer = new Container();
      // Container c1 = new Container();
       //Container c2 = new Container();
        for (UserStory us  : ServiceUserStory.getInstance().getAllUserStory(idf)) 
        {
            Container InfoContainer = new Container(BoxLayout.y());
            Container InfoContainerr = new Container(BoxLayout.x());
               Container c1 = new Container(BoxLayout.x());
               Container c2 = new Container(BoxLayout.x());
               Container c3 = new Container(BoxLayout.x());
               Container c4 = new Container(BoxLayout.x());
               Container c5 = new Container(BoxLayout.x());
            
            
            
            Label iddus = new Label(String.valueOf(us.getId_user_story())); 
            
             
           
            
            
            
            
            
            Label nom = new Label(us.getUser_story_description());
            
            
             Label UserStoryDescription = new Label();
              UserStoryDescription.setText("User Story Description:");
            
            c1.add(UserStoryDescription);
             c1.add(nom);
            
            
            
            
            Label estimdays = new Label(String.valueOf(us.getTotal_estimation_userstory_jours()));  
            
             
             Label desestimations = new Label();
              desestimations.setText("User Story Days Estimation:");
            
            c2.add(desestimations);
             c2.add(estimdays);
            
            
            
            
            //Label prority = new Label(String.valueOf(us.getPriority()));  
            
                   Label prio = new Label();
                    Label p = new Label();
              prio.setText("User Story Priority:");
            
              if (us.getPriority()==1)
              {
                  p.setText("Low");
              }
              
               if (us.getPriority()==2)
              {
                  p.setText("Meduim");
              }
                if (us.getPriority()==3)
              {
                  p.setText("High");
              }
              
            c3.add(prio);
             c3.add(p);
            
            
            
            
            
            
            
            
            Label doo = new Label(String.valueOf(us.getDoing()));  
            
            
            
                   Label doing = new Label();
              doing.setText("User Sroy progress:");
            
            c4.add(doing);
             c4.add(doo);
            
            
            
            
            
            Button btnUpdateUserStory = new Button("Update Progress User Story");
            
            
            btnUpdateUserStory.addActionListener(e-> new UpdateProgress(us.getId_user_story(),previous).show());
            
            InfoContainer.add(iddus);
            InfoContainer.add(c1);
            InfoContainer.add(c2);
            InfoContainer.add(c3);
            InfoContainer.add(c4);
            InfoContainerr.add(btnUpdateUserStory);
             InfoContainer.add(InfoContainerr);

       
        
       add(InfoContainer);
        }
         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }

    
}
