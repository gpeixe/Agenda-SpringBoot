package org.agenda.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import org.agenda.modelo.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepositorio {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void cadastrar(Usuario usuario) {
		manager.persist(usuario);
	}
	
	public boolean autenticar(String login, String senha) {
		Query query = manager.createQuery("select u from Usuario u where u.email= ?1 and u.senha = ?2");
		query.setParameter(1, login).setParameter(2, senha);
		try {
			query.getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}
	
	public List<Usuario> listarTodos(){
		TypedQuery<Usuario> query = manager.createQuery("select c from Usuario c", Usuario.class);
		return query.getResultList();
	}
	
	public Usuario listarPeloEmail(String email){
		TypedQuery<Usuario> query = manager.createQuery("select u from Usuario u where u.email= ?1", Usuario.class);
		query.setParameter(1, email);
		return query.getSingleResult();
	}

	
	public Usuario listar(int id) {
		return manager.find(Usuario.class, id);
	}
	
	public void remover(Usuario usuario) {
		manager.remove(usuario);
	}
}
