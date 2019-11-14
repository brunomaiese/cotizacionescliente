package com.webir.cotizacionesuy.utils;

import com.webir.cotizacionesuy.dtypes.CasaCambiariaItem2;

import java.util.Comparator;

public class CompraComparator implements Comparator<CasaCambiariaItem2> {
    @Override
    public int compare(CasaCambiariaItem2 c1, CasaCambiariaItem2 c2) {
        Double d1 = new Double(c1.getCompra());
        Double d2 = new Double(c2.getCompra());
        return -1*d1.compareTo(d2);
    }
}
