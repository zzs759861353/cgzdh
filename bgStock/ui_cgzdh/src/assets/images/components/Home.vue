<template>
  <div class="row max">
    <div class="col-xs-12 h-100">
      <div class="col-xs-10x">
          <div class="row h-32">
            <div class="col-xs-12" style = "height:247px" >
                <div class="col-xs-6  m-h-240">
                    <company-profile></company-profile>
                </div>
                <div class="col-xs-6  m-h-240">
                   <update-log></update-log>
                </div>
            </div>
         </div>
         <div class="row h-33">
           <div class="col-xs-12 ">
             <div class="col-xs-12  m-l">
                          <quick-launch></quick-launch>
                    </div>
                </div>
            </div>

            <div class="row h-20">
                    <div class="col-xs-12">
                        <div class="col-xs-12  m-l">
                        <service-guide></service-guide>



                        </div>

                    </div>
                </div>


              </div>
              <!-- PAGE CONTENT ENDS -->
          </div><!-- /.col -->

  </div>
</template>
<script>
import companyProfile from './directives/companyProfile.vue'
import noticeBoard from './directives/noticeBoard.vue'
import questionBoard from './directives/questionBoard.vue'
import quickLaunch from './directives/quickLaunch.vue'
import serviceGuide from './directives/serviceGuide.vue'
import reviewFeedback from './directives/reviewFeedback.vue'
import updateLog from './directives/updateLog.vue'
export default {
  name: 'Home',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  components: {
    companyProfile: 'companyProfile',
    noticeBoard: 'noticeBoard',
    questionBoard: 'questionBoard',
    quickLaunch: 'quickLaunch',
    serviceGuide: 'serviceGuide',
    reviewFeedback: 'reviewFeedback',
    updateLog: 'updateLog'
  }
}
</script>
<style>
</style>
