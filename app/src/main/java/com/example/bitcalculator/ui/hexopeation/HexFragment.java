package com.example.bitcalculator.ui.hexopeation;

import static android.view.View.INVISIBLE;

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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Observer;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bitcalculator.Hexa_learning;
import com.example.bitcalculator.MainActivity;
import com.example.bitcalculator.R;
import com.example.bitcalculator.databinding.FragmentGalleryBinding;
import com.example.bitcalculator.databinding.FragmentHexoperationBinding;
//import com.example.bitcalculator.ui.binaryoperations.BinaryViewModel;

public class HexFragment extends Fragment implements View.OnClickListener {
    private EditText hexaval1;
    private TextView hexaoutput;
    private Button bhexdec,bhexbin,bhexoct,learning;
    private LinearLayout l1;
    TextView title_d,title_b,title_o,title_h,title;
    private TextView d0,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15;
    private TextView bin0,bin1,bin2,bin3,bin4,bin5,bin6,bin7,bin8,bin9,bin10,bin11,bin12,bin13,bin14,bin15;

    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_hexoperation, container, false);
        hexaval1 = (EditText) v.findViewById(R.id.hexvalue);
        hexaval1.requestFocus();
        hexaoutput = (TextView) v.findViewById(R.id.hexans);
        bhexdec = (Button) v.findViewById(R.id.btnhex_dec);
        bhexbin = (Button) v.findViewById(R.id.btnhex_bin);
        bhexoct = (Button) v.findViewById(R.id.btnhex_oct);
        learning = (Button) v.findViewById(R.id.hex_learning);

        l1 = (LinearLayout) v.findViewById(R.id.table);

        title = (TextView) v.findViewById(R.id.main_title);
        title_d = (TextView) v.findViewById(R.id.dec_title);
        title_b = (TextView) v.findViewById(R.id.bin_title);

        d0 = (TextView) v.findViewById(R.id.d0);
        d1 = (TextView) v.findViewById(R.id.d1);
        d2 = (TextView) v.findViewById(R.id.d2);
        d3 = (TextView) v.findViewById(R.id.d3);
        d4 = (TextView) v.findViewById(R.id.d4);
        d5 = (TextView) v.findViewById(R.id.d5);
        d6 = (TextView) v.findViewById(R.id.d6);
        d7 = (TextView) v.findViewById(R.id.d7);
        d8 = (TextView) v.findViewById(R.id.d8);
        d9 = (TextView) v.findViewById(R.id.d9);
        d10 = (TextView) v.findViewById(R.id.d10);
        d11 = (TextView) v.findViewById(R.id.d11);
        d12 = (TextView) v.findViewById(R.id.d12);
        d13 = (TextView) v.findViewById(R.id.d13);
        d14 = (TextView) v.findViewById(R.id.d14);
        d15 = (TextView) v.findViewById(R.id.d15);

        bin0 = (TextView) v.findViewById(R.id.bin0);
        bin1= (TextView) v.findViewById(R.id.bin1);
        bin2= (TextView) v.findViewById(R.id.bin2);
        bin3= (TextView) v.findViewById(R.id.bin3);
        bin4 = (TextView) v.findViewById(R.id.bin4);
        bin5= (TextView) v.findViewById(R.id.bin5);
        bin6= (TextView) v.findViewById(R.id.bin6);
        bin7= (TextView) v.findViewById(R.id.bin7);
        bin8 = (TextView) v.findViewById(R.id.bin8);
        bin9= (TextView) v.findViewById(R.id.bin9);
        bin10= (TextView) v.findViewById(R.id.bin10);
        bin11= (TextView) v.findViewById(R.id.bin11);
        bin12 = (TextView) v.findViewById(R.id.bin12);
        bin13= (TextView) v.findViewById(R.id.bin13);
        bin14= (TextView) v.findViewById(R.id.bin14);
        bin15= (TextView) v.findViewById(R.id.bin15);

        if((hexaval1.getText().toString().isEmpty()))
        {
            bhexbin.setEnabled(false);
            bhexdec.setEnabled(false);
            bhexoct.setEnabled(false);
        }
        hexaval1.addTextChangedListener(buttontextwatcher);

        bhexdec.setOnClickListener(this);
        bhexbin.setOnClickListener(this);
        bhexoct.setOnClickListener(this);
        learning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Hexa_learning.class);
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
            case R.id.btnhex_dec:
                String input = hexaval1.getText().toString();
                String str1 = "";
                for (int i = 0 ; i <= input.length()-1; i++)
                {
                    if(input.charAt(i) >='G' && input.charAt(i)<='Z' || input.charAt(i) >='g' && input.charAt(i)<='z' || input.charAt(i) == '.' || input.charAt(i) == ',' || input.charAt(i) == '-'  )
                    {
                        hexaoutput.setText("Invalid HexaDecimal Value");
                        hexaoutput.setTextColor(Color.BLUE);
                        hexaoutput.setTextSize(25);
                        l1.setVisibility(v.INVISIBLE);
                        title.setText("");
                        break;
                    }
                    else
                    {
                        String digits = "0123456789ABCDEF";
                        input = input.toUpperCase();
                        int val = 0;
                        for (int j = 0; j < input.length(); j++)
                        {
                            char c = input.charAt(j);
                            int d = digits.indexOf(c);
                            val = 16*val + d;
                            hexaoutput.setText("Decimal :- "+input + " = " + val );
                            hexaoutput.setTextColor(Color.BLACK);
                            l1.setVisibility(v.VISIBLE);

                            title.setText("Hexa to Decimal Conversion Table");
                            title_d.setText("Hexa");
                            title_b.setText("Decimal");
                            }
                        }
                    }
                hideKeybaord(v);

                d0.setText("0");
                d1.setText("1");
                d2.setText("2");
                d3.setText("3");
                d4.setText("4");
                d5.setText("5");
                d6.setText("6");
                d7.setText("7");
                d8.setText("8");
                d9.setText("9");
                d10.setText("A");
                d11.setText("B");
                d12.setText("C");
                d13.setText("D");
                d14.setText("E");
                d15.setText("F");

                bin0.setText("0");
                bin1.setText("1");
                bin2.setText("2");
                bin3.setText("3");
                bin4.setText("4");
                bin5.setText("5");
                bin6.setText("6");
                bin7.setText("7");
                bin8.setText("8");
                bin9.setText("9");
                bin10.setText("10");
                bin11.setText("11");
                bin12.setText("12");
                bin13.setText("13");
                bin14.setText("14");
                bin15.setText("15");

                break;

            case R.id.btnhex_bin:
                String hexostr1 = hexaval1.getText().toString();
                for (int i = 0 ; i <= hexostr1.length()-1; i++)
                {
                    if(hexostr1.charAt(i) >='G' && hexostr1.charAt(i)<='Z' || hexostr1.charAt(i) >='g' && hexostr1.charAt(i)<='z' || hexostr1.charAt(i) == '.' || hexostr1.charAt(i) == ',' || hexostr1.charAt(i) == '-'  )
                    {
                        hexaoutput.setText("Invalid HexaDecimal Value");
                        hexaoutput.setTextColor(Color.BLUE);
                        hexaoutput.setTextSize(25);
                        l1.setVisibility(v.INVISIBLE);
                        title.setText("");
                        break;
                    }
                    else
                    {
                        String digits = "0123456789ABCDEF";
                        hexostr1 = hexostr1.toUpperCase();
                        int val = 0;
                        for (int j = 0; j < hexostr1.length(); j++)
                        {
                            char c = hexostr1.charAt(j);
                            int d = digits.indexOf(c);
                            val = 16*val + d;
                        }
                        String bin = "";
                        int rem = 0;
                        if(val == 0)
                        {
                            hexaoutput.setText("Binary :- "+hexostr1 +" = "+"0");
                            hexaoutput.setTextColor(Color.BLACK);
                            l1.setVisibility(v.VISIBLE);
                            title.setText("Hexa to Decimal Conversion Table");
                            title_d.setText("Hexa");
                            title_b.setText("Decimal");
                        }
                        else {
                            while (val != 0) {
                                rem = val % 2;
                                bin = rem + bin;
                                val /= 2;
                            }
                            hexaoutput.setText("Binary :- " + hexostr1 + " = " + bin);
                            hexaoutput.setTextColor(Color.BLACK);
                            l1.setVisibility(v.VISIBLE);
                            title.setText("Hexa to Decimal Conversion Table");
                            title_d.setText("Hexa");
                            title_b.setText("Decimal");
                        }
                    }
                }
                hideKeybaord(v);

                d0.setText("0");
                d1.setText("1");
                d2.setText("2");
                d3.setText("3");
                d4.setText("4");
                d5.setText("5");
                d6.setText("6");
                d7.setText("7");
                d8.setText("8");
                d9.setText("9");
                d10.setText("A");
                d11.setText("B");
                d12.setText("C");
                d13.setText("D");
                d14.setText("E");
                d15.setText("F");

                bin0.setText("0000");
                bin1.setText("0001");
                bin2.setText("0010");
                bin3.setText("0011");
                bin4.setText("0100");
                bin5.setText("0101");
                bin6.setText("0110");
                bin7.setText("0111");
                bin8.setText("1000");
                bin9.setText("1001");
                bin10.setText("1010");
                bin11.setText("1011");
                bin12.setText("1100");
                bin13.setText("1101");
                bin14.setText("1110");
                bin15.setText("1111");

                break;

            case R.id.btnhex_oct:
                String hexostr2 = hexaval1.getText().toString();
                for (int i = 0 ; i <= hexostr2.length()-1; i++) {
                    if (hexostr2.charAt(i) >= 'G' && hexostr2.charAt(i) <= 'Z' || hexostr2.charAt(i) >= 'g' && hexostr2.charAt(i) <= 'z' || hexostr2.charAt(i) == '.' || hexostr2.charAt(i) == ',' || hexostr2.charAt(i) == '-') {
                        hexaoutput.setText("Invalid HexaDecimal Value");
                        hexaoutput.setTextColor(Color.BLUE);
                        hexaoutput.setTextSize(25);
                        l1.setVisibility(v.INVISIBLE);
                        title.setText("");
                        break;
                    } else {
                        String digits = "0123456789ABCDEF";
                        hexostr2 = hexostr2.toUpperCase();
                        int val = 0;
                        for (int j = 0; j < hexostr2.length(); j++) {
                            char c = hexostr2.charAt(j);
                            int d = digits.indexOf(c);
                            val = 16 * val + d;
                        }
                        String bin = "";
                        int rem = 0;
                        if (val == 0) {
                            hexaoutput.setText("Octal :- " + hexostr2 + " = " + "0");
                            hexaoutput.setTextColor(Color.BLACK);
                            l1.setVisibility(v.VISIBLE);
                            title.setText("Hexa to Decimal Conversion Table");
                            title_d.setText("Hexa");
                            title_b.setText("Decimal");
                        } else {
                            while (val != 0) {
                                rem = val % 8;
                                bin = rem + bin;
                                val /= 8;
                            }
                            hexaoutput.setText("Octal :- " + hexostr2 + " = " + bin);
                            hexaoutput.setTextColor(Color.BLACK);
                            l1.setVisibility(v.VISIBLE);
                            title.setText("Hexa to Decimal Conversion Table");
                            title_d.setText("Hexa");
                            title_b.setText("Decimal");
                        }
                    }
                }
                hideKeybaord(v);

                d0.setText("0");
                d1.setText("1");
                d2.setText("2");
                d3.setText("3");
                d4.setText("4");
                d5.setText("5");
                d6.setText("6");
                d7.setText("7");
                d8.setText("8");
                d9.setText("9");
                d10.setText("A");
                d11.setText("B");
                d12.setText("C");
                d13.setText("D");
                d14.setText("E");
                d15.setText("F");

                bin0.setText("0");
                bin1.setText("1");
                bin2.setText("2");
                bin3.setText("3");
                bin4.setText("4");
                bin5.setText("5");
                bin6.setText("6");
                bin7.setText("7");
                bin8.setText("10");
                bin9.setText("11");
                bin10.setText("12");
                bin11.setText("13");
                bin12.setText("14");
                bin13.setText("15");
                bin14.setText("16");
                bin15.setText("17");

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
            String gatestr = hexaval1.getText().toString().trim();
            bhexbin.setEnabled(!gatestr.isEmpty());
            bhexdec.setEnabled(!gatestr.isEmpty());
            bhexoct.setEnabled(!gatestr.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

            hexaoutput.setText(" ");
            title.setText("");
            l1.setVisibility(INVISIBLE);
        }
    };
}