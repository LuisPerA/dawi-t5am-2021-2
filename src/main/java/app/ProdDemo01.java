package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;
import model.Usuario;

public class ProdDemo01 {

	public static void main(String[] args) {
		//obtener conexion--> segun unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//crea los DAO usando la fabrica
		EntityManager em= fabrica.createEntityManager();
		
		//proceso: registrar un nuevo usuario
		Producto p =new Producto();
		p.setIdprod("P0050");
		p.setDescripcion("Prueba");
		p.setStock(10);
		p.setIdcategoria(1);
		p.setPrecio(0.99);
		

		
		//para reg, act, eli -> transacciones
		em.getTransaction().begin();
		em.persist(p);//para registrar
		em.getTransaction().commit();
		System.out.println("Registro Ok");
		em.close();
	}
}
