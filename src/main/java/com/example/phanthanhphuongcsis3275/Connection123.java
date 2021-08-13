package com.example.phanthanhphuongcsis3275;

import org.springframework.stereotype.Service;

import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class Connection123 {
    public java.sql.Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/savings", "root", "");
        if(con1 != null){
            System.out.print("connect success DB");
        }
        return con1;

    }

}