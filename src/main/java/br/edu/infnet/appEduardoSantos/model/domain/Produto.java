package br.edu.infnet.appEduardoSantos.model.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @Column(unique = true)
    private int codigo;
    @Min(value = 1, message = "Valor do produto maior ou igual a 10")
    private float preco;
    private String descricao;
    private boolean estoque;

    @ManyToOne
    @JoinColumn(name = "idVendedor")
    private Vendedor vendedor;

    @Override
    public String toString() {
        return String.format("%d;%d;%.2f;%s;%s", id, codigo, preco, descricao, estoque ? "estoque=sim" : "estoque=não");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isEstoque() {
        return estoque;
    }

    public void setEstoque(boolean estoque) {
        this.estoque = estoque;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
