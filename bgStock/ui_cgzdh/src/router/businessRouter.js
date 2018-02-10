import auto from '@/components/business/auto.vue'
import cs from '@/components/business/cs.vue'
import zd from '@/components/business/zd.vue'
import xx from '@/components/business/xx.vue'
import tactics from '@/components/business/tactics.vue'
let basepath = '/business';
let routes = [{
  path: basepath + '/auto',
  component: auto
},
{
  path: basepath + '/cs',
  component: cs
},
{
  path: basepath + '/xx',
  component: xx
},
{
  path: basepath + '/zd',
  component: zd
},
{
  path: basepath + '/tactics',
  component: tactics
}];
export default {
  routes
}
