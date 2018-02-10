import companylogin from '@/components/auth/companylogin'
import accountregister from '@/components/auth/accountregister'
let routes = [{
  path: '/',
  redirect: '/login'
},
{
  path: '/login',
  name: 'companylogin',
  component: companylogin
},
{
  path: '/register',
  name: 'accountregister',
  component: accountregister
}
];
export default {
  routes
}
