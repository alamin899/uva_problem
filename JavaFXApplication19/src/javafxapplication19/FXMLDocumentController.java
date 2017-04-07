/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication19;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
    private ListView<String> listfield;
    private ObservableList<String>list;
    @FXML
    private TextField updatedonefield;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      list=FXCollections.observableArrayList();
      listfield.setItems(list);
    }    

    @FXML
    private void handleaddAction(ActionEvent event) {
        String name=namefield.getText();
        long id=Long.parseLong(idfield.getText());
        
        try{
            Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1/property","root","140186");
            Statement statement=connection.createStatement();
            String i=(name+" = "+id);
            String query="insert into nameid values('"+ name +"','"+ id +"')";
            //list.add(name);
            list.add(i);
            
            System.out.println(query);
            statement.executeUpdate(query);
            updatedonefield.setText("Update Complete");
            //updatedonefield.clear();
            namefield.clear();
            idfield.clear();
            
        }catch(SQLException sqle)
        {
            System.err.println("can not connect database");
        }
    }
    
}
