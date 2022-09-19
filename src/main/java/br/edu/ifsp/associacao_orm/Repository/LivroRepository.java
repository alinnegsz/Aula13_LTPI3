package br.edu.ifsp.associacao_orm.Repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifsp.associacao_orm.Model.Livro;

public interface LivroRepository extends CrudRepository<Livro, Long> {

}
