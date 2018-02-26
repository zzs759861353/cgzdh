export default {
  install(Vue, options) {
    Vue.mixin({
      data: function() {
        return {
          currentUserSimisItem: 'integrated_wssb_user',
          menuItem: 'integrated_wssb_Menu',
          usermenuItem: 'integrated_wssb_user_Menu',
          tokenItem: 'gpzdh_user',
          broker: 'broker'
        }
      },
      methods: {
        // 对user对象操作
        setuserDetail: function(userDetail) {
          this.$store.dispatch('setuserDetail', userDetail);
          window.localStorage.setItem(this.currentUserSimisItem, JSON.stringify(userDetail));
        },
        getuserDetail: function() {
          var userDetail = this.$store.getters.getUserDetail;
          if (!userDetail.hasOwnProperty('orgId')) {
            userDetail = JSON.parse(window.localStorage.getItem(this.currentUserSimisItem));
            this.setuserDetail(userDetail);
          }
          return userDetail;
        },
        getuserid: function() {
          var userDetail = this.getuserDetail();
          return userDetail.id;
        },
        getCurrentUserSimisID: function() {
          var userDetail = this.getuserDetail();
          return userDetail.orgId;
        },



        // 对个人应用列表操作
        setUserMenus: function(userMenus) {
          this.$store.dispatch('setUserMenus', userMenus);
          window.localStorage.setItem(this.usermenuItem, JSON.stringify(userMenus));
        },
        getUserMenus: function() {
          var userMenus = this.$store.state.userMenus;
          if (userMenus.length === 0) {
            userMenus = JSON.parse(window.localStorage.getItem(this.usermenuItem));
            this.setUserMenus(userMenus);
          }
          return userMenus;
        },


                // 对个人应用列表操作
                setBroker: function(broker) {

                  window.localStorage.setItem(this.broker, JSON.stringify(broker));
                },
                getBroker: function() {

                  return JSON.parse(window.localStorage.getItem(this.broker));
                },

        // 对token操作
        setToken: function(token) {
          this.$store.dispatch('setToken', token);
          window.sessionStorage.setItem(this.tokenItem, JSON.stringify(token));
        },
        getToken: function() {

        },
        clearSession() {
          this.setuserDetail({});
          this.setToken({
            'access_token': '',
            'token_type': '',
            'expires_in': -1
          });
          window.localStorage.removeItem(this.currentUserSimisItem);
        }
      }
    })
  }
}
