package com.example.bitcalculator.ui.gallery;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.bitcalculator.R;
//import com.example.bitcalculator.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment implements View.OnClickListener{

    private EditText val1,val2;
    Button btnadd,bsub,bmutli,bdiv,bzero,bone;
    TextView binopeartion;
    LinearLayout add_l1;
    TextView title,a_title,b_title,sum_title,carry_title,a_firstV,b_firstV,sum_firstV,carry_firstV,a_secondV,b_secondV,sum_secondV,carry_secondV,a_thirdV,b_thirdV,sum_thirdV,carry_thirdV,a_fourthV,b_fourthV,sum_fourthV,carry_fourthV;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gallery,container,false);
        val1 = (EditText) v.findViewById(R.id.num1);
        val2 = (EditText) v.findViewById(R.id.num2);
        val2.requestFocus();
        val1.requestFocus();
        btnadd = (Button) v.findViewById(R.id.btnplus);
        bsub = (Button) v.findViewById(R.id.btnminus);
        bmutli = (Button) v.findViewById(R.id.btnmul);
        bdiv = (Button) v.findViewById(R.id.btndiv);
        binopeartion = (TextView) v.findViewById(R.id.binoperans);
        add_l1 = (LinearLayout) v.findViewById(R.id.addition_table);
        title =(TextView) v.findViewById(R.id.Add_title);
        a_title =(TextView) v.findViewById(R.id.first_value);
        b_title =(TextView) v.findViewById(R.id.second_value);
        sum_title =(TextView) v.findViewById(R.id.third_value);
        carry_title =(TextView) v.findViewById(R.id.fourth_value);
        a_firstV =(TextView) v.findViewById(R.id.A_first_zero);
        b_firstV =(TextView) v.findViewById(R.id.B_first_zero);
        sum_firstV =(TextView) v.findViewById(R.id.sum_first_zero);
        carry_firstV =(TextView) v.findViewById(R.id.carry_first_zero);
        a_secondV =(TextView) v.findViewById(R.id.A_second_zero);
        b_secondV =(TextView) v.findViewById(R.id.B_second_zero);
        sum_secondV =(TextView) v.findViewById(R.id.sum_second_zero);
        carry_secondV =(TextView) v.findViewById(R.id.carry_second_zero);
        a_thirdV =(TextView) v.findViewById(R.id.A_third_zero);
        b_thirdV =(TextView) v.findViewById(R.id.B_third_zero);
        sum_thirdV =(TextView) v.findViewById(R.id.sum_third_zero);
        carry_thirdV =(TextView) v.findViewById(R.id.carry_third_zero);
        a_fourthV =(TextView) v.findViewById(R.id.A_fourth_zero);
        b_fourthV =(TextView) v.findViewById(R.id.B_fourth_zero);
        sum_fourthV =(TextView) v.findViewById(R.id.sum_fourth_zero);
        carry_fourthV =(TextView) v.findViewById(R.id.carry_fourth_zero);

        if((val1.getText().toString().isEmpty()) &&(val2.getText().toString().isEmpty()))
        {
            btnadd.setEnabled(false);
            bsub.setEnabled(false);
            bmutli.setEnabled(false);
            bdiv.setEnabled(false);
        }
        val1.addTextChangedListener(buttontextwatcher);
        val2.addTextChangedListener(buttontextwatcher);

        add_l1.setVisibility(v.INVISIBLE);

        btnadd.setOnClickListener(this);
        bsub.setOnClickListener(this);
        bmutli.setOnClickListener(this);
        bdiv.setOnClickListener(this);
        return v;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnplus:
                String b1 = val1.getText().toString();
                String b2 = val2.getText().toString();
                int len = b1.length();
                int len2 = b2.length();

                for (int cntr=0;cntr<len;cntr++)
                {
                    char c = b1.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        binopeartion.setText("Invalid Binary Number..!!");
                        binopeartion.setTextColor(Color.BLUE);
                        binopeartion.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                for (int cntr=0;cntr<len2;cntr++)
                {
                    char c = b2.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        binopeartion.setText("Invalid Binary Number..!!");
                        binopeartion.setTextColor(Color.BLUE);
                        binopeartion.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                int num1 = Integer.parseInt(b1,2);
                int num2 = Integer.parseInt(b2,2);
                int sum = num1 + num2;
                String ans = Integer.toBinaryString(sum);
                binopeartion.setText(b1 + " + " + b2 + " = " + ans);
                binopeartion.setTextColor(Color.BLACK);
                add_l1.setVisibility(VISIBLE);
                hideKeybaord(v);

                title.setText("Binary Addition Table");
                a_title.setText("A");
                b_title.setText("B");
                sum_title.setText("SUM");
                carry_title.setText("CARRY");

                a_firstV.setText("0");
                b_firstV.setText("0");
                sum_firstV.setText("0");
                carry_firstV.setText("0");

                a_secondV.setText("0");
                b_secondV.setText("1");
                sum_secondV.setText("1");
                carry_secondV.setText("0");

                a_thirdV.setText("1");
                b_thirdV.setText("0");
                sum_thirdV.setText("1");
                carry_thirdV.setText("0");

                a_fourthV.setText("1");
                b_fourthV.setText("1");
                sum_fourthV.setText("0");
                carry_fourthV.setText("1");

                break;

            case R.id.btnminus:
                String b3 = val1.getText().toString();
                String b4 = val2.getText().toString();

                for (int cntr=0;cntr<b3.length();cntr++)
                {
                    char c = b3.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        binopeartion.setText("Invalid Binary Number..!!");
                        binopeartion.setTextColor(Color.BLUE);
                        binopeartion.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                for (int cntr=0;cntr<b4.length();cntr++)
                {
                    char c = b4.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        binopeartion.setText("Invalid Binary Number..!!");
                        binopeartion.setTextColor(Color.BLUE);
                        binopeartion.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }

                int num3 = Integer.parseInt(b3,2);
                int num4 = Integer.parseInt(b4,2);
                int sum1 = num3 - num4;
                if(num3 <= num4)
                {
                    //Toast.makeText(getActivity(),"Number 1 shouldn't be greater then Number2..!!",Toast.LENGTH_LONG).show();
                    sum1 = num4 - num3;
                    String ans1 = Integer.toBinaryString(sum1);
                    binopeartion.setText(b3 + " - " + b4 + " = " + "-"+ans1);
                    binopeartion.setTextColor(Color.BLACK);
                    add_l1.setVisibility(VISIBLE);
                }
                else
                {
                    String ans1 = Integer.toBinaryString(sum1);
                    binopeartion.setText(b3 + " - " + b4 + " = " + ans1);
                    binopeartion.setTextColor(Color.BLACK);
                    add_l1.setVisibility(VISIBLE);
                }

                hideKeybaord(v);

                title.setText("Binary Subtraction Table");
                a_title.setText("A");
                b_title.setText("B");
                sum_title.setText("DIFF");
                carry_title.setText("Borrow");

                a_firstV.setText("0");
                b_firstV.setText("0");
                sum_firstV.setText("0");
                carry_firstV.setText("0");

                a_secondV.setText("1");
                b_secondV.setText("0");
                sum_secondV.setText("1");
                carry_secondV.setText("0");

                a_thirdV.setText("0");
                b_thirdV.setText("1");
                sum_thirdV.setText("1");
                carry_thirdV.setText("1");

                a_fourthV.setText("1");
                b_fourthV.setText("1");
                sum_fourthV.setText("0");
                carry_fourthV.setText("0");
                break;

            case R.id.btnmul:
                String b5 = val1.getText().toString();
                String b6 = val2.getText().toString();

                for (int cntr=0;cntr<b5.length();cntr++)
                {
                    char c = b5.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        binopeartion.setText("Invalid Binary Number..!!");
                        binopeartion.setTextColor(Color.BLUE);
                        binopeartion.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                for (int cntr=0;cntr<b6.length();cntr++)
                {
                    char c = b6.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        binopeartion.setText("Invalid Binary Number..!!");
                        binopeartion.setTextColor(Color.BLUE);
                        binopeartion.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }

                int num5 = Integer.parseInt(b5,2);
                int num6 = Integer.parseInt(b6,2);
                int sum2 = num5 * num6;
                String ans2 = Integer.toBinaryString(sum2);
                binopeartion.setText(b5 + " * " + b6 + " = " + ans2);
                binopeartion.setTextColor(Color.BLACK);
                add_l1.setVisibility(VISIBLE);
                hideKeybaord(v);

                title.setText("Binary Multiplication Table");
                a_title.setText("Case");
                b_title.setText("A");
                sum_title.setText("B");
                carry_title.setText("Multiply");

                a_firstV.setText("1)");
                b_firstV.setText("0");
                sum_firstV.setText("0");
                carry_firstV.setText("0");

                a_secondV.setText("2)");
                b_secondV.setText("0");
                sum_secondV.setText("1");
                carry_secondV.setText("0");

                a_thirdV.setText("3)");
                b_thirdV.setText("1");
                sum_thirdV.setText("0");
                carry_thirdV.setText("0");

                a_fourthV.setText("4)");
                b_fourthV.setText("1");
                sum_fourthV.setText("1");
                carry_fourthV.setText("1");

                break;

            case R.id.btndiv:
                String b7 = val1.getText().toString();
                String b8 = val2.getText().toString();

                for (int cntr=0;cntr<b7.length();cntr++)
                {
                    char c = b7.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        binopeartion.setText("Invalid Binary Number..!!");
                        binopeartion.setTextColor(Color.BLUE);
                        binopeartion.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                for (int cntr=0;cntr<b8.length();cntr++)
                {
                    char c = b8.charAt(cntr);
                    if(c=='0' || c=='1')
                    {
                    }
                    else
                    {
                        binopeartion.setText("Invalid Binary Number..!!");
                        binopeartion.setTextColor(Color.BLUE);
                        binopeartion.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }

                int num7 = Integer.parseInt(b7,2);
                int num8 = Integer.parseInt(b8,2);
                if(num8 == 0)
                {
                    //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                    binopeartion.setText("Can't Divide by 0");
                    binopeartion.setTextColor(Color.RED);
                    binopeartion.setTextSize(25);
                    title.setText("");
                }
                else {
                    int sum3 = num7 / num8;
                    String ans3 = Integer.toBinaryString(sum3);
                    binopeartion.setText(b7 + " / " + b8 + " = " + ans3);
                    add_l1.setVisibility(VISIBLE);
                    binopeartion.setTextColor(Color.BLACK);
                    title.setText("Binary Division Table");
                }
                hideKeybaord(v);


                a_title.setText("Case");
                b_title.setText("DIVIDEND");
                sum_title.setText("DIVISOR");
                carry_title.setText("RESULT");

                a_firstV.setText("1)");
                b_firstV.setText("0");
                sum_firstV.setText("1");
                carry_firstV.setText("0");

                a_secondV.setText("2)");
                b_secondV.setText("1");
                sum_secondV.setText("1");
                carry_secondV.setText("1");

                a_thirdV.setText("3)");
                b_thirdV.setText("0");
                sum_thirdV.setText("0");
                carry_thirdV.setText("Not Valid");

                a_fourthV.setText("4)");
                b_fourthV.setText("1");
                sum_fourthV.setText("0");
                carry_fourthV.setText("Not Valid");
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
            btnadd.setEnabled(!gatestr.isEmpty() && !gatestr2.isEmpty());
            bsub.setEnabled(!gatestr.isEmpty() && !gatestr2.isEmpty());
            bmutli.setEnabled(!gatestr.isEmpty() && !gatestr2.isEmpty());
            bdiv.setEnabled(!gatestr.isEmpty() && !gatestr2.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {
            binopeartion.setText(" ");
            title.setText(" ");
            add_l1.setVisibility(INVISIBLE);
        }
    };
}