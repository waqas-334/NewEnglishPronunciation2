package com.androidbull.mypronounce.DailyLessons.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


import com.androidbull.mypronounce.R;
import com.bumptech.glide.Glide;

public class DetailedActivity extends AppCompatActivity {

    ImageView image;
    TextView title, subtitle, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        image = findViewById(R.id.image);
        subtitle = findViewById(R.id.subtitle);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        Bundle unPacker = getIntent().getExtras();

        description.setText(unPacker.getString("description"));
        title.setText(unPacker.getString("title"));
        subtitle.setText(unPacker.getString("subtitle"));
        Glide.with(image).load(unPacker.getString("image_url")).placeholder(R.drawable.placeholder).into(image);

//        Picasso.get().load(unPacker.getString("image_url")).placeholder(R.drawable.placeholder).into(image);

    }
}
