package br.edu.infnet.appEduardoSantos.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Alimento extends Produto{

    private boolean bebida;
    @Size(min = 3, max = 10, message = "Permitido minimo 3 e Máximo 10 caracteres")
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
