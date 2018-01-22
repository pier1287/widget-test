package it.carusopi.widgettest.model;

import java.io.Serializable;

/**
 * Created by mirkovarese on 18/01/17.
 */

public class NegozioModel implements Serializable {

    private String nome_compagnia;
    private String nome_logo;
    private String url_website;

    public NegozioModel(String nome_compagnia, String nome_logo, String url_website) {
        this.nome_compagnia = nome_compagnia;
        this.nome_logo = nome_logo;
        this.url_website = url_website;
    }

    public String getNome() {
        return nome_compagnia;
    }

    public void setNome(String nome) {
        this.nome_compagnia = nome;
    }

    public String getLogo() {
        return nome_logo;
    }

    public void setLogo(String logo) {
        this.nome_logo = logo;
    }

    public String getUrl() {
        return url_website;
    }

    public void setUrl(String url_website) {
        this.url_website = url_website;
    }
}

