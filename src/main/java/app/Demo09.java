package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo09 {

	public static void main(String[] args) {
		//obtener conexion--> segun unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//crea los DAO usando la fabrica
		EntityManager em= fabrica.createEntityManager();
		
		
		//proceso: obtener la informacion de un usuario
		
		//validar un usuario segun su usuario y clave->usar procedimientos almacenados

		String sql2= "{call usp_validaAcceso (?, ?)}";//jpa
		
		//TypedQuery<Usuario> query = em.createQuery(sql2, Usuario.class); JPA
		Query query= em.createNativeQuery(sql2, Usuario.class);
		query.setParameter(1, "U002@gmail.com");
		query.setParameter(2, "10002");
		
		Usuario u=null;
		try {
			u = (Usuario) query.getSingleResult();
		} catch (Exception e) {

		}
		
		if (u==null) {
			System.out.println("Codigo no existe");
		}else {
			System.out.println("Bienvenido: " + u.getNombre());
			System.out.println(u);
		}
		
		
		em.close();
	}
}
