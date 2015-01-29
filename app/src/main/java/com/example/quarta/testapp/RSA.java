package com.example.quarta.testapp;

import java.math.BigInteger;

/**
 * Created by Utente on 29/01/2015.
 */
public class RSA {

    private int p;
    private int q;
    private BigInteger n;
    private BigInteger f;
    private BigInteger e;
    private BigInteger d;

    private BigInteger m;
    private BigInteger c;

    public RSA(int p, int q, int m) {
        setP(p);
        setQ(q);
        setN();
        setF();

        setE();
        setD();

        setM(BigInteger.valueOf(m));
        setC();
    }

    /*public RSA(int p, int q, String m) {
        setP(p);
        setQ(q);
        setN();
        setF();

        setE();
        setD();

        char[] charArray = m.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char c : charArray) {
            sb.append((int)c);
        }

        setM(BigInteger.valueOf(Integer.parseInt(sb.toString())));
        setC();
    }*/

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getF() {
        return f;
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getD() {
        return d;
    }

    public BigInteger getM() {
        return m;
    }

    public BigInteger getC() {
        return c;
    }

    public void setP(int p) {
        this.p = p;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public void setN() {
        this.n = BigInteger.valueOf(p).multiply(BigInteger.valueOf(q));    // n = p*q
    }

    public void setF() {
        this.f = BigInteger.valueOf(p).subtract(BigInteger.valueOf(1)).multiply(BigInteger.valueOf(q).subtract(BigInteger.valueOf(1)));    // f = (p-1)(q-1)
    }

    public void setE() {
        this.e = new BigInteger("2");
        while (!((e.compareTo(f) < 0) && (e.gcd(f)).compareTo(BigInteger.valueOf(1)) == 0) || (e.intValue() % p == 0 || e.intValue() % q == 0)) {
            this.e = e.add(BigInteger.valueOf(1));
        }
    }

    public void setD() {
        d = e.modInverse(f);
    }

    public void setM(BigInteger m) {
        this.m = m;
    }

    public void setC() {
        c = m.modPow(e, n);
    }
}