package com.cl.entity.view;

import com.cl.entity.HugongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;


/**
 * 护工
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
@TableName("hugong")
public class HugongView extends HugongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HugongView(){
	}
 
 	public HugongView(HugongEntity hugongEntity){
 	try {
			BeanUtils.copyProperties(this, hugongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
