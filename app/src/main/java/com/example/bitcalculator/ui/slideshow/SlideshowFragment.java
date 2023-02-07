package com.example.bitcalculator.ui.slideshow;

import static android.view.View.INVISIBLE;

import android.content.Intent;
import android.graphics.Color;
import android.icu.number.IntegerWidth;
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
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.bitcalculator.Decimal_learning;
import com.example.bitcalculator.MainActivity;
import com.example.bitcalculator.R;
//import com.example.bitcalculator.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment implements View.OnClickListener
{
    private EditText val1;
    private TextView binoutput;
    private Button b,btn,bhexa,dec_learn;
    private LinearLayout l1;
    TextView title_d,title_b,title;
    private TextView d0,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15;
    private TextView bin0,bin1,bin2,bin3,bin4,bin5,bin6,bin7,bin8,bin9,bin10,bin11,bin12,bin13,bin14,bin15;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_slideshow, container, false);
        val1 = (EditText) v.findViewById(R.id.decvalue);
        val1.requestFocus();
        binoutput = (TextView) v.findViewById(R.id.binaryans);

        b = (Button) v.findViewById(R.id.btndec_binary);
        btn = (Button) v.findViewById(R.id.btndec_octal);
        bhexa = (Button) v.findViewById(R.id.btndec_hexa);
        dec_learn = (Button) v.findViewById(R.id.btn_dec_learn);

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

        if((val1.getText().toString().isEmpty()))
        {
            b.setEnabled(false);
            btn.setEnabled(false);
            bhexa.setEnabled(false);
        }
        l1.setVisibility(INVISIBLE);
        val1.addTextChangedListener(buttontextwatcher);

        b.setOnClickListener(this);
        btn.setOnClickListener(this);
        bhexa.setOnClickListener(this);
        dec_learn.setOnClickListener(this);
        return v;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btndec_binary:
                //Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
                String edittostr = val1.getText().toString();
                String bin = "";
                String temp = "";

                for (int cntr=0; cntr<=edittostr.length()-1;cntr++)
                {
                    char c = edittostr.charAt(cntr);
                    if(c=='0' || c=='1'|| c=='2'|| c=='3'|| c=='4'|| c=='5'|| c=='6'|| c=='7'|| c=='8'|| c=='9')
                    {

                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        binoutput.setText("Invalid Decimal Number..!!");
                        binoutput.setTextColor(Color.BLUE);
                        binoutput.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                Long num = Long.parseLong(edittostr);
                if(num == 0)
                {
                    binoutput.setText("Binary :- "+edittostr +" = "+"0");
                }
                else
                {
                    while (num != 0)
                    {
                        Long rem = num % 2;
                        bin = rem + bin;
                        num /= 2;
                    }
                    binoutput.setText("Binary :- "+edittostr +" = "+bin);
                }

                hideKeybaord(v);

                l1.setVisibility(v.VISIBLE);

                title.setText("Decimal to Binary Conversion Table");
                title_d.setText("Decimal");
                title_b.setText("Binary");

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
                d10.setText("10");
                d11.setText("11");
                d12.setText("12");
                d13.setText("13");
                d14.setText("14");
                d15.setText("15");

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

            case R.id.btndec_octal:
                String octtostr = val1.getText().toString();
                String oct = "";

                for (int cntr=0; cntr<=octtostr.length()-1;cntr++)
                {
                    char c = octtostr.charAt(cntr);
                    if(c=='0' || c=='1'|| c=='2'|| c=='3'|| c=='4'|| c=='5'|| c=='6'|| c=='7'|| c=='8'|| c=='9')
                    {
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        binoutput.setText("Invalid Decimal Number..!!");
                        binoutput.setTextColor(Color.BLUE);
                        binoutput.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                int num1 = Integer.parseInt(octtostr);
                if(num1 == 0)
                {
                    binoutput.setText("Octal :- "+octtostr +" = "+"0");
                }
                else
                {
                    while (num1 != 0)
                    {
                        int rem = num1 % 8;
                        oct = rem + oct;
                        num1 /= 8;
                    }
                    binoutput.setText("Octal :- "+ octtostr+ " = "+oct);
                }
                l1.setVisibility(v.VISIBLE);
                hideKeybaord(v);

                title.setText("Decimal & Octal Table");
                title_d.setText("Decimal");
                title_b.setText("Octal");

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
                d10.setText("10");
                d11.setText("11");
                d12.setText("12");
                d13.setText("13");
                d14.setText("14");
                d15.setText("15");

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

            case R.id.btndec_hexa:
                char hexchar[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
                String hextostr = val1.getText().toString();
                for (int cntr=0; cntr<=hextostr.length()-1;cntr++)
                {
                    char c = hextostr.charAt(cntr);
                    if(c=='0' || c=='1'|| c=='2'|| c=='3'|| c=='4'|| c=='5'|| c=='6'|| c=='7'|| c=='8'|| c=='9')
                    {
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        binoutput.setText("Invalid Decimal Number..!!");
                        binoutput.setTextColor(Color.BLUE);
                        binoutput.setTextSize(25);
                        //Toast.makeText(getActivity(),"Invalid Binary Number, Enter Again..!!",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                String hex = "";
                int num2 = Integer.parseInt(hextostr);
                if(num2 == 0)
                {
                    binoutput.setText("Octal :- "+hextostr +" = "+"0");
                }
                else
                {
                    while (num2 != 0)
                    {
                        int rem = num2 % 16;
                        hex = hexchar[rem] + hex;
                        num2 /= 16;
                    }
                    binoutput.setText("HexaDecimal :- "+hextostr+ " = "+hex);
                }
                hideKeybaord(v);

                l1.setVisibility(v.VISIBLE);

                title.setText("Decimal & HexaDecimal Table");
                title_d.setText("Decimal");
                title_b.setText("Hexa");

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
                d10.setText("10");
                d11.setText("11");
                d12.setText("12");
                d13.setText("13");
                d14.setText("14");
                d15.setText("15");

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
                bin15.setText("F");;
                break;

            case R.id.btn_dec_learn:
                Intent intent = new Intent(getActivity(), Decimal_learning.class);
                ((MainActivity) getActivity()).startActivity(intent);
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
            b.setEnabled(!gatestr.isEmpty());
            btn.setEnabled(!gatestr.isEmpty());
            bhexa.setEnabled(!gatestr.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {
            binoutput.setText(" ");
            title.setText("");
            l1.setVisibility(INVISIBLE);
        }
    };
}
