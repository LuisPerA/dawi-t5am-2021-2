package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo06 {
	
	public static void main(String[] args) {
		//obtener conexion--> segun unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//crea los DAO usando la fabrica
		EntityManager em= fabrica.createEntityManager();
		
		//proceso: obtener la informacion de un usuario
		System.out.println("Listado de los usuarios");
		
		String sql= "select u from Usuario u";//jpa
		
		List<Usuario> lstUsuarios=em.createQuery(sql, Usuario.class).getResultList();
		
		System.out.println("cantidad de ususarios : " + lstUsuarios.size());
		for (Usuario u:lstUsuarios) {
			System.out.println(">>> " + u);
		}
		
		
		System.out.println("Listado de los usuarios x tipo");
		String sql2= "select u from Usuario u where u.tipo= :xtipo";//jpa
		TypedQuery<Usuario> query = em.createQuery(sql2, Usuario.class);
		query.setParameter("xtipo", 1);
		
		List<Usuario> lstUsuarios2=query.getResultList();
		
		System.out.println("cantidad de ususarios : " + lstUsuarios2.size());
		for (Usuario u:lstUsuarios2) {
			System.out.println(">>> " + u);
		}
		
		em.close();
	}

}
