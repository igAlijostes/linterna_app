package com.example.linterna_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private ImageButton botonCamara;
    private CameraManager miCamara;
    private String idCamara;
    private boolean encendida=false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    tv=(TextView) findViewById(R.id.tv1);
    botonCamara=(ImageButton) findViewById(R.id.bt_camara);
    miCamara=(CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            idCamara=miCamara.getCameraIdList()[0];
        } catch (Exception e) {
            Toast.makeText(this,"Problemas al localizar la Camara",Toast.LENGTH_LONG).show();
        }

    }


public void EnciendeApaga (View view) {

    try {
        if (encendida){
            Toast.makeText(this,"Te Apago",Toast.LENGTH_LONG).show();
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                miCamara.setTorchMode(idCamara, false);
            }
                botonCamara.setImageResource(R.drawable.linternaon);
            } else {
            Toast.makeText(this,"Te Enciendo",Toast.LENGTH_LONG).show();
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                miCamara.setTorchMode(idCamara, true);
            }
            botonCamara.setImageResource(R.drawable.linternaoff);
            }

    encendida= !encendida;
    } catch (Exception e) {
        Toast.makeText(this,"NO PUEDO ENCENDER",Toast.LENGTH_LONG).show();
                }

        }




}