package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YiliaoleixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YiliaoleixingView;


/**
 * 医疗类型
 *
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
public interface YiliaoleixingService extends IService<YiliaoleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YiliaoleixingView> selectListView(Wrapper<YiliaoleixingEntity> wrapper);
   	
   	YiliaoleixingView selectView(@Param("ew") Wrapper<YiliaoleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YiliaoleixingEntity> wrapper);
   	

}

