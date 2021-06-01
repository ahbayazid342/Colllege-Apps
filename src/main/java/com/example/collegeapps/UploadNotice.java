package com.example.collegeapps;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;

import java.io.IOException;

public class UploadNotice extends AppCompatActivity {

    CardView uploadPhoto;
    ImageView imgUpload;
    ImageView imgUploadCircle;
    Button btnUpload;
    EditText etTitle;

    private final int REQ = 1;
    Bitmap bitmap;

    //firebase database variable
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_notice);

        uploadPhoto = findViewById(R.id.cardUploadPhoto);
        imgUpload   = findViewById(R.id.imgUpload);
        imgUploadCircle = findViewById(R.id.imgUploadCircle);
        etTitle = findViewById(R.id.etTitle);
        btnUpload = findViewById(R.id.btnUpload);

        //photo upload from phone gallery
        uploadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        //click upload button
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etTitle.getText().toString().trim().isEmpty()){
                    etTitle.setError("Empty Title");
                    etTitle.requestFocus();
                } else if (bitmap == null){
                    uploadData();
                } else {
                    uploadImage();
                }
            }
        });
    }

    private void uploadData() {
    }

    private void uploadImage() {
    }



    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ && resultCode == RESULT_OK){
            Uri uri = data.getData();

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            imgUpload.setImageBitmap(bitmap);
            imgUploadCircle.setImageBitmap(bitmap);
        }
    }
}