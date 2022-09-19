package br.edu.ifsp.associacao_orm.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Capa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String imagem, tipo;

    // tabela dominante
    @OneToOne(mappedBy = "capa") // campo capa dentro da tabela Livro
    private Livro livro;

    public Capa() {

    }

    public Long getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
