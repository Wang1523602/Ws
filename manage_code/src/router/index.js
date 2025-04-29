	import {
		createRouter,
		createWebHashHistory
	} from 'vue-router'
	import yiliaoleixing from '@/views/yiliaoleixing/list'
	import leixing from '@/views/leixing/list'
	import wenhuayuleshenqing from '@/views/wenhuayuleshenqing/list'
	import laoren from '@/views/laoren/list'
	import shequxinwen from '@/views/shequxinwen/list'
	import hugong from '@/views/hugong/list'
	import jingshenweiji from '@/views/jingshenweiji/list'
	import laorenyiliaoshenqing from '@/views/laorenyiliaoshenqing/list'
	import fuwuleixing from '@/views/fuwuleixing/list'
	import shenghuofuwushenqing from '@/views/shenghuofuwushenqing/list'
	import laorenRegister from '@/views/laoren/register'
	import laorenCenter from '@/views/laoren/center'
	import hugongRegister from '@/views/hugong/register'
	import hugongCenter from '@/views/hugong/center'

export const routes = [{
		path: '/login',
		name: 'login',
		component: () => import('../views/login.vue')
	},{
		path: '/',
		name: '首页',
		component: () => import('../views/index'),
		children: [{
			path: '/',
			name: '首页',
			component: () => import('../views/HomeView.vue'),
			meta: {
				affix: true
			}
		}, {
			path: '/updatepassword',
			name: '修改密码',
			component: () => import('../views/updatepassword.vue')
		}
		
		,{
			path: '/laorenCenter',
			name: '老人个人中心',
			component: laorenCenter
		}
		,{
			path: '/hugongCenter',
			name: '护工个人中心',
			component: hugongCenter
		}
		,{
			path: '/yiliaoleixing',
			name: '医疗类型',
			component: yiliaoleixing
		}
		,{
			path: '/leixing',
			name: '类型',
			component: leixing
		}
		,{
			path: '/wenhuayuleshenqing',
			name: '文化娱乐申请',
			component: wenhuayuleshenqing
		}
		,{
			path: '/laoren',
			name: '老人',
			component: laoren
		}
		,{
			path: '/shequxinwen',
			name: '社区新闻',
			component: shequxinwen
		}
		,{
			path: '/hugong',
			name: '护工',
			component: hugong
		}
		,{
			path: '/jingshenweiji',
			name: '精神慰籍',
			component: jingshenweiji
		}
		,{
			path: '/laorenyiliaoshenqing',
			name: '老人医疗申请',
			component: laorenyiliaoshenqing
		}
		,{
			path: '/fuwuleixing',
			name: '服务类型',
			component: fuwuleixing
		}
		,{
			path: '/shenghuofuwushenqing',
			name: '生活服务申请',
			component: shenghuofuwushenqing
		}
		]
	},
	{
		path: '/laorenRegister',
		name: '老人注册',
		component: laorenRegister
	},
	{
		path: '/hugongRegister',
		name: '护工注册',
		component: hugongRegister
	},
]

const router = createRouter({
	history: createWebHashHistory(process.env.BASE_URL),
	routes
})

export default router
