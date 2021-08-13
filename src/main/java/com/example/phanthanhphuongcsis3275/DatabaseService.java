package com.example.phanthanhphuongcsis3275;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService implements Database {
    Connection con;
    public DatabaseService(Connection con) {
        this.con = con;
    }

    @Override
    public void add(Savingstable saving) throws SQLException, ClassNotFoundException {
        String quer1 = "INSERT INTO savingstable VALUES ( ?, ?, ?, ?, ?, ?)";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, saving.getCustno());
        query.setString(2, saving.getCustname());
        query.setDouble(3, saving.getCdep());
        query.setInt(4,saving.getNyears());
        query.setString(5, saving.getSavtype());
        query.executeUpdate();
    }

    @Override
    public Savingstable edit(Savingstable saving, String custno) throws SQLException, ClassNotFoundException {
        PreparedStatement query;
        query = con.prepareStatement("Update savingstable set custno=?, custname=?,cdep =?, nyears = ?,savtype = ? where custno = ?");
        query.setString(1, saving.getCustno());
        query.setString(2, saving.getCustname());
        query.setDouble(3, saving.getCdep());
        query.setInt(4,saving.getNyears());
        query.setString(5, saving.getSavtype());
        query.executeUpdate();
        return saving;
    }

    @Override
    public void delete(String custno) throws SQLException {
        String quer1 = "Delete from Savingstable where custno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, custno);
        query.executeUpdate();
    }

    @Override
    public List<Savingstable> display() throws ClassNotFoundException, SQLException {
        //create an array list that will contain the data recovered
        List<Savingstable> Savingslist = new ArrayList<Savingstable>();
        String quer1 = "Select * from savingstable";
        PreparedStatement query = con.prepareStatement(quer1);
        ResultSet rs = query.executeQuery();
        Savingstable obj1;
        //display records if there is data;
        while (rs.next()) {
            obj1 = new Savingstable(rs.getString("custno"), rs.getString("custname"), rs.getDouble("cdep"), rs.getInt("nyears"),rs.getString("savtype"));
            Savingslist.add(obj1);
        }
        return Savingslist;
    }
    public Savingstable search(String custno) throws SQLException,ClassNotFoundException {
        String quer1 = "Select * from savingstable where custno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, custno);
        ResultSet rs = query.executeQuery();
        if(!rs.first()){
            System.out.print("Record not existing");
            return null;
        }
        Savingstable obj1=null;
        obj1 = new Savingstable(rs.getString("custno"), rs.getString("custname"), rs.getDouble("cdep"), rs.getInt("nyears"),rs.getString("savtype"));        return obj1;
    }
}

