import Vuex from 'vuex'
import Vue from 'vue'
Vue.use(Vuex);
const store = new Vuex.Store({
  state: {
    count: 10,
    numb: 10086,
    aac002: ''
  },
  getters: {
    add: (state, getter) => {
      state.count = getter.add;
      return state.count;
    }
  },
  mutations: {
    saveAac002: (state, aac002) => {
      state.aac002 = aac002;
    }
  },
  actions: {
    actionA({
      dispatch,
      commit
    }) {
      return commit('add');
    }
  }
});
export default {
  install(Vue, options) {
    Vue.mixin({
      methods: {
        setaac002(aac002) {
          store.commit('saveAac002', aac002);
        }
      }
    })
  }
}
