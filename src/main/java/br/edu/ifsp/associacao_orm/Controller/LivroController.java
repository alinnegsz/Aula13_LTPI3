package br.edu.ifsp.associacao_orm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.associacao_orm.Model.Livro;
import br.edu.ifsp.associacao_orm.Repository.LivroRepository;

@RestController
@CrossOrigin
public class LivroController {
    @Autowired
    LivroRepository repo;

    @GetMapping("/livro")
    public List<Livro> recuperaLivros() {
        return (List<Livro>) repo.findAll();
    }

    @PostMapping("/livro")
    public void salvaLivro(@RequestBody Livro livro) {
        repo.save(livro);
    }
    // Exemplo requisição POST:
    // {
    // "preco": 34.89,
    // "titulo": "A Vida Invisível de Addie LaRue",
    // "descricao": "Uma vida que ninguém lembra. Um livro que ninguém esquece. Em A
    // vida invisível de Addie LaRue, o aguardado best-seller de V.E. Schwab,
    // conheça Addie e se perca em sua vida invisível ― porém memorável.",
    // "numPaginas": 504,
    // "capa": {
    // "imagem":
    // "https://m.media-amazon.com/images/P/B098RF64DZ.01._SCLZZZZZZZ_SX500_.jpg",
    // "tipo": "Brochura"
    // }
    // }
}
