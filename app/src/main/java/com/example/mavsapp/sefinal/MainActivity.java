package com.example.mavsapp.sefinal;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity  {
    Button b1,b2;
    EditText ed1,ed2;

    TextView tx1;
    int counter = 3;

    DBHandler db = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button);
        ed1 = (EditText) findViewById(R.id.editText_id);
        ed2 = (EditText) findViewById(R.id.editText_password);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1.getText().toString().equals("admin") &&

                        ed2.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,navigation_slide.class);
                    startActivity(intent);
                }
                else if(ed1.getText().toString().equals("1001241807") && ed2.getText().toString().equals("password")){
                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,navigation_slide.class);
                    startActivity(intent);
                }

                else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        final EditText username = (EditText) findViewById(R.id.editTextReg_id);
        final EditText password = (EditText) findViewById(R.id.editTextReg_id2);
        final EditText password_confirmation = (EditText) findViewById(R.id.editTextReg_id3);

        b2 = (Button) findViewById(R.id.buttonReg); //b2 Registration button

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Student s = new Student(username.getText().toString(),
                        password.getText().toString());
                boolean isInserted = db.addNewStudent(s);

                if (isInserted == true) {

                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, navigation_slide.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
            }

        });




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
















