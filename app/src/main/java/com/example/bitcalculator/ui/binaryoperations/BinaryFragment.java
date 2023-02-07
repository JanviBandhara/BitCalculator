package com.example.bitcalculator.ui.binaryoperations;

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

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.bitcalculator.Binary_learning;
import com.example.bitcalculator.MainActivity;
import com.example.bitcalculator.MainActivity2;
import com.example.bitcalculator.R;
//import com.example.bitcalculator.databinding.FragmentBinaryoperationBinding;
//import com.example.bitcalculator.ui.gallery.GalleryViewModel;

public class BinaryFragment extends Fragment implements View.OnClickListener{

    private EditText binvalue;
    private TextView binans;
    Button bbindec,bbinoct,bbinhex,learning;
    private LinearLayout l1;
    TextView title_d,title_b,title_o,title_h,title;
    private TextView d0,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15;
    private TextView bin0,bin1,bin2,bin3,bin4,bin5,bin6,bin7,bin8,bin9,bin10,bin11,bin12,bin13,bin14,bin15;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_binaryoperation,container,false);
        binvalue = (EditText) v.findViewById(R.id.binvalue);
        binvalue.requestFocus();
        binans = (TextView) v.findViewById(R.id.binoperationsans);
        bbindec = (Button) v.findViewById(R.id.btnbin_dec);
        bbinoct = (Button) v.findViewById(R.id.btnbin_octal);
        bbinhex = (Button) v.findViewById(R.id.btnbin_hexa);
        learning = (Button) v.findViewById(R.id.binary_learn);

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

        if(binvalue.getText().toString().isEmpty())
        {
            bbindec.setEnabled(false);
            bbinoct.setEnabled(false);
            bbinhex.setEnabled(false);
        }

        l1.setVisibility(INVISIBLE);

        binvalue.addTextChangedListener(buttontextwatcher);
        bbindec.setOnClickListener(this);
        bbinoct.setOnClickListener(this);
        bbinhex.setOnClickListener(this);
        learning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Binary_learning.class);
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
            case R.id.btnbin_dec:
                String binstr = binvalue.getText().toString();
                String Binarystr1 = "";
                for(int i = 0 ; i< binstr.length(); i++)
                {
                    if(binstr.charAt(i) != '0' && binstr.charAt(i) != '1')
                    {
                        binans.setText("Invalid Binary Number");
                        binans.setTextColor(Color.BLUE);
                        binans.setTextSize(25);
                        l1.setVisibility(v.INVISIBLE);

                        title.setText("");
                        //Toast.makeText(getActivity(),"Enter Values in 1 or 0",Toast.LENGTH_LONG).show();
                        break;
                    }
                    else
                    {
                        Binarystr1 = Binarystr1 + binstr.charAt(i);
                        //int binary1 = Integer.parseInt(binstr);
                        int temp = Integer.parseInt(Binarystr1);
                        int base = 1;
                        int dec_value = 0;
                        while (temp > 0) {
                            long last_digit = temp % 10;
                            temp = temp / 10;
                            dec_value += last_digit * base;
                            base = base * 2;
                        }
                        String bin_ans = Integer.toString(dec_value);
                        //int bindec = Integer.parseInt(String.valueOf(binary1));
                        binans.setText("Decimal :- "+Binarystr1+ " = "+String.valueOf(bin_ans));
                        binans.setTextColor(Color.BLACK);
                        l1.setVisibility(v.VISIBLE);

                        title.setText("Binary to Decimal Conversion Table");
                        title_d.setText("Binary");
                        title_b.setText("Decimal");
                    }
                }
                hideKeybaord(v);

                d0.setText("0000");
                d1.setText("0001");
                d2.setText("0010");
                d3.setText("0011");
                d4.setText("0100");
                d5.setText("0101");
                d6.setText("0110");
                d7.setText("0111");
                d8.setText("1000");
                d9.setText("1001");
                d10.setText("1010");
                d11.setText("1011");
                d12.setText("1100");
                d13.setText("1101");
                d14.setText("1110");
                d15.setText("1111");

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

            case R.id.btnbin_octal:
                String binstr1 = binvalue.getText().toString();
                String Octalstr1 = "";
                for(int i = 0 ; i< binstr1.length(); i++)
                {
                    if(binstr1.charAt(i) != '0' && binstr1.charAt(i) != '1')
                    {
                        binans.setText("Invalid Binary Number");
                        binans.setTextColor(Color.BLUE);
                        binans.setTextSize(25);
                        l1.setVisibility(v.INVISIBLE);

                        title.setText("");
                        //Toast.makeText(getActivity(),"Enter Values in 1 or 0",Toast.LENGTH_LONG).show();
                        break;
                    }
                    else
                    {
                        Octalstr1 = Octalstr1 + binstr1.charAt(i);
                        int binary1 = Integer.parseInt(Octalstr1,2);
                        String binoct = Integer.toOctalString(binary1);
                        binans.setText("Octal :- "+binstr1+ " = "+ binoct);
                        binans.setTextColor(Color.BLACK);
                        l1.setVisibility(v.VISIBLE);

                        title.setText("Binary to Octal Conversion Table");
                        title_d.setText("Binary");
                        title_b.setText("Octal");
                    }
                }
                hideKeybaord(v);

                d0.setText("0000");
                d1.setText("0001");
                d2.setText("0010");
                d3.setText("0011");
                d4.setText("0100");
                d5.setText("0101");
                d6.setText("0110");
                d7.setText("0111");
                d8.setText("1000");
                d9.setText("1001");
                d10.setText("1010");
                d11.setText("1011");
                d12.setText("1100");
                d13.setText("1101");
                d14.setText("1110");
                d15.setText("1111");

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

            case R.id.btnbin_hexa:
                String binstr2 = binvalue.getText().toString();
                String hexastr1 = "";
                for(int i = 0 ; i<binstr2.length(); i++)
                {
                    if(binstr2.charAt(i) != '0' && binstr2.charAt(i) != '1')
                    {
                        binans.setText("Invalid Binary Number");
                        binans.setTextColor(Color.BLUE);
                        binans.setTextSize(25);
                        l1.setVisibility(v.INVISIBLE);

                        title.setText("");
                        //Toast.makeText(getActivity(),"Enter Values in 1 or 0",Toast.LENGTH_LONG).show();
                        break;
                    }
                    else
                    {
                        hexastr1 = hexastr1 + binstr2.charAt(i);
                        int binary2 = Integer.parseInt(hexastr1,2);
                        String binhex = Integer.toHexString(binary2);
                        binans.setText("HexaDecimal :- "+binstr2 + " = "+binhex);
                        binans.setTextColor(Color.BLACK);
                        l1.setVisibility(v.VISIBLE);

                        title.setText("Binary to Hexa Conversion Table");
                        title_d.setText("Binary");
                        title_b.setText("Hexa");
                    }
                }
                hideKeybaord(v);

                d0.setText("0000");
                d1.setText("0001");
                d2.setText("0010");
                d3.setText("0011");
                d4.setText("0100");
                d5.setText("0101");
                d6.setText("0110");
                d7.setText("0111");
                d8.setText("1000");
                d9.setText("1001");
                d10.setText("1010");
                d11.setText("1011");
                d12.setText("1100");
                d13.setText("1101");
                d14.setText("1110");
                d15.setText("1111");

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
            /*case R.id.btnnext:
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                getActivity().startActivity(intent);*/
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
            String gatestr = binvalue.getText().toString().trim();
            bbindec.setEnabled(!gatestr.isEmpty() );
            bbinhex.setEnabled(!gatestr.isEmpty() );
            bbinoct.setEnabled(!gatestr.isEmpty() );
        }

        @Override
        public void afterTextChanged(Editable s) {
            binans.setText(" ");
            l1.setVisibility(INVISIBLE);
            title.setText("");
        }
    };
}