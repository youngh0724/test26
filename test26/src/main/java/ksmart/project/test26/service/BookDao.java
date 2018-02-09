package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private final String mapperRoot = "ksmart.project.test26.service.BookMapper.";
	
	public List<Book> selectBookList(){
		return sqlSessionTemplate.selectList(mapperRoot+"selectBookList");
	}
	
	public Book selectBookOne(int book_id) {	
		return sqlSessionTemplate.selectOne(mapperRoot+"selectBookOne", book_id);
	}
	
	public int insertBook(Book book) {
		return sqlSessionTemplate.insert(mapperRoot+"insertBookName", book);
	}
	
	public int updateBook(Book book) {
		return sqlSessionTemplate.update(mapperRoot+"updateBookName", book);
	}
	
	public int deleteBook(int book_id) {
		return sqlSessionTemplate.delete(mapperRoot+"deleteBookName", book_id);
	}
}
