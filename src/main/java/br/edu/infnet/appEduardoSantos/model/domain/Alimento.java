package br.edu.infnet.appEduardoSantos.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Alimento extends Produto{

    private boolean bebida;
    private String detalhes;

    @Override
    public String toString() {
        return String.format("%s;%s;%s",
                super.toString(),
                bebida ? "bebida=sim" : "bebida=não",
                detalhes
        );
    }

    public boolean isBebida() {
        return bebida;
    }

    public void setBebida(boolean bebida) {
        this.bebida = bebida;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}
