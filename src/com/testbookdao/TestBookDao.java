package com.testbookdao;

import java.awt.print.Book;

import com.bookdao.BookDao;
import com.model.BookModel;

public class TestBookDao {public static void main(String args[])
		{
		BookDao book= new BookDao();
			
		
			
		BookModel cc= new BookModel();
			
		 cc.setBook_id(26);
			cc.setBook_name("Ranjana");
			cc.setAuthor("Shakesphere");
		
	book.saveOrUpdate(cc);
		book.delete(25);
		}
	
	
	}


