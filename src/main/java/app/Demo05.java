package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {
	
	public static void main(String[] args) {
		//obtener conexion--> segun unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//crea los DAO usando la fabrica
		EntityManager em= fabrica.createEntityManager();
		
		//proceso: obtener la informacion de un usuario
		Usuario u = em.find(Usuario.class, 20);//devuelve el objeto usuario segun la PK

		if (u==null) {
			System.out.println("Codigo no existe");
		}else {
			System.out.println("Eliminando el usuario");
			//para reg, act, eli -> transacciones
			em.getTransaction().begin();
			em.remove(u);//para eliminar --> si existe el codigo/pero si no existe lo registra
			em.getTransaction().commit();
			System.out.println("Eliminacion Ok");

		}
		
		
		em.close();
	}

}
