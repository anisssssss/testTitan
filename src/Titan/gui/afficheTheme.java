/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Titan.gui;

import Titan.entities.Theme;
import Titan.entities.product_backlog;
import Titan.services.ServiceTheme;
import Titan.services.productBacklogService;
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
public class afficheTheme extends Form {
    
   
     public afficheTheme (int idpb,Form previous) {
         setLayout(BoxLayout.y());
        setTitle("List Themes");
   
        for (Theme t  : ServiceTheme.getInstance().getAllTheme(idpb)) 
        {
            Container InfoContainer = new Container(BoxLayout.y());
            Container InfoContainerr = new Container(BoxLayout.x());
             Container c1 = new Container(BoxLayout.x());
            Container c2 = new Container(BoxLayout.x());
            Label name = new Label();
              Label nom = new Label(t.getNom_theme());
             name.setText("Theme Name :");
             
             
             
              Label est = new Label();
            Label description = new Label(String.valueOf(t.getTotal_estimation_theme_jours()));   
            est.setText("Theme Days :");
            
            Button btnReadFeature = new Button("Read  Feature");
            btnReadFeature.addActionListener(e-> new afficheFeature(t.getId_theme(),previous).show());
            
             btnReadFeature.setIcon(FontImage.createMaterial(FontImage.MATERIAL_ZOOM_IN, btnReadFeature.getUnselectedStyle()));
            
            
              Button btnAddFeature = new Button("Add  Feature");
            btnAddFeature.addActionListener(e-> new addFeauture(t.getId_theme(),previous).show());
             btnAddFeature.setIcon(FontImage.createMaterial(FontImage.MATERIAL_ADD, btnAddFeature.getUnselectedStyle()));
            c1.add(name);
             c1.add(nom);
            c2.add(est);
             c2.add(description);
             InfoContainer.add(c1);
            InfoContainer.add(c2);
            InfoContainerr.add(btnReadFeature);
            InfoContainerr.add(btnAddFeature);
 InfoContainer.add(InfoContainerr);
           // c1.add(pb.getProductBacklog());
        
        //    c2.add(pb.getIdBacklog());
        
        

        
       // SpanLabel sp = new SpanLabel();
        //sp.setText(productBacklogService.getInstance().getAllProductBacklog().toString());
        
        
       add(InfoContainer);
        }
         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
    
}
