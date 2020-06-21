package com.example.challenge;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnaddcontact;
    ImageView imgface,imgloc,imgcall,imgweb;

    final  int CREATECONTACT=1;

String name="",number="",web="",loc="",mood="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnaddcontact = findViewById(R.id.btnaddcontact);
        imgcall = findViewById(R.id.imgcall);
        imgface = findViewById(R.id.imgface);
        imgloc = findViewById(R.id.imgloc);
        imgweb = findViewById(R.id.imgweb);

        imgface.setVisibility(View.GONE);
        imgcall.setVisibility(View.GONE);
        imgweb.setVisibility(View.GONE);
        imgloc.setVisibility(View.GONE);


        btnaddcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.challenge.Main2Activity.class);
                startActivityForResult(intent, CREATECONTACT);
            }
        });


        imgcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ number));
                startActivity(intent);
            }
        });


        imgweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+web));
                startActivity(intent);
            }
        });


        imgloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+loc));
                startActivity(intent);
            }
        });

    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if(requestCode==CREATECONTACT)
            {
                if(resultCode==RESULT_OK)
                {
                    imgface.setVisibility(View.VISIBLE);
                    imgcall.setVisibility(View.VISIBLE);
                    imgweb.setVisibility(View.VISIBLE);
                    imgloc.setVisibility(View.VISIBLE);


                    name=data.getStringExtra("name");
                    number=data.getStringExtra("number");
                    web=data.getStringExtra("website");
                    loc=data.getStringExtra("Location");
                    mood=data.getStringExtra("mood");



                    if(mood.equals("sad"))
                    {
                        imgface.setImageResource(R.drawable.sad);
                    }

                    if(mood.equals("happy"))
                    {
                        imgface.setImageResource(R.drawable.happy);
                    }
                    else
                        {
                        imgface.setImageResource(R.drawable.nuetral);
                    }

                }
                else {
                    Toast.makeText(MainActivity.this,"No data was passed",Toast.LENGTH_LONG).show();
                    }

        }

    }
}
