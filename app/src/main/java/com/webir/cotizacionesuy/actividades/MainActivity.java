package com.webir.cotizacionesuy.actividades;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.webir.cotizacionesuy.R;
import com.webir.cotizacionesuy.cliente.PDAService;
import com.webir.cotizacionesuy.dtypes.RespuestaCotizaciones;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Call<RespuestaCotizaciones> a = PDAService.getPDAService().prueba();
        a.enqueue(new Callback<RespuestaCotizaciones>() {
            @Override
            public void onResponse(Call<RespuestaCotizaciones> call, Response<RespuestaCotizaciones> response) {
                if(response.body()!=null){
                    int i = 1;
                }
            }

            @Override
            public void onFailure(Call<RespuestaCotizaciones> call, Throwable t) {
                int i = 2;

            }
        });




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}