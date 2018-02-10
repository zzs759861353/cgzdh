export default {
  // getToken: state => {
  //   // return state.token;
  //   return state.userDetail;
  // },
  // getUserMenus: state => {
  //   return state.userMenus;
  // },
  // getUserMenus: state => {
  //   return state.userDetail;
  // },
  getCodelist: state => {
    return state.codelist;
    // return state.userMenus;
  },
  getUserDetail: state => {
    return state.userDetail;
  },
  getSiMenus: state => {
    return state.menus;
  },
  getAc01Dto: state => {
    return state.ac01Dto;
  }
}
