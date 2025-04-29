package com.cl.dao;

import com.cl.entity.YiliaoleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YiliaoleixingView;


/**
 * 医疗类型
 * 
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
public interface YiliaoleixingDao extends BaseMapper<YiliaoleixingEntity> {
	
	List<YiliaoleixingView> selectListView(@Param("ew") Wrapper<YiliaoleixingEntity> wrapper);

	List<YiliaoleixingView> selectListView(Pagination page, @Param("ew") Wrapper<YiliaoleixingEntity> wrapper);
	
	YiliaoleixingView selectView(@Param("ew") Wrapper<YiliaoleixingEntity> wrapper);
	

}
