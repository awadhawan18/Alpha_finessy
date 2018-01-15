package com.example.abhi.alpha;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Contact extends AppCompatActivity {

    TextView t1,t2,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        setTitle("Contact Us");

        t1 = (TextView) findViewById(R.id.query_mail);
        t2 = (TextView) findViewById(R.id.feedback_mail);
        t3 = (TextView) findViewById(R.id.ceo_mail);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(Intent.ACTION_SENDTO);
                i1.setData(Uri.parse("mailto:"));
                i1.putExtra(Intent.EXTRA_EMAIL, R.string.query_email);
                startActivity(i1);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(Intent.ACTION_SENDTO);
                i2.setData(Uri.parse("mailto:"));
                i2.putExtra(Intent.EXTRA_EMAIL, R.string.feedback_mail);
                startActivity(i2);
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(Intent.ACTION_SENDTO);
                i3.setData(Uri.parse("mailto:"));
                i3.putExtra(Intent.EXTRA_EMAIL, R.string.ceo_mail);
                startActivity(i3);
            }
        });

    }
}
