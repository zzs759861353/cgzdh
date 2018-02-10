import welcome from '@/components/base/welcome.vue'
import unauthorized from '@/components/base/unauthorized.vue'
import jcxx from '@/components/base/jcxx.vue'
let basepath = '/base';
let routes = [{
  path: basepath + '/welcome',
  component: welcome
}, {
  path: basepath + '/unauthorized',
  component: unauthorized
}, {
  path: basepath + '/jcxx',
  component: jcxx
}];
export default {
  routes
}
