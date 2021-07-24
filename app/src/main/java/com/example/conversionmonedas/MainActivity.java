package com.example.conversionmonedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner ruleta;
    private Button convertir;
    private EditText dato1, dato2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ruleta = (Spinner) findViewById(R.id.spinner);
        convertir = (Button) findViewById(R.id.btn_convertir);
        dato1 = (EditText) findViewById(R.id.texto_imput);
        dato2 = (EditText) findViewById(R.id.texto_output);
        dato2.setEnabled(false);
        String [] opciones = {"Soles", "Euros"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        ruleta.setAdapter(adapter);

        convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertir();
            }
        });
    }

    public void convertir(){
        String seleccionado = ruleta.getSelectedItem().toString();
        double num1 = Double.parseDouble(dato1.getText().toString());
        double resultado;
        if (seleccionado.equals("Soles")){
            resultado= num1*3.93;
            dato2.setText(String.valueOf(resultado));
        }else if(seleccionado.equals("Euros")){
            resultado= num1*0.85;
            dato2.setText(String.valueOf(resultado));
        }
    }
}