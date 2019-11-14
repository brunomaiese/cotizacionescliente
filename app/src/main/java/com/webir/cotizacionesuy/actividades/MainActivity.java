package com.webir.cotizacionesuy.actividades;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.webir.cotizacionesuy.R;
import com.webir.cotizacionesuy.adapters.CotizacionAdapter;
import com.webir.cotizacionesuy.adapters.CotizacionAdapter2;
import com.webir.cotizacionesuy.dtypes.CasaCambiariaItem;
import com.webir.cotizacionesuy.dtypes.CasaCambiariaItem2;
import com.webir.cotizacionesuy.dtypes.RespuestaCotizaciones;
import com.webir.cotizacionesuy.utils.CompraComparator;
import com.webir.cotizacionesuy.utils.DistanciaComparator;
import com.webir.cotizacionesuy.utils.VentaComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner mMonedas;
    private Spinner mAcciones;
    private ListView mListView;
    private CotizacionAdapter mCotizacionAdapter;
    private CotizacionAdapter2 mCotizacionAdapter2;
    private List<CasaCambiariaItem> mCasaCambiariaItems;
    private List<CasaCambiariaItem2> mCasaCambiariaItems2;
    public static Dialog mProgressDialog;
    private RadioGroup radioGroupOrden;
    private RadioButton radioOrden;
    private String criterioOrden = "PRECIO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mMonedas = (Spinner) findViewById(R.id.spinner_monedas);
        mAcciones = (Spinner) findViewById(R.id.spinner_acciones);
        // Initializing an ArrayAdapter
        ArrayAdapter spinnerArrayAdapter = ArrayAdapter.createFromResource(
                this, R.array.monedas, R.layout.spinner_item
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        mMonedas.setAdapter(spinnerArrayAdapter);

        ArrayAdapter spinnerArrayAdapter2 = ArrayAdapter.createFromResource(
                this, R.array.acciones, R.layout.spinner_item
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        mAcciones.setAdapter(spinnerArrayAdapter2);
        mListView = (ListView) findViewById(R.id.listCotizaciones);

        mMonedas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                obtenerCotizaciones();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        mAcciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                obtenerCotizaciones();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        radioGroupOrden = (RadioGroup) findViewById(R.id.radioOrden);
        radioOrden = (RadioButton) radioGroupOrden.findViewById(radioGroupOrden.getCheckedRadioButtonId());

        radioGroupOrden.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioDistancia) {
                    criterioOrden = "DISTANCIA";
                } else {
                    criterioOrden = "PRECIO";
                }
                obtenerCotizaciones();
            }
        });
        obtenerCotizaciones();


    }

    private void obtenerCotizaciones() {


        RespuestaCotizaciones r1 = new RespuestaCotizaciones();
        r1.setArgentinoCompraGales(0.35);
        r1.setArgentinoCompraIndumex(0.35);
        r1.setArgentinoCompraSir(0.30);
        r1.setArgentinoVentaGales(0.85);
        r1.setArgentinoVentaIndumex(0.85);
        r1.setArgentinoVentaSir(0.90);
        r1.setDistanciaGales(468.4);
        r1.setDistanciaIndumex(442);
        r1.setDistanciaSir(202.8);
        r1.setDolarCompraGales(36.50);
        r1.setDolarCompraIndumex(36.50);
        r1.setDolarCompraSir(36.50);
        r1.setDolarVentaGales(38.50);
        r1.setDolarVentaIndumex(38.50);
        r1.setDolarVentaSir(38.50);
        r1.setRealCompraGales(8.80);
        r1.setRealCompraIndumex(8.80);
        r1.setRealCompraSir(8.50);
        r1.setRealVentaGales(9.80);
        r1.setRealVentaIndumex(9.80);
        r1.setRealVentaSir(9.90);
        r1.setEuroCompraGales(40.40);
        r1.setEuroCompraIndumex(40.15);
        r1.setEuroCompraSir(39.50);
        r1.setEuroVentaGales(43.40);
        r1.setEuroVentaIndumex(43.15);
        r1.setEuroVentaSir(43.50);
        r1.setLatitudGales(-56.20557163231187);
        r1.setLongitudGales(-34.90665589381983);
        r1.setLatitudIndumex(-56.20582739262713);
        r1.setLongitudIndumex(-34.906774339155675);
        r1.setLatitudSir(-56.2082357);
        r1.setLongitudSir(-34.9074196);

        //obtenerCasaCambiariaItems(r1);
        obtenerCasaCambiariaItems2(r1);

    }

    private void obtenerCasaCambiariaItems2(RespuestaCotizaciones r1) {
        mCasaCambiariaItems2 = new ArrayList<>();
        CasaCambiariaItem2 gales = new CasaCambiariaItem2();
        gales.setNombre("Cambio Gales");
        gales.setDistancia(r1.getDistanciaGales());
        gales.setLatitud(r1.getLatitudGales());
        gales.setLongitud(r1.getLongitudGales());

        CasaCambiariaItem2 sir = new CasaCambiariaItem2();
        sir.setNombre("Cambio Sir");
        sir.setDistancia(r1.getDistanciaSir());
        sir.setLatitud(r1.getLatitudSir());
        sir.setLongitud(r1.getLongitudSir());

        CasaCambiariaItem2 indumex = new CasaCambiariaItem2();
        indumex.setNombre("Cambio Indumex");
        indumex.setDistancia(r1.getDistanciaIndumex());
        indumex.setLatitud(r1.getLatitudIndumex());
        indumex.setLongitud(r1.getLongitudIndumex());

        String moneda = mMonedas.getSelectedItem().toString();
        gales.setMoneda(moneda);
        indumex.setMoneda(moneda);
        sir.setMoneda(moneda);
        switch (moneda) {
            case "DÓLAR": {
                gales.setCompra(r1.getDolarCompraGales());
                gales.setVenta(r1.getDolarVentaGales());
                sir.setCompra(r1.getDolarCompraSir());
                sir.setVenta(r1.getDolarVentaSir());
                indumex.setCompra(r1.getDolarCompraIndumex());
                indumex.setVenta(r1.getDolarVentaIndumex());
            }
            break;
            case "ARGENTINO": {
                gales.setCompra(r1.getArgentinoCompraGales());
                gales.setVenta(r1.getArgentinoVentaGales());
                sir.setCompra(r1.getArgentinoCompraSir());
                sir.setVenta(r1.getArgentinoVentaSir());
                indumex.setCompra(r1.getArgentinoCompraIndumex());
                indumex.setVenta(r1.getArgentinoVentaIndumex());
            }
            break;
            case "REAL": {
                gales.setCompra(r1.getRealCompraGales());
                gales.setVenta(r1.getRealVentaGales());
                sir.setCompra(r1.getRealCompraSir());
                sir.setVenta(r1.getRealVentaSir());
                indumex.setCompra(r1.getRealCompraIndumex());
                indumex.setVenta(r1.getRealVentaIndumex());
            }
            break;
            case "EURO": {
                gales.setCompra(r1.getEuroCompraGales());
                gales.setVenta(r1.getEuroVentaGales());
                sir.setCompra(r1.getEuroCompraSir());
                sir.setVenta(r1.getEuroVentaSir());
                indumex.setCompra(r1.getEuroCompraIndumex());
                indumex.setVenta(r1.getEuroVentaIndumex());
            }
            break;
        }

        mCasaCambiariaItems2.add(gales);
        mCasaCambiariaItems2.add(sir);
        mCasaCambiariaItems2.add(indumex);
        String accion = mAcciones.getSelectedItem().toString();
        if (criterioOrden.equals("PRECIO")) {
            if (accion.equals("VENTA")) {
                Collections.sort(mCasaCambiariaItems2, new VentaComparator());
            } else {
                Collections.sort(mCasaCambiariaItems2, new CompraComparator());
            }
        }else{
            Collections.sort(mCasaCambiariaItems2, new DistanciaComparator());
        }
        mCotizacionAdapter2 = new CotizacionAdapter2(MainActivity.this, mCasaCambiariaItems2);
        mListView.setAdapter(mCotizacionAdapter2);
        mCotizacionAdapter2.notifyDataSetChanged();
    }

    private void obtenerCasaCambiariaItems(RespuestaCotizaciones r1) {
        mCasaCambiariaItems = new ArrayList<>();
        CasaCambiariaItem gales = new CasaCambiariaItem();
        gales.setNombre("Cambio Gales");
        gales.setDistancia(r1.getDistanciaGales());
        gales.setLatitud(r1.getLatitudGales());
        gales.setLongitud(r1.getLongitudGales());
        gales.setArgentinoCompra(r1.getArgentinoCompraGales());
        gales.setArgentinoVenta(r1.getArgentinoVentaGales());
        gales.setDolarCompra(r1.getDolarCompraGales());
        gales.setDolarVenta(r1.getDolarVentaGales());
        gales.setEuroCompra(r1.getEuroCompraGales());
        gales.setEuroVenta(r1.getEuroVentaGales());
        gales.setRealCompra(r1.getRealCompraGales());
        gales.setRealVenta(r1.getRealVentaGales());

        CasaCambiariaItem sir = new CasaCambiariaItem();
        sir.setNombre("Cambio Sir");
        sir.setDistancia(r1.getDistanciaSir());
        sir.setLatitud(r1.getLatitudSir());
        sir.setLongitud(r1.getLongitudSir());
        sir.setArgentinoCompra(r1.getArgentinoCompraSir());
        sir.setArgentinoVenta(r1.getArgentinoVentaSir());
        sir.setDolarCompra(r1.getDolarCompraSir());
        sir.setDolarVenta(r1.getDolarVentaSir());
        sir.setEuroCompra(r1.getEuroCompraSir());
        sir.setEuroVenta(r1.getEuroVentaSir());
        sir.setRealCompra(r1.getRealCompraSir());
        sir.setRealVenta(r1.getRealVentaSir());

        CasaCambiariaItem indumex = new CasaCambiariaItem();
        indumex.setNombre("Cambio Indumex");
        indumex.setDistancia(r1.getDistanciaIndumex());
        indumex.setLatitud(r1.getLatitudIndumex());
        indumex.setLongitud(r1.getLongitudIndumex());
        indumex.setArgentinoCompra(r1.getArgentinoCompraIndumex());
        indumex.setArgentinoVenta(r1.getArgentinoVentaIndumex());
        indumex.setDolarCompra(r1.getDolarCompraIndumex());
        indumex.setDolarVenta(r1.getDolarVentaIndumex());
        indumex.setEuroCompra(r1.getEuroCompraIndumex());
        indumex.setEuroVenta(r1.getEuroVentaIndumex());
        indumex.setRealCompra(r1.getRealCompraIndumex());
        indumex.setRealVenta(r1.getRealVentaIndumex());


        mCasaCambiariaItems.add(gales);
        mCasaCambiariaItems.add(sir);
        mCasaCambiariaItems.add(indumex);

        mCotizacionAdapter = new CotizacionAdapter(MainActivity.this, mCasaCambiariaItems);
        mListView.setAdapter(mCotizacionAdapter);
        mCotizacionAdapter.notifyDataSetChanged();
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




      /*  Call<RespuestaCotizaciones> a = PDAService.getPDAService().prueba();
        a.enqueue(new Callback<RespuestaCotizaciones>() {
            @Override
            public void onResponse(Call<RespuestaCotizaciones> call, Response<RespuestaCotizaciones> response) {
                if (response.body() != null) {
                    int i = 1;
                }
            }

            @Override
            public void onFailure(Call<RespuestaCotizaciones> call, Throwable t) {
                int i = 2;

            }
        });
*/

}
