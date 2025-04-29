package com.cl.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.LaorenyiliaoshenqingEntity;
import com.cl.entity.view.LaorenyiliaoshenqingView;

import com.cl.service.LaorenyiliaoshenqingService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;

/**
 * 老人医疗申请
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
@RestController
@RequestMapping("/laorenyiliaoshenqing")
public class LaorenyiliaoshenqingController {
    @Autowired
    private LaorenyiliaoshenqingService laorenyiliaoshenqingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, LaorenyiliaoshenqingEntity laorenyiliaoshenqing,
                  HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("laoren")) {
			laorenyiliaoshenqing.setLaorenzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("hugong")) {
			laorenyiliaoshenqing.sethugongzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LaorenyiliaoshenqingEntity> ew = new EntityWrapper<LaorenyiliaoshenqingEntity>();

		PageUtils page = laorenyiliaoshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, laorenyiliaoshenqing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, LaorenyiliaoshenqingEntity laorenyiliaoshenqing,
                  HttpServletRequest request){
        EntityWrapper<LaorenyiliaoshenqingEntity> ew = new EntityWrapper<LaorenyiliaoshenqingEntity>();

		PageUtils page = laorenyiliaoshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, laorenyiliaoshenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LaorenyiliaoshenqingEntity laorenyiliaoshenqing){
       	EntityWrapper<LaorenyiliaoshenqingEntity> ew = new EntityWrapper<LaorenyiliaoshenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( laorenyiliaoshenqing, "laorenyiliaoshenqing")); 
        return R.ok().put("data", laorenyiliaoshenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LaorenyiliaoshenqingEntity laorenyiliaoshenqing){
        EntityWrapper<LaorenyiliaoshenqingEntity> ew = new EntityWrapper<LaorenyiliaoshenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( laorenyiliaoshenqing, "laorenyiliaoshenqing")); 
		LaorenyiliaoshenqingView laorenyiliaoshenqingView =  laorenyiliaoshenqingService.selectView(ew);
		return R.ok("查询老人医疗申请成功").put("data", laorenyiliaoshenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LaorenyiliaoshenqingEntity laorenyiliaoshenqing = laorenyiliaoshenqingService.selectById(id);
		laorenyiliaoshenqing = laorenyiliaoshenqingService.selectView(new EntityWrapper<LaorenyiliaoshenqingEntity>().eq("id", id));
        return R.ok().put("data", laorenyiliaoshenqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LaorenyiliaoshenqingEntity laorenyiliaoshenqing = laorenyiliaoshenqingService.selectById(id);
		laorenyiliaoshenqing = laorenyiliaoshenqingService.selectView(new EntityWrapper<LaorenyiliaoshenqingEntity>().eq("id", id));
        return R.ok().put("data", laorenyiliaoshenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LaorenyiliaoshenqingEntity laorenyiliaoshenqing, HttpServletRequest request){
    	laorenyiliaoshenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(laorenyiliaoshenqing);
        laorenyiliaoshenqingService.insert(laorenyiliaoshenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LaorenyiliaoshenqingEntity laorenyiliaoshenqing, HttpServletRequest request){
    	laorenyiliaoshenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(laorenyiliaoshenqing);
        laorenyiliaoshenqingService.insert(laorenyiliaoshenqing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LaorenyiliaoshenqingEntity laorenyiliaoshenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(laorenyiliaoshenqing);
        laorenyiliaoshenqingService.updateById(laorenyiliaoshenqing);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String glyhf){
        List<LaorenyiliaoshenqingEntity> list = new ArrayList<LaorenyiliaoshenqingEntity>();
        for(Long id : ids) {
            LaorenyiliaoshenqingEntity laorenyiliaoshenqing = laorenyiliaoshenqingService.selectById(id);
            laorenyiliaoshenqing.setSfsh(sfsh);
            laorenyiliaoshenqing.setglyhf(glyhf);
            list.add(laorenyiliaoshenqing);
        }
        laorenyiliaoshenqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        laorenyiliaoshenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
