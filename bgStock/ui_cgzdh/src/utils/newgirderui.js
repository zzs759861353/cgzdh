import Vuex from 'Vuex'
import axios from 'axios'

export default {
  install(Vue, options) {
    Vue.use(Vuex);
    var vuexStore = new Vuex.Store({
      state: {
        // 数据源
        userDetail: {},
        menus: {},
        codeList: []
      },
      // 数据操作
      mutations: {
        setUserDetail: function(state, userDetail) {
          state.userDetail = userDetail;
        },
        setMenus: function(state, menus) {
          state.menus = menus;
        },
        setCodeList: function(state, codeList) {
          state.codeList = codeList;
        }
      }
    });

    Vue.prototype.getCurrentUserSimisID = () => {
      var userDetail = vuexStore.state.userDetail;
      if (userDetail.associatedCompanys) {
        return userDetail.associatedCompanys[0].companyNumber;
      } else {
        return '000000000';
      }
    }
    Vue.prototype.setCurrentUserSimisID = (userDetail) => {
      vuexStore.commit('setUserDetail', userDetail);
    }
    Vue.prototype.setCodeList = (codeList) => {
      vuexStore.commit('setCodeList', codeList);
    }
    Vue.prototype.getCodeList = (codeType) => {
      return vuexStore.state.codeList;
    }
    Vue.prototype.getMenus = () => {
      return vuexStore.state.menus;
    }
    Vue.prototype.setMenus = (menus) => {
      vuexStore.commit('setMenus', menus);
    }
  }
}
