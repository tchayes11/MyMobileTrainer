package com.bignerdranch.android.mymobiletrainer;

import android.app.FragmentManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.R.attr.data;
import static android.R.attr.value;
import static com.bignerdranch.android.mymobiletrainer.MyFitnessDatabase.KEY_EMAIL_ADDRESS_COLUMN;
import static com.bignerdranch.android.mymobiletrainer.MyFitnessDatabase.KEY_FIRST_NAME_COLUMN;
import static com.bignerdranch.android.mymobiletrainer.MyFitnessDatabase.KEY_FITNESS_LEVEL_COLUMN;
import static com.bignerdranch.android.mymobiletrainer.MyFitnessDatabase.KEY_LAST_NAME_COLUMN;

public class ListCustomers extends AppCompatActivity {

    private Button mViewCustomers;
    private Button mAddNewCustomer;
    private Button mSave;
    private int DATABASE_VERSION;
    private SQLiteDatabase myHelper;
    private Context mContext;
    private Button takepic;
    private TextView First;
    private TextView Last;
    private TextView Email;
    private TextView Level;
    private MyFitnessDatabase myfDB;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_PHOTO = 1;
    private ImageView mImageView;
    String mCurrentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_customers);



        // public void add(Context context) {

        // myHelper = new MyFitnessDatabase.FitnessDBOpenHelper(mContext, null, null, DATABASE_VERSION).getWritableDatabase();
        //Context  c= getApplicationContext();


        mViewCustomers = (Button) findViewById(R.id.view_customer);
        mViewCustomers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                Intent intent = new Intent(ListCustomers.this, PictureActivity.class);
                startActivity(intent);
            }
        });


        mAddNewCustomer = (Button) findViewById(R.id.addNewCustomer);
        mAddNewCustomer.setOnClickListener(new View.OnClickListener() {


            /*String firstName = String.valueOf(FirstName.getText().toString());
            String lastName= String.valueOf(LastName.getText().toString());
            String emailAdress = String.valueOf(EmailAddress.getText().toString());
            String fitLevel= String.valueOf(FitnessLevel.getText().toString());*/

            @Override
            public void onClick(View view) {
                First = (TextView) findViewById(R.id.textFirstName);
                Last = (TextView) findViewById(R.id.textLastName);
                Email = (TextView) findViewById(R.id.textEmailAdd);
                Level = (TextView) findViewById(R.id.textFitLevel);
            }




           /* mContext = context.getApplicationContext();
            myHelper = new MyFitnessDatabase.FitnessDBOpenHelper(mContext, null, null, DATABASE_VERSION).getWritableDatabase();
            myfDB = new MyFitnessDatabase(this);
*/
        });

    }

    public void dispatchTakePictureIntent(View view) throws IOException {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            Uri photoURI = FileProvider.getUriForFile(ListCustomers.this,
                    ListCustomers.this.getApplicationContext().getPackageName() + ".provider",
                    createImageFile());

            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,photoURI);
            startActivity(takePictureIntent);
            /*
            File photoFile = null;

            try {
                photoFile = createImageFile();

            } catch (IOException ex) {

            }
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(ListCustomers.this,
                        ListCustomers.this.getApplicationContext().getPackageName() + ".provider",
                        createImageFile());

                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }*/
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resutlCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resutlCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);

        }
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMDD_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, ".jpg", storageDir);


        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }


    @Override
    public boolean onCreateOptionsMenu (Menu menu){
       MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logoff_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.LogOff) {
            Toast.makeText(ListCustomers.this, "Logging You Off", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ListCustomers.this, LoginActivity.class);
            startActivity(intent);
            return true;
        }
        return true;
        }
    }