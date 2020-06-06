<template>
  <div id="app">
    <Header/>
    <router-view></router-view>
    <Footer/>
  </div>
</template>

<script>
import Header from '@/components/pages/common/header.vue'
import Footer from '@/components/pages/common/Footer.vue'

export default {
  name: 'App',
  components: {
    Header,
    Footer,
  },
  computed: {
    username () {
      return this.$route.params.username
    }
  },
  method: {
    goBack () {
      window.history.length > 1
          ? this.$router.go(-1)
          : this.$router.push('/')
    },
    go ( targetName ) {
      this.$router.push(targetName)
    }
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
