package com.baitulmalfkam.baitulmalfkam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProgramActivity extends AppCompatActivity {
    ImageView main_program;
    TextView textview_program;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);

        main_program = findViewById(R.id.main_program);
        textview_program = findViewById(R.id.textview_program);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            textview_program.setText(extras.getString("info"));
        }
    }
}
