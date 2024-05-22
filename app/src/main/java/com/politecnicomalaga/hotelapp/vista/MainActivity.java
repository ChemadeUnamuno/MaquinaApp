package com.politecnicomalaga.hotelapp.vista;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.politecnicomalaga.hotelapp.R;
import com.politecnicomalaga.hotelapp.model.Maquina;
import java.util.function.Function;

public class MainActivity extends AppCompatActivity {

    private Maquina maquina;
    private Activity thisAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thisAct = this;
        maquina = new Maquina("1A",55,5);
        Button miBotonComprobar = (Button) findViewById(R.id.botonComprobar);
        Button miBotonArrancar = (Button) findViewById(R.id.botonArrancar);
        Button miBotonApagar = (Button) findViewById(R.id.botonApagar);
        EditText setTemp = (EditText) findViewById(R.id.setTemp);
        EditText setAmp = (EditText) findViewById(R.id.setAmp);
        TextView tvLed = (TextView) findViewById(R.id.textoLed);
        TextView tvEstado = (TextView) findViewById(R.id.textoEstado);

        miBotonArrancar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                miBotonComprobar.callOnClick(); // (Actualizar Datos)
                maquina.arrancar();
                miBotonComprobar.callOnClick(); // (Comprobar Incidencia)


            }
        });

        miBotonApagar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                miBotonComprobar.callOnClick(); // (Actualizar Datos)
                maquina.apagar();
                tvLed.setText("OFF");
                tvLed.setTextColor(Color.WHITE);
                tvLed.setBackgroundColor(Color.BLACK);
                tvEstado.setText("OFF");
                tvEstado.setBackgroundColor(Color.RED);

            }
        });

        miBotonComprobar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                try {
                    maquina.setAmperios(Float.parseFloat(setAmp.getText().toString()));
                    maquina.setTemperatura(Float.valueOf(setTemp.getText().toString()));

                    switch (maquina.getLuzPiloto()) {
                        case apagada:
                            tvLed.setText("OFF");
                            tvLed.setTextColor(Color.WHITE);
                            tvLed.setBackgroundColor(Color.BLACK);
                            break;
                        case rojo:
                            tvLed.setText("ROJO");
                            tvLed.setTextColor(Color.WHITE);
                            tvLed.setBackgroundColor(Color.RED);
                            break;
                        case amarillo:
                            tvLed.setText("AMARILLO");
                            tvLed.setTextColor(Color.WHITE);
                            tvLed.setBackgroundColor(Color.YELLOW);
                            break;
                        case verde:
                            tvLed.setText("VERDE");
                            tvLed.setTextColor(Color.WHITE);
                            tvLed.setBackgroundColor(Color.GREEN);//argb(1f,0.9f,0.1f,0.5f));
                            break;
                        default:
                            tvLed.setText("ERROR");
                            tvLed.setTextColor(Color.WHITE);
                            tvLed.setBackgroundColor(Color.BLACK);
                    }

                    if(maquina.getLuzPiloto() != Maquina.Piloto.apagada) {
                        tvEstado.setText("ON");
                        tvEstado.setBackgroundColor(Color.GREEN);
                    } else {
                        tvEstado.setText("OFF");
                        tvEstado.setBackgroundColor(Color.RED);
                    }

                    Function<Boolean, String> estado = (b) -> b ? "ON" : "OFF";
                    tvEstado.setText(estado.apply(maquina.isEncendida()));

                } catch (NumberFormatException e) {
                    Toast.makeText(thisAct,"Los Amperios y la Temperatura deben ser numéricos",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}