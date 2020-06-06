import Vue from 'vue'
import VueRouter from "vue-router";

// 0. 모듈 시스템을 이용하고 있다면, vue와 vue라우터를 import하세요.
// 그리고 Vue.use(VueRouter)를 호출 하세요.
Vue.use(VueRouter)

// 1. 라우트 컴포넌트를 정의하세요.
// 아래 내용들은 다른 파일로부터 가져올 수 있습니다.


// 2. 라우트를 정의하세요.
// Each route should map to a component. The 'component' can
// 각 라우트는 반드시 컴포넌트와 매핑되어야 합니다.
// 'component'는 Vue.extend() 를 통해 만들어진
// 실제 컴포넌트 생성자이거나 컴포넌트 옵션 객체 입니다.

// 3. 'routes'옵션과 함께 router 인스턴스를 만드세요.
// 추가 옵션을 여기서 전달해야 합니다.
// 지금은 간단하게 유지하겠습니다.

export const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      component: () => import ('@/components/pages/view/main.vue'),
    },
    {
      path: '/news',
      component: () => import ('@/components/pages/view/NewsView.vue'),
    },
    {
      path: '/user/:id',
      component: () => import ('@/components/pages/view/User.vue')
    },
    {
      path: '/kakao',
      component: () => import ('@/components/pages/view/KakaoLink.vue')
    },
    {
      path: '/facebook',
      component: () => import ('@/components/pages/view/FaceBookLink.vue')
    }
  ]
})
