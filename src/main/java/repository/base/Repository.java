package repository.base;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.Predicate;

public interface Repository<E, PK> {
	
	JPQLQuery queryAll();
	JPQLQuery queryAll(Predicate predicate);
	
	E findBy(PK pk);
}
