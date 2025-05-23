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

import com.cl.entity.HugongEntity;
import com.cl.entity.view.HugongView;

import com.cl.service.HugongService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;

/**
 * 护工
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
@RestController
@RequestMapping("/hugong")
public class HugongController {
    @Autowired
    private HugongService hugongService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		HugongEntity u = hugongService.selectOne(new EntityWrapper<HugongEntity>().eq("hugongzhanghao", username));
        if(u==null || !u.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"hugong",  "护工" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody HugongEntity hugong){
    	//ValidatorUtils.validateEntity(hugong);
    	HugongEntity u = hugongService.selectOne(new EntityWrapper<HugongEntity>().eq("hugongzhanghao", hugong.gethugongzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		hugong.setId(uId);
        hugongService.insert(hugong);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        HugongEntity u = hugongService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	HugongEntity u = hugongService.selectOne(new EntityWrapper<HugongEntity>().eq("hugongzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        hugongService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HugongEntity hugong,
                  HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("laoren")) {
			hugong.setLaorenzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HugongEntity> ew = new EntityWrapper<HugongEntity>();

		PageUtils page = hugongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, hugong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HugongEntity hugong,
                  HttpServletRequest request){
        EntityWrapper<HugongEntity> ew = new EntityWrapper<HugongEntity>();

		PageUtils page = hugongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, hugong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HugongEntity hugong){
       	EntityWrapper<HugongEntity> ew = new EntityWrapper<HugongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( hugong, "hugong")); 
        return R.ok().put("data", hugongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HugongEntity hugong){
        EntityWrapper<HugongEntity> ew = new EntityWrapper<HugongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( hugong, "hugong")); 
		HugongView hugongView =  hugongService.selectView(ew);
		return R.ok("查询护工成功").put("data", hugongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HugongEntity hugong = hugongService.selectById(id);
		hugong = hugongService.selectView(new EntityWrapper<HugongEntity>().eq("id", id));
        return R.ok().put("data", hugong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HugongEntity hugong = hugongService.selectById(id);
		hugong = hugongService.selectView(new EntityWrapper<HugongEntity>().eq("id", id));
        return R.ok().put("data", hugong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HugongEntity hugong, HttpServletRequest request){
    	hugong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(hugong);
    	HugongEntity u = hugongService.selectOne(new EntityWrapper<HugongEntity>().eq("hugongzhanghao", hugong.gethugongzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		hugong.setId(new Date().getTime());
        hugongService.insert(hugong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HugongEntity hugong, HttpServletRequest request){
    	hugong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(hugong);
    	HugongEntity u = hugongService.selectOne(new EntityWrapper<HugongEntity>().eq("hugongzhanghao", hugong.gethugongzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		hugong.setId(new Date().getTime());
        hugongService.insert(hugong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HugongEntity hugong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(hugong);
        hugongService.updateById(hugong);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        hugongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
