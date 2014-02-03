package model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.google.common.collect.Sets;

import lombok.Data;

@Data @Entity
public class Author {

	@Id @GeneratedValue
	private Integer id;
	
	private String fullname;
	
	@ManyToMany(mappedBy="authors")
	private Set<Book> books = Sets.newHashSet();
}
