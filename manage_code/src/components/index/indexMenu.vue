<template>
	<div>
		<el-scrollbar wrap-class="scrollbar-wrapper" class="menu_scrollbar">
			<el-menu :default-openeds="[]" :unique-opened="true" default-active="0" class="menu_view"
				:collapse="collapse">
				<el-sub-menu :index="0" @click="menuHandler('')">
					<template #title>
						<i class="iconfont icon-zhuye2" v-if="collapse?true:true"></i>
						<span>首页</span>
					</template>
				</el-sub-menu>
				<el-sub-menu v-for=" (menu,index) in menuList.backMenu" :key="menu.menu" :index="index+2+''">
					<template #title>
						<i class="iconfont" :class="menu.fontClass" v-if="collapse?true:true"></i>
						<span>{{ menu.menu }}</span>
					</template>
					<el-menu-item class="menu_item_view" v-for=" (child,sort) in menu.child" :key="sort"
						:index="(index+2)+'-'+sort" @click="menuHandler(child.tableName,child.menuJump)">{{ child.menu }}
					</el-menu-item>
				</el-sub-menu>
			</el-menu>
		</el-scrollbar>
	</div>
</template>

<script setup>
	import menu from '@/utils/menu'
	import {
		ref,
		toRefs,
		getCurrentInstance,
		nextTick
	} from 'vue';
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	//props
	const props = defineProps({
		collapse: Boolean
	})
	const {
		collapse
	} = toRefs(props)
	//data
	const menuList = ref([])
	const role = ref('')
	const styleChange = () => {
		nextTick(() => {
			document.querySelectorAll('.el-menu-vertical-demo .el-sub-menu .el-menu').forEach(el => {
				el.removeAttribute('style')
				const icon = {
					"border": "none",
					"padding": "0",
					"margin": "10px auto 0",
					"borderRadius": "0px",
					"background": "none",
					"display": "none",
					"width": "100%"
				}
				Object.keys(icon).forEach((key) => {
					el.style[key] = icon[key]
				})
			})
		})
	}
	//权限验证
	const btnAuth = (e,a)=>{
		return context?.$toolUtil.isAuth(e,a)
	}
	const init = () => {
		const menus = menu.list()
		if (menus) {
			menuList.value = menus
		}
		role.value = context?.$toolUtil.storageGet('role')

		for (let i = 0; i < menuList.value.length; i++) {
			if (menuList.value[i].roleName == role.value) {
				menuList.value = menuList.value[i];
				break;
			}
		}
		// styleChange()
	}
	const menuHandler = (name,menuJump) => {
		if(name == 'center'){
			name = `${role.value}Center`
		}
		if(name == 'storeup'){
			name = `storeup?type=${menuJump}`
		}
		if(name == 'exampaper' && menuJump == '12'){
			name = 'exampaperlist'
		}
		if(name == 'examrecord' && menuJump == '22'){
			name = 'examfailrecord'
		}
		let router = context?.$router
		name = '/' + name
		router.push(name)
	}
	init()
</script>

<style lang="scss" scoped>
	// 总盒子
	:deep(.menu_scrollbar) {

		// 菜单盒子-展开样式
		.menu_view {
			border: 0;
			padding: 0 0 60px;
			color: #fff;
			background: none;
			height: 100%;

			// 无二级菜单
			.el-menu-item {
				padding: 0 10px 0 30px;
				box-shadow: inset 1px 1px 5px 0px rgba(0,0,0,0.3);
				margin: 0 0 5px;
				color: #fff;
				background: none;
				font-weight: 500;
				border-color: #ff9c05;
				border-width: 0px;
				line-height: 40px;
				border-style: solid;
				height: 40px;
				.iconfont {
					margin: 0 5px 0 0;
					color: inherit;
					width: 20px;
					vertical-align: middle;
					font-size: 20px;
					text-align: center;
				}
			}

			// 无二级悬浮
			.el-menu-item:hover {
				padding: 0 10px 0 30px;
				box-shadow: inset 1px 1px 5px 0px rgba(0,0,0,0.3);
				margin: 0 0 5px;
				color: #ffc8a5;
				background: none;
				border-color: #ff9c05;
				border-width: 0px;
				line-height: 40px;
				border-style: solid;
				height: 40px;
			}

			// 无二级选中
			.el-menu-item.is-active {
				padding: 0 10px 0 30px;
				box-shadow: inset 1px 1px 5px 0px rgba(0,0,0,0.3);
				margin: 0 0 5px;
				color: #ffc8a5;
				background: none;
				border-color: #ff9c05;
				border-width: 0px;
				line-height: 40px;
				border-style: solid;
				height: 40px;
			}

			// 有二级盒子
			.el-sub-menu {
				cursor: pointer;
				padding: 0 0;
				color: #333;
				white-space: nowrap;
				background: none;
				position: relative;

				// 有二级item
				.el-sub-menu__title {
					padding: 0 10px 0 30px;
					box-shadow: inset 1px 1px 5px 0px rgba(0,0,0,0.3);
					margin: 0 0 5px;
					color: #fff;
					background: none;
					font-weight: 500;
					border-color: #ff9c05;
					border-width: 0px;
					line-height: 40px;
					border-style: solid;
					height: 40px;
					.iconfont {
						margin: 0 5px 0 0;
						color: inherit;
						width: 20px;
						vertical-align: middle;
						font-size: 20px;
						text-align: center;
					}
					.el-sub-menu__icon-arrow{
						margin: -6px 0 0 8px;
						color: inherit;
						vertical-align: middle;
						font-size: 12px;
						position: absolute;
						right: 10px;
					}
				}

				// 有二级item悬浮
				.el-sub-menu__title:hover {
					padding: 0 10px 0 30px;
					box-shadow: inset 1px 1px 5px 0px rgba(0,0,0,0.3);
					margin: 0 0 5px;
					color: #ffc8a5;
					background: none;
					border-color: #ff9c05;
					border-width: 0px;
					line-height: 40px;
					border-style: solid;
					height: 40px;
				}
			}
			//二级选中
			.is-active {
				.el-sub-menu__title {
					padding: 0 10px 0 30px;
					box-shadow: inset 1px 1px 5px 0px rgba(0,0,0,0.3);
					margin: 0 0 5px;
					color: #ffc8a5;
					background: none;
					border-color: #ff9c05;
					border-width: 0px;
					line-height: 40px;
					border-style: solid;
					height: 40px;
				}
			}
			// 二级盒子
			.el-menu--inline {
				border: none;
				padding: 0;
				margin: -5px 0 5px;
				background: none;
				width: auto;
				box-sizing: border-box;
				// 二级菜单
				.menu_item_view {
					padding: 0 20px 0 52px;
					box-shadow: none;
					margin: 0 0 5px;
					color: #fff;
					background: none;
					display: block;
					border-color: #fbbe62;
					border-width: 0px;
					line-height: 40px;
					border-style: solid;
					height: 40px;
				}
				// 二级悬浮
				.menu_item_view:hover {
					padding: 0 20px 0 52px;
					color: #fff;
					background: #965F40 url(http://codegen.caihongy.cn/20231103/c4a5cbdd271c46c297ba96d01f4849ef.png) center center/100% 100% no-repeat;
					border-color: #fbbe62;
					border-width: 0px;
					line-height: 40px;
					border-style: solid;
					height: 40px;
				}
				// 二级选中
				.is-active.menu_item_view {
					padding: 0 20px 0 52px;
					box-shadow: none;
					color: #fff;
					background: #965F40 url(http://codegen.caihongy.cn/20231103/c4a5cbdd271c46c297ba96d01f4849ef.png) center center/100% 100% no-repeat;
					border-color: #fbbe62;
					border-width: 0px;
					line-height: 40px;
					border-style: #fbbe62;
					height: 40px;
				}
			}
		}
		// 菜单盒子-关闭样式
		.el-menu--collapse {
			padding: 0 10px;
			color: #fff;
			background: red;
			height: 100%;

			// 无二级菜单
			.el-menu-item {
				padding: 0 10px;
				color: #666;
				background: #fff;
				line-height: 50px;
				height: 50px;
				.iconfont {
					margin: 0 5px 0 0;
					color: inherit;
					width: 34px;
					vertical-align: middle;
					font-size: 20px;
					text-align: center;
				}
			}

			// 无二级悬浮
			.el-menu-item:hover {
				padding: 0 10px;
				color: #ccc;
				background: gray;
				line-height: 50px;
				height: 50px;
			}

			// 无二级选中
			.el-menu-item.is-active {
				padding: 0 10px;
				color: #ccc;
				background: #123;
				line-height: 50px;
				height: 50px;
			}

			// 有二级盒子
			.el-sub-menu {
				cursor: pointer;
				padding: 0 0;
				color: #333;
				white-space: nowrap;
				background: #fff;
				position: relative;

				// 有二级item
				.el-sub-menu__title {
					padding: 0 10px;
					color: #666;
					background: #fff;
					line-height: 50px;
					height: 50px;
					.iconfont {
						margin: 0 5px 0 0;
						color: inherit;
						width: 34px;
						vertical-align: middle;
						font-size: 20px;
						text-align: center;
					}
					.el-sub-menu__icon-arrow{
						margin: -3px 0 0 8px;
						color: inherit;
						vertical-align: middle;
						font-size: 12px;
						position: static;
					}
				}

				// 有二级item悬浮
				.el-sub-menu__title:hover {
					padding: 0 10px;
					color: #ccc;
					background: gray;
					line-height: 50px;
					height: 50px;
				}
			}
			//二级选中
			.is-active {
				.el-sub-menu__title {
					padding: 0 10px;
					color: #ccc;
					background: #123;
					line-height: 50px;
					height: 50px;
				}
			}
			// 二级盒子
			.el-menu--inline {
				border: none;
				padding: 4px;
				background: #123;
				// 二级菜单
				.menu_item_view {
					padding: 0 40px;
					color: #666;
					background: goldenrod;
					line-height: 50px;
					height: 50px;
				}
				// 二级悬浮
				.menu_item_view:hover {
					padding: 0 40px;
					color: #f00;
					background: greenyellow;
					line-height: 50px;
					height: 50px;
				}
				// 二级选中
				.is-active.menu_item_view {
					padding: 0 40px;
					color: #000;
					background: burlywood;
					line-height: 50px;
					height: 50px;
				}
			}
		}
	}
</style>
<style lang="scss">
	.el-popper{
		.el-menu--popup-container {
			.el-menu--popup{
				border: none;
				padding: 4px;
				background: #123;
				// 二级菜单
				.menu_item_view {
					padding: 0 40px;
					color: #666;
					background: goldenrod;
					line-height: 50px;
					height: 50px;
				}
				// 二级悬浮
				.menu_item_view:hover {
					padding: 0 40px;
					color: #f00;
					background: greenyellow;
					line-height: 50px;
					height: 50px;
				}
				// 二级选中
				.is-active.menu_item_view {
					padding: 0 40px;
					color: #000;
					background: burlywood;
					line-height: 50px;
					height: 50px;
				}
			}
		}
	}
</style>
