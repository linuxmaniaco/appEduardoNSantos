package br.edu.infnet.appEduardoSantos.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Papelaria extends Produto{

    private String marca;
    private String tipoMercadoria;

    @Override
    public String toString() {
        return String.format("%s;%s;%s",
                super.toString(),
                marca,
                tipoMercadoria
        );
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipoMercadoria() {
        return tipoMercadoria;
    }

    public void setTipoMercadoria(String tipoMercadoria) {
        this.tipoMercadoria = tipoMercadoria;
    }
}
