import baseutil from './baseutil.js'
import authutil from './authutil.js'
import ArrayUtil from './ArrayUtil.js'
import StringUtil from './StringUtil.js'
import DateUtil from './DateUtil.js'
import JsonUtil from './JsonUtil.js'
import functions from './functions.js';
export default {
  install(Vue, options) {
    // 使用
    Vue.use(baseutil);
    Vue.use(authutil);
    Vue.use(ArrayUtil);
    Vue.use(DateUtil);
    Vue.use(StringUtil);
    Vue.use(JsonUtil);
    Vue.use(functions);
  }
}
