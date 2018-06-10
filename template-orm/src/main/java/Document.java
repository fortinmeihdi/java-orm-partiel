import java.sql.DriverManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Document {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("doc");
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		}
		finally {
		if (connection != null) {
		    connection.close();
		  }
		}
	}
	
	public void ajoutCentre(Centre centre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("doc");
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(centre);
			entityManager.getTransaction().commit();
		}
		finally {
		  entityManager.close();
		  emf.close();
		}
	}
	
	public void ajoutAuteur(Auteur auteur) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("doc");
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(auteur);
			entityManager.getTransaction().commit();
			}
		finally {
		  entityManager.close();
		  emf.close();
		}
	}
	
	public void ajoutArticle(Article article) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("doc");
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(article);
			entityManager.getTransaction().commit();
			}
		finally {
		  entityManager.close();
		  emf.close();
		}
	}
	
	public Centre findCentre(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("doc");
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Centre centre = null;
			centre =  (Centre) entityManager.createQuery("select * from centre where centre_nom = ':name'").setParameter("name", name).getResultList();
			entityManager.getTransaction().commit();
			return centre;
		}
		finally {
		  entityManager.close();
		  emf.close();
		}
	}
}
