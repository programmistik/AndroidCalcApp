package com.example.calcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double val1, val2;
    double res = 0d;
    TextView txtSol;
    String oper;
    Boolean mode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSol = (TextView) findViewById(R.id.txtSolution);
        TextView textView = (TextView) findViewById(R.id.txtInput);

        if (savedInstanceState != null) {
            val1 = savedInstanceState.getDouble ("Val1");
            val2 = savedInstanceState.getDouble ("Val2");
            res = savedInstanceState.getDouble ("Res");
            oper = savedInstanceState.getString ("Oper");
            mode = savedInstanceState.getBoolean ("Mode");
            String solTxt = savedInstanceState.getString ("SolText");
            txtSol.setText(solTxt);

            String s = "";

            if (res % 1 == 0){
                s = String.valueOf((int)res);
            }
            else {

                s = String.valueOf(res);
            }
            if (s.length() > 9){
                s = "~" + s.substring(0,8);
            }
            textView.setText(s);
        }
        else {
            val1 = val2 = res = 0d;
            oper = "";
        }
    }


    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState (outState);
        outState.putDouble ("Val1", val1);
        outState.putDouble ("Val2", val2);
        outState.putDouble ("Res", res);
        outState.putString("Oper",oper);
        outState.putBoolean("Mode", mode);
        outState.putString("SolText",txtSol.getText().toString());
    }




    public void clickBtn(View view, String num) {
        TextView textView = (TextView) findViewById(R.id.txtInput);
        if (mode){
            textView.setText(num);
            mode = false;
            txtSol.setText("");
            oper = "";
            val1 = val2 = res = 0d;
        }
        else {
            textView.setText(textView.getText() + num);
        }

    }

    public void click3(View view) {
        clickBtn(view, "3");
    }
    public void click0(View view) {
        clickBtn(view, "0");
    }
    public void click1(View view) {
        clickBtn(view, "1");
    }
    public void click2(View view) {
        clickBtn(view, "2");
    }
    public void click4(View view) {
        clickBtn(view, "4");
    }
    public void click5(View view) {
        clickBtn(view, "5");
    }
    public void click6(View view) {
        clickBtn(view, "6");
    }
    public void click7(View view) {
        clickBtn(view, "7");
    }
    public void click8(View view) {
        clickBtn(view, "8");
    }
    public void click9(View view) {
        clickBtn(view, "9");
    }
    public void clickPlus(View view) {
        TextView textView = (TextView) findViewById(R.id.txtInput);
        if(textView.getText().toString().length() != 0) {
            String str = textView.getText().toString();
            if(str.substring(0,1).equals("~")){
                clickC(view);
            }
            else {
                if (mode || txtSol.getText().toString().length() == 0) {

                    txtSol.setText(textView.getText() + "+");
                    oper = "+";
                    val1 = Double.parseDouble(textView.getText().toString());
                    textView.setText("");
                    mode = false;
                } else {
                    val2 = Double.parseDouble(textView.getText().toString());

                    if (oper == "+") {
                        val1 = val1 + val2;

                    }
                    else if (oper == "-"){
                        val1 = val1 - val2;
                    }
                    else if (oper == "/"){
                        val1 = val1 / val2;
                    }
                    else if (oper == "*"){
                        val1 = val1 * val2;
                    }

                    String s = "";

                    if (val1 % 1 == 0) {
                        s = String.valueOf((int) val1);
                    } else {

                        s = String.valueOf(val1);
                    }
                    if (s.length() > 9) {
                        s = "~" + s.substring(0, 8);
                    }

                    txtSol.setText(s + "+");
                    oper = "+";
                    textView.setText("");
                    mode = false;

                }
            }
        }
    }

    public void Equal(View view) {
        TextView textView = (TextView) findViewById(R.id.txtInput);
        if (mode){
            val1 = res;
            String strVal2 = "";
            if (val2 % 1 == 0){
                strVal2 = String.valueOf((int)val2);
            }
            else {

                strVal2 = String.valueOf(val2);
            }
            txtSol.setText(textView.getText().toString()+oper+strVal2+"=");
        }
        else {
            val2 = Double.parseDouble(textView.getText().toString());
            txtSol.setText(txtSol.getText() + textView.getText().toString() + "=");
        }

        if (oper == "+") {
            res = val1 + val2;

        }
        else if (oper == "-"){
            res = val1 - val2;
        }
        else if (oper == "/"){
            res = val1 / val2;
        }
        else if (oper == "*"){
            res = val1 * val2;
        }
        String s = "";

        if (res % 1 == 0){
            s = String.valueOf((int)res);
        }
        else {

            s = String.valueOf(res);
        }
        if (s.length() > 9){
            s = "~" + s.substring(0,8);
        }
        textView.setText(s);
        mode = true;
    }

    public void clickMinus(View view) {

        TextView textView = (TextView) findViewById(R.id.txtInput);
        if(textView.getText().toString().length() != 0) {
            String str = textView.getText().toString();
            if(str.substring(0,1).equals("~")){
                clickC(view);
            }
            else {
                if (mode || txtSol.getText().toString().length() == 0) {

                    txtSol.setText(textView.getText() + "-");
                    oper = "-";
                    val1 = Double.parseDouble(textView.getText().toString());
                    textView.setText("");
                    mode = false;
                } else {
                    val2 = Double.parseDouble(textView.getText().toString());
                    if (oper == "+") {
                        val1 = val1 + val2;
                    }
                    else if (oper == "-"){
                        val1 = val1 - val2;
                    }
                    else if (oper == "/"){
                        val1 = val1 / val2;
                    }
                    else if (oper == "*"){
                        val1 = val1 * val2;
                    }

                    String s = "";

                    if (val1 % 1 == 0) {
                        s = String.valueOf((int) val1);
                    } else {

                        s = String.valueOf(val1);
                    }
                    if (s.length() > 9) {
                        s = "~" + s.substring(0, 8);
                    }

                    txtSol.setText(s + "-");
                    oper = "-";
                    textView.setText("");
                    mode = false;

                }
            }
        }
    }

    public void clickDot(View view) {
        TextView textView = (TextView) findViewById(R.id.txtInput);
        String str = textView.getText().toString();

        if (mode){
            str = "0.";
            txtSol.setText("");
            oper = "";
            val1 = val2 = res = 0d;
            mode = false;
        }
        else {
            if (str.length() == 0) {
                str = "0.";
            } else if (!str.contains(".")) {
                str += ".";
            }
        }
        textView.setText(str);
    }

    public void clickC(View view) {
        TextView textView = (TextView) findViewById(R.id.txtInput);
        txtSol.setText("");
        oper = "";
        val1 = val2 = res = 0d;
        textView.setText("");
    }

    public void clickBack(View view) {
        TextView textView = (TextView) findViewById(R.id.txtInput);
        String str = textView.getText().toString();
        if (str != null && str.length() > 0 ) {
            str = str.substring(0, str.length() - 1);
            textView.setText(str);
        }
    }

    public void clickDiv(View view) {
        TextView textView = (TextView) findViewById(R.id.txtInput);
        if(textView.getText().toString().length() != 0) {
            String str = textView.getText().toString();
            if(str.substring(0,1).equals("~")){
                clickC(view);
            }
            else {
                if (mode || txtSol.getText().toString().length() == 0) {

                    txtSol.setText(textView.getText() + "/");
                    oper = "/";
                    val1 = Double.parseDouble(textView.getText().toString());
                    textView.setText("");
                    mode = false;
                } else {
                    val2 = Double.parseDouble(textView.getText().toString());
                    if (oper == "+") {
                        val1 = val1 + val2;
                    }
                    else if (oper == "-"){
                        val1 = val1 - val2;
                    }
                    else if (oper == "/"){
                        val1 = val1 / val2;
                    }
                    else if (oper == "*"){
                        val1 = val1 * val2;
                    }

                    String s = "";

                    if (val1 % 1 == 0) {
                        s = String.valueOf((int) val1);
                    } else {

                        s = String.valueOf(val1);
                    }
                    if (s.length() > 9) {
                        s = "~" + s.substring(0, 8);
                    }

                    txtSol.setText(s + "/");
                    oper = "/";
                    textView.setText("");
                    mode = false;

                }
            }
        }
    }

    public void clickMul(View view) {
        TextView textView = (TextView) findViewById(R.id.txtInput);
        if(textView.getText().toString().length() != 0) {
            String str = textView.getText().toString();
            if(str.substring(0,1).equals("~")){
                clickC(view);
            }
            else {
                if (mode || txtSol.getText().toString().length() == 0) {

                    txtSol.setText(textView.getText() + "*");
                    oper = "*";
                    val1 = Double.parseDouble(textView.getText().toString());
                    textView.setText("");
                    mode = false;
                } else {
                    val2 = Double.parseDouble(textView.getText().toString());
                    if (oper == "+") {
                        val1 = val1 + val2;
                    }
                    else if (oper == "-"){
                        val1 = val1 - val2;
                    }
                    else if (oper == "/"){
                        val1 = val1 / val2;
                    }
                    else if (oper == "*"){
                        val1 = val1 * val2;
                    }

                    String s = "";

                    if (val1 % 1 == 0) {
                        s = String.valueOf((int) val1);
                    } else {

                        s = String.valueOf(val1);
                    }
                    if (s.length() > 9) {
                        s = "~" + s.substring(0, 8);
                    }

                    txtSol.setText(s + "*");
                    oper = "*";
                    textView.setText("");
                    mode = false;

                }
            }
        }
    }

    public void clickSqr(View view) {
        TextView textView = (TextView) findViewById(R.id.txtInput);
        val1 = Double.parseDouble(textView.getText().toString());
        txtSol.setText("sqr("+ textView.getText().toString() +")=");
        oper = "sqr";
        res = Math.sqrt(val1);
        String s = "";

        if (res % 1 == 0){
            s = String.valueOf((int)res);
        }
        else {

            s = String.valueOf(res);
        }

        if (s.length() > 9){
            s = "~" + s.substring(0,8);
        }
        textView.setText(s);
        mode = true;
    }
}
