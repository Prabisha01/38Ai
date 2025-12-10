/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sectiona_ai;

import controller.UserController;
import database.Database;
import database.MySqlConnection;
import view.Signup;

/**
 *
 * @author User
 */
public class SectionA_AI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Database db = new MySqlConnection();
//        if(db.openConnection() !=null){
//            System.out.println("Connection opened");
//        }else{
//            System.out.println("Connection closed");
//        }
       Signup  signup = new Signup();
       UserController usercontroller = new UserController(signup);
       usercontroller.open();
     }
    
}
