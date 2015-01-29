package com.example.quarta.testapp;

import android.content.Context;
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
            Toast.makeText(this, "Penis", Toast.LENGTH_SHORT).show();
            return true;
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
        String P = ((EditText) findViewById(R.id.p)).getText().toString();
        String Q = ((EditText) findViewById(R.id.q)).getText().toString();

        String m = ((EditText) findViewById(R.id.message)).getText().toString();
/*
        int f = (p-1)*(q-1);
*/


        BigInteger p, q;
        BigInteger n;
        BigInteger PhiN;
        BigInteger e, d;

        int SIZE = 512;
        /* Step 1: Select two large prime numbers. Say p and q. */
        p = new BigInteger(P);
        q = new BigInteger(Q);
        /* Step 2: Calculate n = p.q */
        n = p.multiply(q);
        /* Step 3: Calculate ø(n) = (p - 1).(q - 1) */
        PhiN = p.subtract(BigInteger.valueOf(1));
        PhiN = PhiN.multiply(q.subtract(BigInteger.valueOf(1)));
        e = new BigInteger("" + (PhiN.subtract(BigInteger.valueOf(1))));
        /* Step 4: Find e such that gcd(e, ø(n)) = 1 ; 1 < e < ø(n) */
        boolean ok = false;
        while (!((e.compareTo(PhiN) != 1) && (e.gcd(PhiN).equals(BigInteger.valueOf(1)))) && ok) {
            if(!((e.compareTo(PhiN) != 1) && (e.gcd(PhiN).equals(BigInteger.valueOf(1)))))
                ok = true;
            e = e.subtract(BigInteger.valueOf(1));

        }
        /* Step 5: Calculate d such that e.d = 1 (mod ø(n)) */
        // FIXME: questo qui non va
        d = findD(e, PhiN);

        BigInteger bplaintext, bciphertext;
        // Converte m in hex
        // Long l = Long.parseLong(toHex(m));
        bplaintext = BigInteger.valueOf(Integer.parseInt(m));
        bciphertext = encrypt(e, n, bplaintext);
       // System.out.println("Plaintext : " + bplaintext.toString());
       // System.out.println("Ciphertext : " + bciphertext.toString());
        bplaintext = decrypt(d, n, bciphertext);
        Toast.makeText(this, "Chiave pubblica: (" + e + "; " + n + ")\n" +
                            "Chiave privata: (" + d + "; " + n + ")\n" +
                            bciphertext.toString() + "\n" +
                            bplaintext, Toast.LENGTH_LONG).show();
    }

    public BigInteger encrypt(BigInteger e, BigInteger n, BigInteger plaintext) {
        return plaintext.modPow(e, n);
    }

    public BigInteger decrypt(BigInteger d, BigInteger n, BigInteger ciphertext) {
        return ciphertext.modPow(d, n);
    }

    public String toHex(String arg) {
        return String.format(Locale.ITALY, "%040x", new BigInteger(1, arg.getBytes(Charset.defaultCharset())));
    }

    public BigInteger findD(BigInteger e, BigInteger PhiN) {
        BigInteger d = new BigInteger("0");
        int k = 1;
        while(true) {
            double i = ((k * PhiN.intValue()) + 1) / e.intValue();
            if(i == (int)i) {
                d.add(new BigInteger((int)i + ""));
                return d;
            }
            k++;
        }
    }
}
