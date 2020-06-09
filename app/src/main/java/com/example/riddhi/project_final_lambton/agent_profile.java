package com.example.riddhi.project_final_lambton;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.Serializable;

public class agent_profile extends AppCompatActivity {
    TextView name,level,agency,web,country,phone,add ;
    ImageView internet,calls,map,warning,sms,camara;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_profile);

        final for_data employee = (for_data) getIntent().getSerializableExtra("employe");


        name = (TextView) findViewById(R.id.name);

        level = (TextView)findViewById(R.id.level);

        agency = (TextView)findViewById(R.id.agency);
        web = (TextView)findViewById(R.id.website);
        country = (TextView)findViewById(R.id.country);
        phone = (TextView)findViewById(R.id.Phone);
        add = (TextView)findViewById(R.id.adress);

        internet=(ImageView)findViewById(R.id.image1);
        calls=(ImageView)findViewById(R.id.image3);
        map=(ImageView)findViewById(R.id.image4);
        camara=(ImageView)findViewById(R.id.image5);
        sms=(ImageView)findViewById(R.id.image2);
        warning=(ImageView)findViewById(R.id.image6);




        name.setText(employee.getName());
        level.setText(employee.getLevel());
        agency.setText(employee.getAgency());
        web.setText(employee.getWeb());
        country.setText(employee.getCountry());
        phone.setText(employee.getPhone());
        add.setText(employee.getAdd());
        final String web="http://"+employee.getWeb();
        final String call=employee.getPhone();
        final String number = employee.getPhone();


        internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse(web); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);


            }
        });
        calls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse(call));
                startActivity(i);

            }
        });

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.putExtra("sms_body", "default content");
                sendIntent.setType("vnd.android-dir/mms-sms");
                startActivity(sendIntent);
            }
        });
        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                String dirappphoto=getExternalFilesDir(null)+"/"+ System.currentTimeMillis()+".jpg";
                File filephoto=new File((dirappphoto));
                intent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(filephoto));

                startActivity(intent);

            }
        });
        warning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(agent_profile.this, warning.class);
                startActivity(i);

            }
        });




    }


}
