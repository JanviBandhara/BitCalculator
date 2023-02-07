package com.example.bitcalculator.ui.shift;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.bitcalculator.Hexa_learning;
import com.example.bitcalculator.MainActivity;
import com.example.bitcalculator.R;
import com.example.bitcalculator.Shift_learning;

public class Shift extends Fragment implements View.OnClickListener{
    private EditText val1,val2,val3;
    Button btnone,btntwo,btnRishift,btnLeshift,learning;
    TextView ShiftAnswer,complementAnswer,twos_complement;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_shift,container,false);
        val1 = (EditText) v.findViewById(R.id.complval1);
        val2 = (EditText) v.findViewById(R.id.complval2);
        val3 = (EditText) v.findViewById(R.id.dec_input);
        val2.requestFocus();
        val3.requestFocus();
        val1.requestFocus();
        btnone = (Button) v.findViewById(R.id.one_complement);
        btntwo = (Button) v.findViewById(R.id.two_complement);
        btnRishift = (Button) v.findViewById(R.id.rshift);
        btnLeshift = (Button) v.findViewById(R.id.lshift);
        learning = (Button) v.findViewById(R.id.shift_learning);
        ShiftAnswer = (TextView) v.findViewById(R.id.shiftans);
        complementAnswer = (TextView) v.findViewById(R.id.complement_ans);
        twos_complement = (TextView) v.findViewById(R.id.two_complement_ans);

        if((val1.getText().toString().isEmpty()) &&(val2.getText().toString().isEmpty()))
        {
            btnone.setEnabled(false);
            btntwo.setEnabled(false);
            btnRishift.setEnabled(false);
            btnLeshift.setEnabled(false);
        }
        val1.addTextChangedListener(buttontextwatcher);
        val2.addTextChangedListener(buttontextwatcher);
        val3.addTextChangedListener(buttontextwatcher);

        btnone.setOnClickListener(this);
        btntwo.setOnClickListener(this);
        btnRishift.setOnClickListener(this);
        btnLeshift.setOnClickListener(this);

        learning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Shift_learning.class);
                ((MainActivity) getActivity()).startActivity(intent);
            }
        });

        return v;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.one_complement:
                String b1 = val1.getText().toString();

                for (int cntr=0;cntr<b1.length();cntr++)
                {
                    char c = b1.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        complementAnswer.setText("Invalid Binary Number..!!");
                        complementAnswer.setTextColor(Color.BLUE);
                        complementAnswer.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                char[] num = b1.toCharArray();
                String onescomplement ="";

                for(int i=0;i<b1.length();i++)
                {
                    if(num[i]=='0')
                    {
                        onescomplement= onescomplement + '1';
                    }
                    else if(num[i]=='1')
                    {
                        onescomplement= onescomplement + '0';
                    }
                }
                complementAnswer.setText("One's complement of " + "'" + b1 + "'" + " is " + "'" + onescomplement +"'");
                hideKeybaord(v);
                break;

            case R.id.two_complement:
                String b3 = val1.getText().toString();

                for (int cntr=0;cntr<b3.length();cntr++)
                {
                    char c = b3.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        complementAnswer.setText("Invalid Binary Number..!!");
                        complementAnswer.setTextColor(Color.BLUE);
                        complementAnswer.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                char[] num1 = b3.toCharArray();
                String onescomplement1 ="";
                String twoscomplement1 ="";
                int carry=1;

                for(int i=0; i<b3.length(); i++)
                {
                    if(num1[i]=='0')
                    {
                        onescomplement1 = onescomplement1 + '1';
                    }
                    else if(num1[i]=='1')
                    {
                        onescomplement1= onescomplement1 + '0';
                    }
                }
                char[] toones = onescomplement1.toCharArray();
                for(int i=onescomplement1.length()-1;i>=0;i--)
                {
                    if(toones[i] == '1' && carry == 1)
                    {
                        twoscomplement1 = twoscomplement1 + '0';
                    }
                    else if(toones[i] == '0' && carry == 1)
                    {
                        twoscomplement1 = twoscomplement1 + '1';
                        carry=0;
                    }
                    else { twoscomplement1 = twoscomplement1 + toones[i]; }
                }
                String reversedStr="";
                for(int i = twoscomplement1.length()-1; i >= 0; i--){
                    reversedStr = reversedStr + twoscomplement1.charAt(i);
                }
                twos_complement.setText("Two's complement of " + "'" + b3 + "'" + " is " + "'" + reversedStr +"'");
                hideKeybaord(v);
                break;

            case R.id.lshift:
                String b5 = val3.getText().toString();
                String b6 = val2.getText().toString();

                for (int cntr=0;cntr<b5.length();cntr++)
                {
                    char c = b5.charAt(cntr);
                    if(c=='0' || c=='1'|| c=='2'|| c=='3'|| c=='4'|| c=='5'|| c=='6'|| c=='7'|| c=='8'|| c=='9')
                    {
                    }
                    else
                    {
                        ShiftAnswer.setText("Invalid Decimal Number..!!");
                        ShiftAnswer.setTextColor(Color.BLUE);
                        ShiftAnswer.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                for (int cntr=0;cntr<b6.length();cntr++)
                {
                    char c = b6.charAt(cntr);
                    if(c=='0' || c=='1'|| c=='2'|| c=='3'|| c=='4'|| c=='5'|| c=='6'|| c=='7'|| c=='8'|| c=='9')
                    {
                    }
                    else
                    {
                        ShiftAnswer.setText("Invalid Bit Number..!!");
                        ShiftAnswer.setTextColor(Color.BLUE);
                        ShiftAnswer.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                long x = Long.parseLong(b5);
                long bit = Long.parseLong(b6);
                long a = x<<bit;
                String resultl = "";
                while(a>0)
                {
                    resultl = a%2 + resultl;
                    a = a/2;
                }
                ShiftAnswer.setText( b5 + " << " + b6 + " = " + resultl );
                hideKeybaord(v);
                break;

            case R.id.rshift:
                String b7 = val3.getText().toString();
                String b8 = val2.getText().toString();

                for (int cntr=0;cntr<b7.length();cntr++)
                {
                    char c = b7.charAt(cntr);
                    if(c=='0' || c=='1'|| c=='2'|| c=='3'|| c=='4'|| c=='5'|| c=='6'|| c=='7'|| c=='8'|| c=='9')
                    {
                    }
                    else
                    {
                        ShiftAnswer.setText("Invalid Decimal Number..!!");
                        ShiftAnswer.setTextColor(Color.BLUE);
                        ShiftAnswer.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                for (int cntr=0;cntr<b8.length();cntr++)
                {
                    char c = b8.charAt(cntr);
                    if(c=='0' || c=='1'|| c=='2'|| c=='3'|| c=='4'|| c=='5'|| c=='6'|| c=='7'|| c=='8'|| c=='9')
                    {
                    }
                    else
                    {
                        ShiftAnswer.setText("Invalid Bit Number..!!");
                        ShiftAnswer.setTextColor(Color.BLUE);
                        ShiftAnswer.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }

                long y = Long.parseLong(b7);
                long bit1 = Long.parseLong(b8);
                String resultr = "";
                long b = y>>bit1;
                while(b>0)
                {
                    resultr = b%2 + resultr;
                    b = b/2;
                }
                ShiftAnswer.setText(b7 + " >> "  + b8  + " = " +  resultr );
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
            String gatestr = val1.getText().toString().trim();
            String gatestr2 = val2.getText().toString().trim();
            String gatestr3 = val3.getText().toString().trim();
            btnone.setEnabled(!gatestr.isEmpty());
            btntwo.setEnabled(!gatestr.isEmpty());
            btnRishift.setEnabled(!gatestr2.isEmpty() && !gatestr3.isEmpty());
            btnLeshift.setEnabled(!gatestr2.isEmpty() && !gatestr3.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {
            ShiftAnswer.setText(" ");
            complementAnswer.setText(" ");
            twos_complement.setText("");
        }
    };
}

