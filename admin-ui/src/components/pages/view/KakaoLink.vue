<template>
  <div class="hello">
    {{ text }}
    <div id="map" style="width:500px;height:400px;"></div>
    <a id="kakao-link-btn" @click="sendLink()">
    <img
        src="//developers.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_medium.png"
    />
    </a>
    <div
        class="fb-share-button"
        data-href="https://jinikjang88.github.io/"
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
  name: 'KakaoLink',
  props: {
    msg: String
  },
  data: () => ({
    text: ""
  }),
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement('script');
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src = 'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=f9419f8ddb1d60fd0304da91cf250f0b';
      document.head.appendChild(script);
    }
  },
  methods: {
    initMap() {
      var container = document.getElementById('map');
      var options = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 3
      };

      var map = new kakao.maps.Map(container, options);
      map.setMapTypeId(kakao.maps.MapTypeId.HYBRID);
    },
    sendLink() {
      console.log(window.Kakao)
      window.Kakao.Link.sendDefault({
        objectType: 'feed',
        content: {
          title: '디저트 사진',
          description: '아메리카노, 빵, 케익',
          imageUrl:
              'https://adm-cdn.baemin.com/upload/offline/course/197.jpg',
          link: {
            mobileWebUrl: 'https://jinikjang88.github.io/',
            androidExecParams: 'test',
          },
        },
        social: {
          likeCount: 10,
          commentCount: 20,
          sharedCount: 30,
        },
        buttons: [
          {
            title: '웹으로 이동',
            link: {
              mobileWebUrl: 'https://jinikjang88.github.io/',
            },
          },
          {
            title: '앱으로 이동',
            link: {
              mobileWebUrl: 'https://jinikjang88.github.io/',
            },
          },
        ],
        success: function(response) {
          console.log(response);
        },
        fail: function(error) {
          console.log(error);
        }
      });
    },
  }
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
