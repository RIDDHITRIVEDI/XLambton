package com.example.riddhi.project_final_lambton;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class database extends SQLiteOpenHelper
{

    public database(Context context) {
        super(context, "harpal.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sql = "CREATE TABLE USERS(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT NOT NULL ,email TEXT NOT NULL ,password TEXT NOT NULL)";
        db.execSQL(sql);
//        String sql1 = "CREATE TABLE IF NOT EXISTS demoTable(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name VARCHAR, level VARCHAR, agency VARCHAR,web VARCHAR, country VARCHAR, phone VARCHAR,address VARCHAR)";
//
//        db.execSQL(sql1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS USERS";
        db.execSQL(sql); //call me
        onCreate(db); // create again

    }

    public void dbInsert(User user)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues userData = new ContentValues();
        userData.put("name", user.getEmail());
        userData.put("email", user.getEmail());
        userData.put("password", user.getPassword());
        //Toast.makeText(Context, user.getEmail(), Toast.LENGTH_SHORT).show();
        db.insert("USERS",null,userData);

    }



    public List<User> dbSearch()
    {
        String sql="SELECT * FROM USERS;";
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery(sql,null);

        List<User>userList = new ArrayList<User>();
        if(c.moveToFirst()) {
            do  {
                User user = new User();
                user.setEmail(c.getString(c.getColumnIndex("name")));

                user.setEmail(c.getString(c.getColumnIndex("email")));
                user.setPassword(c.getString(c.getColumnIndex("password")));
                userList.add(user);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return userList;
    }

   /* public boolean checkUser(String email)
    {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';

        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
*/

}

