/**
 * 
 */
package businesslogic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author cristian
 *
 */
public class JpaModule {

	public static EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistenceUnit");
		return emf.createEntityManager();
	}
	
	
}
