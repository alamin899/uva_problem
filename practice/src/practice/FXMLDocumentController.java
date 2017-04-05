/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author alamin
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField namefield;
    @FXML
    private TextField idfield;
    @FXML
    private TextField batchfield;
    @FXML
    private TextField yearfield;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       System.out.println("alamin899");
    }    

    @FXML
    private void handleaddAction(ActionEvent event) {
        String name= namefield.getText();
        double id=Double.parseDouble(idfield.getText());
        int batch=Integer.parseInt(batchfield.getText());
        int year=Integer.parseInt(yearfield.getText());
        try{
             Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1/property","root","140186");
            Statement statement=connection.createStatement();
            String query="insert into practice values('"+ name +"','"+ id+ "','"+ batch +"','"+ year +"')";
            System.out.println(query);
            statement.executeUpdate(query);
            namefield.clear();
            idfield.clear();
            batchfield.clear();
            yearfield.clear();
             
            
        }catch(SQLException sqle){
            System.err.println("database not connected");
        }
    }

    @FXML
    private void handledeleteAction(ActionEvent event) {
        String name= namefield.getText();
        double id=Double.parseDouble(idfield.getText());
        int batch=Integer.parseInt(batchfield.getText());
        int year=Integer.parseInt(yearfield.getText());
        try{
             Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1/property","root","140186");
            Statement statement=connection.createStatement();
            String query="delete from practice where id="+ id + "";
            System.out.println(query);
            statement.executeUpdate(query);
            namefield.clear();
            idfield.clear();
           batchfield.clear();
            yearfield.clear();
             
            
            
        }catch(SQLException sqle){
            System.err.println("database not connected");
        }
    }
        
    @FXML
    private void handlesearchAction(ActionEvent event) {
    }
    
    }


    


