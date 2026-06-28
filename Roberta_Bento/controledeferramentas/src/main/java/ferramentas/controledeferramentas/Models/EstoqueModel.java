package ferramentas.controledeferramentas.Models;

import ferramentas.controledeferramentas.Models.ProdutoModel;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "estoque")
public class EstoqueModel {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "valor")
    private int valor;

    @Column(name = "data_hora")
    private LocalDateTime data_hora;

    @ManyToOne
    private ProdutoModel produto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }
}
