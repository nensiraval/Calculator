package com.example.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
    TextView textView;
     Button ac, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btequ, ptn, plus, minus, multi, div, module, dot, cut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.calculator);

        textView = findViewById(R.id.txt);
        ac = findViewById(R.id.ac);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);
        bt0 = findViewById(R.id.bt0);
        plus = findViewById(R.id.plus);
        btequ = findViewById(R.id.btequ);
        minus = findViewById(R.id.minus);
        multi = findViewById(R.id.multi);
        div = findViewById(R.id.div);
        module = findViewById(R.id.module);
        dot = findViewById(R.id.dot);
        cut = findViewById(R.id.cut);
        ptn = findViewById(R.id.ptn);


        setbutn(ac, "AC");
        setbutn(bt1, "1");
        setbutn(bt2, "2");
        setbutn(bt3, "3");
        setbutn(bt4, "4");
        setbutn(bt5, "5");
        setbutn(bt6, "6");
        setbutn(bt7, "7");
        setbutn(bt8, "8");
        setbutn(bt9, "9");
        setbutn(bt0, "0");
        setbutn(plus, "+");
        setbutn(btequ, "=");
        setbutn(minus, "-");
        setbutn(multi, "*");
        setbutn(div, "/");
        setbutn(module, "%");
        setbutn(dot, ".");
        setbutn(cut, "⌫");
        setbutn(ptn, "+/-");
    }

    Double n1 = 0.0;
    Double n2 = 0.0;
//    Double temp = 0.0;


    void setbutn(Button btn, String n)
    {
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //clear karva
                if (n.equals("AC"))
                {
                    textView.setText("");
                }

                else if (n.equals("+") || n.equals("-") || n.equals("*") || n.equals("/") ||  n.equals("%"))
                {
                    Double temp = 0.0;
                    temp = n1;

                    try
                    {
                        n1 = Double.parseDouble(textView.getText().toString());
                        Log.e("===fv", "onClick: before if "+ n1);

                        //3 value sum,multi,div,minus start
                        if (Sign.plus)
                        {
                            Log.e("===fv", "onClick: before process plus "+ n1);
                            n1 = n1 +temp;
                            Log.e("===temp", "onClick: after if plus "+ temp);
                        }
                        if (Sign.minus)
                        {
                            Log.e("===fv", "onClick: before process minus "+ n1);
                            n1 = temp - n1;
                            Log.e("===temp", "onClick: after if minus "+ temp);
                        }
                        if (Sign.multi)
                        {
                            Log.e("===fv", "onClick: before process multi "+ n1);
                            n1 = n1 * temp;
                            Log.e("===temp", "onClick: after if multi "+ temp);
                        }
                        if (Sign.div)
                        {
                            Log.e("===fv", "onClick: before process div "+ n1);
                            n1 = temp/n1;
                            Log.e("===temp", "onClick: after if div "+ temp);
                        }
                        if (Sign.module)
                        {
                            Log.e("===fv", "onClick: before process module "+ n1);
                            Double n1 = Double.parseDouble(textView.getText().toString());
                             n1 = n1/100;
                            Log.e("===temp", "onClick: after if module "+ temp);
                        }
                        //3 value sum,multi,div,minus end
                    }
                    catch (NumberFormatException e)
                    {
                        Log.d("+++", "NumberFormatException : "+e.getMessage());
                    }
                    Log.d("+++", "first value: " + n1);
                    textView.setText("");


                    //value ne true karavva start
                    if (n.equals("+"))
                    {
                        Sign.plus = true;
                    }
                    if (n.equals("-"))
                    {
                        Sign.minus = true;
                    }
                    if (n.equals("*"))
                    {
                        Sign.multi = true;
                    }
                    if (n.equals("/"))
                    {
                        Sign.div = true;

                    }
                    //value ne true karavva end
                }

                else if (n.equals("%"))
                {
                   if (!textView.getText().toString().isEmpty())
                   {
                       n1 = Double.parseDouble(textView.getText().toString());
                       n1=n1/100;
                       textView.setText(""+n1);
                   }
                }


                //ans equal kre
                else if (n.equals("="))
                {
                    ans();
                }


                //1 time 0 press
                else if (n.equals("0"))
                {
                    if (!textView.getText().toString().startsWith("0") || textView.getText().toString().length() > 1)
                    {
                        textView.setText(textView.getText().toString().concat(n));
                    }
                }


                //1 time dot press
                else if (n.equals("."))
                {
                    if (!textView.getText().toString().contains("."))
                    {
                        if (textView.getText().toString().isEmpty())
                        {
                            textView.setText(textView.getText().toString().concat("0."));
                        }

                        //value ni pachal je dot lagavvano hoi tyare
                        else
                        {
                            textView.setText(textView.getText().toString().concat("."));
                        }
                    }
                }

                //value remove
                    else if (n.equals("⌫"))
                    {
                        if (!textView.getText().toString().equals(""))
                        {
                            textView.setText(textView.getText().toString().substring(0, textView.getText().toString().length() - 1));
                        }

                    }

                    //Positive nagative value
                    else if (n.equals("+/-"))
                    {
                        if (textView.getText().toString().contains("-"))
                        {
                            textView.setText(textView.getText().toString().replace("-",""));
                        }
                        else
                        {
                            textView.setText("-"+textView.getText());
                        }
                }
                    else
                {
                    textView.setText(textView.getText().toString().concat(n));
                }
            }
        });
    }
    private void ans()
    {
        try
        {
            n2 = Double.parseDouble(textView.getText().toString());
        }
        catch (NumberFormatException e)
        {
            Log.d("+++", "NumberFormatException : "+e.getMessage());
        }
        Log.d("+++", "second value: " + n2);

        textView.setText("");
        Double answer = 0.0;

        //value sum,multi,div,minus mate f1 + f2 only start
        if(Sign.plus)
        {
            answer = n1 + n2;
        }
        if(Sign.minus)
        {
            answer = n1 - n2;
        }
        if(Sign.multi)
        {
            answer = n1 * n2;
        }
        if(Sign.div)
        {
            answer = n1 / n2;
        }
 //value sum,multi,div,minus mate f1 + f2 only end

        //boolean according value false
     Sign.plus = false ;
     Sign.minus = false;
     Sign.multi = false;
     Sign.div = false;
     Sign.module = false;

     textView.setText(answer.toString());
    }
}
class  Sign
{
    //three time value sum, multi, div, minus boolean according value false
    static boolean plus = false, minus = false, multi = false, div = false, module = false;
}





//second option
//      if(n.equals("")) {
//              textView.setText("");
//              } else if (n.equals("+"))
//              {
//              n1 = Double.parseDouble(textView.getText().toString());
//              Log.d("+++", "first value: "+n1);
//              textView.setText("");
//              } else if (n.equals("="))
//              {
//              n2 = Double.parseDouble(textView.getText().toString());
//              Double ans = n1 + n2;
//              Log.d("+++", "second value: "+n2);
//              Log.d("+++", "ans: "+ans);
//
//              textView.setText(ans.toString());
//              }
