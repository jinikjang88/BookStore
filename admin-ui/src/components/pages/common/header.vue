<template>
  <div>
    Header
    <p>
      <router-link to="/">home</router-link> |
      <router-link to="/kakao">kakao</router-link> |
      <router-link to="/facebook">facebook</router-link>
    </p>
  </div>
</template>

<script>
  export default {
    name: "header"
  }
</script>

<style scoped>

</style>
