package com.example.databases;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.sql.DataSource;

public class SQLConnection {

    Connection con;


    @SuppressLint("NewApi")
    public Connection conclass() {
        String ip = "178.238.123.78", port = "1433", db = "EMIR_DB", username = "sa", password = "Tar:01012017";
        StrictMode.ThreadPolicy a = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(a);
        String connectURL = null;

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connectURL = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";databasename=" + db + ";user=" + username + ";"+"password=" + password + ";";
            con = DriverManager.getConnection(connectURL);
        } catch (Exception e) {
            Log.e("Error :", e.getMessage());
        }
        return con;
    }

    public void insert(){


    }

}
