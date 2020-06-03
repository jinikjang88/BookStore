<template>
  <div class="hello">
    {{ text }}
    <div id="map" style="width:500px;height:400px;"></div>
    <a id="kakao-link-btn" @click="sendLink()">
    <img
        src="//developers.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_medium.png"
    />
    </a> <br >
    <a id="create-kakao-link-btn" @click="sendCreateLink()">
      <img
          src="//developers.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_medium.png"
      />
    </a>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
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
    sendCreateLink() {
      window.Kakao.Link.createDefaultButton({
        container: '#create-kakao-link-btn',
        objectType: 'feed',
        content: {
          title: '딸기 치즈 케익',
          description: '#케익 #딸기 #삼평동 #카페 #분위기 #소개팅',
          imageUrl:
              'http://k.kakaocdn.net/dn/Q2iNx/btqgeRgV54P/VLdBs9cvyn8BJXB3o7N8UK/kakaolink40_original.png',
          link: {
            mobileWebUrl: 'https://developers.kakao.com',
            webUrl: 'https://developers.kakao.com',
          },
        },
        social: {
          likeCount: 286,
          commentCount: 45,
          sharedCount: 845,
        },
        buttons: [
          {
            title: '웹으로 보기',
            link: {
              mobileWebUrl: 'https://developers.kakao.com',
              webUrl: 'https://developers.kakao.com',
            },
          },
          {
            title: '앱으로 보기',
            link: {
              mobileWebUrl: 'https://developers.kakao.com',
              webUrl: 'https://developers.kakao.com',
            },
          },
        ],
      })
    }
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
