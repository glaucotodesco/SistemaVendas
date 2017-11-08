package services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import entity.Cliente;


public class ClienteService {
	private Cliente cliente = new Cliente();
	private List<Cliente> clientes = new ArrayList<>();
	
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaVendas");

	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Cliente> getClientes() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select * from Cliente", Cliente.class);
		clientes = q.getResultList();
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public void Salvar(Cliente cliente) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();
	}
	public void excluir(Cliente cliente) {
		Cliente rmv;
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		rmv = em.find(Cliente.class, cliente.getCpf());
		em.remove(rmv);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void atualizar(Cliente cliente) {;
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
		em.close();
	}
	
	

}
