package com.example.collegeapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminActivity extends AppCompatActivity implements View.OnClickListener {

    CardView cardNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        cardNotice = findViewById(R.id.cardNotice);
        cardNotice.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.cardNotice:
                Intent intent = new Intent(AdminActivity.this, UploadNotice.class);
                startActivity(intent);
                break;
        }
    }
}