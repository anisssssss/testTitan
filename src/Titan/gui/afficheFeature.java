/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Titan.gui;

import Titan.entities.Feature;
import Titan.entities.Theme;
import Titan.model.Developpers;
import Titan.services.ServiceDeveloppers;
import Titan.services.ServiceFeature;
import Titan.services.ServiceTheme;
import static com.codename1.charts.util.ColorUtil.green;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author Lenovo
 */
public class afficheFeature extends Form {
    
    
    public afficheFeature (int idt,Form previous) {
        
        setTitle("List Feature");
        setLayout(BoxLayout.y());
      
        for (Feature f  : ServiceFeature.getInstance().getAllFeature(idt)) 
        {
            Container InfoContainer = new Container(BoxLayout.y());
            Container InfoContainerr = new Container(BoxLayout.x());
               Container c1 = new Container(BoxLayout.x());
               Container c2 = new Container(BoxLayout.x());
               Container c3 = new Container(BoxLayout.x());
               Container c4 = new Container(BoxLayout.x());
               //Container c2 = new Container(BoxLayout.x());
               //Container c3 = new Container(BoxLayout.x());
             //  Container c4 = new Container(BoxLayout.x());
            
            
            
            Label nomf = new Label(f.getNom_feature());
             Label featurename = new Label("Feature name:","reddd");
            //  featurename.setText("Feature name:");
            
            c1.add(featurename);
             c1.add(nomf);
             
             
            Label total = new Label(String.valueOf(f.getTotal_estimation_feature_jours())); 
            
             Label tataldays = new Label("Total days estimation:","red");
            //  tataldays.setText("Total days estimation:");
            
                 c2.add(tataldays);
             c2.add(total);
             
             
               Label statue = new Label(); 
                        
              Label Statuee = new Label();
              Statuee.setText("Feature Statue:");
            
              
              if (f.getStatue()==0)
              {statue.setText("No Start yet");}
              
               if (f.getStatue()==1)
              {statue.setText("In progressive");
              }
               
                if (f.getStatue()==0)
              {statue.setText("Finish");
              
              }
              
            c3.add(Statuee);
            c3.add(statue);
            
            
            
            
            // InfoContainer.add(c2);
            if  (f.getId_user_respensability()!=0){
            Developpers dev=   ServiceDeveloppers.getInstance().finduser(f.getId_user_respensability());
            Label FirstNameDev = new Label(dev.getFirstname());
            Label LastNameDev = new Label(dev.getLastname());
            
             Label useres = new Label();
              useres.setText("User Respensible:");
             c4.add(useres);
                c4.add(FirstNameDev);
                c4.add(LastNameDev);
            //c2.add(LastNameDev);
             }
            
            
            
             
        /*     
             
          
              Label devrespensabllity = new Label();
              devrespensabllity.setText("User respensability:");
        
              
                
            c2.add(devrespensabllity);
             //c2.add(iduser);
            
          
           
            Label total = new Label(String.valueOf(f.getTotal_estimation_feature_jours())); 
            
             Label tataldays = new Label();
              tataldays.setText("Total days estimation:");
            
                 c3.add(tataldays);
             c3.add(total);
            
             
             
             
            Label statue = new Label(String.valueOf(f.getStatue())); 
            
            
              Label Statuee = new Label();
              Statuee.setText("Feature Statue:");
            
            c4.add(Statuee);
            c4.add(statue);
              
          */    
              
            
            Button btnReadUserStory = new Button("Read Users");
            btnReadUserStory.addActionListener(e-> new afficheUserStory(f.getId_feature(),previous).show());
            
             btnReadUserStory.setIcon(FontImage.createMaterial(FontImage.MATERIAL_OPEN_IN_BROWSER, btnReadUserStory.getUnselectedStyle()));
            
              Button btnAddUserStory = new Button("Add User" );
            btnAddUserStory.addActionListener(e-> new addUserStory(f.getId_feature(),previous).show());
            btnAddUserStory.setIcon(FontImage.createMaterial(FontImage.MATERIAL_ADD, btnAddUserStory.getUnselectedStyle()));
            
            
            
             Button btnprogress = new Button();
            btnprogress.addActionListener(e-> new progress(f.getId_feature(),previous).show());
            btnprogress.setIcon(FontImage.createMaterial(FontImage.MATERIAL_PIE_CHART, btnprogress.getUnselectedStyle()));
            
            
            
                Button btnaffect = new Button("Affect" );
            btnaffect.addActionListener(e-> new affectDevelopperToFeature(f.getId_feature(),previous).show());
             btnaffect.setIcon(FontImage.createMaterial(FontImage.MATERIAL_PLUS_ONE, btnaffect.getUnselectedStyle()));
            
            
            
            
            InfoContainer.add(c1);
            InfoContainer.add(c2);
            InfoContainer.add(c3);
            InfoContainer.add(c4);
          //  InfoContainer.add(c2);
       /*      if  (f.getId_user_respensability()!=0){
            Developpers dev=   ServiceDeveloppers.getInstance().finduser(f.getId_user_respensability());
            Label FirstNameDev = new Label(dev.getFirstname());
            Label LastNameDev = new Label(dev.getLastname());
                c2.add(FirstNameDev);
            c2.add(LastNameDev);
             }
          */ 
          
                 //    c3.add(Statuee);
              //       c3.add(statue);
              
        //    InfoContainer.add(c3);
            
            
            
          //  InfoContainer.add(c4);
        
         
          
          
          InfoContainerr.add(btnReadUserStory);
            InfoContainerr.add(btnAddUserStory);
             InfoContainerr.add(btnprogress);
              InfoContainerr.add(btnaffect);
       
              
              
              
        InfoContainer.add(InfoContainerr);
       
        
        

    
        
        
       add(InfoContainer);
        }
         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
    
}
