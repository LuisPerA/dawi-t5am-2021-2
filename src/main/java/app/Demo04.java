package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {

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
			System.out.println("Bienvenido: " + u.getNombre());
			System.out.println(u);
		}
		
		
		em.close();
	}
}
