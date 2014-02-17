package repository;

import static model.QAuthor.author;
import repository.base.QueryDSLRespository;
import model.Author;

import com.mysema.query.types.path.EntityPathBase;

public class AuthorRepository extends QueryDSLRespository<Author, Integer> {

	@Override
	protected EntityPathBase<?> getEntityPath() {
		return author;
	}

}
