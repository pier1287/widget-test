package it.carusopi.widgettest.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by mirkovarese on 19/01/17.
 */

public class CartaFedeltaModel implements Serializable{

    public UUID getId() {
        return id;
    }

    private UUID id;
    private String descrizione, imgFrontePath, imgRetroPath;
    private NegozioModel negozio;
    private BarCodeModel codice;
    private boolean preferita, prima;
    private boolean selected;
    private Date ultimoUtilizzo;
    private int countUtilizzi;

    public CartaFedeltaModel(BarCodeModel codice, String descrizione, String imgFrontePath, String imgRetroPath, NegozioModel negozio, boolean preferita, Date ultimoUtilizzo, int countUtilizzi, boolean prima, boolean selected) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.imgFrontePath = imgFrontePath;
        this.imgRetroPath = imgRetroPath;
        this.negozio = negozio;
        this.preferita = preferita;
        this.ultimoUtilizzo = ultimoUtilizzo;
        this.countUtilizzi = countUtilizzi;
        this.prima = prima;
        this.selected = selected;
        this.id = UUID.randomUUID();
    }

    public CartaFedeltaModel(){
        this.id = UUID.randomUUID();
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isPrima() {
        return prima;
    }

    public void setPrima(boolean prima) {
        this.prima = prima;
    }

    public Date getUltimoUtilizzo() {
        return ultimoUtilizzo;
    }

    public void setUltimoUtilizzo(Date ultimoUtilizzo) {
        this.ultimoUtilizzo = ultimoUtilizzo;
    }

    public int getCountUtilizzi() {
        return countUtilizzi;
    }

    public void setCountUtilizzi(int countUtilizzi) {
        this.countUtilizzi = countUtilizzi;
    }

    public BarCodeModel getBarcode() {
        return codice;
    }

    public void setBarcode(BarCodeModel codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getImgFrontePath() {
        return imgFrontePath;
    }

    public void setImgFrontePath(String imgFrontePath) {
        this.imgFrontePath = imgFrontePath;
    }

    public String getImgRetroPath() {
        return imgRetroPath;
    }

    public void setImgRetroPath(String imgRetroPath) {
        this.imgRetroPath = imgRetroPath;
    }

    public NegozioModel getNegozio() {
        return negozio;
    }

    public void setNegozio(NegozioModel negozio) {
        this.negozio = negozio;
    }

    public boolean isPreferita() {
        return preferita;
    }

    public void setPreferita(boolean preferita) {
        this.preferita = preferita;
    }
}
