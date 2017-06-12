package com.bookdao;

import java.awt.print.Book;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.connectionutil.ConnectionUtil;
import com.model.BookModel;


public class BookDao {
	private JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
		
		
		public List<Book> findAll(){
	
			String sql = "SELECT * FROM BOOK";
	
			List<Book> books  = (List) jdbcTemplate.query(sql,
					new BeanPropertyRowMapper(Book.class));
	
			return books;
		}
		
	/*	public int findTotalBook(){
				String sql = "SELECT COUNT(*) FROM BOOK";
	
			int total = jdbcTemplate.q;
				return total;
	}*/
		
	public void saveOrUpdate(BookModel bookmodel) {
		    if (bookmodel.getBook_id() < 0) {
		        // update
	        String sql = "UPDATE book SET book_id=?, book_name=?, author=?, "
		                    + " WHERE book_id=?";
		        jdbcTemplate.update(sql, bookmodel.getBook_id(), bookmodel.getBook_name(),
		                bookmodel.getAuthor(),bookmodel.getBook_id());
		    } else {
		        // insert
		        String sql = "INSERT INTO book (book_id,book_name,author)"
	                    + " VALUES (?, ?, ?)";
		        jdbcTemplate.update(sql, bookmodel.getBook_id(), bookmodel.getBook_name(),
		                bookmodel.getAuthor());
		    }
		 
		}
		
		public void delete(int book_id) {
		    String sql = "DELETE FROM book WHERE book_id=?";
		    jdbcTemplate.update(sql, book_id);
		    
	    System.out.println("Successfully deleted");
		}
	
	}


