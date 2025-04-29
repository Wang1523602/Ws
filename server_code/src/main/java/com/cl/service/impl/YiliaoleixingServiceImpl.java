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


import com.cl.dao.YiliaoleixingDao;
import com.cl.entity.YiliaoleixingEntity;
import com.cl.service.YiliaoleixingService;
import com.cl.entity.view.YiliaoleixingView;

@Service("yiliaoleixingService")
public class YiliaoleixingServiceImpl extends ServiceImpl<YiliaoleixingDao, YiliaoleixingEntity> implements YiliaoleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YiliaoleixingEntity> page = this.selectPage(
                new Query<YiliaoleixingEntity>(params).getPage(),
                new EntityWrapper<YiliaoleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YiliaoleixingEntity> wrapper) {
		  Page<YiliaoleixingView> page =new Query<YiliaoleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YiliaoleixingView> selectListView(Wrapper<YiliaoleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YiliaoleixingView selectView(Wrapper<YiliaoleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
