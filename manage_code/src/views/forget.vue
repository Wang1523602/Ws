<template>
	<div>
		<div class="forget_view">
			<el-form :model="forgetForm" class="forget_box">
				<div class="forget_title">社区医疗养老系统{{pageType==1?'找回密码':pageType==2?'输入密保':'重置密码'}}</div>
				<div class="tab_view">
					<div class="header_number" :class="pageType>1?'header_number2':pageType==1?'header_number1':''"><div class="number" v-if="pageType<2">1</div><div class="number" v-else><el-icon><Check /></el-icon></div></div>
					<div class="header_number" :class="pageType>2?'header_number2':pageType==2?'header_number1':''"><div class="number" v-if="pageType<3">2</div><div class="number" v-else><el-icon><Check /></el-icon></div></div>
					<div class="header_number" :class="pageType==3?'header_number1':''"><div class="number">3</div></div>
				</div>
			</el-form>
		</div>
	</div>
</template>
<script setup>
	import {
		ref,
		getCurrentInstance,
		nextTick,
	} from 'vue';
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const pageType = ref(1)
	const forgetForm = ref({})
	const userForm = ref({})
	//返回登录
	const close = () => {
		context?.$router.push({
			path: "/login"
		});
	}
</script>

<style lang="scss" scoped>
	.forget_view {
		background-repeat: no-repeat;
		flex-direction: column;
		background-size: 100% 100%!important;
		background: url(http://codegen.caihongy.cn/20231101/a7c636f5b2a0455d8f08899ab6e08582.png);
		display: flex;
		min-height: 100vh;
		justify-content: center;
		align-items: flex-end;
		position: relative;
		background-position: center center;
		// 表单盒子
		.forget_box {
			border-radius: 0px;
			padding: 80px 60px;
			margin: 0 12% 0 0;
			background: url(http://codegen.caihongy.cn/20231101/82632a780f5047e18aed0e5f9fbecdf1.png) no-repeat center center / 100% 100%;
			display: flex;
			width: 600px;
			justify-content: flex-start;
			flex-wrap: wrap;
			// 标题
			.forget_title {
				padding: 0px;
				margin: 0 auto 20px;
				color: #654B3C;
				font-weight: 600;
				width: 80%;
				font-size: 18px;
				text-align: center;
			}
			// tab
			// 盒子
			.tab_view {
				padding: 0 0 50px;
				display: flex;
				width: 100%;
				align-items: center;
				// 默认样式
				.header_number{
					display: flex;
					width: 100%;
					font-size: 24px;
					justify-content: center;
					align-items: center;
					.number{
						border: 4px solid #ddd;
						border-radius: 50%;
						color: #aaa;
						display: flex;
						width: 40px;
						justify-content: center;
						align-items: center;
						height: 40px;
					}
				}
				// 当前样式
				.header_number1{
					.number{
						margin: 0 30px;
						color: #654B3C;
						background: #fff;
						width: 48px;
						font-size: 26px;
						border-color: #654B3C;
						height: 48px;
					}
				}
				// 完成样式
				.header_number2{
					.number{
						color: rgba(0, 170, 0, 1.0);
						border-color: rgba(0, 170, 0, 1.0);
					}
				}
			}
			// item
			.list_item {
				margin: 10px auto;
				display: flex;
				width: 80%;
				justify-content: flex-start;
				align-items: center;
				// label
				.item_label {
					background: #fff;
					display: block;
					width: 130px;
					font-size: 14px;
					line-height: 36px;
					box-sizing: border-box;
					text-align: left;
					height: 36px;
				}
				// 输入框
				:deep(.list_inp) {
					border: 1px solid #eee;
					border-radius: 0px;
					padding: 0 10px;
					color: #666;
					background: #fff;
					width: 80%;
					line-height: 36px;
					box-sizing: border-box;
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
				//下拉框样式
				:deep(.list_sel) {
					border: 1px solid #eee;
					border-radius: 0px;
					padding: 0 10px;
					color: #666;
					background: #fff;
					width: 80%;
					line-height: 36px;
					box-sizing: border-box;
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
			}
			// 按钮盒子
			.list_btn {
				margin: 20px auto 0;
				display: flex;
				width: 80%;
				justify-content: center;
				align-items: center;
				flex-wrap: wrap;
				// 获取密保
				:deep(.el-button--success) {
					border: 0;
					cursor: pointer;
					border-radius: 0px;
					padding: 0 40px;
					margin: 0 10px 0 0;
					color: #fff;
					background: #654B3C;
					width: auto;
					font-size: 14px;
					height: 36px;
				}
				// 获取密保悬浮
				:deep(.el-button--success:hover) {
				}
				// 确认密保
				:deep(.el-button--primary) {
					border: 0;
					cursor: pointer;
					border-radius: 0px;
					padding: 0 40px;
					margin: 0 10px 0 0;
					outline: none;
					color: #fff;
					background: #654B3C;
					width: auto;
					font-size: 14px;
					height: 36px;
				}
				// 确认密保悬浮
				:deep(.el-button--primary:hover) {
				}
				// 重置密码
				:deep(.el-button--warning) {
					border: 0;
					cursor: pointer;
					border-radius: 0px;
					padding: 0 40px;
					margin: 0 10px 0 0;
					outline: none;
					color: #fff;
					background: #654B3C;
					width: auto;
					font-size: 14px;
					height: 36px;
				}
				// 重置密码悬浮
				:deep(.el-button--warning:hover) {
				}
				.r-login {
					cursor: pointer;
					padding: 10px 0 0;
					color: #999;
					width: 100%;
					font-size: 14px;
					text-align: right;
				}
			}
		}
	}

	
</style>
