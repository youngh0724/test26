package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	@Autowired
	private SqlSessionTemplate sst;
	public List<Book> selectBookList(){
		return sst.selectList("ksmart.project.test26.service.BookMapper.selectBookList");
		
	}
}

