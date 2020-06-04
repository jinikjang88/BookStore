<template>
  <div id="app">
    <h1> Hello App! </h1>
    <p>
    </p>
    이 사이에 뷰 라우터 가 있슴다
    <router-view></router-view>
    이 사이에 뷰 라우터 가 있슴다
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    HelloWorld,
  },
  computed: {
  },
  method: {
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
