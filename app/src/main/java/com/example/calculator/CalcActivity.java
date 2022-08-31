package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalcActivity extends Activity implements View.OnClickListener{
    TextView t;
    Button but0,but00,but1,but2,but3,but4,but5,but6,but7,but8,but9,but_de,but_ad,but_su,but_di,but_po,but_pe,but_eq,but_c,but_mu;
    double part1,part2,result;
    char operation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_layout);

        t=findViewById(R.id.tb);
        but0=findViewById(R.id.b0);
        but00=findViewById(R.id.b00);
        but1=findViewById(R.id.b1);
        but2=findViewById(R.id.b2);
        but3=findViewById(R.id.b3);
        but4=findViewById(R.id.b4);
        but5=findViewById(R.id.b5);
        but6=findViewById(R.id.b6);
        but7=findViewById(R.id.b7);
        but8=findViewById(R.id.b8);
        but9=findViewById(R.id.b9);
        but_de=findViewById(R.id.bde);
        but_ad=findViewById(R.id.bad);
        but_su=findViewById(R.id.bsu);
        but_di=findViewById(R.id.bdi);
        but_mu=findViewById(R.id.bmu);
        but_po=findViewById(R.id.bpo);
        but_pe=findViewById(R.id.bpe);
        but_eq=findViewById(R.id.beq);
        but_c=findViewById(R.id.bc);

        but00.setOnClickListener(this);
        but0.setOnClickListener(this);
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);
        but5.setOnClickListener(this);
        but6.setOnClickListener(this);
        but7.setOnClickListener(this);
        but8.setOnClickListener(this);
        but9.setOnClickListener(this);
        but_de.setOnClickListener(this);
        but_ad.setOnClickListener(this);
        but_su.setOnClickListener(this);
        but_di.setOnClickListener(this);
        but_mu.setOnClickListener(this);
        but_po.setOnClickListener(this);
        but_pe.setOnClickListener(this);
        but_eq.setOnClickListener(this);
        but_c.setOnClickListener(this);
    }
    private void set(String s)
    { // method to put one or more numbers in text box
        String TT = t.getText() + s;
        t.setText(TT);
    }
    private void setop(char op)
    { // method to do the operation
        if(t.getText().length()==0)
            Toast.makeText(this,"Failed, try again",Toast.LENGTH_LONG).show();
        else {
            part1 = Double.parseDouble(t.getText().toString());
            t.setText("");
            operation = op;
        }
    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.b0)
            set("0");
        else if(view.getId()==R.id.b00)
            set("00");
        else if(view.getId()==R.id.b1)
            set("1");
        else if(view.getId()==R.id.b2)
            set("2");
        else if(view.getId()==R.id.b3)
            set("3");
        else if(view.getId()==R.id.b4)
            set("4");
        else if(view.getId()==R.id.b5)
            set("5");
        else if(view.getId()==R.id.b6)
            set("6");
        else if(view.getId()==R.id.b7)
            set("7");
        else if(view.getId()==R.id.b8)
            set("8");
        else if(view.getId()==R.id.b9)
            set("9");
        else if(view.getId()==R.id.bc)
            t.setText("");
        else if(view.getId()==R.id.bpo)
            set(".");
        else if(view.getId()==R.id.bad)
            setop('+');
        else if(view.getId()==R.id.bsu)
            setop('-');
        else if(view.getId()==R.id.bdi)
            setop('÷');
        else if(view.getId()==R.id.bpe)
            setop('%');
        else if(view.getId()==R.id.bmu)
            setop('×');
        else if(view.getId()==R.id.beq)
        {
            if(t.getText().length()==0)
                Toast.makeText(this,"Failed, try again",Toast.LENGTH_LONG).show();
            else {
                part2 = Double.parseDouble(t.getText().toString());
                switch (operation) {
                    case '+':
                        result = part1 + part2;
                        break;
                    case '-':
                        result = part1 - part2;
                        break;
                    case '×':
                        result = part1 * part2;
                        break;
                    case '÷':
                        if (part2 == 0)
                            Toast.makeText(this, "Error, you can't be divided by 0", Toast.LENGTH_LONG).show();
                        else
                            result = part1 / part2;
                        break;
                    case '%':
                        result = part1 % part2;
                        break;
                }
                t.setText(result + ""); // or new Double(result).toString();
            }
        }
        else if(view.getId()==R.id.bde)
        {
            String oldstring = t.getText().toString();
            char[] ch_oldstring = oldstring.toCharArray();
            int y = t.getText().length()-1;
            String newstring="";
            for (int i = 0; i < y; i++)
                newstring += ch_oldstring[i];
            t.setText(newstring);
        }
    }
}
