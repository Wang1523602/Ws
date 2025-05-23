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


import com.cl.dao.HugongDao;
import com.cl.entity.HugongEntity;
import com.cl.service.HugongService;
import com.cl.entity.view.HugongView;

@Service("hugongService")
public class HugongServiceImpl extends ServiceImpl<HugongDao, HugongEntity> implements HugongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HugongEntity> page = this.selectPage(
                new Query<HugongEntity>(params).getPage(),
                new EntityWrapper<HugongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HugongEntity> wrapper) {
		  Page<HugongView> page =new Query<HugongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<HugongView> selectListView(Wrapper<HugongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HugongView selectView(Wrapper<HugongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
