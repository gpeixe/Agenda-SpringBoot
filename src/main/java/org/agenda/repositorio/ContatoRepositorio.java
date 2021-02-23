package org.agenda.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import org.agenda.modelo.Contato;
import org.springframework.stereotype.Repository;

@Repository
public class ContatoRepositorio {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void cadastrar(Contato contato) {
		manager.persist(contato);
	}
	
	public void atualizar(Contato contato) {
		manager.merge(contato);
	}
	
	public List<Contato> listarTodos(){
		TypedQuery<Contato> query = manager.createQuery("select c from Contato c", Contato.class);
		return query.getResultList();
	}
	
	
	public Contato listar(int id) {
		return manager.find(Contato.class, id);
	}
	
	public void remover(Contato contato) {
		manager.remove(contato);
	}
	
	public List<Contato> listarTodosDoUsuario(int usuarioId){
		TypedQuery<Contato> query = manager.createQuery("select c from Contato c where usuario_id = ?1", Contato.class);
		query.setParameter(1, usuarioId);
		List<Contato> contatos;
		try {
			contatos = query.getResultList();
		}
		catch(Exception E) {
			contatos = null;
		}
		return contatos;
	}

	public List<Contato> listarPeloNome(int id, String nome) {
		TypedQuery<Contato> query = manager.createQuery("select c from Contato c where usuario_id = ?1 and nome = ?2", Contato.class);
		query.setParameter(1, id);
		query.setParameter(2, nome);
		List<Contato> contatos;
		try {
			contatos = query.getResultList();
		}
		catch(Exception E) {
			contatos = null;
		}
		return contatos;
	}
}
