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
        }
      }
    })
  }
}
