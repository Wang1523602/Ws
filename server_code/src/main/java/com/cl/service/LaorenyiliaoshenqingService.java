package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.LaorenyiliaoshenqingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LaorenyiliaoshenqingView;


/**
 * 老人医疗申请
 *
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
public interface LaorenyiliaoshenqingService extends IService<LaorenyiliaoshenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LaorenyiliaoshenqingView> selectListView(Wrapper<LaorenyiliaoshenqingEntity> wrapper);
   	
   	LaorenyiliaoshenqingView selectView(@Param("ew") Wrapper<LaorenyiliaoshenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LaorenyiliaoshenqingEntity> wrapper);
   	

}

