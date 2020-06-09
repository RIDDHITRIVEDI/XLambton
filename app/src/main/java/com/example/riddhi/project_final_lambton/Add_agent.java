package com.example.riddhi.project_final_lambton;


public class Add_agent extends AppCompatActivity {

    EditText name,level,agency,web,country,phone,add ;
    Button Submit ;
    String name1,level1,agency1,web1,country1,phone1,add1 ;
    ImageView image;
    Boolean CheckEditTextEmpty ;
    String SQLiteQuery;
    SQLiteDatabase SQLITEDATABASE;

    private static final int SELECT_PICTURE = 100;
    private static final String TAG = "MainActivity";
    public static final String DATABASE_NAME = "DemoDataBase";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_agent);
        name = (EditText)findViewById(R.id.name);
image=(ImageView)findViewById(R.id.add_image);

        image.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

               openImageChooser();

            }
        });


        level = (EditText)findViewById(R.id.level);

        agency = (EditText)findViewById(R.id.agency);
        web = (EditText)findViewById(R.id.website);
        country = (EditText)findViewById(R.id.country);
        phone = (EditText)findViewById(R.id.Phone);
        add = (EditText)findViewById(R.id.adress);
       // image.setOnClickListener(this);

        Submit = (Button)findViewById(R.id.submit1);

        Submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                DBCreate();

                SubmitData2SQLiteDB();

            }
        });

    }

    public void DBCreate(){

        SQLITEDATABASE = openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null);

        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS demoTable(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name VARCHAR, level VARCHAR, agency VARCHAR,web VARCHAR, country VARCHAR, phone VARCHAR,address VARCHAR);");
    }

    public void SubmitData2SQLiteDB(){

        name1 = name.getText().toString();

        level1 = level.getText().toString();

        agency1 = agency.getText().toString();
        web1 = web.getText().toString();
        country1 = country.getText().toString();
        phone1 = phone.getText().toString();
        add1 = add.getText().toString();

        CheckEditTextIsEmptyOrNot(name1,level1,agency1,web1,country1,phone1,add1);

        if(CheckEditTextEmpty == true)
        {

            SQLiteQuery = "INSERT INTO demoTable (Name,Level,Agency,Web,Country,Phone,address,image) VALUES ('"+name1+"', '"+level1+"', '"+agency1+"', '"+web1+"', '"+country1+"', '"+phone1+"', '"+add1+"',);";

            SQLITEDATABASE.execSQL(SQLiteQuery);

            Toast.makeText(Add_agent.this,"Data Submit Successfully", Toast.LENGTH_LONG).show();

            ClearEditTextAfterDoneTask();

        }
        else {

            Toast.makeText(Add_agent.this,"Please Fill All the Fields", Toast.LENGTH_LONG).show();
        }
    }

    public void CheckEditTextIsEmptyOrNot(String name1,String level1,String agency1,String web1,String country1,String phone1,String add1 ){

        if(TextUtils.isEmpty(name1) || TextUtils.isEmpty(level1) || TextUtils.isEmpty(phone1)){

            CheckEditTextEmpty = false ;

        }
        else {
            CheckEditTextEmpty = true ;
        }
    }

    public void ClearEditTextAfterDoneTask(){

        name.getText().clear();
        level.getText().clear();
        agency.getText().clear();
        web.getText().clear();
        country.getText().clear();
        phone.getText().clear();
        add.getText().clear();


    }


   // SQLiteDatabase db=(new Add_agent(.this)).getReadableDatabase();

    void openImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                // Get the url from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // Get the path from the Uri
                    String path = getPathFromURI(selectedImageUri);
                    Log.i(TAG, "Image Path : " + path);
                    // Set the image in ImageView
                    image.setImageURI(selectedImageUri);
                }
            }
        }
    }

    /* Get the real path from the URI */
    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }


   }