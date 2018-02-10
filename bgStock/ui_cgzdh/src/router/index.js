// 在 src 下新建目录 router/index.js
import Vue from 'vue';
import Router from 'vue-router'
Vue.use(Router)
// 定义斜线转驼峰的方法（path->name）
var tocamelCase = function(s) {
  var re = /\/(\w)/g;
  return s.replace(re, function($0, $1) {
    return $1.toUpperCase();
  });
}
// 将基础信息、人事人才、就业创业、社会保障、劳动关系的路由合并
var oldroutes = [];
import baseRouter from './baseRouter.js'
import businessRouter from './businessRouter.js'
oldroutes = oldroutes.concat(baseRouter.routes);
oldroutes = oldroutes.concat(businessRouter.routes);
// 设置每个路由的name
oldroutes.forEach((route) => {
  route.name = tocamelCase(route.path);
});
// 定义home下的路由
import Home from '@/components/base/Home.vue'
let homeroute = {
  path: '/home',
  name: 'home',
  component: Home,
  meta: {
    requiresAuth: true
  },
  children: oldroutes
}
// 合并认证路由和其他路由
import authRouter from './authRouter.js'
const routes = authRouter.routes.concat(homeroute)
console.info(routes)
// 创建路由对象
const router = new Router({
  routes: routes
})

// 导航钩子
// to/from 都是路由信息对象
// next 是一个函数，用于释放导航钩子
router.beforeEach((to, from, next) => {
  // route.matched 返回一个数组，包含当前路由对象的所有嵌套路径片段的路由记录
  // .some() 方法测试数组中的某些元素是否通过了指定函数的测试
  // 此处查看是否有路由记录的 meta.requiresAuth 返回 true ，返回 true 则进入 if
  let token = window.sessionStorage.getItem('gpzdh_user')
  if (to.matched.some(record => record.meta.requiresAuth) && (!token || token === null)) {
    // 查看登陆状态
    next({
      path: '/', // ,
      query: {
        // 使用 query 可在登陆成功后跳转到 to
        // 重定向到 to 的路径
        redirect: to.fullPath
      }
    })
  } else {
    // 必须要有一个 next 释放导航钩子
    next()
  }
})

// 输出路由对象
export default router
