package com.example.ajay.suicide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class SafetyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety);

        ArrayList<Detail> safe= new ArrayList<Detail>();
        safe.add(new Detail("Step #1: Promise not to do anything right now","Even though you’re in a lot of pain right now, give yourself some distance between thoughts and action. Make a promise to yourself: \"I will wait 24 hours and won't do anything drastic during that time.\" Or, wait a week.\n" +
                "\n" +
                "Thoughts and actions are two different things—your suicidal thoughts do not have to become a reality. There is no deadline, no one's pushing you to act on these thoughts immediately. Wait. Wait and put some distance between your suicidal thoughts and suicidal action."));
        safe.add(new Detail("Step #2: Avoid drugs and alcohol","Suicidal thoughts can become even stronger if you have taken drugs or alcohol. It is important to not use nonprescription drugs or alcohol when you feel hopeless or are thinking about suicide."));
        safe.add(new Detail("Step #3: Make your home safe","Remove things you could use to hurt yourself, such as pills, knives, razors, or firearms. If you are unable to do so, go to a place where you can feel safe. If you are thinking of taking an overdose, give your medicines to someone who can return them to you one day at a time as you need them."));
        safe.add(new Detail("Step #4: Don’t keep these suicidal feelings to yourself","Many of us have found that the first step to coping with suicidal thoughts and feelings is to share them with someone we trust. It may be a family member, friend, therapist, member of the clergy, teacher, family doctor, coach, or an experienced counselor at the end of a helpline. Find someone you trust and let them know how bad things are. Don’t let fear, shame, or embarrassment prevent you from seeking help. And if the first person you reach out to doesn’t seem to understand, try someone else. Just talking about how you got to this point in your life can release a lot of the pressure that’s building up and help you find a way to cope. "));
        safe.add(new Detail("Step #5: Take hope - people DO get through this","Even people who feel as badly as you are feeling now manage to survive these feelings. Take hope in this. There is a very good chance that you are going to live through these feelings, no matter how much self-loathing, hopelessness, or isolation you are currently experiencing. Just give yourself the time needed and don’t try to go it alone."));

        CustomAdapter adapter = new CustomAdapter(this , safe ) ;
        ListView listView = (ListView) findViewById(R.id.list_safety) ;
        listView.setAdapter(adapter);

        listView.setOnTouchListener(new ListView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                // Handle ListView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });
    }
}
