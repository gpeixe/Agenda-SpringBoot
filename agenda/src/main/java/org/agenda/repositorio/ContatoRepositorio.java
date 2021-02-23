package org.agenda.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import org.agenda.modelo.Contato;
import org.springframework.stereotype.Repository;

@Repository
public class ContatoRepositorio {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void cadastrar(Contato usuario) {
		manager.persist(usuario);
	}
	
	public boolean autenticar(String login, String senha) {
		Query query = manager.createQuery("select u from Contato u where u.email= ?1 and u.senha = ?2");
		query.setParameter(1, login).setParameter(2, senha);
		try {
			query.getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}
	
	public List<Contato> listarTodos(){
		TypedQuery<Contato> query = manager.createQuery("select c from Contato c", Contato.class);
		return query.getResultList();
	}
	
	public Contato listarPeloEmail(String email){
		TypedQuery<Contato> query = manager.createQuery("select u from Contato u where u.email= ?1", Contato.class);
		query.setParameter(1, email);
		return query.getSingleResult();
	}

	
	public Contato listar(int id) {
		return manager.find(Contato.class, id);
	}
	
	public void remover(Contato contato) {
		manager.remove(contato);
	}
}
