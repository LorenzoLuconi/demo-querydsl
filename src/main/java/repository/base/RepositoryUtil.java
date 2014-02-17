package repository.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class RepositoryUtil {

	/**
	 * Estrae il Class relativo al primo generic della classe target
	 * @see org.jboss.seam.framework.Home
	 * 
	 * @param targetClass
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <E> Class<E> getEntityClass(Class<?> targetClass) {
		final Type type = targetClass.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			final ParameterizedType paramType = (ParameterizedType) type;
			return (Class<E>) paramType.getActualTypeArguments()[0];
		} else {
			throw new IllegalArgumentException(
					"Could not guess entity class by reflection");
		}
	}

}
