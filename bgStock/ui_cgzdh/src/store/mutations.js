export default {
  setAac002(state, aac002) {
    state.aac002 = aac002;
  },
  SETAC01DTO(state, ac01Dto) {
    state.ac01Dto = ac01Dto;
  },
  SETCODELIST(state, codelist) {
    state.codelist = codelist;
  },
  SETUSERDETAIL(state, userDetail) {
    state.userDetail = userDetail;
  },
  SETMENUS: function(state, menus) {
    state.menus = menus;
  },
  SETTOKEN: function(state, token){
    state.token = token;
  },
  SETUSERMENUS: function(state, userMenus){
    console.info('SETUSERMENUS');
    console.info(userMenus);
    state.userMenus = userMenus;
  }
}
