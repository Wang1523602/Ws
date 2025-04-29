package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;


/**
 * 老人医疗申请
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
@TableName("laorenyiliaoshenqing")
public class LaorenyiliaoshenqingEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public LaorenyiliaoshenqingEntity() {
		
	}
	
	public LaorenyiliaoshenqingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 医疗项目
	 */
					
	private String yiliaoxiangmu;
	
	/**
	 * 医疗内容
	 */
					
	private String yiliaoneirong;
	
	/**
	 * 医疗类型
	 */
					
	private String yiliaoleixing;
	
	/**
	 * 申请时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date shenqingshijian;
	
	/**
	 * 老人账号
	 */
					
	private String laorenzhanghao;
	
	/**
	 * 老人姓名
	 */
					
	private String laorenxingming;
	
	/**
	 * 护工账号
	 */
					
	private String hugongzhanghao;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 回复内容
	 */
					
	private String glyhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：医疗项目
	 */
	public void setyiliaoxiangmu(String yiliaoxiangmu) {
		this.yiliaoxiangmu = yiliaoxiangmu;
	}
	/**
	 * 获取：医疗项目
	 */
	public String getyiliaoxiangmu() {
		return yiliaoxiangmu;
	}
	/**
	 * 设置：医疗内容
	 */
	public void setyiliaoneirong(String yiliaoneirong) {
		this.yiliaoneirong = yiliaoneirong;
	}
	/**
	 * 获取：医疗内容
	 */
	public String getyiliaoneirong() {
		return yiliaoneirong;
	}
	/**
	 * 设置：医疗类型
	 */
	public void setyiliaoleixing(String yiliaoleixing) {
		this.yiliaoleixing = yiliaoleixing;
	}
	/**
	 * 获取：医疗类型
	 */
	public String getyiliaoleixing() {
		return yiliaoleixing;
	}
	/**
	 * 设置：申请时间
	 */
	public void setShenqingshijian(Date shenqingshijian) {
		this.shenqingshijian = shenqingshijian;
	}
	/**
	 * 获取：申请时间
	 */
	public Date getShenqingshijian() {
		return shenqingshijian;
	}
	/**
	 * 设置：老人账号
	 */
	public void setLaorenzhanghao(String laorenzhanghao) {
		this.laorenzhanghao = laorenzhanghao;
	}
	/**
	 * 获取：老人账号
	 */
	public String getLaorenzhanghao() {
		return laorenzhanghao;
	}
	/**
	 * 设置：老人姓名
	 */
	public void setLaorenxingming(String laorenxingming) {
		this.laorenxingming = laorenxingming;
	}
	/**
	 * 获取：老人姓名
	 */
	public String getLaorenxingming() {
		return laorenxingming;
	}
	/**
	 * 设置：护工账号
	 */
	public void sethugongzhanghao(String hugongzhanghao) {
		this.hugongzhanghao = hugongzhanghao;
	}
	/**
	 * 获取：护工账号
	 */
	public String gethugongzhanghao() {
		return hugongzhanghao;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：回复内容
	 */
	public void setglyhf(String glyhf) {
		this.glyhf = glyhf;
	}
	/**
	 * 获取：回复内容
	 */
	public String getglyhf() {
		return glyhf;
	}

}
