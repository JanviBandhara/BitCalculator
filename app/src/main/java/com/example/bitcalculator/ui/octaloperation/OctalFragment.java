package com.example.bitcalculator.ui.octaloperation;

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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.bitcalculator.MainActivity;
import com.example.bitcalculator.Octal_learning;
import com.example.bitcalculator.R;
import com.example.bitcalculator.databinding.FragmentGalleryBinding;
import com.example.bitcalculator.databinding.FragmentOctaloperationBinding;
//import com.example.bitcalculator.ui.binaryoperations.BinaryViewModel;

public class OctalFragment extends Fragment implements View.OnClickListener{
    private EditText octalValue;
    private TextView octaloperationsAns;
    Button boctodec,boctobin,boctohexa,learning;
    private LinearLayout l1;
    TextView title_d,title_b,title;
    private TextView d0,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15;
    private TextView bin0,bin1,bin2,bin3,bin4,bin5,bin6,bin7,bin8,bin9,bin10,bin11,bin12,bin13,bin14,bin15;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_octaloperation,container,false);
        boctodec = (Button) v.findViewById(R.id.btnoct_dec);
        boctobin = (Button) v.findViewById(R.id.btnoct_bin);
        boctohexa = (Button) v.findViewById(R.id.btnoct_hexa);
        learning = (Button) v.findViewById(R.id.octal_leaning);
        octalValue = (EditText) v.findViewById(R.id.octvalue);
        octalValue.requestFocus();
        octaloperationsAns = (TextView) v.findViewById(R.id.octans);

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

        if((octalValue.getText().toString().isEmpty()))
        {
            boctobin.setEnabled(false);
            boctohexa.setEnabled(false);
            boctodec.setEnabled(false);
        }
        octalValue.addTextChangedListener(buttontextwatcher);

        boctodec.setOnClickListener(this);
        boctobin.setOnClickListener(this);
        boctohexa.setOnClickListener(this);
        learning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Octal_learning.class);
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
            case R.id.btnoct_dec:
                String octostr = octalValue.getText().toString();
                String octalStr = "";
                int dec_value = 0;
                int last_digit = 0;
                for(int i = 0 ; i< octostr.length(); i++)
                {
                    if(octostr.charAt(i) != '0' && octostr.charAt(i) != '1'&& octostr.charAt(i) != '2' && octostr.charAt(i) != '3' && octostr.charAt(i) != '4' && octostr.charAt(i) != '5' && octostr.charAt(i) != '6' && octostr.charAt(i) != '7' && octostr.charAt(i) != '8' && octostr.charAt(i) != '9')
                    {
                        octaloperationsAns.setText("Invalid Octal Number");
                        octaloperationsAns.setTextColor(Color.BLUE);
                        octaloperationsAns.setTextSize(25);
                        l1.setVisibility(v.INVISIBLE);
                        title.setText("");
                        break;
                    }
                    else {
                        octalStr = octalStr + octostr.charAt(i);
                        int num = Integer.parseInt(octalStr);
                        int base = 1;

                        int temp = num;
                        while (temp > 0) {
                            last_digit = temp % 10;
                            temp = temp / 10;
                            dec_value += last_digit * base;
                            base = base * 8;
                        }
                        octaloperationsAns.setText("Decimal :- " + octostr + " = " + dec_value);
                        octaloperationsAns.setTextColor(Color.BLACK);
                        l1.setVisibility(v.VISIBLE);

                        title.setText("Octal to Decimal Conversion Table");
                        title_d.setText("Octal");
                        title_b.setText("Decimal");
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
                d8.setText("10");
                d9.setText("11");
                d10.setText("12");
                d11.setText("13");
                d12.setText("14");
                d13.setText("15");
                d14.setText("16");
                d15.setText("17");

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

            case R.id.btnoct_bin:
                String octostr1 = octalValue.getText().toString();
                String octalStr1 = "";
                int dec_value1 = 0;
                int last_digit1 = 0;
                for(int i = 0 ; i< octostr1.length(); i++) {
                    if (octostr1.charAt(i) != '0' && octostr1.charAt(i) != '1' && octostr1.charAt(i) != '2' && octostr1.charAt(i) != '3' && octostr1.charAt(i) != '4' && octostr1.charAt(i) != '5' && octostr1.charAt(i) != '6' && octostr1.charAt(i) != '7' && octostr1.charAt(i) != '8' && octostr1.charAt(i) != '9') {
                        octaloperationsAns.setText("Invalid Octal Number");
                        octaloperationsAns.setTextColor(Color.BLUE);
                        octaloperationsAns.setTextSize(25);
                        l1.setVisibility(v.INVISIBLE);
                        title.setText("");
                        break;
                    } else {
                        octalStr1 = octalStr1 + octostr1.charAt(i);
                        int num = Integer.parseInt(octalStr1);
                        int base = 1;

                        int temp = num;
                        while (temp > 0) {
                            last_digit1 = temp % 10;
                            temp = temp / 10;
                            dec_value1 += last_digit1 * base;
                            base = base * 8;
                        }
                    }
                    String bin = "";
                    if(dec_value1 == 0)
                    {
                        octaloperationsAns.setText("Binary :- "+octostr1 +" = "+"0");
                        octaloperationsAns.setTextColor(Color.BLACK);
                        l1.setVisibility(v.VISIBLE);
                        title.setText("Octal to Binary Conversion Table");
                        title_d.setText("Octal");
                        title_b.setText("Binary");
                    }
                    else
                    {
                        int rem = 0;
                        while (dec_value1 != 0)
                        {
                            rem = rem % 2;
                            bin = rem + bin;
                            dec_value1 /= 2;
                        }

                        l1.setVisibility(v.VISIBLE);

                        octaloperationsAns.setText("Decimal :- " + octostr1 + " = " + bin);
                        octaloperationsAns.setTextColor(Color.BLACK);
                        title.setText("Octal to Binary Conversion Table");
                        title_d.setText("Octal");
                        title_b.setText("Binary");
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
                d8.setText("10");
                d9.setText("11");
                d10.setText("12");
                d11.setText("13");
                d12.setText("14");
                d13.setText("15");
                d14.setText("16");
                d15.setText("17");

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

            case R.id.btnoct_hexa:
                String octostr2 = octalValue.getText().toString();

                String HexaStr1 = "";
                int dec_value2 = 0;
                int last_digit2 = 0;
                for(int i = 0 ; i< octostr2.length(); i++) {
                    if (octostr2.charAt(i) != '0' && octostr2.charAt(i) != '1' && octostr2.charAt(i) != '2' && octostr2.charAt(i) != '3' && octostr2.charAt(i) != '4' && octostr2.charAt(i) != '5' && octostr2.charAt(i) != '6' && octostr2.charAt(i) != '7' && octostr2.charAt(i) != '8' && octostr2.charAt(i) != '9') {
                        octaloperationsAns.setText("Invalid Octal Number");
                        octaloperationsAns.setTextColor(Color.BLUE);
                        octaloperationsAns.setTextSize(25);
                        l1.setVisibility(v.INVISIBLE);
                        title.setText("");
                        break;
                    } else {
                        HexaStr1 = HexaStr1 + octostr2.charAt(i);
                        int num = Integer.parseInt(HexaStr1);
                        int base = 1;

                        int temp = num;
                        while (temp > 0) {
                            last_digit2 = temp % 10;
                            temp = temp / 10;
                            dec_value2 += last_digit2 * base;
                            base = base * 8;
                        }
                    }
                    String bin = "";
                    if(dec_value2 == 0)
                    {
                        octaloperationsAns.setText("HexaDecimal :- "+octostr2 +" = "+"0");
                        octaloperationsAns.setTextColor(Color.BLACK);
                        l1.setVisibility(v.VISIBLE);
                        title.setText("Octal to Binary Conversion Table");
                        title_d.setText("Octal");
                        title_b.setText("Binary");
                    }
                    else
                    {
                        int rem = 0;
                        String hex = "";
                        char hexchar[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
                        while (dec_value2 != 0)
                        {
                            rem = dec_value2 % 16;
                            hex = hexchar[rem] + hex;
                            dec_value2 /= 16;
                        }

                        l1.setVisibility(v.VISIBLE);

                        octaloperationsAns.setText("HexaDecimal :- " + octostr2 + " = " + hex);
                        octaloperationsAns.setTextColor(Color.BLACK);
                        title.setText("Octal to Hexa Conversion Table");
                        title_d.setText("Octal");
                        title_b.setText("HexaDecimal");
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
                d8.setText("10");
                d9.setText("11");
                d10.setText("12");
                d11.setText("13");
                d12.setText("14");
                d13.setText("15");
                d14.setText("16");
                d15.setText("17");

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
                bin10.setText("A");
                bin11.setText("B");
                bin12.setText("C");
                bin13.setText("D");
                bin14.setText("E");
                bin15.setText("F");

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
            String gatestr = octalValue.getText().toString().trim();
            boctobin.setEnabled(!gatestr.isEmpty());
            boctodec.setEnabled(!gatestr.isEmpty());
            boctohexa.setEnabled(!gatestr.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {
            octaloperationsAns.setText(" ");
            title.setText(" ");
            l1.setVisibility(INVISIBLE);
        }
    };
}