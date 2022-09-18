package com.dong.vote.demo.base;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author: dongxiaohua
 * @date: 2022-09-12 23:30:46
 */
public interface BaseMapper<T> extends Mapper<T>, Marker, MySqlMapper<T> {
}
