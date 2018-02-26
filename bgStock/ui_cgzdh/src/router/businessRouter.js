import auto from '@/components/business/auto.vue'
import cs from '@/components/business/cs.vue'
import zd from '@/components/business/zd.vue'
import dlzd from '@/components/business/dlzd.vue'
import xx from '@/components/business/xx.vue'
import dlxx from '@/components/business/dlxx.vue'
import cz from '@/components/business/cz.vue'
import zfb from '@/components/business/zfb.vue'
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
  path: basepath + '/cz',
  component: cz
},
{
  path: basepath + '/xx',
  component: xx
},
{
  path: basepath + '/dlxx',
  component: dlxx
},
{
  path: basepath + '/zfb',
  name: 'zfb',
  component: zfb
},
{
  path: basepath + '/dlzd',
  component: dlzd
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
