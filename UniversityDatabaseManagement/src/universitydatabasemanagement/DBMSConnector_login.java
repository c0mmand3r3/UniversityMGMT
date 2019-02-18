/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydatabasemanagement;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Mathew_Anish
 */
public class DBMSConnector_login {
    public static Connection connect_Database(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1", "root","");
            System.out.println("Database Connected");
                try {               
                    Statement st=con.createStatement();
                    st.executeUpdate("create database university");
                
            } catch (SQLException ex) {
                System.out.println("Database Already Created");
            }
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/university", "root","");
            return con;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.exit(0);
            return null;
        }
    }
}
