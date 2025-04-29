package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.LaorenyiliaoshenqingDao;
import com.cl.entity.LaorenyiliaoshenqingEntity;
import com.cl.service.LaorenyiliaoshenqingService;
import com.cl.entity.view.LaorenyiliaoshenqingView;

@Service("laorenyiliaoshenqingService")
public class LaorenyiliaoshenqingServiceImpl extends ServiceImpl<LaorenyiliaoshenqingDao, LaorenyiliaoshenqingEntity> implements LaorenyiliaoshenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LaorenyiliaoshenqingEntity> page = this.selectPage(
                new Query<LaorenyiliaoshenqingEntity>(params).getPage(),
                new EntityWrapper<LaorenyiliaoshenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LaorenyiliaoshenqingEntity> wrapper) {
		  Page<LaorenyiliaoshenqingView> page =new Query<LaorenyiliaoshenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<LaorenyiliaoshenqingView> selectListView(Wrapper<LaorenyiliaoshenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LaorenyiliaoshenqingView selectView(Wrapper<LaorenyiliaoshenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
