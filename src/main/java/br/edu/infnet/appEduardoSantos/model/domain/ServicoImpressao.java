package br.edu.infnet.appEduardoSantos.model.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ServicoImpressao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String servico;
    private int quantidade;
    private String cor;
    private double valor;
    private LocalDate data;
    private String hora;
    @Transient
    private Vendedor vendedor;

    @Override
    public String toString() {
        return "ServicoImpressao{" +
                "id=" + id +
                ", servico='" + servico + '\'' +
                ", quantidade=" + quantidade +
                ", cor='" + cor + '\'' +
                ", valor=" + valor +
                ", data=" + data +
                ", hora='" + hora + '\'' +
                ", vendedor=" + vendedor +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
