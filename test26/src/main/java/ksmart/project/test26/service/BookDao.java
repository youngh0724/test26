package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
   @Autowired
   private SqlSessionTemplate sst;
   
   // DELETE
   public void deleteBook(int book_id) {
      sst.delete("ksmart.project.test26.service.BookMapper.deleteBookName",book_id);
   }
   
   // INSERT
   public void insertBook(Book book) {
      sst.insert("ksmart.project.test26.service.BookMapper.insertBookName",book);
   }
   
   // SELECT ONE
   public Book getBook(int book_id) {
      return sst.selectOne("ksmart.project.test26.service.BookMapper.selectBookOne",book_id);
   }
   
   // UPDATE
   public int updateBook(Book book) {
      return sst.update("ksmart.project.test26.service.BookMapper.updateBookName",book);
   }
   
   // SELECT
   public List<Book> selectBookList(){
      return sst.selectList("ksmart.project.test26.service.BookMapper.selectBookList");
   }
   
   
}
