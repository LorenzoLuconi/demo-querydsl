package repository.base;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.path.EntityPathBase;

@RequiredArgsConstructor
public abstract class QueryDSLRespository<E, PK>  implements Repository<E, PK> {
	
	@Inject @Getter(AccessLevel.PROTECTED)
	private EntityManager em;
	
	@Getter(AccessLevel.PROTECTED)
	private Class<E> entityClass = RepositoryUtil.getEntityClass(getClass());
	
	protected abstract EntityPathBase<?> getEntityPath();
	
	
	public JPQLQuery createQuery() {
		return new JPAQuery(em).from(getEntityPath());
	}
	
	public JPQLQuery queryAll() {
		return createQuery();
	}
	
	public JPQLQuery queryAll(Predicate predicate) {
		return queryAll().where(predicate);
	}
	
	public E findBy(PK pk) {
		return em.find(entityClass, pk);
	}
	
	
} 
