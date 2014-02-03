package businesslogic;

import java.math.BigDecimal;
import java.util.Map;

import javax.inject.Inject;

import model.Author;
import model.QAuthor;
import model.QBook;

import com.google.common.base.Optional;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.SearchResults;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.JPQLQueryFactory;

/**
 * @author marco
 *
 */
public class MyStrangeLogic {
	
	private final JPQLQueryFactory factory;
	
	@Inject
	public MyStrangeLogic(JPQLQueryFactory factory) {
		this.factory = factory;
	}
	
	public SearchResults<Author> authorsQuery(Optional<String> name, Optional<BigDecimal> lowerPrice) {
		QAuthor author = QAuthor.author;
		QBook book = QBook.book;
		JPQLQuery query = factory.from(author);
		BooleanBuilder conditions = new BooleanBuilder();
		if (name.isPresent()) {
			query.leftJoin(author.books, book);
			conditions.and(author.fullname.containsIgnoreCase(name.get()));
		}
		if (lowerPrice.isPresent()) {
			conditions.and(book.price.goe(lowerPrice.get()));
		}
		query.where(conditions).limit(100).offset(10);
		return query.orderBy(author.fullname.asc()).listResults(author);
	}
	
	public Map<String, Long> bookByGenre(Author byAuthor) {
		QBook book = QBook.book;
		return factory.from(book).where(book.authors.contains(byAuthor))
				.groupBy(book.genre).map(book.genre, book.count());
	}
}
