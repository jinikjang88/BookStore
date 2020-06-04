import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')


// 0. 모듈 시스템을 이용하고 있다면, vue와 vue라우터를 import하세요.
// 그리고 Vue.use(VueRouter)를 호출 하세요.
Vue.use(VueRouter)


// 1. 라우트 컴포넌트를 정의하세요.
// 아래 내용들은 다른 파일로부터 가져올 수 있습니다.
const Foo = { template: '<div>foo</div>'}
const Bar = { template: '<div>bar</div>'}

// 2. 라우트를 정의하세요.
// Each route should map to a component. The 'component' can
// 각 라우트는 반드시 컴포넌트와 매핑되어야 합니다.
// 'component'는 Vue.extend() 를 통해 만들어진
// 실제 컴포넌트 생성자이거나 컴포넌트 옵션 객체 입니다.

const routes = [
  {
    path: '/foo', component: Foo
  },
  {
    path: '/bar', component: Bar
  }
  ]

// 3. 'routes'옵션과 함께 router 인스턴스를 만드세요.
// 추가 옵션을 여기서 전달해야 합니다.
// 지금은 간단하게 유지하겠습니다.
const router = new VueRouter({
  routes  //'routes: routes의 줄임
})

// 4. 루트 인스턴스를 만들고 mount하세요.
// router와 router 옵션을 전체 앱에 주입합니다.
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')

// 이제 앱이 시작됩니다.
