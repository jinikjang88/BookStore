<template>
  <div class="facebook">
    <div
        class="fb-share-button"
        data-href="https://academy.baemin.com/"
        data-layout="button_count"
        data-size="small">
        <a
            target="_blank"
            href="https://www.facebook.com/sharer/sharer.php?u=https%3A%2F%2Fdevelopers.facebook.com%2Fdocs%2Fplugins%2F&amp;src=sdkpreparse"
            class="fb-xfbml-parse-ignore">공유하기
        </a>
    </div>
  </div>
</template>

<script>
export default {
  name: 'FaceBookLink',
  props: {
    msg: String
  },
  data: () => ({
    text: ""
  }),
  mounted() {
  },
}
</script>


<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
