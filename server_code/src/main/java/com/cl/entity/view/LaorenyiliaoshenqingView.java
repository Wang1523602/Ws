package com.cl.entity.view;

import com.cl.entity.LaorenyiliaoshenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;


/**
 * 老人医疗申请
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
@TableName("laorenyiliaoshenqing")
public class LaorenyiliaoshenqingView extends LaorenyiliaoshenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LaorenyiliaoshenqingView(){
	}
 
 	public LaorenyiliaoshenqingView(LaorenyiliaoshenqingEntity laorenyiliaoshenqingEntity){
 	try {
			BeanUtils.copyProperties(this, laorenyiliaoshenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
