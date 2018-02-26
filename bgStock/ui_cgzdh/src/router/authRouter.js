import companylogin from '@/components/auth/companylogin'
import accountregister from '@/components/auth/accountregister'
import agentRegister from '@/components/auth/agentRegister'
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
},
{
  path: '/agentRegister',
  name: 'agentRegister',
  component: agentRegister
}
];
export default {
  routes
}
