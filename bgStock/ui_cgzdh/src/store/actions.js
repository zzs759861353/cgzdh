export default {
  setCodelist: function(dis, codelist) {
    dis.commit('SETCODELIST', codelist);
  },
  setuserDetail: function(dis, userDetail) {
    dis.commit('SETUSERDETAIL', userDetail)
  },
  setMenus: function(dis, menus) {
    dis.commit('SETMENUS', menus)
  },
  setAc01Dto: function(dis, ac01Dto) {
    dis.commit('SETAC01DTO', ac01Dto)
  },
  setToken: function(dis, token){
    dis.commit('SETTOKEN', token)
  },
  setUserMenus: function(dis, userMenus){
    console.info('setUserMenus');
    console.info(userMenus);
    dis.commit('SETUSERMENUS', userMenus)
  }
}
