package com.example.riddhi.project_final_lambton;

        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.widget.ListView;

        import com.example.riddhi.project_final_lambton.Add_agent;
        import com.example.riddhi.project_final_lambton.R;
        import com.example.riddhi.project_final_lambton.custom_listview_adapter;
        import com.example.riddhi.project_final_lambton.for_data;

        import java.util.ArrayList;
        import java.util.List;

public class agent_list extends AppCompatActivity {

    List<for_data> employeeList;
    SQLiteDatabase mDatabase;
    ListView listViewEmployees;
    custom_listview_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_list);

        listViewEmployees = (ListView) findViewById(R.id.listViewEmployees);
        employeeList = new ArrayList<>();

        //opening the database 
        mDatabase = openOrCreateDatabase(Add_agent.DATABASE_NAME, MODE_PRIVATE, null);

        //this method will display the employees in the list
        showEmployeesFromDatabase();
    }

    private void showEmployeesFromDatabase() {

        //we used rawQuery(sql, selectionargs) for fetching all the employees
        Cursor cursorEmployees = mDatabase.rawQuery("SELECT * FROM demoTable", null);

        //if the cursor has some data
        if (cursorEmployees.moveToFirst()) {
            //looping through all the records
            do {
                //pushing each record in the employee list
                employeeList.add(new for_data(
                        cursorEmployees.getString(1),cursorEmployees.getString(2),cursorEmployees.getString(3),cursorEmployees.getString(4),cursorEmployees.getString(5),cursorEmployees.getString(6),cursorEmployees.getString(7)
                ));
            } while (cursorEmployees.moveToNext());
        }
        //closing the cursor
        cursorEmployees.close();

        //creating the adapter object
        adapter = new custom_listview_adapter(agent_list.this, R.layout.activity_custom_listview_adapter, employeeList);

        //adding the adapter to listview
        listViewEmployees.setAdapter(adapter);
    }

}