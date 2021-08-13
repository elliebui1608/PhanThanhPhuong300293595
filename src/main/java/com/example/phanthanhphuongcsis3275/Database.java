package com.example.phanthanhphuongcsis3275;

import java.sql.SQLException;
import java.util.List;

public interface Database {
    public  void add(Savingstable saving) throws SQLException, ClassNotFoundException;
    public  Savingstable edit(Savingstable saving, String custno) throws  SQLException, ClassNotFoundException;
    public  void delete(String custno) throws  SQLException;
    public List<Savingstable> display() throws ClassNotFoundException, SQLException;
}