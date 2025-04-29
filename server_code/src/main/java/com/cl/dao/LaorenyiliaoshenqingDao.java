package com.cl.dao;

import com.cl.entity.LaorenyiliaoshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LaorenyiliaoshenqingView;


/**
 * 老人医疗申请
 * 
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
public interface LaorenyiliaoshenqingDao extends BaseMapper<LaorenyiliaoshenqingEntity> {
	
	List<LaorenyiliaoshenqingView> selectListView(@Param("ew") Wrapper<LaorenyiliaoshenqingEntity> wrapper);

	List<LaorenyiliaoshenqingView> selectListView(Pagination page, @Param("ew") Wrapper<LaorenyiliaoshenqingEntity> wrapper);
	
	LaorenyiliaoshenqingView selectView(@Param("ew") Wrapper<LaorenyiliaoshenqingEntity> wrapper);
	

}
