package com.example.bitcalculator.ui.logicgate;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.bitcalculator.R;

public class logicGate extends Fragment implements View.OnClickListener{
    private EditText gatevalue1, gatevalue2;
    private TextView gateanswer,inputvalue1,inputvalue2,inputvalue3,inputvalue4,TTA,TTB,TToutput,TTA1,TTA2,TTA3,TTA4,TTB1,TTB2,TTB3,TTB4,ans1,ans2,ans3,ans4,truthtable,explaination;
    Button btnand,btnor,btnnot,btnxor,btnnand,btnnor,btnxnor;

    Handler mHandler;
    ProgressDialog mProgressBar;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_logicgate,container,false);
        gatevalue1 = (EditText) v.findViewById(R.id.gateid1);
        gatevalue2 = (EditText) v.findViewById(R.id.gateid2);
        gatevalue2.requestFocus();
        gatevalue1.requestFocus();
        gateanswer = (TextView) v.findViewById(R.id.gateans);
        inputvalue1 = (TextView) v.findViewById(R.id.lblinput1);
        inputvalue2 = (TextView) v.findViewById(R.id.lblinput2);
        inputvalue3 = (TextView) v.findViewById(R.id.lblinput3);
        inputvalue4 = (TextView) v.findViewById(R.id.lblinput4);
        TTA = (TextView) v.findViewById(R.id.inputA);
        TTB = (TextView) v.findViewById(R.id.inputB);
        TToutput = (TextView) v.findViewById(R.id.output);
        TTA1 = (TextView) v.findViewById(R.id.Avalue1);
        TTA2 = (TextView) v.findViewById(R.id.Avalue2);
        TTA3 = (TextView) v.findViewById(R.id.Avalue3);
        TTA4 = (TextView) v.findViewById(R.id.Avalue4);
        TTB1 = (TextView) v.findViewById(R.id.Bvalue1);
        TTB2 = (TextView) v.findViewById(R.id.Bvalue2);
        TTB3 = (TextView) v.findViewById(R.id.Bvalue3);
        TTB4 = (TextView) v.findViewById(R.id.Bvalue4);
        ans1 = (TextView) v.findViewById(R.id.Output1);
        ans2 = (TextView) v.findViewById(R.id.Output2);
        ans3 = (TextView) v.findViewById(R.id.Output3);
        ans4 = (TextView) v.findViewById(R.id.Output4);
        explaination = (TextView) v.findViewById(R.id.ansExplain);
        truthtable = (TextView) v.findViewById(R.id.Truthtable);
        btnand = (Button) v.findViewById(R.id.andgate);
        btnor = (Button) v.findViewById(R.id.orgate);
        btnnot = (Button) v.findViewById(R.id.notgate);
        btnxor = (Button) v.findViewById(R.id.xorgate);
        btnnand = (Button) v.findViewById(R.id.nandgate);
        btnnor = (Button) v.findViewById(R.id.norgate);
        btnxnor = (Button) v.findViewById(R.id.xnorgate);

        if((gatevalue1.getText().toString().isEmpty()) &&(gatevalue2.getText().toString().isEmpty()))
        {
            btnand.setEnabled(false);
            btnor.setEnabled(false);
            btnnot.setEnabled(false);
            btnxor.setEnabled(false);
            btnnand.setEnabled(false);
            btnnor.setEnabled(false);
            btnxnor.setEnabled(false);
        }
        gatevalue1.addTextChangedListener(buttontextwatcher);
        gatevalue2.addTextChangedListener(buttontextwatcher);

        btnand.setOnClickListener(this);
        btnor.setOnClickListener(this);
        btnnot.setOnClickListener(this);
        btnxor.setOnClickListener(this);
        btnnand.setOnClickListener(this);
        btnnor.setOnClickListener(this);
        btnxnor.setOnClickListener(this);

        return v;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.andgate:
                String andans = "";
                String gatestr = gatevalue1.getText().toString();
                String gatestr2 = gatevalue2.getText().toString();

                for (int cntr=0;cntr<gatestr.length();cntr++)
                {
                    char c = gatestr.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        gateanswer.setText("Invalid Binary Number..!!");
                        gateanswer.setTextColor(Color.BLUE);
                        gateanswer.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                for (int cntr=0;cntr<gatestr2.length();cntr++)
                {
                    char c = gatestr2.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        gateanswer.setText("Invalid Binary Number..!!");
                        gateanswer.setTextColor(Color.BLUE);
                        gateanswer.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                char[] ch1 = gatestr.toCharArray();
                char[] ch2 = gatestr2.toCharArray();

                for (int i =0 ; i<=(ch1.length)-1; i++)
                {
                    int val1 = ch1[i];
                    int val2 = ch2[i];

                    int numericvalue1 = Character.getNumericValue(val1);
                    int numericvalue2 = Character.getNumericValue(val2);

                    int product = numericvalue1 * numericvalue2;
                    andans = andans + product;

                }
                gateanswer.setText(gatestr + "  'AND'  " + gatestr2 + " = " + andans);
                truthtable.setText("'AND' Truth table");
                TTA.setText("A");

                TTB.setText("B");
                TToutput.setText("Output");
                TTA1.setText("0");
                TTA2.setText("0");
                TTA3.setText("1");
                TTA4.setText("1");
                TTB1.setText("0");
                TTB2.setText("1");
                TTB3.setText("0");
                TTB4.setText("1");
                ans1.setText("0");
                ans2.setText("0");
                ans3.setText("0");
                ans4.setText("1");
                explaination.setText("Explanation");
                inputvalue1.setText(gatestr);
                inputvalue2.setText(gatestr2);
                String temp = "";
                for (int j = 0 ; j<=gatestr.length()-1;j++)
                {
                    String t = "";
                    t = t + "_";
                    temp = temp + t ;
                    //pattern.setText(temp);
                    inputvalue3.setText(temp);
                }
                inputvalue4.setText(andans);
                hideKeybaord(v);
                break;

            case R.id.orgate:
                String orans = "";
                int product1 ;
                String gatestr3 = gatevalue1.getText().toString();
                String gatestr4 = gatevalue2.getText().toString();

                for (int cntr=0;cntr<gatestr3.length();cntr++)
                {
                    char c = gatestr3.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        gateanswer.setText("Invalid Binary Number..!!");
                        gateanswer.setTextColor(Color.BLUE);
                        gateanswer.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                for (int cntr=0;cntr<gatestr4.length();cntr++)
                {
                    char c = gatestr4.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        gateanswer.setText("Invalid Binary Number..!!");
                        gateanswer.setTextColor(Color.BLUE);
                        gateanswer.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                char[] ch3 = gatestr3.toCharArray();
                char[] ch4 = gatestr4.toCharArray();

                for (int i =0 ; i<=(ch3.length)-1; i++)
                {
                    int val1 = ch3[i];
                    int val2 = ch4[i];

                    int numericvalue1 = Character.getNumericValue(val1);
                    int numericvalue2 = Character.getNumericValue(val2);

                    if(numericvalue1 + numericvalue2 >0)
                    {
                        product1 = 1;
                    }
                    else
                        {
                            product1 = 0;
                        }
                        orans = orans + product1;

                    }
                gateanswer.setText(gatestr3 + "  'OR'  " + gatestr4 + " = " + orans);
                truthtable.setText("'OR' Truth table");
                TTA.setText("A");
                TTB.setText("B");
                TToutput.setText("Output");
                TTA1.setText("0");
                TTA2.setText("0");
                TTA3.setText("1");
                TTA4.setText("1");

                TTB1.setText("0");
                TTB2.setText("1");
                TTB3.setText("0");
                TTB4.setText("1");

                ans1.setText("0");
                ans2.setText("1");
                ans3.setText("1");
                ans4.setText("1");
                explaination.setText("Explanation");
                inputvalue1.setText(gatestr3);
                inputvalue2.setText(gatestr4);
                String temp1 = "";
                for (int j = 0 ; j<=gatestr3.length()-1;j++)
                {
                    String t = "";
                    t = t + "_";
                    temp1 = temp1 + t ;
                    inputvalue3.setText(temp1);
                }
                inputvalue4.setText(orans);
                hideKeybaord(v);
                break;

            case R.id.notgate:
                String gatestr5 = gatevalue1.getText().toString();

                for (int cntr=0;cntr<gatestr5.length();cntr++)
                {
                    char c = gatestr5.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        gateanswer.setText("Invalid Binary Number..!!");
                        gateanswer.setTextColor(Color.BLUE);
                        gateanswer.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                char[] ch5 = gatestr5.toCharArray();
                int product2;
                String notans = "";

                for (int i =0 ; i<=(ch5.length)-1; i++)
                {
                    int val1 = ch5[i];

                    int numericvalue1 = Character.getNumericValue(val1);

                    if(numericvalue1 == 0)
                    {
                        product2 = 1;
                    }
                    else { product2 = 0; }
                    notans = notans + product2;
                }
                gateanswer.setText("  'NOT' of  " + gatestr5 + " = " + notans);
                truthtable.setText("'NOT' Truth table");
                TTA.setText("A");
                //TTB.setText("B");
                TToutput.setText("Output");
                TTA1.setText("0");
                TTA2.setText("1");
                TTA3.setText("\t");
                TTA4.setText("\t");
                //TTB1.setText("1");
                //TTB2.setText("0");

                //TTB3.setText("0");
                //TTB4.setText(" ");
                ans1.setText("1");
                ans2.setText("0");

                ans3.setText("\t");
                ans4.setText("\t");
                explaination.setText("Explanation");
                inputvalue1.setText(gatestr5);
                //inputvalue2.setText(gatestr4);
                String temp2 = "";
                for (int j = 0 ; j<=gatestr5.length()-1;j++)
                {
                    String t = "";
                    t = t + "_";
                    temp2 = temp2 + t ;
                    inputvalue2.setText(temp2);
                }
                inputvalue3.setText(notans);
                hideKeybaord(v);
                break;

            case R.id.xorgate:
                String xorans = "";
                int product3;
                String gatestr6 = gatevalue1.getText().toString();
                String gatestr7 = gatevalue2.getText().toString();

                for (int cntr=0;cntr<gatestr6.length();cntr++)
                {
                    char c = gatestr6.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        gateanswer.setText("Invalid Binary Number..!!");
                        gateanswer.setTextColor(Color.BLUE);
                        gateanswer.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                for (int cntr=0;cntr<gatestr7.length();cntr++)
                {
                    char c = gatestr7.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        gateanswer.setText("Invalid Binary Number..!!");
                        gateanswer.setTextColor(Color.BLUE);
                        gateanswer.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                char[] ch6 = gatestr6.toCharArray();
                char[] ch7 = gatestr7.toCharArray();

                for (int i =0 ; i<=(ch6.length)-1; i++)
                {
                    int val1 = ch6[i];
                    int val2 = ch7[i];

                    int numericvalue1 = Character.getNumericValue(val1);
                    int numericvalue2 = Character.getNumericValue(val2);

                    if((numericvalue1 ==0 && numericvalue2 == 0) || (numericvalue1 ==1 && numericvalue2 == 1) )
                    {
                        product3 = 0;
                    }
                    else { product3 = 1; }
                    xorans = xorans + product3;

                }
                gateanswer.setText(gatestr6 + "  'XOR'  " + gatestr7 + " = " + xorans);
                truthtable.setText("'XOR' Truth table");
                TTA.setText("A");
                TTB.setText("B");
                TToutput.setText("Output");
                TTA1.setText("0");
                TTA2.setText("0");
                TTA3.setText("1");
                TTA4.setText("1");

                TTB1.setText("0");
                TTB2.setText("1");
                TTB3.setText("0");
                TTB4.setText("1");

                ans1.setText("0");
                ans2.setText("1");
                ans3.setText("1");
                ans4.setText("0");
                explaination.setText("Explanation");
                inputvalue1.setText(gatestr6);
                inputvalue2.setText(gatestr7);
                String temp3 = "";
                for (int j = 0 ; j<=gatestr6.length()-1;j++)
                {
                    String t = "";
                    t = t + "_";
                    temp3 = temp3 + t ;
                    inputvalue3.setText(temp3);
                }
                inputvalue4.setText(xorans);
                hideKeybaord(v);
                break;

            case R.id.nandgate:
                String nandans = "";
                int product4;
                String gatestr8 = gatevalue1.getText().toString();
                String gatestr9 = gatevalue2.getText().toString();

                for (int cntr=0;cntr<gatestr8.length();cntr++)
                {
                    char c = gatestr8.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        gateanswer.setText("Invalid Binary Number..!!");
                        gateanswer.setTextColor(Color.BLUE);
                        gateanswer.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                for (int cntr=0;cntr<gatestr9.length();cntr++)
                {
                    char c = gatestr9.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        gateanswer.setText("Invalid Binary Number..!!");
                        gateanswer.setTextColor(Color.BLUE);
                        gateanswer.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }

                char[] ch8 = gatestr8.toCharArray();
                char[] ch9 = gatestr9.toCharArray();

                for (int i =0 ; i<=(ch8.length)-1; i++)
                {
                    int val1 = ch8[i];
                    int val2 = ch9[i];

                    int numericvalue1 = Character.getNumericValue(val1);
                    int numericvalue2 = Character.getNumericValue(val2);

                    if((numericvalue1 ==1 && numericvalue2 == 1))
                    {
                        product4 = 0;
                    }
                    else { product4 = 1; }
                    nandans = nandans + product4;
                }
                gateanswer.setText(gatestr8 + "  'NAND'  " + gatestr9 + " = " + nandans);
                truthtable.setText("'NAND' Truth table");
                TTA.setText("A");
                TTB.setText("B");
                TToutput.setText("Output");
                TTA1.setText("0");
                TTA2.setText("0");
                TTA3.setText("1");
                TTA4.setText("1");

                TTB1.setText("0");
                TTB2.setText("1");
                TTB3.setText("0");
                TTB4.setText("1");

                ans1.setText("1");
                ans2.setText("1");
                ans3.setText("1");
                ans4.setText("0");
                explaination.setText("Explanation");
                inputvalue1.setText(gatestr8);
                inputvalue2.setText(gatestr9);
                String temp4 = "";
                for (int j = 0 ; j<=gatestr8.length()-1;j++)
                {
                    String t = "";
                    t = t + "_";
                    temp4 = temp4 + t ;
                    inputvalue3.setText(temp4);
                }
                inputvalue4.setText(nandans);
                hideKeybaord(v);
                break;

            case R.id.norgate:

                String norans = "";
                int product5;
                String gatestr10 = gatevalue1.getText().toString();
                String gatestr11 = gatevalue2.getText().toString();

                for (int cntr=0;cntr<gatestr10.length();cntr++)
                {
                    char c = gatestr10.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        gateanswer.setText("Invalid Binary Number..!!");
                        gateanswer.setTextColor(Color.BLUE);
                        gateanswer.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                for (int cntr=0;cntr<gatestr11.length();cntr++)
                {
                    char c = gatestr11.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        gateanswer.setText("Invalid Binary Number..!!");
                        gateanswer.setTextColor(Color.BLUE);
                        gateanswer.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                char[] ch10 = gatestr10.toCharArray();
                char[] ch11 = gatestr11.toCharArray();

                for (int i =0 ; i<=(ch10.length)-1; i++)
                {
                    int val1 = ch10[i];
                    int val2 = ch11[i];

                    int numericvalue1 = Character.getNumericValue(val1);
                    int numericvalue2 = Character.getNumericValue(val2);

                    if((numericvalue1 == 0 && numericvalue2 == 0))
                    {
                        product5 = 1;
                    }
                    else { product5 = 0; }
                    norans = norans + product5;

                }
                gateanswer.setText(gatestr10 + "  'NOR'  " + gatestr11 + " = " + norans);
                truthtable.setText("'NOR' Truth table");
                TTA.setText("A");
                TTB.setText("B");
                TToutput.setText("Output");
                TTA1.setText("0");
                TTA2.setText("0");
                TTA3.setText("1");
                TTA4.setText("1");

                TTB1.setText("0");
                TTB2.setText("1");
                TTB3.setText("0");
                TTB4.setText("1");

                ans1.setText("1");
                ans2.setText("0");
                ans3.setText("0");
                ans4.setText("0");
                explaination.setText("Explanation");
                inputvalue1.setText(gatestr10);
                inputvalue2.setText(gatestr11);
                String temp5 = "";
                for (int j = 0 ; j<=gatestr10.length()-1;j++)
                {
                    String t = "";
                    t = t + "_";
                    temp5 = temp5 + t ;
                    inputvalue3.setText(temp5);
                }
                inputvalue4.setText(norans);
                hideKeybaord(v);
                break;

            case R.id.xnorgate:

                String xnorans = "";
                int product6;
                String gatestr12 = gatevalue1.getText().toString();
                String gatestr13 = gatevalue2.getText().toString();

                for (int cntr=0;cntr<gatestr12.length();cntr++)
                {
                    char c = gatestr12.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        gateanswer.setText("Invalid Binary Number..!!");
                        gateanswer.setTextColor(Color.BLUE);
                        gateanswer.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                for (int cntr=0;cntr<gatestr13.length();cntr++)
                {
                    char c = gatestr13.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        gateanswer.setText("Invalid Binary Number..!!");
                        gateanswer.setTextColor(Color.BLUE);
                        gateanswer.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                char[] ch12 = gatestr12.toCharArray();
                char[] ch13 = gatestr13.toCharArray();

                for (int i =0 ; i<=(ch12.length)-1; i++)
                {
                    int val1 = ch12[i];
                    int val2 = ch13[i];

                    int numericvalue1 = Character.getNumericValue(val1);
                    int numericvalue2 = Character.getNumericValue(val2);

                    if((numericvalue1 == 0 && numericvalue2 == 0) || (numericvalue1 ==1 && numericvalue2 == 1))
                    {
                        product6 = 1;
                    }
                    else { product6 = 0; }
                    xnorans = xnorans + product6;

                }
                gateanswer.setText(gatestr12 + "  'XNOR'  " + gatestr13 + " = " + xnorans);
                truthtable.setText("'XNOR' Truth table");
                TTA.setText("A");
                TTB.setText("B");
                TToutput.setText("Output");
                TTA1.setText("0");
                TTA2.setText("0");
                TTA3.setText("1");
                TTA4.setText("1");

                TTB1.setText("0");
                TTB2.setText("1");
                TTB3.setText("0");
                TTB4.setText("1");

                ans1.setText("1");
                ans2.setText("0");
                ans3.setText("0");
                ans4.setText("1");
                explaination.setText("Explanation");
                inputvalue1.setText(gatestr12);
                inputvalue2.setText(gatestr13);
                String temp6 = "";
                for (int j = 0 ; j<=gatestr12.length()-1;j++)
                {
                    String t = "";
                    t = t + "_";
                    temp6 = temp6 + t ;
                    inputvalue3.setText(temp6);
                }
                inputvalue4.setText(xnorans);
                hideKeybaord(v);
                break;
        }
    }

    private void hideKeybaord(View v) {
        InputMethodManager inputMethodManager = (InputMethodManager)getActivity().getSystemService(getContext().INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
    }

    private TextWatcher buttontextwatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String gatestr = gatevalue1.getText().toString().trim();
            String gatestr2 = gatevalue2.getText().toString().trim();
            btnnot.setEnabled(!gatestr.isEmpty() && gatestr2.isEmpty());
            if(gatestr.length() == gatestr2.length())
            {
                btnand.setEnabled(!gatestr.isEmpty() && !gatestr2.isEmpty());
                btnor.setEnabled(!gatestr.isEmpty() && !gatestr2.isEmpty());
                btnxor.setEnabled(!gatestr.isEmpty() && !gatestr2.isEmpty());
                btnnand.setEnabled(!gatestr.isEmpty() && !gatestr2.isEmpty());
                btnnor.setEnabled(!gatestr.isEmpty() && !gatestr2.isEmpty());
                btnxnor.setEnabled(!gatestr.isEmpty() && !gatestr2.isEmpty());
            }
            else
            {
                btnand.setEnabled(gatestr.isEmpty() && gatestr2.isEmpty());
                btnor.setEnabled(gatestr.isEmpty() && gatestr2.isEmpty());
                //btnnot.setEnabled(!gatestr.isEmpty() && gatestr2.isEmpty());
                btnxor.setEnabled(gatestr.isEmpty() && gatestr2.isEmpty());
                btnnand.setEnabled(gatestr.isEmpty() && gatestr2.isEmpty());
                btnnor.setEnabled(gatestr.isEmpty() && gatestr2.isEmpty());
                btnxnor.setEnabled(gatestr.isEmpty() && gatestr2.isEmpty());
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            gateanswer.setText(" ");
            truthtable.setText(" ");
            TTA.setText(" ");
            TTB.setText(" ");
            TToutput.setText(" ");
            TTA1.setText(" ");
            TTA2.setText(" ");
            TTA3.setText(" ");
            TTA4.setText(" ");
            TTB1.setText(" ");
            TTB2.setText(" ");
            TTB3.setText(" ");
            TTB4.setText(" ");
            ans1.setText(" ");
            ans2.setText(" ");
            ans3.setText(" ");
            ans4.setText(" ");
            explaination.setText(" ");
            inputvalue1.setText(" ");
            inputvalue2.setText(" ");
            inputvalue3.setText(" ");
            inputvalue4.setText(" ");
        }
    };
}