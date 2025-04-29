package com.cl.entity.view;

import com.cl.entity.YiliaoleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;


/**
 * 医疗类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
@TableName("yiliaoleixing")
public class YiliaoleixingView extends YiliaoleixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YiliaoleixingView(){
	}
 
 	public YiliaoleixingView(YiliaoleixingEntity yiliaoleixingEntity){
 	try {
			BeanUtils.copyProperties(this, yiliaoleixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
