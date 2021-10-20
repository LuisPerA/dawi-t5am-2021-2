package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {
	
	public static void main(String[] args) {
		//obtener conexion--> segun unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//crea los DAO usando la fabrica
		EntityManager em= fabrica.createEntityManager();
		
		//proceso: eliminar usuario
		Usuario u =new Usuario();
		u.setCodigo(20);

		
		//para reg, act, eli -> transacciones
		em.getTransaction().begin();
		em.remove(u);//para eliminar --> si existe el codigo/pero si no existe lo registra
		em.getTransaction().commit();
		System.out.println("Eliminacion Ok");
		em.close();
	}

}
