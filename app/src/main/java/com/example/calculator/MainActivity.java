package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Stack;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button badd,bsub,bmul,bper,bdiv,b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b00,back,clear,bequal,bdot;
    private TextView tm,tres;
    ProgressBar p;
    double ans=0.0;  double a=0.0,b=0.0;
    int counter=0;  boolean flag=false;
    Stack <Character> st=new Stack<>();
    ArrayList<String> post=new ArrayList<>();
    String val="";
    ConstraintLayout l;
    DecimalFormat df=new DecimalFormat("###,###,###,###,###,###.##############");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        badd=findViewById(R.id.btPlus);
        bsub=findViewById(R.id.btMinus);
        bmul=findViewById(R.id.btMultiply);
        bdiv=findViewById(R.id.btDivide);
        bper=findViewById(R.id.btPercentage);

        tm=(TextView)findViewById(R.id.mainText);
        tres=findViewById(R.id.resultText);

        b0=findViewById(R.id.btZero);
        b1=findViewById(R.id.btOne);
        b2=findViewById(R.id.btTwo);
        b3=findViewById(R.id.btThree);
        b4=findViewById(R.id.btFour);
        b5=findViewById(R.id.btFive);
        b6=findViewById(R.id.btSix);
        b7=findViewById(R.id.btSeven);
        b8=findViewById(R.id.btEight);
        b9=findViewById(R.id.btNine);
        b00=findViewById(R.id.btZeroZero);

        back=findViewById(R.id.btBackpace);
        clear=findViewById(R.id.btClear);
        bequal=findViewById(R.id.btEquals);
        bdot=findViewById(R.id.btDot);

        p=findViewById(R.id.progressBar);
        l=findViewById(R.id.layout_constraint);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void numbers(View v)
    {
        tm.setGravity(Gravity.END);
        tm.setScaleX(ScaleAnimation.RELATIVE_TO_SELF);  tm.setScaleY(ScaleAnimation.RELATIVE_TO_SELF);
        if (v.getId()==b0.getId())
        {
            if (!flag)
            {
                a=(a*10);
            }
            else
            {
                val=val+"0";
                a=Double.parseDouble(val);
            }
            tm.append("0");
            tm.setText(tm.getText());
        }
        else if (v.getId()==b1.getId())
        {
            if (!flag)
            {
                a=(a*10)+1;
            }
            else
            {
                val=val+"1";
                a=Double.parseDouble(val);
            }
            tm.append("1");
            tm.setText(tm.getText());
        }
        else if (v.getId()==b2.getId())
        {
            if (!flag)
            {
                a=(a*10)+2;
            }
            else
            {
                val=val+"2";
                a=Double.parseDouble(val);
            }
            tm.append("2");
            tm.setText(tm.getText());
        }
        else if (v.getId()==b3.getId())
        {
            if (!flag)
            {
                a=(a*10)+3;
            }
            else
            {
                val=val+"3";
                a=Double.parseDouble(val);
            }
            tm.append("3");
            tm.setText(tm.getText());
        }
        else if (v.getId()==b4.getId())
        {
            if (!flag)
            {
                a=(a*10)+4;
            }
            else
            {
                val=val+"4";
                a=Double.parseDouble(val);
            }
            tm.append("4");
            tm.setText(tm.getText());
        }
        else if (v.getId()==b5.getId())
        {
            if (!flag)
            {
                a=(a*10)+5;
            }
            else
            {
                val=val+"5";
                a=Double.parseDouble(val);
            }
            tm.append("5");
            tm.setText(tm.getText());
        }
        else if (v.getId()==b6.getId())
        {
            if (!flag)
            {
                a=(a*10)+6;
            }
            else
            {
                val=val+"6";
                a=Double.parseDouble(val);
            }
            tm.append("6");
            tm.setText(tm.getText());
        }
        else if (v.getId()==b7.getId())
        {
            if (!flag)
            {
                a=(a*10)+7;
            }
            else
            {
                val=val+"7";
                a=Double.parseDouble(val);
            }
            tm.append("7");
            tm.setText(tm.getText());
        }
        else if (v.getId()==b8.getId())
        {
            if (!flag)
            {
                a=(a*10)+8;
            }
            else
            {
                val=val+"8";
                a=Double.parseDouble(val);
            }
            tm.append("8");
            tm.setText(tm.getText());
        }
        else if (v.getId()==b9.getId())
        {
            if (!flag)
            {
                a=(a*10)+9;
            }
            else
            {
                val=val+"9";
                a=Double.parseDouble(val);
            }
            tm.append("9");
            tm.setText(tm.getText());
        }
        else if(v.getId()==b00.getId())
        {
            if (!flag)
            {
                a=(a*10);
                a=(a*10);
            }
            else
            {
                val=val+"00";
                a=Double.parseDouble(val);
            }
            tm.append("00");
            tm.setText(tm.getText());
        }
        else if(v.getId()==bdot.getId())
        {
            if (!flag)
            {
                flag=true;
                tm.append(".");
                tm.setText(tm.getText());
                val=Double.toString(a);
                val=val.substring(0,val.length()-1);
            }
        }
        else if(v.getId()==back.getId())
        {
            if (tm.getText().length()!=0)
            {
                char b=tm.getText().charAt(tm.getText().length()-1);
                if (!isOperator(Character.toString(b)))
                {
                    if (flag)
                    {
                        a=Double.parseDouble(Double.toString(a).substring(0,Double.toString(a).length()-1));
                    }
                    else
                    {
                        int number=(int)a;
                        number/=10;
                        a=(double)number;
                    }
                    val=Double.toString(a); val=val.substring(0,val.length()-1);  Log.i("VAL",val);
                    tm.setText(tm.getText().toString().substring(0,tm.getText().toString().length()-1));
                }
                else
                {

                }
                if (b=='.')
                {
                    flag=false;
                    val=val.substring(0,val.length()-1);  Log.i("VAL",val);
                    tm.setText(tm.getText().toString().substring(0,tm.getText().toString().length()-1));
                }
            }
        }

        effect();
        if (!st.isEmpty() && ((tm.getText().charAt(tm.length()-1)!='+') && (tm.getText().charAt(tm.length()-1)!='-') && (tm.getText().charAt(tm.length()-1)!='*') && (tm.getText().charAt(tm.length()-1)!='/')))
        {
            p.setVisibility(View.VISIBLE);   Log.i("A=",Double.toString(a));
            p.setProgress(0);
            post.set(counter,Double.toString(a));
            postEval(post);
        }
    }

    public void operators(View v)
    {
        tm.setGravity(Gravity.END);
        tm.setScaleX(ScaleAnimation.RELATIVE_TO_SELF);  tm.setScaleY(ScaleAnimation.RELATIVE_TO_SELF);
        p.setProgress(0);  flag=false;  val="";
        if (v.getId()==clear.getId())
        {
            a=0.0; b=0.0; ans=0.0;
            tm.setText("");  tres.setText("");
            st.clear();
            post.clear();
            counter=0;
            flag=false;
            p.setVisibility(View.VISIBLE);
            tm.setScaleX(ScaleAnimation.RELATIVE_TO_SELF);  tm.setScaleY(ScaleAnimation.RELATIVE_TO_SELF);
        }
        else if(v.getId()==badd.getId())
        {
            if (a!=0 && ((tm.getText().charAt(tm.length()-1)!='+') && (tm.getText().charAt(tm.length()-1)!='-') && (tm.getText().charAt(tm.length()-1)!='*') && (tm.getText().charAt(tm.length()-1)!='/')))
            {
                Log.i("INSIDE ADD",Double.toString(a));
                tm.append("+");
                tm.setText(tm.getText());
                if (post.isEmpty())
                post.add(Double.toString(a));
                else
                post.set(counter,Double.toString(a));

                if (st.isEmpty() || outerPrecidence('+') > innerPrecidence(st.peek()))
                {
                    st.push('+');
                }
                else
                {
                    while (!st.isEmpty() && outerPrecidence('+') <= innerPrecidence(st.peek()))
                    {
                        post.add(Character.toString(st.pop()));
                        counter++;
                    }
                    st.push('+');
                }
                a=0.0;
                counter++;
                post.add(Double.toString(a));
            }
            effect();
        }
        else if(v.getId()==bsub.getId())
        {
            if (a!=0 && ((tm.getText().charAt(tm.length()-1)!='+') && (tm.getText().charAt(tm.length()-1)!='-') && (tm.getText().charAt(tm.length()-1)!='*') && (tm.getText().charAt(tm.length()-1)!='/')))
            {
                tm.append("-");
                tm.setText(tm.getText());
                if (post.isEmpty())
                    post.add(Double.toString(a));
                else
                    post.set(counter,Double.toString(a));

                if (st.isEmpty() || outerPrecidence('-') > innerPrecidence(st.peek()))
                {
                    st.push('-');
                }
                else
                {
                    while (!st.isEmpty() && outerPrecidence('-') <= innerPrecidence(st.peek()))
                    {
                        post.add(Character.toString(st.pop()));
                        counter++;
                    }
                    st.push('-');
                }
                a=0.0;
                counter++;
                post.add(Double.toString(a));
            }
            effect();
        }
        else if(v.getId()==bmul.getId())
        {
            if (a!=0 && ((tm.getText().charAt(tm.length()-1)!='+') && (tm.getText().charAt(tm.length()-1)!='-') && (tm.getText().charAt(tm.length()-1)!='*') && (tm.getText().charAt(tm.length()-1)!='/')))
            {
                tm.append("x");
                tm.setText(tm.getText());
                if (post.isEmpty())
                    post.add(Double.toString(a));
                else
                    post.set(counter,Double.toString(a));

                if (st.isEmpty() || outerPrecidence('*') > innerPrecidence(st.peek()))
                {
                    st.push('*');
                }
                else
                {
                    while (!st.isEmpty() && outerPrecidence('*') <= innerPrecidence(st.peek()))
                    {
                        post.add(Character.toString(st.pop()));
                        counter++;
                    }
                    st.push('*');
                }
                a=0.0;
                counter++;
                post.add(Double.toString(a));
            }
            effect();
        }
        else if(v.getId()==bdiv.getId())
        {
            if (a!=0 && ((tm.getText().charAt(tm.length()-1)!='+') && (tm.getText().charAt(tm.length()-1)!='-') && (tm.getText().charAt(tm.length()-1)!='*') && (tm.getText().charAt(tm.length()-1)!='/')))
            {
                tm.append("÷");
                tm.setText(tm.getText());
                if (post.isEmpty())
                    post.add(Double.toString(a));
                else
                    post.set(counter,Double.toString(a));

                if (st.isEmpty() || outerPrecidence('/') > innerPrecidence(st.peek()))
                {
                    st.push('/');
                }
                else
                {
                    while (!st.isEmpty() && outerPrecidence('/') <= innerPrecidence(st.peek()))
                    {
                        post.add(Character.toString(st.pop()));
                        counter++;
                    }
                    st.push('/');
                }
                a=0.0;
                counter++;
                post.add(Double.toString(a));
            }
            effect();
        }
        else if(v.getId()==bper.getId())
        {
            if (tres.getText().length()!=0)
            {
                a=Double.parseDouble(tres.getText().toString());
                tm.setText(tres.getText());
                tm.append("%");
                tm.setText(tm.getText());
                a/=100;
                tres.setText(df.format(a));
                a=0.0;
            }
            else if(a!=0)
            {
                tm.setText(Double.toString(a));
                a/=100;
                tm.append("%");
                tres.setText(df.format(a));
                a=0.0;
            }
            effect();
        }
        else if(v.getId()==bequal.getId())
        {
            if (tres.getText().length()!=0)
            {
                tm.setText(tres.getText().toString().replaceAll(",",""));
                tm.setGravity(Gravity.CENTER);
                tm.animate().scaleX(1F).scaleY(1F).setDuration(200);
                tres.setText("");
                a=Double.parseDouble(tm.getText().toString());
                post.clear();
                st.clear();
                counter=0;
            }
        }
    }

    @SuppressLint("SetTextI18n")
    void postEval(ArrayList<String> postfix)
    {
        Log.i("Postfix arraylist length",Integer.toString(postfix.size()));
        ArrayList<String> s=new ArrayList<>();
        for (int i=0;i<postfix.size();i++)
            s.add(postfix.get(i));
        for (int i=st.size()-1;i>=0;i--)
            s.add(Character.toString(st.get(i)));

        Log.i("Postfix",s.toString());

        Stack <Double> temp=new Stack<>();
        for (int i=0;i<s.size();i++)
        {
            if (!isOperator(s.get(i)))
            {
                temp.push(Double.parseDouble(String.valueOf(s.get(i))));
            }
            else
            {
                double a=temp.pop();
                double b=temp.pop();
                switch (s.get(i)) {
                    case "+":
                        temp.push(b + a);
                        break;
                    case "-":
                        temp.push(b - a);
                        break;
                    case "*":
                        temp.push(b * a);
                        break;
                    case "/":
                        temp.push(b / a);
                        break;
                }
            }
            Log.i("RESULT",Double.toString(temp.peek()));
        }
        new pro(p).start();
        tres.setText(df.format(temp.peek()));
        s=null;  temp.clear();
    }

    void effect()
    {
        tm.setTranslationY(50);
        tm.animate().translationY(0).setDuration(80);
    }

    boolean isOperator(String c)
    {
        if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || c.equals(".") || c.equals("÷") || c.equals("x"))
            return true;
        else
            return false;
    }

    int innerPrecidence(char a)
    {
        if (a=='+' || a=='-')
        {
            return 2;
        }
        else if(a=='*' || a=='/')
        {
            return 4;
        }
        return 0;
    }

    int outerPrecidence(char a)
    {
        if (a=='+' || a=='-')
        {
            return 1;
        }
        else if(a=='*' || a=='/')
        {
            return 3;
        }
        return 0;
    }
}

class pro extends Thread
{
    ProgressBar p;
    int c=0;
    pro(ProgressBar p)
    {
        this.p=p;
    }
    public void  run()
    {
        while (c<=100)
        {
            p.setProgress(c);
            c++;
            try
            {
                sleep(2);
            }catch(Exception e){}
        }
        c=0;
        p.setProgress(0);
    }
}