package com.example.riddhi.project_final_lambton;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Belal on 9/30/2017.
 */

public class custom_listview_adapter extends ArrayAdapter<for_data>  {

    Context mCtx;
    int listLayoutRes;
    List<for_data> employeeList;
    SQLiteDatabase mDatabase;

    public custom_listview_adapter(Context mCtx, int listLayoutRes, List<for_data> employeeList) {
        super(mCtx, listLayoutRes, employeeList);

        this.mCtx = mCtx;
        this.listLayoutRes = listLayoutRes;
        this.employeeList = employeeList;
        this.mDatabase = mDatabase;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(listLayoutRes, null);

        //getting employee of the specified position
        final for_data employee = employeeList.get(position);


        //getting views
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewDept = view.findViewById(R.id.textViewDepartment);
        LinearLayout lay = view.findViewById(R.id.linera_layout1);

        //adding data to views
        textViewName.setText(employee.getName());
        textViewDept.setText(employee.getLevel());

        lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToScreen(employee);
            }
        });

        return view;
    }

    private void sendToScreen(for_data employee) {
        Intent intent = new Intent(mCtx, agent_profile.class);

        for_data employee2 = new for_data(employee.name,employee.level,employee.agency,employee.web,employee.country,employee.phone,employee.add);

        intent.putExtra("employe",  employee2);

        mCtx.startActivity(intent);
    }
}

