/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Titan.gui;

import Titan.model.Developpers;
import Titan.services.ServiceDeveloppers;
import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author Lenovo
 */
public class affectDevelopperToFeature extends Form {
    
    
     public affectDevelopperToFeature (int idf,Form previous)
     {
     
       setTitle("List of developpers");
       // Container InfoContainer = new Container();
       Container c1 = new Container();
       Container c2 = new Container();
        for (Developpers dev  : ServiceDeveloppers.getInstance().getAlldeveloppers() )
        {
            Container InfoContainer = new Container(BoxLayout.y());
            Label nom = new Label(dev.getFirstname());
           // Label description = new Label(String.valueOf(f.getId_user_respensability()));  
           
             Label prenom = new Label(dev.getLastname());
                 
                Button btnaffect = new Button("Affect this developper" );
            btnaffect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               
                    try {
                       // Task t = new Task(Integer.parseInt(tfStatus.getText()), tfName.getText());
                        if( ServiceDeveloppers.getInstance().affectDevelopper(idf,dev.getId() ))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    
                                }
                
                
            }
        });
            
            InfoContainer.add(nom);
            InfoContainer.add(prenom);
           
              InfoContainer.add(btnaffect);
          
        
       add(InfoContainer);
        }
         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
     
     }
    

