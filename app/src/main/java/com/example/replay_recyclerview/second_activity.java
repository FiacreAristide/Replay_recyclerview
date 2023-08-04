package com.example.replay_recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class second_activity extends AppCompatActivity {
    private  ImageView imageView;
    private TextView text_title,text_sbt;
    private ImageButton backBtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        String title = getIntent().getStringExtra("title");
        String subtitle = getIntent().getStringExtra("subtitle");
        int picture = getIntent().getIntExtra("picture",0);

         imageView = findViewById(R.id.sec_image);
         text_title = findViewById(R.id.sec_title);
         text_sbt = findViewById(R.id.sec_subtitle);

         text_title.setText(title);
         text_sbt.setText(subtitle);
         imageView.setImageResource(picture);
    }
}