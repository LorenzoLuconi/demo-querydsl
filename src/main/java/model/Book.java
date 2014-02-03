package model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

import com.google.common.collect.Sets;

@Entity @Data
public class Book {

	@Id @GeneratedValue
	private Integer id;
	
	private BigDecimal price;
	
	private String name;
	
	private String genre;
	
	@ManyToMany
	private Set<Author> authors = Sets.newHashSet();
	
	private String summary;
	
	@ElementCollection
	private Set<String> tags = Sets.newHashSet();
}
