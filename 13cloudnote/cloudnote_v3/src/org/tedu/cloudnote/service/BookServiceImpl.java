package org.tedu.cloudnote.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tedu.cloudnote.dao.BookDao;
import org.tedu.cloudnote.entity.Book;
import org.tedu.cloudnote.util.NoteResult;
//注入bookDao
//调用bookDao.findByUserId,将结果封装成NoteResult

@Service("bookService")
public class BookServiceImpl implements BookService{
	@Resource
	private BookDao bookDao;
	
	public NoteResult loadUserBooks(String userId) {
		List<Book> list = 
			bookDao.findByUserId(userId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("查询笔记本列表成功");
		result.setData(list);
		return result;
	}

}
