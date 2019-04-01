package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorDao {

	@Inject
	private Banco banco;

	public void salva(Autor autor) {
		
		System.out.println("[INFO] Salvando o Autor " + autor.getNome());
		
//		try {
//			Thread.sleep(20000); // 20 segundos
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		banco.save(autor);
		
		System.out.println("[INFO] Salvou o Autor " + autor.getNome());
			
	}
	
	public List<Autor> todosAutores() {
		return banco.listaAutores();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.banco.buscaPelaId(autorId);
		return autor;
	}
	
	@PostConstruct
	void aposCriacao() {
		System.out.println("[INFO] AutorDao foi criado.");
	}
	
}
