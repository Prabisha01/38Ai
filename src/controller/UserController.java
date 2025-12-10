/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.userDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.UserData;
import view.Signup;
import view.login;

/**
 *
 * @author User
 */
public class UserController {
    private final userDao userdao = new userDao();
    private final Signup userView;
    
    public UserController(Signup userView){
        this.userView = userView;
        
        userView.AddAddUserListener(new AddActionListner());
    }
    public void open(){
        this.userView.setVisible(true);
    }
    public void close(){
        this.userView.dispose();
    }

    class AddActionListner implements ActionListener {
@Override
        public void actionPerformed(ActionEvent e) {
            try{
                String username = userView.getUsername().getText();
                String email = userView.getEmailField().getText();
                String password = userView.getPassword().getText();
                UserData userdata = new UserData(username, email, password);
                boolean check = userdao.check(userdata);
                if(check){
                    JOptionPane.showMessageDialog(userView, "Duplicated user");
                }else{
                    userdao.signUp(userdata);
                     JOptionPane.showMessageDialog(userView, "Successfull");
                     login lc = new login();
                      LoginController log = new LoginController(lc);
                      close();
                      log.open();
                }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
