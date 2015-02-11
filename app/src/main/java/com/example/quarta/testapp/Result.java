package com.example.quarta.testapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class Result extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        int p = intent.getIntExtra("p", 3);
        int q = intent.getIntExtra("q", 5);
        int m = intent.getIntExtra("m", 2);

        RSA encrypt = new RSA(p, q, m);


        TextView pub_key = (TextView) findViewById(R.id.pub_key);
        TextView priv_key = (TextView) findViewById(R.id.priv_key);
        TextView c = (TextView) findViewById(R.id.c);

        pub_key.setText("Chiave pubblica: (" + encrypt.getE() + "; " + encrypt.getN() + ")");
        priv_key.setText("Chiave privata: (" + encrypt.getD() + "; " + encrypt.getN() + ")");
        c.setText("Cifrato: " + encrypt.getC());
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
}
