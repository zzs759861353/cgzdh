// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import 'babel-polyfill'
import Vue from 'vue';
import ElementUI from 'element-ui'

import 'element-ui/lib/theme-default/index.css'
// import 'element-ui/lib/theme-default/main.css'
import '../static/style/main.css';
import '../static/style/icomoon/style.css'
import '../static/style/icomoon/demo-files/demo.css'

import App from './App.vue';
import router from './router';

import './assets/bootstrap-3.3.7/css/bootstrap.min.css';
import './assets/bootstrap-3.3.7/css/bootstrap-theme.min.css';
import './assets/bootstrap-3.3.7/js/bootstrap.min.js';
Vue.config.productionTip = false;

Vue.use(require('electron-vue-debugger'));

Vue.use(ElementUI);
const VueResource = require('vue-resource');
Vue.use(VueResource);

import util from '@/utils/index.js'
Vue.use(util);

import Vuex from 'Vuex'
Vue.use(Vuex);
import TreeView from 'vue-json-tree-view'
Vue.use(TreeView)

/* eslint-disable no-new */
import stores from '@/store/index.js'
const store = new Vuex.Store({
  ...stores
})
import Dialog from 'hsy-vue-dialog'

Vue.use(Dialog)
import axios from 'axios'
var href = window.location.href;
// var baseURL = href.substring(0, href.indexOf('#'));
// axios.defaults.baseURL = baseURL;
axios.interceptors.request.use(
  config => {
  //  debugger;
    var token = window.localStorage.getItem('integrated_wssb_token');
    config.headers.common['access_token'] = token;
    return config;
  },
  err => {
    return Promise.reject(err);
  }
);
Vue.prototype.$axios = axios

new Vue({
  el: '#app',
  router,
  store,
  data: {
    eventHub: new Vue()
  },
  template: '<App/>',
  components: {
    App
  }
});
