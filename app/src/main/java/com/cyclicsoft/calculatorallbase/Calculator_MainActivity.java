package com.cyclicsoft.calculatorallbase;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

import bsh.EvalError;
import bsh.Interpreter;

public class Calculator_MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator__main);

        //eqn to be evaluated
        final String[] mathEqn = {""};


        //unicode symbol mul and div

        final char uMul='\u00D7';
        final char uDiv='\u00F7';



        //getting all button ref
        TextView btnOne=(TextView) findViewById(R.id.tV1);
        TextView btnTwo=(TextView) findViewById(R.id.tV2);
        TextView btnThree=(TextView) findViewById(R.id.tV3);
        TextView btnFour=(TextView) findViewById(R.id.tV4);
        TextView btnFive=(TextView) findViewById(R.id.tV5);
        TextView btnSix=(TextView) findViewById(R.id.tV6);
        TextView btnSeven=(TextView) findViewById(R.id.tV7);
        TextView btnEight=(TextView) findViewById(R.id.tV8);
        TextView btnNine=(TextView) findViewById(R.id.tV9);
        TextView btnZero=(TextView) findViewById(R.id.tV0);

        TextView btnDot=(TextView) findViewById(R.id.tVdot);
        TextView btnPlus=(TextView) findViewById(R.id.tVplus);
        TextView btnMinus=(TextView) findViewById(R.id.tVminus);
        TextView btnMul=(TextView) findViewById(R.id.tVmul);
        TextView btnDiv=(TextView) findViewById(R.id.tVdiv);
        TextView btnMod=(TextView) findViewById(R.id.tVmod);

        TextView btnOB=(TextView) findViewById(R.id.tVob);
        TextView btnCB=(TextView) findViewById(R.id.tVcb);
        TextView btnClr=(TextView) findViewById(R.id.tVclr);
        TextView btnDel=(TextView) findViewById(R.id.tVdel);
        TextView btnEql=(TextView) findViewById(R.id.tVeql);
        TextView btnPM=(TextView) findViewById(R.id.tVpm);
        TextView btnPow=(TextView) findViewById(R.id.tVpwr);

        //getting result showing TextView ref
        final TextView eqnTV=(TextView) findViewById(R.id.mainEqnTV);
        final TextView resTV=(TextView) findViewById(R.id.resultTV);
        resTV.setPaintFlags(resTV.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);





        //all button onclick

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eqnTV.setText(eqnTV.getText()+"1");
                mathEqn[0] += "1";
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eqnTV.setText(eqnTV.getText()+"2");
                mathEqn[0] += "2";
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eqnTV.setText(eqnTV.getText()+"3");
                mathEqn[0] += "3";
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eqnTV.setText(eqnTV.getText()+"4");
                mathEqn[0] += "4";
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eqnTV.setText(eqnTV.getText()+"5");
                mathEqn[0] += "5";

            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eqnTV.setText(eqnTV.getText()+"6");
                mathEqn[0] += "6";
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eqnTV.setText(eqnTV.getText()+"7");
                mathEqn[0] += "7";
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eqnTV.setText(eqnTV.getText()+"8");
                mathEqn[0] += "8";
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eqnTV.setText(eqnTV.getText()+"9");
                mathEqn[0] += "9";
            }
        });
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eqnTV.setText(eqnTV.getText()+"0");
                mathEqn[0] += "0";
            }
        });


        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eqnTV.setText(eqnTV.getText()+".");
                mathEqn[0] += ".";
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eqnTV.setText(eqnTV.getText()+"+");
                mathEqn[0] += "+";
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eqnTV.setText(eqnTV.getText()+"-");
                mathEqn[0] += "-";
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eqnTV.setText(eqnTV.getText()+Character.toString(uMul));
                mathEqn[0] += "*";
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eqnTV.setText(eqnTV.getText()+Character.toString(uDiv));
                String temp="";
                if (!mathEqn[0].toString().isEmpty()){
                    for (int i=mathEqn[0].toString().length();i>0;i--){
                        if(Character.isDigit(mathEqn[0].toString().charAt(i-1)) | mathEqn[0].toString().charAt(i-1)=='.'){
                            temp=Character.toString(mathEqn[0].toString().charAt(i-1))+temp;
                            mathEqn[0]=mathEqn[0].substring(0,mathEqn[0].toString().length()-1);

                        }
                    }

                    temp=String.valueOf(Float.parseFloat(temp)*1.0);
                    mathEqn[0] +=temp+"/";
                }else {
                    mathEqn[0] +=temp+"/";
                }
            }
        });
        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eqnTV.setText(eqnTV.getText()+"%");
                mathEqn[0] += "%";
            }
        });
        btnOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eqnTV.setText(eqnTV.getText()+"(");
                mathEqn[0] += "(";
            }
        });
        btnCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eqnTV.setText(eqnTV.getText()+")");
                mathEqn[0] += ")";
            }
        });
        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eqnTV.setText("");
                resTV.setText("");
                mathEqn[0]="";
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mathEqn[0].isEmpty()) {
                    mathEqn[0] = mathEqn[0].substring(0, mathEqn[0].toString().length() - 1);
                    eqnTV.setText(eqnTV.getText().toString().substring(0,eqnTV.getText().toString().length()-1));
                }
            }
        });




        //result calculation
        final Interpreter interpreter=new Interpreter();
        btnEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String result = interpreter.eval(mathEqn[0]).toString();
                    if(result.contains(".")){
                        BigDecimal bd = new BigDecimal(result);
                        bd = bd.setScale(9, BigDecimal.ROUND_HALF_UP);
                         result=bd.doubleValue()+"";
                    }

                    resTV.setText(result);
                    eqnTV.setText("");
                    mathEqn[0]="";
                } catch (EvalError evalError) {
                    evalError.printStackTrace();
                    resTV.setText("Wrong XPRSN");
                }
            }
        });






    }
}
