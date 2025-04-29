<template>
	<div>
		<el-dialog v-model="formVisible" :title="formTitle" width="50%" destroy-on-close :fullscreen='false'>
			<el-form class="formModel_form" ref="formRef" :model="form" label-width="$template2.back.add.form.base.labelWidth" :rules="rules">
				<el-row>
					<el-col :span="12">
						<el-form-item label="医疗项目" prop="yiliaoxiangmu">
							<el-input class="list_inp" v-model="form.yiliaoxiangmu" placeholder="医疗项目"
								 type="text" 								:readonly="!isAdd||disabledForm.yiliaoxiangmu?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="医疗类型" prop="yiliaoleixing">
							<el-select
								class="list_sel"
								:disabled="!isAdd||disabledForm.yiliaoleixing?true:false"
								v-model="form.yiliaoleixing"
								placeholder="请选择医疗类型"
								>
								<el-option v-for="(item,index) in yiliaoleixingLists" :label="item"
									:value="item"
									>
								</el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="申请时间" prop="shenqingshijian">
							<el-date-picker
								class="list_date"
								v-model="form.shenqingshijian"
								format="YYYY-MM-DD HH:mm:ss"
								value-format="YYYY-MM-DD HH:mm:ss"
								type="datetime"
								:readonly="!isAdd||disabledForm.shenqingshijian?true:false"
								placeholder="请选择申请时间" />
						</el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="老人账号" prop="laorenzhanghao">
							<el-input class="list_inp" v-model="form.laorenzhanghao" placeholder="老人账号"
								 type="text" 								:readonly="!isAdd||disabledForm.laorenzhanghao?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="老人姓名" prop="laorenxingming">
							<el-input class="list_inp" v-model="form.laorenxingming" placeholder="老人姓名"
								 type="text" 								:readonly="!isAdd||disabledForm.laorenxingming?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="护工账号" prop="hugongzhanghao">
							<el-input class="list_inp" v-model="form.hugongzhanghao" placeholder="护工账号"
								 type="text" 								:readonly="!isAdd||disabledForm.hugongzhanghao?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="12">
						<el-form-item label="医疗内容" prop="yiliaoneirong">
							<el-input v-model="form.yiliaoneirong" placeholder="医疗内容" type="textarea"
							:readonly="!isAdd||disabledForm.yiliaoneirong?true:false"
							/>
						</el-form-item>
					</el-col>
				</el-row>
			</el-form>
			<template #footer v-if="isAdd||type=='logistics'||type=='reply'">
				<span class="formModel_btn_box">
					<el-button class="formModel_cancel" @click="closeClick">取消</el-button>
					<el-button class="formModel_confirm" type="primary" @click="save"
						>
						提交
					</el-button>
				</span>
			</template>
		</el-dialog>
	</div>
</template>
<script setup>
	import {
		reactive,
		ref,
		getCurrentInstance,
		nextTick,
		computed,
		defineEmits
	} from 'vue'
	const context = getCurrentInstance()?.appContext.config.globalProperties;	
	const emit = defineEmits(['formModelChange'])
	//基础信息
	const tableName = 'laorenyiliaoshenqing'
	const formName = '老人医疗申请'
	//基础信息
	//form表单
	const form = ref({})
	const disabledForm = ref({
		yiliaoxiangmu : false,
		yiliaoneirong : false,
		yiliaoleixing : false,
		shenqingshijian : false,
		laorenzhanghao : false,
		laorenxingming : false,
		hugongzhanghao : false,
		sfsh : false,
		glyhf : false,
	})
	const formVisible = ref(false)
	const isAdd = ref(false)
	const formTitle = ref('')
	//表单验证
	//匹配整数
	const validateIntNumber = (rule, value, callback) => {
		if (!value) {
			callback();
		} else if (!context?.$toolUtil.isIntNumer(value)) {
			callback(new Error("请输入整数"));
		} else {
			callback();
		}
	}
	//匹配数字
	const validateNumber = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isNumber(value)) {
			callback(new Error("请输入数字"));
		} else {
			callback();
		}
	}
	//匹配手机号码
	const validateMobile = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isMobile(value)) {
			callback(new Error("请输入正确的手机号码"));
		} else {
			callback();
		}
	}
	//匹配电话号码
	const validatePhone = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isPhone(value)) {
			callback(new Error("请输入正确的电话号码"));
		} else {
			callback();
		}
	}
	//匹配邮箱
	const validateEmail = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isEmail(value)) {
			callback(new Error("请输入正确的邮箱地址"));
		} else {
			callback();
		}
	}
	//匹配身份证
	const validateIdCard = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.checkIdCard(value)) {
			callback(new Error("请输入正确的身份证号码"));
		} else {
			callback();
		}
	}
	//匹配网站地址
	const validateUrl = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isURL(value)) {
			callback(new Error("请输入正确的URL地址"));
		} else {
			callback();
		}
	}
	const rules = ref({
		yiliaoxiangmu: [
		],
		yiliaoneirong: [
		],
		yiliaoleixing: [
		],
		shenqingshijian: [
		],
		laorenzhanghao: [
		],
		laorenxingming: [
		],
		hugongzhanghao: [
		],
		sfsh: [
		],
		glyhf: [
		],
	})
	//表单验证
	
	const formRef = ref(null)
	const id = ref(0)
	const type = ref('')
	//医疗类型列表
	const yiliaoleixingLists = ref([])
	//methods

	//获取唯一标识
	const getUUID =()=> {
      return new Date().getTime();
    }
	//重置
	const resetForm = () => {
		form.value = {
			yiliaoxiangmu: '',
			yiliaoneirong: '',
			yiliaoleixing: '',
			shenqingshijian: '',
			laorenzhanghao: '',
			laorenxingming: '',
			hugongzhanghao: '',
			sfsh: '待审核',
			glyhf: '',
		}
	}
	//获取info
	const getInfo = ()=>{
		context?.$http({
			url: `${tableName}/info/${id.value}`,
			method: 'get'
		}).then(res => {
			let reg=new RegExp('../../../file','g')
			form.value = res.data.data
			formVisible.value = true
		})
	}
	const crossRow = ref('')
	const crossTable = ref('')
	const crossTips = ref('')
	const crossColumnName = ref('')
	const crossColumnValue = ref('')
	//初始化
	const init=(formId=null,formType='add',formNames='',row=null,table=null,statusColumnName=null,tips=null,statusColumnValue=null)=>{
		resetForm()
			form.value.shenqingshijian = context?.$toolUtil.getCurDateTime()
		if(formId){
			id.value = formId
			type.value = formType
		}
		if(formType == 'add'){
			isAdd.value = true
			formTitle.value = '新增' + formName
			formVisible.value = true
		}else if(formType == 'info'){
			isAdd.value = false
			formTitle.value = '查看' + formName
			getInfo()
		}else if(formType == 'edit'){
			isAdd.value = true
			formTitle.value = '修改' + formName
			getInfo()
		}
		else if(formType == 'cross'){
			isAdd.value = true
			formTitle.value = formNames
			// getInfo()
			for(let x in row){
				if(x=='yiliaoxiangmu'){
					form.value.yiliaoxiangmu = row[x];
					disabledForm.value.yiliaoxiangmu = true;
					continue;
				}
				if(x=='yiliaoneirong'){
					form.value.yiliaoneirong = row[x];
					disabledForm.value.yiliaoneirong = true;
					continue;
				}
				if(x=='yiliaoleixing'){
					form.value.yiliaoleixing = row[x];
					disabledForm.value.yiliaoleixing = true;
					continue;
				}
				if(x=='shenqingshijian'){
					form.value.shenqingshijian = row[x];
					disabledForm.value.shenqingshijian = true;
					continue;
				}
				if(x=='laorenzhanghao'){
					form.value.laorenzhanghao = row[x];
					disabledForm.value.laorenzhanghao = true;
					continue;
				}
				if(x=='laorenxingming'){
					form.value.laorenxingming = row[x];
					disabledForm.value.laorenxingming = true;
					continue;
				}
				if(x=='hugongzhanghao'){
					form.value.hugongzhanghao = row[x];
					disabledForm.value.hugongzhanghao = true;
					continue;
				}
			}
			if(row){
				crossRow.value = row
			}
			if(table){
				crossTable.value = table
			}
			if(tips){
				crossTips.value = tips
			}
			if(statusColumnName){
				crossColumnName.value = statusColumnName
			}
			if(statusColumnValue){
				crossColumnValue.value = statusColumnValue
			}
			form.value.sfsh='待审核'
			formVisible.value = true
		}

		context?.$http({
			url: `${context?.$toolUtil.storageGet('sessionTable')}/session`,
			method: 'get'
		}).then(res => {
			var json = res.data.data
			if(json.hasOwnProperty('laorenzhanghao')&& context?.$toolUtil.storageGet("role")!="管理员"){
				form.value.laorenzhanghao = json.laorenzhanghao
				disabledForm.value.laorenzhanghao = true;
			}
			if(json.hasOwnProperty('laorenxingming')&& context?.$toolUtil.storageGet("role")!="管理员"){
				form.value.laorenxingming = json.laorenxingming
				disabledForm.value.laorenxingming = true;
			}
			if(json.hasOwnProperty('hugongzhanghao')&& context?.$toolUtil.storageGet("role")!="管理员"){
				form.value.hugongzhanghao = json.hugongzhanghao
				disabledForm.value.hugongzhanghao = true;
			}
		})
		context?.$http({
			url: `option/yiliaoleixing/yiliaoleixing`,
			method: 'get'
		}).then(res=>{
			yiliaoleixingLists.value = res.data.data
		})
	}
	//初始化
	//声明父级调用
	defineExpose({
		init
	})
	//关闭
	const closeClick = () => {
		formVisible.value = false
	}
	//富文本
	const editorChange = (e,name) =>{
		form.value[name] = e
	}
	//提交
	const save=()=>{
		var table = crossTable.value
		var objcross = JSON.parse(JSON.stringify(crossRow.value))
		let crossUserId = ''
		let crossRefId = ''
		let crossOptNum = ''
		if(type.value == 'cross'){
			if(crossColumnName.value!=''){
				if(!crossColumnName.value.startsWith('[')){
					for(let o in objcross){
						if(o == crossColumnName.value){
							objcross[o] = crossColumnValue.value
						}
					}
					//修改跨表数据
					changeCrossData(objcross)
				}else{
					crossUserId = context?.$toolUtil.storageGet('userid')
					crossRefId = objcross['id']
					crossOptNum = crossColumnName.value.replace(/\[/,"").replace(/\]/,"")
				}
			}
		}
		formRef.value.validate((valid)=>{
			if(valid){
				if(crossUserId&&crossRefId){
					form.value.crossuserid = crossUserId
					form.value.crossrefid = crossRefId
					let params = {
						page: 1,
						limit: 1000, 
						crossuserid:form.value.crossuserid,
						crossrefid:form.value.crossrefid,
					}
					context?.$http({
						url: `${tableName}/page`,
						method: 'get', 
						params: params 
					}).then(res=>{
						if(res.data.data.total>=crossOptNum){
							context?.$toolUtil.message(`${crossTips.value}`,'error')
							return false
						}else{
							context?.$http({
								url: `${tableName}/${!form.value.id ? "save" : "update"}`,
								method: 'post', 
								data: form.value 
							}).then(res=>{
								context?.$toolUtil.message(`操作成功`,'success',()=>{
									formVisible.value = false
									emit('formModelChange')
								})
							})
						}
					})
				}else{
					context?.$http({
						url: `${tableName}/${!form.value.id ? "save" : "update"}`,
						method: 'post', 
						data: form.value 
					}).then(res=>{
						context?.$toolUtil.message(`操作成功`,'success',()=>{
							formVisible.value = false
							emit('formModelChange')
						})
					})
				}
			}
		})
	}
	//修改跨表数据
	const changeCrossData=(row)=>{
		context?.$http({
			url: `${crossTable.value}/update`,
			method: 'post',
			data: row
		}).then(res=>{})
	}
</script>
<style lang="scss" scoped>
	// 表单
	.formModel_form{
		border: 0px solid #ddd;
		border-radius: 4px;
		padding: 30px;
		margin: 0;
		background: #fff;
		// form item
		:deep(.el-form-item) {
			margin: 0 150px 20px 0;
			background: none;
			display: flex;
			//label
			.el-form-item__label {
			 background: none;
			 font-weight: 500;
			 display: block;
			 width: 90px;
			 min-width: 70px;
			 text-align: right;
			}
			// 内容盒子
			.el-form-item__content {
				display: flex;
				width: calc(100% - 120px);
				justify-content: flex-start;
				align-items: center;
				flex-wrap: wrap;
				// 输入框
				.list_inp {
					border: 1px solid #eee;
					border-radius: 0px;
					padding: 0 10px;
					width: auto;
					line-height: 36px;
					box-sizing: border-box;
					min-width: 250px;
					height: 36px;
					//去掉默认样式
					.el-input__wrapper{
						border: none;
						box-shadow: none;
						background: none;
						border-radius: 0;
						height: 100%;
						padding: 0;
					}
					.is-focus {
						box-shadow: none !important;
					}
				}
				//日期选择器
				.list_date {
					border: 1px solid #eee;
					border-radius: 0px;
					width: auto;
					line-height: 36px;
					box-sizing: border-box;
					min-width: 250px;
					//去掉默认样式
					.el-input__wrapper{
						border: none;
						box-shadow: none;
						background: none;
						border-radius: 0;
						height: 100%;
					}
				}
				// 下拉框
				.list_sel {
					border: 1px solid #eee;
					border-radius: 0px;
					padding: 0 10px;
					width: auto;
					line-height: 36px;
					box-sizing: border-box;
					min-width: 250px;
					//去掉默认样式
					.select-trigger{
						height: 100%;
						.el-input{
							height: 100%;
							.el-input__wrapper{
								border: none;
								box-shadow: none;
								background: none;
								border-radius: 0;
								height: 100%;
								padding: 0;
							}
							.is-focus {
								box-shadow: none !important;
							}
						}
					}
				}
				// 长文本
				.el-textarea__inner {
					border: 1px solid #eee;
					border-radius: 0;
					padding: 12px;
					color: #333;
					width: 100%;
					font-size: 14px;
					min-height: 120px;
				}
			}
		}
	}
	// 按钮盒子
	.formModel_btn_box {
		display: flex;
		width: 100%;
		justify-content: center;
		align-items: center;
		.formModel_cancel {
			border: 0;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 24px;
			margin: 0 20px 0 0;
			color: #965F40;
			background: #965F4050;
			width: auto;
			font-size: 14px;
			min-width: 100px;
			height: 36px;
		}
		.formModel_cancel:hover {
		}
		
		.formModel_confirm {
			border: 0;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 24px;
			margin: 0 20px 0 0;
			color: #fff;
			background: #965F40;
			width: auto;
			font-size: 14px;
			min-width: 100px;
			height: 36px;
		}
		.formModel_confirm:hover {
		}
	}
</style>