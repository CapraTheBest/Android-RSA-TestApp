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
            Intent inent = new Intent(this, EasterEgg.class);
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
        int p = Integer.parseInt(((EditText) findViewById(R.id.p)).getText().toString());
        int q = Integer.parseInt(((EditText) findViewById(R.id.q)).getText().toString());
        int m = Integer.parseInt(((EditText) findViewById(R.id.message)).getText().toString());

        RSA encrypt = new RSA(p, q, m);

        Toast.makeText(this, "Chiave pubblica: (" + encrypt.getE() + "; " + encrypt.getN() + ")\n" +
                            "Chiave privata: (" + encrypt.getD() + "; " + encrypt.getN() + ")\n" +
                            "Cifrato: " + encrypt.getC(), Toast.LENGTH_LONG).show();
    }
}
