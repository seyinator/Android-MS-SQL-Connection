package com.example.databases;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    Connection con = null;
    Button sendButton;
    SQLConnection sqlConnection = new SQLConnection();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = findViewById(R.id.sendButton);



        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ip = "YOUR IP", port = "1433", db = "YOUR DATABASE", username = "YOUR USERNAME", password = "YOUR PASSWORD";
                String connectURL = null;
                try {

                    connectURL = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";databasename=" + db + ";user=" + username + ";"+"password=" + password + ";";
                    Connection conn = DriverManager.getConnection(connectURL,"","");
                    Statement st = conn.createStatement();
                    st.executeUpdate("INSERT INTO Test " +
                            "VALUES ('Emir', 'Seyit')");
                    conn.close();
                } catch (Exception e) {
                    System.err.println("Got an exception! ");
                    System.err.println(e.getMessage());
                }

            }
        });

    }


}
