package br.com.criandoapi.youtube.projeto.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.criandoapi.youtube.projeto.model.Usuario;

@Repository
public interface IUsuario extends CrudRepository<Usuario,Integer>{

}
