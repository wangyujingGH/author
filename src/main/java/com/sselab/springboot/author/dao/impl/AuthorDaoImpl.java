package com.sselab.springboot.author.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sselab.springboot.author.dao.AuthorDao;
import com.sselab.springboot.author.mapper.AuthorMapper;
import com.sselab.springboot.author.model.AuthorModel;

import tk.mybatis.mapper.entity.Example;


@Repository
public class AuthorDaoImpl implements AuthorDao {

    @Autowired
    private AuthorMapper mapper;
	/**/
	public AuthorModel getInfo(String bookname) {
		// TODO Auto-generated method stub
		return mapper.findAuthorInfo(bookname);
	}

	@Override
	public int insert(AuthorModel model) {
		// TODO Auto-generated method stub
		return mapper.insert(model);
	}

	@Override
	public int update(AuthorModel entity) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public int deleteById(long authorId) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(authorId);
	}

	@Override
	public AuthorModel selectById(long authorId) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(authorId);
	}

	@Override
	public List<AuthorModel> selectPaged(int page, int limits) {
		// TODO Auto-generated method stub
		int offset = (page - 1) * limits;
        return mapper.selectPaged(offset, limits, "AUTHOR_PK_ID ASC");
	}

}



