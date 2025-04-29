package com.cl.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.Date;
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

import com.cl.entity.YiliaoleixingEntity;
import com.cl.entity.view.YiliaoleixingView;

import com.cl.service.YiliaoleixingService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;

/**
 * 医疗类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
@RestController
@RequestMapping("/yiliaoleixing")
public class YiliaoleixingController {
    @Autowired
    private YiliaoleixingService yiliaoleixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, YiliaoleixingEntity yiliaoleixing,
                  HttpServletRequest request){
        EntityWrapper<YiliaoleixingEntity> ew = new EntityWrapper<YiliaoleixingEntity>();

		PageUtils page = yiliaoleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yiliaoleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, YiliaoleixingEntity yiliaoleixing,
                  HttpServletRequest request){
        EntityWrapper<YiliaoleixingEntity> ew = new EntityWrapper<YiliaoleixingEntity>();

		PageUtils page = yiliaoleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yiliaoleixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YiliaoleixingEntity yiliaoleixing){
       	EntityWrapper<YiliaoleixingEntity> ew = new EntityWrapper<YiliaoleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yiliaoleixing, "yiliaoleixing")); 
        return R.ok().put("data", yiliaoleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YiliaoleixingEntity yiliaoleixing){
        EntityWrapper<YiliaoleixingEntity> ew = new EntityWrapper<YiliaoleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yiliaoleixing, "yiliaoleixing")); 
		YiliaoleixingView yiliaoleixingView =  yiliaoleixingService.selectView(ew);
		return R.ok("查询医疗类型成功").put("data", yiliaoleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YiliaoleixingEntity yiliaoleixing = yiliaoleixingService.selectById(id);
		yiliaoleixing = yiliaoleixingService.selectView(new EntityWrapper<YiliaoleixingEntity>().eq("id", id));
        return R.ok().put("data", yiliaoleixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YiliaoleixingEntity yiliaoleixing = yiliaoleixingService.selectById(id);
		yiliaoleixing = yiliaoleixingService.selectView(new EntityWrapper<YiliaoleixingEntity>().eq("id", id));
        return R.ok().put("data", yiliaoleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YiliaoleixingEntity yiliaoleixing, HttpServletRequest request){
    	yiliaoleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yiliaoleixing);
        yiliaoleixingService.insert(yiliaoleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YiliaoleixingEntity yiliaoleixing, HttpServletRequest request){
    	yiliaoleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yiliaoleixing);
        yiliaoleixingService.insert(yiliaoleixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YiliaoleixingEntity yiliaoleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yiliaoleixing);
        yiliaoleixingService.updateById(yiliaoleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yiliaoleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
