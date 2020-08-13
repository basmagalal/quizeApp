package com.example.quizeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioButton rightAns1,rightAns2,rightAns3,rightAns4;
    private CheckBox rightAns5,rightAns5_5,wrongAns5;
    private EditText e6;
    private  int total;
    private RadioGroup group1,group2,group3,group4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rightAns1=findViewById(R.id.right1);
        rightAns2=findViewById(R.id.right2);
        rightAns3=findViewById(R.id.right3);
        rightAns4=findViewById(R.id.right4);
        rightAns5=findViewById(R.id.right5);
        e6=findViewById(R.id.edit6);
        rightAns5_5=findViewById(R.id.right55);
        wrongAns5=findViewById(R.id.wrong5);
        group1=findViewById(R.id.radio1);
        group2=findViewById(R.id.radio2);
        group3=findViewById(R.id.radio3);
        group4=findViewById(R.id.radio4);
    }

    public void CheckAns1(){
        if(rightAns1.isChecked()){
            total++;
        }
    }
    public void CheckAns2(){
        if (rightAns2.isChecked() )
            total++;
    }

    public void CheckAns3(){
        if(rightAns3.isChecked())
            total++;
    }

    public void CheckAns4(){
        if(rightAns4.isChecked() )
            total++;
    }


    public void CheckAns5(){

        if (rightAns5.isChecked() && rightAns5_5.isChecked() && !wrongAns5.isChecked())
                total++;

    }

    public void CheckAns6(){
        String ans= e6.getText().toString();
        int res =Integer.parseInt(ans);


       if (ans.isEmpty()) {
           Toast toast = Toast.makeText(getApplicationContext(),
                   "plz Enter the answer",
                   Toast.LENGTH_SHORT);

           toast.show();

       }
       else {

           if (res == 84)
               total++;

       }
    }

    public void ALL(){
        CheckAns1();
        CheckAns2();
        CheckAns3();
        CheckAns4();
        CheckAns5();
        CheckAns6();

    }
      public void Delete(){
        total=0;
       e6.getText().clear();
       group1.clearCheck();
       group2.clearCheck();
       group3.clearCheck();
       group4.clearCheck();

          if (rightAns5.isChecked()) {
              rightAns5.toggle();
          }

          if (rightAns5_5.isChecked()) {
              rightAns5_5.toggle();
          }

          if (wrongAns5.isChecked()) {
              wrongAns5.toggle();
          }
      }

    public  void  Submit(View v){
        ALL();
          if (total==6) {
           Toast toast = Toast.makeText(getApplicationContext(),
                   "YOU PASSED " ,
                   Toast.LENGTH_SHORT);

           toast.show();

          }
            else{
               Toast toast = Toast.makeText(getApplicationContext(),
                       "YOUR Result is "+ total,
                       Toast.LENGTH_SHORT);

                 toast.show();

             }
        Delete();
       }
    }

