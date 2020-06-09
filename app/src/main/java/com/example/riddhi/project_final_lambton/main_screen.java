package com.example.riddhi.project_final_lambton;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

public class main_screen extends AppCompatActivity {
LinearLayout add;
    LinearLayout list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
add=(LinearLayout)findViewById(R.id.add);
        list=(LinearLayout)findViewById(R.id.agent_list);
add.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent myIntent = new Intent(main_screen.this,
                Add_agent.class);
        startActivity(myIntent);

    }
});
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(main_screen.this,
                        agent_list.class);
                startActivity(myIntent);

            }
        });



}}
