package com.webir.cotizacionesuy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.webir.cotizacionesuy.R;
import com.webir.cotizacionesuy.dtypes.CasaCambiariaItem;
import com.webir.cotizacionesuy.dtypes.CasaCambiariaItem2;

import java.util.List;

public class CotizacionAdapter2 extends ArrayAdapter<CasaCambiariaItem2> {

    public CotizacionAdapter2(Context context, List<CasaCambiariaItem2> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        CasaCambiariaItem2 c = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.cotizacion_item2, parent, false);
        TextView nombre = (TextView) convertView.findViewById(R.id.nombre);
        nombre.setText(c.getNombre());
        TextView distancia = (TextView) convertView.findViewById(R.id.distancia);
        distancia.setText(c.getDistancia()+" metros");
        TextView valorCompra = (TextView) convertView.findViewById(R.id.valor_compra);
        valorCompra.setText("Compra "+c.getCompra());
        TextView valorVenta = (TextView) convertView.findViewById(R.id.valor_venta);
        valorVenta.setText("Venta "+c.getVenta());

        return convertView;

    }
}
