/**
 * 
 */
package test;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Author;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import businesslogic.JpaModule;

/**
 * @author cristian
 *
 */
public class CreateAuthor {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistenceUnit");
	EntityManager em;
	
	@Test
	public void createAuthor() {
		assertThat(em).isInstanceOf(EntityManager.class);
		em.getTransaction().begin();
		
		Author a = new Author("Cristian Lucchesi");
		em.persist(a);
		em.getTransaction().commit();
		
		assertThat(a.getId()).isInstanceOf(Integer.class);
	}
	
	@BeforeTest
	public void initializeEm() {
		em = JpaModule.getEntityManager();
	}
	
}
