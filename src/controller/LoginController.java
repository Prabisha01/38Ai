
package controller;
import dao.loginDao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.UserData;
import view.login;

public class LoginController {
    private final loginDao logindao = new loginDao();
    private final login loginView;
    
    public LoginController(login loginView){
        this.loginView = loginView;
        
        loginView.AddLoginListner(new LoginListner());
    }
    public void open(){
        this.loginView.setVisible(true);
    }
    public void close(){
        this.loginView.dispose();
    }

  class LoginListner implements ActionListener {
@Override
       public void actionPerformed(ActionEvent e) {
            try{
                String username = loginView.getUsernameText().getText();
                String password = loginView.getPasswordText().getText();
                UserData userdata = new UserData(username, password);
                boolean check = logindao.login(userdata);
                if(check){
                    JOptionPane.showMessageDialog(loginView, "Successful");
                }else{
                    JOptionPane.showMessageDialog(loginView, "Not successful");
                    
                }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

   
    
}

