package org.agenda.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import org.agenda.modelo.Compromisso;
import org.springframework.stereotype.Repository;


@Repository
public class CompromissoRepositorio {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void criar(Compromisso compromisso) {
		manager.persist(compromisso);
	}
	
	public void remover(Compromisso compromisso) {
		manager.remove(compromisso);
	}
	
	public void atualizar(Compromisso compromisso) {
		manager.merge(compromisso);
	}
	
	public List<Compromisso> listarTodos(){
		TypedQuery<Compromisso> query = manager.createQuery("select c from Compromisso c", Compromisso.class);
		return query.getResultList();
	}
	
	public Compromisso listar(int id) {
		return manager.find(Compromisso.class, id);
	}
	
	public List<Compromisso> listarTodosDoUsuario(int usuarioId){
		TypedQuery<Compromisso> query = manager.createQuery("select c from Compromisso c where contato_id = ?1", Compromisso.class);
		query.setParameter(1, usuarioId);
		List<Compromisso> compromissos;
		try {
			compromissos = query.getResultList();
		}
		catch(Exception E) {
			compromissos = null;
		}
		return compromissos;
	}
}
