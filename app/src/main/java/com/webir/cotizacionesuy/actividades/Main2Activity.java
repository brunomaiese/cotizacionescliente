package com.webir.cotizacionesuy.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.webir.cotizacionesuy.R;
import com.webir.cotizacionesuy.adapters.CotizacionAdapter;
import com.webir.cotizacionesuy.dtypes.CasaCambiariaItem;
import com.webir.cotizacionesuy.dtypes.RespuestaCotizaciones;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private Spinner mMonedas;
    private Spinner mAcciones;
    private ListView mListView;
    private CotizacionAdapter mCotizacionAdapter;
    private List<CasaCambiariaItem> mCasaCambiariaItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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
        r1.setDistanciaGales(329);
        r1.setDistanciaIndumex(200);
        r1.setDistanciaSir(500);
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
        obtenerCasaCambiariaItems(r1);

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
        // mCasaCambiariaItems.add(sir);
        // mCasaCambiariaItems.add(indumex);

        mCotizacionAdapter = new CotizacionAdapter(Main2Activity.this,mCasaCambiariaItems);
        mListView.setAdapter(mCotizacionAdapter);
        mCotizacionAdapter.notifyDataSetChanged();
    }
}
