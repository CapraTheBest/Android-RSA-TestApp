package com.example.quarta.testapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.sql.Time;
import java.util.Locale;
import java.util.Random;


public class MainActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            Intent inent = new Intent(this, TakePictureActivity.class);
            startActivity(inent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void encript(View view){
        try {
            // Hides the virtual keyboard
            InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } catch(Exception e) {
            // Do nothing;
        }
        String p = (((EditText) findViewById(R.id.p)).getText().toString());
        String q = (((EditText) findViewById(R.id.q)).getText().toString());
        String m = ((EditText) findViewById(R.id.message)).getText().toString();
        if (p.matches("")) {
            Toast.makeText(this, "Inseririsci il Seme P", Toast.LENGTH_SHORT).show();
            return;
        } else if (q.matches("")) {
            Toast.makeText(this, "Inseririsci il Seme Q", Toast.LENGTH_SHORT).show();
            return;
        } else if (m.matches("")) {
            Toast.makeText(this, "Inserisci il messaggio", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent result = new Intent (this, Result.class);
        result.putExtra("p", Integer.parseInt(p));
        result.putExtra("q", Integer.parseInt(q));
        result.putExtra("m", m);
        startActivity(result);
    }
}
