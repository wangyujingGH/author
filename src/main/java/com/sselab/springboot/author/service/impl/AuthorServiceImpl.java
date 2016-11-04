package com.sselab.springboot.author.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sselab.springboot.author.dao.AuthorDao;
import com.sselab.springboot.author.form.AuthorForm;
import com.sselab.springboot.author.form.AuthorUpdateForm;
import com.sselab.springboot.author.model.AuthorModel;
import com.sselab.springboot.author.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Override
    @HystrixCommand(fallbackMethod = "getAuthorInfoFB")
    public AuthorModel getAuthorInfo(String bookname){
        return authorDao.getInfo(bookname);
    }

    public AuthorModel getAuthorInfoFB(String bookname){
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "addFB")
    public long add(AuthorForm form) {
        // TODO Auto-generated method stub
        AuthorModel model = new AuthorModel(null, form.getAuthorname(), form.getEmail(), form.getAddress());
        authorDao.insert(model);
        return model.getAuthorId();
    }

    public long addFB(AuthorForm form) {  return 0l;    }

    @Override
    @HystrixCommand(fallbackMethod = "updateFB")
    public long update(AuthorUpdateForm form) {
        // TODO Auto-generated method stub
        AuthorModel model = new AuthorModel(form.getAuthorId(), form.getAuthorname(), form.getEmail(), form.getAddress());
        authorDao.update(model);
        return model.getAuthorId();
    }

    public long updateFB(AuthorUpdateForm form){
        return 0l;
    }

    @Override
    @HystrixCommand(fallbackMethod = "deleteByIdFB")
    public int deleteById(long authorId) {
        // TODO Auto-generated method stub
        return authorDao.deleteById(authorId);
    }

    public int deleteByIdFB(long authorId) {  return 0;   }

    @Override
    @HystrixCommand(fallbackMethod = "getByIdFB")
    public AuthorModel getById(long authorId) {
        // TODO Auto-generated method stub
        return authorDao.selectById(authorId);
    }

    public AuthorModel getByIdFB(long authorId) { return null;    }

    @Override
    @HystrixCommand(fallbackMethod = "selectPagedFB")
    public List<AuthorModel> selectPaged(int page, int limits) {
        // TODO Auto-generated method stub
        List<AuthorModel> list = authorDao.selectPaged(page, limits);
        return list;
    }

    public List<AuthorModel> selectPagedFB(int page, int limits) {    return  null;   }
}


