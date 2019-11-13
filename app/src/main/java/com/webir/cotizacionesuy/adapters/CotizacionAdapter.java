package com.webir.cotizacionesuy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.webir.cotizacionesuy.R;
import com.webir.cotizacionesuy.dtypes.CasaCambiariaItem;

import java.util.List;

public class CotizacionAdapter extends ArrayAdapter<CasaCambiariaItem> {

    public CotizacionAdapter(Context context, List<CasaCambiariaItem> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        CasaCambiariaItem c = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.cotizacion_item, parent, false);
        TextView nombre = (TextView) convertView.findViewById(R.id.nombre);
        nombre.setText(c.getNombre());
        TextView distancia = (TextView) convertView.findViewById(R.id.distancia);
        distancia.setText(c.getDistancia()+" metros");
        TextView dolar = (TextView) convertView.findViewById(R.id.dolar);
        dolar.setText("Compra "+c.getDolarCompra()+" - " +"Venta "+c.getDolarVenta());
        TextView argentino = (TextView) convertView.findViewById(R.id.argentino);
        argentino.setText("Compra "+c.getArgentinoCompra()+" - " +"Venta "+c.getArgentinoVenta());
        TextView real = (TextView) convertView.findViewById(R.id.real);
        real.setText("Compra "+c.getRealCompra()+" - " +"Venta "+c.getRealVenta());
        TextView euro = (TextView) convertView.findViewById(R.id.euro);
        euro.setText("Compra "+c.getEuroCompra()+" - " +"Venta "+c.getEuroVenta());
        return convertView;

    }
}
