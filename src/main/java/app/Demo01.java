package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {

	public static void main(String[] args) {
		//obtener conexion--> segun unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//crea los DAO usando la fabrica
		EntityManager em= fabrica.createEntityManager();
		
		//proceso: registrar un nuevo usuario
		Usuario u =new Usuario();
		u.setCodigo(10);
		u.setNombre("eren");
		u.setApellido("ackerman");
		u.setUsuario("tatakae@gmail.com");
		u.setClave("12345");
		u.setFnacim("2021/08/24");
		u.setTipo(1);
		u.setEstado(1);
		//para reg, act, eli -> transacciones
		em.getTransaction().begin();
		em.persist(u);//para registrar
		em.getTransaction().commit();
		System.out.println("Registro Ok");
		em.close();
	}
}
