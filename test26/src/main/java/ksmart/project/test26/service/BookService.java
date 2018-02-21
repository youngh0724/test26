package ksmart.project.test26.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


@Service
@Transactional
public class BookService {
	@Autowired
	private BookDao bookDao;
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
	private static final Logger logger = LoggerFactory.getLogger(BookService.class);
	
	public List<BookFile> bookSelectListBookFile(int bookId){
		
		logger.debug("bookSelectListBookFile() bookId = {}", bookId);
		List<BookFile> list = bookDao.bookSelectListBookFile(bookId);
		logger.debug("bookSelectListBookFile() list = {}", list);
		return list;
	}
	
	public BookAndBookFile bookAndBookFileMap(int bookId){
		logger.debug("bookAndBookFileMap() bookId = {}", bookId);
		BookAndBookFile bookAndBookFile = bookDao.bookAndBookFileMap(bookId);
		logger.debug("bookAndBookFileMap() bookId = {}", bookAndBookFile.getBookId());
		logger.debug("bookAndBookFileMap() bookAndBookFile.getList() = {}", bookAndBookFile.getList());		
		return bookAndBookFile;		
	}
	
	
	
	public void bookFileDownload(int bookFileId, String path) {
		logger.debug("bookFileDownload() bookFileId = {}", bookFileId);
		logger.debug("bookFileDownload() path = {}", path);
		
		
		
	}
	
	public Map<String, Object> bookSelectListByPage(int currentPage, int rowPerPage, String searchWord){
		
		logger.debug("bookSelectListByPage() currentPage = {}", currentPage);
		logger.debug("bookSelectListByPage() rowPerPage = {}", rowPerPage);
		logger.debug("bookSelectListByPage() searchWord = {}", searchWord);
		
		int startRow = (currentPage-1)*rowPerPage;
		Map map = new HashMap();
		map.put("startRow", startRow);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		
		List<Book> list = bookDao.bookSelectPage(map);
		logger.debug("bookSelectListByPage() list = {}", list);
		int totalCount = bookDao.bookSelectTotalCount();
		logger.debug("bookSelectListByPage() totalCount = {}", totalCount);
		
		Map returnMap = new HashMap();
		returnMap.put("list", list);
		returnMap.put("totalCount", totalCount);
		
		return returnMap;
	}
	
	//컨트롤러에서 전체 리스트를 조회할때 사용되어지는 메서드 
	public List<Book> bookSelcetList(){
		//dao에있는 전체 정보를 조회하는 메서드를 호출하여 list에 할당한다.
		List<Book> list = bookDao.bookSelectList();
		//list에 들어있는 값을 확인해본다.
		logger.debug("bookSelcetList() list = {}", list);
		return list;
	}
	
	//컨트롤러에서 정볼르 입력할때 사용되어지는 메서드
	public void bookInsert(BookCommand bookCommand, String path) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.
		logger.debug("bookInsert() bookName = {}", bookCommand.getBookName());
		
		//매개변수 ArticleCommand타입에서 Article타입을 뽑아낸다.
		Book book = new Book();
		book.setBookName(bookCommand.getBookName());
		//위에서 뽑아낸 Book타입을 insert한다.
		bookDao.bookInsert(book);
		
		//insert쿼리문에서 생성된 id값을 꺼내오고 확인해본다.
		int generatedId = book.getBookId();
		logger.debug("bookInsert() bookId = {}", book.getBookId());
		
		for(MultipartFile files : bookCommand.getFiles()) {
			BookFile bookFile = new BookFile();
			
			//겹치지 않는 값을 사용하기위해 랜덤UUID메서드를 사용하여 오리지널 파일이름을 사용하는 대신 사용한다.
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString().toString().replaceAll("-", "");	//중복되지 않는 이름 랜덤....
			
			//오리지날 파일이름
			String bookFileName = files.getOriginalFilename();	
			
			//오리지널 파일이름에서 .이 마지막몇번째에 있는지 int값을 반환한다.
			int pos = bookFileName.lastIndexOf(".");
			//오리지널 파일이름에서 pos+1번째까지의 문자열을 잘라낸다.
			String fileExt = bookFileName.substring( pos + 1 );
			
			//오리지날 파일 사이즈
			long fileSize = files.getSize();	
			
			//구한값들을 매개변수로 쓸 BookFile 타입의 변수에 세팅한다.
			bookFile.setFileName(fileName);
			bookFile.setFileExt(fileExt);
			bookFile.setFileSize(fileSize);
			bookFile.setBookId(generatedId);
						
			File directory = new File(path+"/bookFileUpload/");
			if(!directory.exists()) {
				directory.mkdirs();
			} else {
				File temp = new File(path+"/bookFileUpload/", fileName+"."+fileExt);
				try {
					files.transferTo(temp);
					
					bookDao.bookInsertFile(bookFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}
	
	//컨트롤러에서 수정화면에 사용될 하나의 레코드값을 조회할때 사용되어지는 메서드
	public Book bookSelectOne(int bookId) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.
		logger.debug("bookSelectOne() bookId = {}", bookId);
		//dao에 있는 컨트롤러에서 넘겨받은값과 조건이 일치하는 정보를 조회하는 메서드를 호출하여 book에 할당한다.
		Book book = bookDao.bookSelectOneForUpdate(bookId);
		//book에 들어있는 값을 확인해본다.
		logger.debug("bookSelectOne() book = {}", book);
		return book;
	}
	
	//컨트롤러에서 넘겨받은 정보로 db정보를 수정할때 사용되어지는 메서드
	public int bookUpdate(Book book) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.
		logger.debug("bookUpdate() book = {}", book);
		//dao에 있는 수정기능의 메서드를 호출하고 결과(db에 변동이 일어난 행수)를 row에 할당한다.
		int row = bookDao.bookUpdate(book); 
		//row에 들어있는 값을 확인해본다.
		logger.debug("bookUpdate() row = {}", row);
		return row;
	}
	
	//컨트롤러에서 넘겨받은 정보로 db정보를 삭제할때 사용되어지는 메서드
	public int bookDelete(int bookId, String path) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.
		logger.debug("bookDelete() bookId = {}", bookId);
	
		List<BookFile> list = bookDao.bookSelectListBookFile(bookId);
		
		if( list != null) {
			for(BookFile bookFile : list) {
				File file = new File(path+"/bookFileUpload/"+bookFile.getFileName()+"."+bookFile.getFileExt());
				if(file.exists()) {
					logger.debug("bookDelete() 파일이 존재하고 있습니다.");
					bookDao.bookDeleteFile(bookFile);
					file.delete();
				} else if(!file.exists()) {
					bookDao.bookDeleteFile(bookFile);
					logger.debug("bookDelete() 파일이 존재하지 앖습니다.");
				}
			}
		}
		//dao에 있는 삭제기능의 메서드를 호출하고 결과(db에 변동이 일어난 행수)를 row에 할당한다.
		int row = bookDao.bookDelete(bookId);
	
		//row에 들어있는 값을 확인해본다.
		logger.debug("bookDelete() row = {}", row);
		return row;
	}
	
}
