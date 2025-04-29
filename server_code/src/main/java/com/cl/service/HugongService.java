package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HugongEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HugongView;


/**
 * 护工
 *
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
public interface HugongService extends IService<HugongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HugongView> selectListView(Wrapper<HugongEntity> wrapper);
   	
   	HugongView selectView(@Param("ew") Wrapper<HugongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HugongEntity> wrapper);
   	

}

