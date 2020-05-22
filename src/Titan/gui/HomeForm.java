/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Titan.gui;

import Titan.model.User;
import Titan.model.login;
import Titan.services.ServiceUser;
import com.codename1.components.ImageViewer;
import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import static com.codename1.ui.CN.*;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;



/**
 *
 * @author Lenovo
 */
public class HomeForm extends Form {

    Form current;
    public User userr;
    public HomeForm(Resources theme) {
         super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("LoginForm");
      /*  Container welcome = FlowLayout.encloseCenter(
            new Label("Sign In | ", "WelcomeWhite"),
                new Label("TITAN", "WelcomeBlue")
       );
      */  
        getTitleArea().setUIID("Container");

        TextField login = new TextField(null, "Enter your username ! Exp: Admin_Admin", 20, TextField.ANY) ;
        TextField password = new TextField(null, "Enter tour password", 20, TextField.PASSWORD) ;
        Label passwordIcon = new Label("", "TextField");
        login.getAllStyles().setMargin(LEFT, 0);
        password.getAllStyles().setMargin(LEFT, 0);
        Label loginIcon = new Label("", "TextField");
        loginIcon.getAllStyles().setMargin(RIGHT, 0);
        passwordIcon.getAllStyles().setMargin(RIGHT, 0);
        FontImage.setMaterialIcon(loginIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(passwordIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        
        Button loginButton = new Button("LOGIN");
        loginButton.setUIID("LoginButton");
         loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((login.getText().length() == 0)) {
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                } else {
                    try {
                        login l = new login(login.getText(), password.getText());
                        userr = ServiceUser.getInstance().Login(l);
                        if (userr != null) {
                            Dialog.show("Success", "Connection accepted", new Command("OK"));
                          
                               //ServiceUser.getInstance().current();
                            
                            
                            new afficheProductBaclkog(current).show();
                            
                        } else {
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                        }
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }

                }

            }
        });
        
        Button createNewAccount = new Button("CREATE NEW ACCOUNT");
        createNewAccount.setUIID("CreateNewAccountButton");
        
        createNewAccount.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent evt) {
                // new Register(current, res).show();

             }
         });
        // We remove the extra space for low resolution devices so things fit better
        Label spaceLabel;
        if(!Display.getInstance().isTablet() && Display.getInstance().getDeviceDensity() < Display.DENSITY_VERY_HIGH) {
            spaceLabel = new Label();
        } else {
            spaceLabel = new Label(" ");
        }
        
                Container logoC = BoxLayout.encloseY(
             new ImageViewer(theme.getImage("blancTitan.png").scaled(500, 100))

               
        );
        add(BorderLayout.OVERLAY, logoC);
        Container by = BoxLayout.encloseY(
              //  welcome,
                
                spaceLabel,
                BorderLayout.center(login).
                        add(BorderLayout.WEST, loginIcon),
                BorderLayout.center(password).
                        add(BorderLayout.WEST, passwordIcon),
                loginButton,
                createNewAccount
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
}
