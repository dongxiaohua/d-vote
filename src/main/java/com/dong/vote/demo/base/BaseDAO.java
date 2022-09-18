package com.dong.vote.demo.base;

import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author: dongxiaohua
 * @date: 2022-09-17 13:44:55
 */
public abstract class BaseDAO<T> implements BaseMapper<T> {

  protected abstract BaseMapper<T> getMapper();


  @Override
  public int deleteByPrimaryKey(Object o) {
    return 0;
  }

  @Override
  public int delete(T t) {
    return 0;
  }

  @Override
  public int insert(T t) {
    return 0;
  }

  @Override
  public int insertSelective(T t) {
    return 0;
  }

  @Override
  public boolean existsWithPrimaryKey(Object o) {
    return false;
  }

  @Override
  public List<T> selectAll() {
    return null;
  }

  @Override
  public T selectByPrimaryKey(Object o) {
    return null;
  }

  @Override
  public int selectCount(T t) {
    return 0;
  }

  @Override
  public List<T> select(T t) {
    return null;
  }

  @Override
  public T selectOne(T t) {
    return null;
  }

  @Override
  public int updateByPrimaryKey(T t) {
    return 0;
  }

  @Override
  public int updateByPrimaryKeySelective(T t) {
    return 0;
  }

  @Override
  public int deleteByExample(Object o) {
    return 0;
  }

  @Override
  public List<T> selectByExample(Object o) {
    return null;
  }

  @Override
  public int selectCountByExample(Object o) {
    return 0;
  }

  @Override
  public T selectOneByExample(Object o) {
    return null;
  }

  @Override
  public int updateByExample(T t, Object o) {
    return 0;
  }

  @Override
  public int updateByExampleSelective(T t, Object o) {
    return 0;
  }

  @Override
  public List<T> selectByExampleAndRowBounds(Object o, RowBounds rowBounds) {
    return null;
  }

  @Override
  public List<T> selectByRowBounds(T t, RowBounds rowBounds) {
    return null;
  }

  @Override
  public int insertList(List<? extends T> list) {
    return 0;
  }

  @Override
  public int insertUseGeneratedKeys(T t) {
    return 0;
  }

}
