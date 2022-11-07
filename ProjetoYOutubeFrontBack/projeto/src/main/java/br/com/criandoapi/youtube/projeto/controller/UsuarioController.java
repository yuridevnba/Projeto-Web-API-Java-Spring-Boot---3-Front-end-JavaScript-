package br.com.criandoapi.youtube.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.criandoapi.youtube.projeto.model.Usuario;
//import br.com.criandoapi.youtube.projeto.repository.IUsuario;
import br.com.criandoapi.youtube.projeto.service.UsuarioService;


@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

	//@Autowired
	//private IUsuario dao;
	private UsuarioService usuarioService;
	
    public UsuarioController(UsuarioService usuarioService) {
    	this.usuarioService=usuarioService;
    }
	@GetMapping
	public  ResponseEntity <List<Usuario>> listaUsuarios() {
		//List<Usuario>lista= dao.findAll();
		//List<Usuario>lista=usuarioService.listaUsuario();// recebe uma lista e guarda dentro da variável do tipo lista.
		return ResponseEntity.status(200).body(usuarioService.listaUsuario());// retornava (lista)
		
	}
	@PostMapping
	public ResponseEntity<Usuario> criarUsuuario(@RequestBody  Usuario usuario) {// requestbody= no corpo da requisição.
		//Usuario usuarioNovo= dao.save(usuario);
		return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuario));
		
	}
	@PutMapping
	public ResponseEntity<Usuario> editarUsuuario(@RequestBody  Usuario usuario) {// requestbody= no corpo da requisição.
		//Usuario usuarioNovo= dao.save(usuario);
		//return ResponseEntity.status(201).body(usuarioNovo);
		return ResponseEntity.status(200).body(usuarioService.editarUsuario(usuario));
    }
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> excluirUsuario(@PathVariable Integer id) {
		//Optional<Usuario> usuario=dao.findById(id);
		//dao.deleteById(id);
		usuarioService.excluirUsuario(id);
		return ResponseEntity.status(204).build();
	}
	
}
