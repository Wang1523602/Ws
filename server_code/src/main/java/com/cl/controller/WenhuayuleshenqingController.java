package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.WenhuayuleshenqingEntity;
import com.cl.entity.view.WenhuayuleshenqingView;

import com.cl.service.WenhuayuleshenqingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 文化娱乐申请
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
@RestController
@RequestMapping("/wenhuayuleshenqing")
public class WenhuayuleshenqingController {
    @Autowired
    private WenhuayuleshenqingService wenhuayuleshenqingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WenhuayuleshenqingEntity wenhuayuleshenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("laoren")) {
			wenhuayuleshenqing.setLaorenzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("hugong")) {
			wenhuayuleshenqing.sethugongzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WenhuayuleshenqingEntity> ew = new EntityWrapper<WenhuayuleshenqingEntity>();

		PageUtils page = wenhuayuleshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wenhuayuleshenqing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WenhuayuleshenqingEntity wenhuayuleshenqing, 
		HttpServletRequest request){
        EntityWrapper<WenhuayuleshenqingEntity> ew = new EntityWrapper<WenhuayuleshenqingEntity>();

		PageUtils page = wenhuayuleshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wenhuayuleshenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WenhuayuleshenqingEntity wenhuayuleshenqing){
       	EntityWrapper<WenhuayuleshenqingEntity> ew = new EntityWrapper<WenhuayuleshenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wenhuayuleshenqing, "wenhuayuleshenqing")); 
        return R.ok().put("data", wenhuayuleshenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WenhuayuleshenqingEntity wenhuayuleshenqing){
        EntityWrapper< WenhuayuleshenqingEntity> ew = new EntityWrapper< WenhuayuleshenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wenhuayuleshenqing, "wenhuayuleshenqing")); 
		WenhuayuleshenqingView wenhuayuleshenqingView =  wenhuayuleshenqingService.selectView(ew);
		return R.ok("查询文化娱乐申请成功").put("data", wenhuayuleshenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WenhuayuleshenqingEntity wenhuayuleshenqing = wenhuayuleshenqingService.selectById(id);
		wenhuayuleshenqing = wenhuayuleshenqingService.selectView(new EntityWrapper<WenhuayuleshenqingEntity>().eq("id", id));
        return R.ok().put("data", wenhuayuleshenqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WenhuayuleshenqingEntity wenhuayuleshenqing = wenhuayuleshenqingService.selectById(id);
		wenhuayuleshenqing = wenhuayuleshenqingService.selectView(new EntityWrapper<WenhuayuleshenqingEntity>().eq("id", id));
        return R.ok().put("data", wenhuayuleshenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WenhuayuleshenqingEntity wenhuayuleshenqing, HttpServletRequest request){
    	wenhuayuleshenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wenhuayuleshenqing);
        wenhuayuleshenqingService.insert(wenhuayuleshenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WenhuayuleshenqingEntity wenhuayuleshenqing, HttpServletRequest request){
    	wenhuayuleshenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wenhuayuleshenqing);
        wenhuayuleshenqingService.insert(wenhuayuleshenqing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WenhuayuleshenqingEntity wenhuayuleshenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wenhuayuleshenqing);
        wenhuayuleshenqingService.updateById(wenhuayuleshenqing);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String glyhf){
        List<WenhuayuleshenqingEntity> list = new ArrayList<WenhuayuleshenqingEntity>();
        for(Long id : ids) {
            WenhuayuleshenqingEntity wenhuayuleshenqing = wenhuayuleshenqingService.selectById(id);
            wenhuayuleshenqing.setSfsh(sfsh);
            wenhuayuleshenqing.setglyhf(glyhf);
            list.add(wenhuayuleshenqing);
        }
        wenhuayuleshenqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wenhuayuleshenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
