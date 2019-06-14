package com.e.numbertypechecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number{

        int number;

        public boolean checkPrime(){

            int i=2,count=0;

            while(i<=number-1){

                if(number % i == 0){

                    count = count + 1;

                    break;

                }

                i++;

            }

            if(count==0) {

                return true;

            }else {

                return false;

            }
        }

        public boolean checkArmstrong(){

            int armstrong = 0;

            int remainder,num;

            num=number;

            while(num != 0){

                remainder = num % 10;

                armstrong = armstrong + (remainder * remainder * remainder);

                num = num / 10;

            }

            if(number == armstrong){

                return true;

            }else{

                return false;

            }

        }

        public boolean checkEven(){

            if(number % 2 == 0){

                return true;

            }else{

                return false;

            }

        }

    }

    public void onClick(View view){

        String message;

        Log.i("Info","Button Clicked!");

        EditText editText = (EditText) findViewById(R.id.editText);

        if (editText.getText().toString().isEmpty()){

            message = "Please enter a number";

        }else {

            Number myNumber = new Number();

            myNumber.number = Integer.parseInt(editText.getText().toString());

            if(myNumber.checkPrime() && myNumber.checkEven()) {

                message = myNumber.number + " is a even and prime number";

            }

            else if (myNumber.checkEven() && myNumber.checkArmstrong()) {

                message = myNumber.number + " is an armstrong and even number";

            }
            else if(myNumber.checkArmstrong() && myNumber.checkPrime()) {

                message = myNumber.number + " is odd, prime and armstrong";

            }

            else if (myNumber.checkArmstrong()){

                message = myNumber.number + " is a odd and armstrong number";

            }

            else if (myNumber.checkPrime()){

                message = myNumber.number +  " is a odd and prime number";

            }

            else if (myNumber.checkEven()){

                message = myNumber.number + " is an even number";

            }

            else{

                message = myNumber.number + " is odd, non prime and non armstrong ";

            }

        }

        Toast.makeText(this,message,Toast.LENGTH_LONG).show();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
