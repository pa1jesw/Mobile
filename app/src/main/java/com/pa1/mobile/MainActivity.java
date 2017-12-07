package com.pa1.mobile;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import
        android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7;

    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("kya apko sachi me jana h  ?? :-|");
        builder.setCancelable(false);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }
        );


        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
            }
        });


        builder.show();

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        btn6=(Button)findViewById(R.id.btn6);
        btn7=(Button)findViewById(R.id.btn7);

    btn1.setOnClickListener(new View.OnClickListener(){

        public void onClick(View v)

        {
            String lan= Locale.getDefault().getDisplayLanguage().toString();
            Toast.makeText(getApplicationContext(),"Language :"+lan,Toast.LENGTH_LONG).show();
        }

    });


        btn2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                String model= Build.MODEL;
                String name=Build.MANUFACTURER;

                Toast.makeText(getApplicationContext(),"Model :"+model+"\nName:"+name,Toast.LENGTH_LONG).show();
            }

        });


        btn3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                String rel=Build.VERSION.RELEASE;
                int ver=Build.VERSION.SDK_INT;

                Toast.makeText(getApplicationContext(),"Version :"+ver+"\nSDK Version :"+ver,Toast.LENGTH_LONG).show();

            }
        });


        btn4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
              TelephonyManager tam= (TelephonyManager) getApplication().getSystemService(Context.TELEPHONY_SERVICE);

                String imei=tam.getDeviceId();

                Toast.makeText(getApplicationContext(),"IMEI Number :"+imei,Toast.LENGTH_LONG).show();
            }
        });


        btn6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Display Disp=getWindowManager().getDefaultDisplay();
                int wid=Disp.getWidth();
                int hei=Disp.getHeight();

                Toast.makeText(getApplicationContext(),"Resolution :"+wid +"*"+hei,Toast.LENGTH_LONG).show();
            }
        });


        btn7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnectivityManager cm=(ConnectivityManager)getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);

                NetworkInfo ni=cm.getActiveNetworkInfo();

                if(ni!=null)
                {
                    Toast.makeText(getApplicationContext(),"You are Connected to internet",Toast.LENGTH_LONG).show();
                }
                    else
                {
                    Toast.makeText(getApplicationContext(),"You are not Connected to internet",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}


