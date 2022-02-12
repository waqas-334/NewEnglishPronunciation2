package com.androidbull.mypronounce.DailyLessons.ui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;

import com.androidbull.mypronounce.DailyLessons.Adapter.MainActAdapter;
import com.androidbull.mypronounce.DailyLessons.model.lesson;
import com.androidbull.mypronounce.DailyLessons.util.AppConstants;
import com.androidbull.mypronounce.DailyLessons.util.preferenceManager;
import com.androidbull.mypronounce.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class LessonActivity extends AppCompatActivity {

    String TAG = getClass().getSimpleName();
    DatabaseReference reference;
    ArrayList<lesson> arrayList;
    RecyclerView recView;
    MainActAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        AppConstants.NOTIFICATION_COUNT = 0;
        recView = findViewById(R.id.recView);
        recView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Log.i(TAG, "limit = " + preferenceManager.getInstance(getApplicationContext()).getLessonLimit());

        reference = FirebaseDatabase.getInstance().getReference().child(AppConstants.FIREBASE_DATABASE_ROOT);
        reference = reference.child(AppConstants.LESSONS_TABLE);
        arrayList = new ArrayList<>();
        int limit = (preferenceManager.getInstance(getApplicationContext()).getLessonLimit() == 0) ? 1 : preferenceManager.getInstance(getApplicationContext()).getLessonLimit();

        adapter = new MainActAdapter(arrayList);
        recView.setAdapter(adapter);

        reference.orderByChild("lesson").limitToFirst(limit).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.e(TAG, dataSnapshot + " :: ");
                lesson model = dataSnapshot.getValue(lesson.class);
                if (model != null) {
                    arrayList.add(model);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
