package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.bean.SearchBook;

public interface SearchBookDAO {
	
	public ArrayList<SearchBook> search(String title,String author);

}
