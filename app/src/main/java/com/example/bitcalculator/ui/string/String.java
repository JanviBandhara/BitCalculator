package com.example.bitcalculator.ui.string;

import android.content.Intent;
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

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.bitcalculator.MainActivity;
import com.example.bitcalculator.R;
import com.example.bitcalculator.String_learning;

import java.util.Arrays;

public class String extends Fragment {
    private EditText inputvalue;
    private Button btnbinarystr,learning;
    private TextView binarystrans,ascii_value;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_string, container, false);
        inputvalue = (EditText) v.findViewById(R.id.strinput);
        inputvalue.requestFocus();
        btnbinarystr = (Button) v.findViewById(R.id.strbin);
        learning = (Button) v.findViewById(R.id.btn_string_learn);
        binarystrans = (TextView) v.findViewById(R.id.strans);
        ascii_value = (TextView) v.findViewById(R.id.ascii);

        if(inputvalue.getText().toString().isEmpty())
        {
            btnbinarystr.setEnabled(false);
        }
        inputvalue.addTextChangedListener(buttontextwatcher);

        learning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), String_learning.class);
                ((MainActivity) getActivity()).startActivity(intent);

            }
        });

        btnbinarystr.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                java.lang.String str1 = inputvalue.getText().toString();
                byte[] bytes = str1.getBytes();
                StringBuilder binary = new StringBuilder();
                for (byte b : bytes) {
                    int val = b;
                    for (int i = 0; i < 8; i++) {
                        binary.append((val & 128) == 0 ? 0 : 1);
                        val <<= 1;
                    }
                    binary.append(' ');
                }
                //System.out.println("'" + s + "' to binary: " + binary);
                java.lang.String ascii_ans = "";
                byte[] bytes1 = str1.getBytes();
                //System.out.println("ASCII value of " + text + " is following");
                ascii_ans =  Arrays.toString(bytes1);
                ascii_value.setText("Ascii Value are " + ascii_ans);
                binarystrans.setText("Binary of Ascii value is :- "+binary);
                hideKeybaord(v);
            }
        });
        return v;
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
            java.lang.String gatestr = inputvalue.getText().toString().trim();
            btnbinarystr.setEnabled(!gatestr.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {
            binarystrans.setText(" ");
            ascii_value.setText("");
        }
    };

}
