package com.example.ajay.suicide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class WarningSignsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning_signs);



        ArrayList<Detail> warn = new ArrayList<Detail>() ;

        warn.add(new Detail("Excessive sadness or moodiness:" , " Long-lasting sadness, mood swings, and unexpected rage."));
        warn.add(new Detail("Hopelessness:" , "Feeling a deep sense of hopelessness about the future, with little expectation that circumstances can improve."));
        warn.add(new Detail("Sudden calmness:" , "Suddenly becoming calm after a period of depression or moodiness can be a sign that the person has made a decision to end his or her life."));
        warn.add(new Detail("Withdrawal:" , "Choosing to be alone and avoiding friends or social activities also are possible symptoms of depression, a leading cause of suicide. This includes the loss of interest or pleasure in activities the person previously enjoyed."));
        warn.add(new Detail("Changes in personality and/or appearance:" , "A person who is considering suicide might exhibit a change in attitude or behavior, such as speaking or moving with unusual speed or slowness. In addition, the person might suddenly become less concerned about his or her personal appearance."));
        warn.add(new Detail("Dangerous or self-harmful behavior:" , "Potentially dangerous behavior, such as reckless driving and increased use of drugs and/or alcohol might indicate that the person no longer values his or her life."));
        warn.add(new Detail("Recent trauma or life crisis:" , "A major life crises might trigger a suicide attempt. Crises include the death of a loved one or pet, divorce or break-up of a relationship, diagnosis of a major illness, loss of a job, or serious financial problems."));
        warn.add(new Detail("Making preparations:" , "Often, a person considering suicide will begin to put his or her personal business in order. This might include visiting friends and family members, giving away personal possessions, making a will, and cleaning up his or her room or home. Some people will write a note before committing suicide. Some will buy a firearm or other means like poison."));
        warn.add(new Detail("Threatening suicide:" , "From 50% to 75% of those considering suicide will give someone -- a friend or relative -- a warning sign. However, not everyone who is considering suicide will say so, and not everyone who threatens suicide will follow through with it. Every threat of suicide should be taken seriously.\n\n"));


        CustomAdapter adapter = new CustomAdapter(this , warn ) ;
        ListView listView = (ListView) findViewById(R.id.list_warning) ;
        listView.setAdapter(adapter);
    }


}
