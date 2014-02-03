package businesslogic;

import javax.inject.Provider;
import javax.persistence.EntityManager;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.mysema.query.jpa.JPQLQueryFactory;
import com.mysema.query.jpa.impl.JPAQueryFactory;

public class QueryModule implements Module {

	@Provides
	public JPQLQueryFactory getFactory(Provider<EntityManager> emp) {
		return new JPAQueryFactory(emp);
	}

	public void configure(Binder binder) {
	}
}
