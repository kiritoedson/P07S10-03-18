package com.example.usuario.practica07s10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class ImageActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    ImageView imageView;
    String[] imagenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imagenes = getResources().getStringArray(R.array.imagenes);
        imageView = (ImageView) findViewById(R.id.imageView2);
        spinner = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_layout, R.id.itemSpinner, imagenes);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        int idImg = 0;
        Toast.makeText(getApplicationContext(),
                "Opcion " + position + "\n"+ imagenes[position], Toast.LENGTH_SHORT).show();
        switch (position){
            case 0:
                idImg = R.drawable.gears1;
                break;
            case 1:
                idImg = R.drawable.gears2;
                break;
            case 2:
                idImg = R.drawable.gears3;
                break;
            case 3:
                idImg = R.drawable.gears4;
                break;
            case 4:
                idImg = R.drawable.mcfly;
                break;
            default:
                idImg = android.R.drawable.ic_menu_agenda;
        }
        imageView.setImageResource(idImg);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
