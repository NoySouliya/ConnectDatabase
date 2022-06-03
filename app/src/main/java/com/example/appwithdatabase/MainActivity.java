package com.example.appwithdatabase;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ConnectDatabase db;
EditText txtName, txtSurname, txtPhone, txtEmail;
Button btnSubmit, btnCancel, btnEdit, btnShow, btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new ConnectDatabase(this);

        txtName = findViewById(R.id.txtName);
        txtSurname = findViewById(R.id.txtSurname);
        txtPhone = findViewById(R.id.txtPhone);
        txtEmail = findViewById(R.id.txtEmail);

        btnSubmit = findViewById(R.id.btnSub);
        btnCancel = findViewById(R.id.btnCancel);
        btnEdit = findViewById(R.id.btnEdit);
        btnShow = findViewById(R.id.btnShow);
        btnList = findViewById(R.id.btnList);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, surname, phone, email;
                name = txtName.getText().toString();
                surname = txtSurname.getText().toString();
                phone = txtPhone.getText().toString();
                email = txtEmail.getText().toString();
                boolean insert = db.insertData(name, surname, phone , email);
                if(insert == true){
                    Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Data can not insert", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtName.setText("");
                txtSurname.setText("");
                txtPhone.setText("");
                txtEmail.setText("");
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EditData.class);
                startActivity(intent);
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), listview_data.class);
                startActivity(intent);
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor result = db.getAllData();
                if(result.getCount()==0){
                    showAllMessage("Error", "Nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (result.moveToNext()){
                    buffer.append("Id: "+result.getString(0) + "\n");
                    buffer.append("Name: "+result.getString(1) + "\n");
                    buffer.append("Surname: "+result.getString(2) + "\n");
                    buffer.append("Phone: "+result.getString(3) + "\n");
                    buffer.append("Email: "+result.getString(4) + "\n");
                }
                showAllMessage("Data", buffer.toString());
            }
        });
    }

    private void showAllMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}