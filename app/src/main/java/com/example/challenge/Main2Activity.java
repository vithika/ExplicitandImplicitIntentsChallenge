package com.example.challenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    EditText etname,etnumber,etlocation,etwebsite;
    ImageView imghappy,imgsad,imgnuetral;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etname=findViewById(R.id.etname);
        etnumber=findViewById(R.id.etnumber);
        etlocation=findViewById(R.id.etlocation);
        etwebsite=findViewById(R.id.etwebsite);

        imghappy=findViewById(R.id.imghappys);
        imgnuetral=findViewById(R.id.imagenuetral);
        imgsad=findViewById(R.id.imgsad);

        imghappy.setOnClickListener(this);
        imgnuetral.setOnClickListener(this);
        imgsad.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(etnumber.getText().toString().isEmpty()|| (etname.getText().toString().isEmpty()||
                etlocation.getText().toString().isEmpty()||etwebsite.getText().toString().isEmpty()))
        {
            Toast.makeText(Main2Activity.this,"Please enter the text",Toast.LENGTH_LONG).show();
        }
        else
        {
            Intent intent=new Intent();

            intent.putExtra("name",etname.getText().toString().trim());
            intent.putExtra("number",etnumber.getText().toString().trim());
            intent.putExtra("website",etwebsite.getText().toString().trim());
            intent.putExtra("Location",etlocation.getText().toString().trim());

            if(v.getId()== R.id.imghappys)
            {

            intent.putExtra("mood","happy");

            }

            if(v.getId()==R.id.imgsad)
            {
                intent.putExtra("mood","sad");
            }

            if(v.getId()==R.id.imagenuetral)
            {
                intent.putExtra("mood","nuetral");
            }

            setResult(RESULT_OK,intent);
            Main2Activity.this.finish();
        }

    }
}
