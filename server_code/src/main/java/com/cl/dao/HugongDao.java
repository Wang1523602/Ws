package com.cl.dao;

import com.cl.entity.HugongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HugongView;


/**
 * 护工
 * 
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
public interface HugongDao extends BaseMapper<HugongEntity> {
	
	List<HugongView> selectListView(@Param("ew") Wrapper<HugongEntity> wrapper);

	List<HugongView> selectListView(Pagination page, @Param("ew") Wrapper<HugongEntity> wrapper);
	
	HugongView selectView(@Param("ew") Wrapper<HugongEntity> wrapper);
	

}
