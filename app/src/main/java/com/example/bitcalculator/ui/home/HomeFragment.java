package com.example.bitcalculator.ui.home;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.bitcalculator.R;

import java.text.DecimalFormat;
//import com.example.bitcalculator.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private Button btnzero,btnone,btntwo,btnthree,btnfour,btnfive,btnsix,btnseven,btneight,btnnine,btnadd,btnclear,btnperiod,btnequal,btnminus,btnmulti,btndiv,btnper,btnback;
    private TextView expration_text;
    private TextView number_text;
    private double number1;
    private double number2;
    private String znak;
    private boolean last_znak;
    private DecimalFormat df = new DecimalFormat("#.####");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        expration_text = v.findViewById(R.id.text_exp);
        number_text = v.findViewById(R.id.text_number);
        btnzero = (Button) v.findViewById(R.id.btn0);
        btnone = (Button) v.findViewById(R.id.btn1);
        btntwo = (Button) v.findViewById(R.id.btn2);
        btnthree = (Button) v.findViewById(R.id.btn3);
        btnfour = (Button) v.findViewById(R.id.btn4);
        btnfive = (Button) v.findViewById(R.id.btn5);
        btnsix = (Button) v.findViewById(R.id.btn6);
        btnseven = (Button) v.findViewById(R.id.btn7);
        btneight = (Button) v.findViewById(R.id.btn8);
        btnnine = (Button) v.findViewById(R.id.btn9);
        btnadd = (Button) v.findViewById(R.id.btnplus);
        btnclear = (Button) v.findViewById(R.id.btn_Allclear);
        btnperiod = (Button) v.findViewById(R.id.btndot);
        btnequal = (Button) v.findViewById(R.id.btnequals);
        btnminus = (Button) v.findViewById(R.id.btnminus);
        btnmulti = (Button) v.findViewById(R.id.btnmultiply);
        btndiv = (Button) v.findViewById(R.id.btndivide);
        btnper = (Button) v.findViewById(R.id.btnplus_minus);
        btnback = (Button) v.findViewById(R.id.btncut);
        last_znak = false;

        if (savedInstanceState != null) {
            expration_text.setText((savedInstanceState.getString("expration")));
            number_text.setText((savedInstanceState.getString("number")));
            znak = savedInstanceState.getString("znak");
            number1 = savedInstanceState.getDouble("number1");
        }

        btnzero.setOnClickListener(this);
        btnone.setOnClickListener(this);
        btntwo.setOnClickListener(this);
        btnthree.setOnClickListener(this);
        btnfour.setOnClickListener(this);
        btnfive.setOnClickListener(this);
        btnsix.setOnClickListener(this);
        btnseven.setOnClickListener(this);
        btneight.setOnClickListener(this);
        btnnine.setOnClickListener(this);
        btnadd.setOnClickListener(this);
        btnclear.setOnClickListener(this);
        btnperiod.setOnClickListener(this);
        btnequal.setOnClickListener(this);
        btnminus.setOnClickListener(this);
        btnmulti.setOnClickListener(this);
        btndiv.setOnClickListener(this);
        btnper.setOnClickListener(this);
        btnback.setOnClickListener(this);

        return v;

    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("expration", expration_text.getText().toString());
        outState.putString("number", number_text.getText().toString());
        outState.putString("znak", znak);
        outState.putDouble("number1", number1);
    }
    @Override
    public void onClick(View v) {
        String result = number_text.getText().toString();
        switch (v.getId())
        {
            case R.id.btn0:
                if (!result.equals("0"))
                    result += "0";
                number_text.setText(result);
                last_znak = false;
                break;

            case R.id.btn1:
                if (result.equals("0"))
                    result = "1";
                else
                    result += "1";
                number_text.setText(result);
                last_znak = false;
                break;

            case R.id.btn2:
                if (result.equals("0"))
                    result = "2";
                else
                    result += "2";
                number_text.setText(result);
                last_znak = false;
                break;

            case R.id.btn3:
                if (result.equals("0"))
                    result = "3";
                else
                    result += "3";
                number_text.setText(result);
                last_znak = false;
                break;

            case R.id.btn4:
                if (result.equals("0"))
                    result = "4";
                else
                    result += "4";
                number_text.setText(result);
                last_znak = false;
                break;

            case R.id.btn5:
                if (result.equals("0"))
                    result = "5";
                else
                    result += "5";
                number_text.setText(result);
                last_znak = false;
                break;

            case R.id.btn6:
                if (result.equals("0"))
                    result = "6";
                else
                    result += "6";
                number_text.setText(result);
                last_znak = false;
                break;

            case R.id.btn7:
                if (result.equals("0"))
                    result = "7";
                else
                    result += "7";
                number_text.setText(result);
                break;

            case R.id.btn8:
                if (result.equals("0"))
                    result = "8";
                else
                    result += "8";
                number_text.setText(result);
                last_znak = false;
                break;

            case R.id.btn9:
                if (result.equals("0"))
                    result = "9";
                else
                    result += "9";
                number_text.setText(result);
                last_znak = false;
                break;

            case R.id.btnplus_minus:
                if (result.charAt(0) == '-')
                    result = result.substring(1, result.length());
                else if (Double.parseDouble(result) == 0)
                    result = result;
                else
                    result = "-" + result;
                number_text.setText(result);
                last_znak = false;
                break;

            case R.id.btndot:
                if (!result.contains("."))
                    result += ".";
                number_text.setText(result);
                last_znak = false;
                break;

            case R.id.btncut:
                if(expration_text.getText().length() > 0)
                {
                    number_text.setText("0");
                    CharSequence name1 = expration_text.getText().toString();
                    expration_text.setText(name1.subSequence(0, name1.length() - 1));
                }
                else
                {   number1 = Double.NaN;
                    number2 = Double.NaN;
                    number_text.setText("");
                    expration_text.setText("");
                }
                break;

            case R.id.btn_Allclear:
                expration_text.setText("");
                number_text.setText("0");
                number1 = 0;
                number2 = 0;
                break;

            case R.id.btndivide:
            {
                if(last_znak==true){
                    String e_text = expration_text.getText().toString();
                    String res = e_text.substring(0, e_text.length()-1) + "/";
                    expration_text.setText(res);
                    number_text.setText("0");
                    last_znak = true;
                    znak = "/";
                    return;
                }
                last_znak = true;
                String e_text = expration_text.getText().toString();
                String n_text = number_text.getText().toString();
                number2 = Double.parseDouble(n_text);
                if(e_text.equals("") || e_text.contains("=")|| e_text.equals("Error")){
                    number1 = Double.parseDouble(n_text);
                    znak = "/";
                    String res = n_text + "/";
                    expration_text.setText(res);
                    number_text.setText("0");
                    return;
                }

                if(e_text.endsWith("=")){
                    String res = n_text + "/";
                    expration_text.setText(res);
                    number_text.setText("0");
                    znak = "/";
                    return;
                }

                double r = calculate();

                if (expration_text.getText().equals("Error"))
                    return;

                String res = String.valueOf(r) + "/";
                expration_text.setText(res);
                number_text.setText("0");
                znak = "/";
                number1 = r;
                return;
            }
            case R.id.btnmultiply:
            {
                if(last_znak==true){
                    String e_text = expration_text.getText().toString();
                    String res = e_text.substring(0, e_text.length()-1) + "*";
                    expration_text.setText(res);
                    number_text.setText("0");
                    last_znak = true;
                    znak = "*";
                    return;
                }
                last_znak = true;
                String e_text = expration_text.getText().toString();
                String n_text = number_text.getText().toString();
                number2 = Double.parseDouble(n_text);
                if(e_text.equals("") || e_text.contains("=")|| e_text.equals("Error")){
                    number1 = Double.parseDouble(n_text);
                    znak = "*";
                    String res = n_text + "*";
                    expration_text.setText(res);
                    number_text.setText("0");
                    return;
                }

                if(e_text.endsWith("=")){
                    String res = n_text + "*";
                    expration_text.setText(res);
                    number_text.setText("0");
                    znak = "*";
                    return;
                }

                double r = calculate();

                if (expration_text.getText().equals("Error"))
                    return;

                String res = String.valueOf(r) + "*";
                expration_text.setText(res);
                number_text.setText("0");
                znak = "*";
                number1 = r;
                return;
            }
            case R.id.btnminus:
            {
                if(last_znak==true){
                    String e_text = expration_text.getText().toString();
                    String res = e_text.substring(0, e_text.length()-1) + "-";
                    expration_text.setText(res);
                    number_text.setText("0");
                    last_znak = true;
                    znak = "-";
                    return;
                }
                last_znak = true;
                String e_text = expration_text.getText().toString();
                String n_text = number_text.getText().toString();
                number2 = Double.parseDouble(n_text);
                if(e_text.equals("") || e_text.contains("=")|| e_text.equals("Error")){
                    number1 = Double.parseDouble(n_text);
                    znak = "-";
                    String res = n_text + "-";
                    expration_text.setText(res);
                    number_text.setText("0");
                    return;
                }

                if(e_text.endsWith("=")){
                    String res = n_text + "-";
                    expration_text.setText(res);
                    number_text.setText("0");
                    znak = "-";
                    return;
                }

                double r = calculate();

                if (expration_text.getText().equals("Error"))
                    return;

                String res = String.valueOf(r) + "-";
                expration_text.setText(res);
                number_text.setText("0");
                znak = "-";
                number1 = r;
                return;
            }
            case R.id.btnplus:
            {
                if(last_znak==true){
                    String e_text = expration_text.getText().toString();
                    String res = e_text.substring(0, e_text.length()-1) + "+";
                    expration_text.setText(res);
                    number_text.setText("0");
                    last_znak = true;
                    znak = "+";
                    return;
                }
                last_znak = true;
                String e_text = expration_text.getText().toString();
                String n_text = number_text.getText().toString();
                number2 = Double.parseDouble(n_text);
                if(e_text.equals("") || e_text.contains("=") || e_text.equals("Error")){
                    number1 = Double.parseDouble(n_text);
                    znak = "+";
                    String res = n_text + "+";
                    expration_text.setText(res);
                    number_text.setText("0");
                    return;
                }

                if(e_text.endsWith("=")){
                    String res = n_text + "+";
                    expration_text.setText(res);
                    number_text.setText("0");
                    znak = "+";
                    return;
                }

                double r = calculate();

                if (expration_text.getText().equals("Error"))
                    return;

                String res = String.valueOf(r) + "+";
                expration_text.setText(res);
                number_text.setText("0");
                znak = "+";
                number1 = r;
                return;
            }
            case R.id.btnequals:
            {
                String e_text = expration_text.getText().toString();
                String n_text = number_text.getText().toString();
                number2 = Double.parseDouble(n_text);

                if(e_text.equals("")){
                    String res = n_text + "=" + n_text;
                    expration_text.setText("0");
                    return;
                }

                if(e_text.endsWith(" ")){
                    String res = n_text + "=";
                    expration_text.setText(res);
                    number_text.setText(n_text);
                    number1 = number2;
                    return;
                }

                double r = calculate();
                if (expration_text.getText().equals("Error"))
                    return;

                if (!ifReallyDecimal()) {
                    String res = String.valueOf( number1) + " " + znak + " " + String.valueOf( number2) + " "  + "=";
                    expration_text.setText( res);
                    number_text.setText(String.valueOf(df.format(r)));
                } else {
                    String res = String.valueOf((int) number1) + " " + znak + " " + String.valueOf((int) number2)+  " " + "=";
                    expration_text.setText( res);
                    number_text.setText(String.valueOf(df.format(r)));
                }
            }
        }
    }
    private boolean ifReallyDecimal() {
        return number1 == (int) number1 & number2 == (int) number2;
    }

    private double calculate() {
        double r = 0;
        switch (znak){
            case "+":
                r = number1 + number2;
                break;
            case "-":
                r = number1 - number2;
                break;
            case "*":
                r = number1 * number2;
                break;
            case "/":
                if(number2==0){
                    expration_text.setText("Error");
                    number_text.setText("0");
                    return 0;
                }
                r = number1 / number2;
                break;
        }
        last_znak=false;
        return r;
    }
}