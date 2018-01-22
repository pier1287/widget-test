package it.carusopi.widgettest.model;

import java.io.Serializable;

/**
 * Created by mirkovarese on 02/02/17.
 */

public class BarCodeModel implements Serializable {
    String codice, barCodeFormat;

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getBarCodeFormat() {
        return barCodeFormat;
    }

    public void setBarCodeFormat(String barCodeFormat) {
        this.barCodeFormat = barCodeFormat;
    }

    public BarCodeModel(String codice, String barCodeFormat) {
        this.codice = codice;
        this.barCodeFormat = barCodeFormat;
    }
}
