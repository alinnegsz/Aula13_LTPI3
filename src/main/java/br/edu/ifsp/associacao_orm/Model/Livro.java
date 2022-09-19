package br.edu.ifsp.associacao_orm.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity

//NÃO ESQUECER GETTERS E SETTERS EM TODAS AS CLASSES DO MODEL
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float preco;
    private String titulo, descricao;
    private int numPaginas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_capa") // tabela submissa
    @JsonBackReference
    private Capa capa;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_livro")
    @JsonManagedReference
    private List<Rotulo> rotulos;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "associacao_livro_rotulo", joinColumns = @JoinColumn(name = "fk_livro"), inverseJoinColumns = @JoinColumn(name = "fk_rotulo"))
    private List<RotuloManyToMany> rotulosMany;

    public Livro() {

    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<RotuloManyToMany> getRotulosMany() {
        return rotulosMany;
    }

    public void setRotulosMany(List<RotuloManyToMany> rotulosMany) {
        this.rotulosMany = rotulosMany;
    }

    public Capa getCapa() {
        return capa;
    }

    public void setCapa(Capa capa) {
        this.capa = capa;
    }

    public List<Rotulo> getRotulos() {
        return rotulos;
    }

    public void setRotulos(List<Rotulo> rotulos) {
        this.rotulos = rotulos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

}
