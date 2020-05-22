/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Titan.gui;

import Titan.entities.product_backlog;
import Titan.model.User;
import Titan.services.ServiceUser;
import Titan.services.productBacklogService;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import static javafx.css.StyleOrigin.USER;

/**
 *
 * @author Lenovo
 */
public class afficheProductBaclkog extends Form {
    
    public afficheProductBaclkog(Form previous ) {
        setUIID("Form");
        int x=1;
        setTitle("Product Backlog");
       // Container InfoContainer = new Container();
        for (product_backlog pb  : productBacklogService.getInstance().getAllProductBacklog()) 
        {
            Container InfoContainer = new Container(BoxLayout.y());
            Container InfoContainerr = new Container(BoxLayout.x());
            Container c1 = new Container(BoxLayout.x());
           
            
            
            Label productname = new Label();
              Label nom = new Label(pb.getProductBacklog());
             productname.setText("Product Backlog :");
             nom.setUIID("Label");
            c1.add(productname);
            
            c1.add(nom);
            
           // Label description = new Label(String.valueOf(pb.getIdBacklog())); 
        //  BorderLayout bor =new BorderLayout().
            Button btnAddTask = new Button("Add Theme");
             btnAddTask.addActionListener(e-> new addTheme(pb.getIdBacklog(),previous).show());
             Button btnReadTheme = new Button("Read Theme");
             btnReadTheme.addActionListener(e-> new afficheTheme(pb.getIdBacklog(),previous).show());
             
             btnReadTheme.setIcon(FontImage.createMaterial(FontImage.MATERIAL_OPEN_IN_NEW, btnReadTheme.getUnselectedStyle()));
             
             InfoContainer.add(c1);
             InfoContainer.add(btnReadTheme);
           // InfoContainer.add(description);
           
            if (ServiceUser.getInstance().current().getRole().equals("ROLE_MASTER")){
                //ServiceUser.getInstance().current();
          //  InfoContainerr.add(btnAddTask);
            InfoContainerr.add(btnAddTask);
            
            }
            
            InfoContainer.add(InfoContainerr);

            
            
     
        
        
       add(InfoContainer);
        }
         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
     
}
