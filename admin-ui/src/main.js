import Vue from 'vue'
import App from './App.vue'
import { router } from '@/router/index.js'

Vue.config.productionTip = false


// 4. 루트 인스턴스를 만들고 mount하세요.
// router와 router 옵션을 전체 앱에 주입합니다.
new Vue({
  router,
  render: h => h(App),
}).$mount('#app')

// 이제 앱이 시작됩니다.
