# admin-ui

## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Lints and fixes files
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).


카카오 링크 만들기

미션 : 배민 아카데미 공유하기 기능 추가
공유 채널 : 카카오톡, 페이스북

1. 개발용 카카오 계정생성
    참고 : https://developers.kakao.com/
    로그인 > 개발용 카카오 계정 생성 (카카오톡과 연동이 되어야 함)

2. 개발용 애플리케이션 연결
    내 애플리케이션 > 애플리케이션 추가하기
    앱아이콘, 앱 이름, 회사 이름 입력 후 저장

3. 내 애플리케이션에서 플랫폼 등록 (iOS/Android/Web)
    내 애플리케이션 > 생성된 애플리케이션
    앱 설정 > 플랫폼 > Web 플랫폼 등록 > 사이트 도메인 등록
        http://localhost:8081
        http://localhost:8080
        http://localhost
        http://172.18.192.54:8081
        http://172.18.192.54
        http://192.168.13.76:8081
        http://192.168.13.76

3. 카카오 링크 가이드
    제품 > 메시지 > 문서보기
    Android/iOS/JavaScript 중 [JavaScript]
    참고 : https://developers.kakao.com/docs/latest/ko/getting-started/sdk-js
    SDK 다운로드 및 초기화
        1. SDK import
            <script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.js"></script>

        2. 앱키 초기화
            <script type="text/javascript">
                Kakao.init('YOUR APP KEY');
                Kakao.isInitialized();  ---->  true 면 정상
            </script>

4. 카카오 링크 메시지 보내기
    참고 : https://developers.kakao.com/sdk/reference/js/release/Kakao.Link.html
    피드 템플릿 : 하나의 콘텐츠와 하나의 기본 버튼이 있는 가장 기본적인 템플릿
    리스트 템플릿 : 리스트 템플릿으로 복수의 콘텐츠를 공유할 수 있는 템플릿
    텍스트 템플릿 : 긴 텍스르를 공유할 수 있는 템플릿
    로케이션 템플릿 : 위치 템플릿으로 주소와 위치를 공유할 수 있는 템플릿
    커머스 템플릿 : 가격 정보 표현에 적합한 템플릿
    스크랩 템플릿 : 웹 페이지의 Open Graph 정보로 웹 사이트를 공유할 수 있는 템플릿
    커스텀 템플릿 : 사용자가 자유롭게 생성하고 편집, 사용할 수 있는 템플릿

5. og 태그
    오픈 그래프 마크업 (https://ogp.me/)
    사용이유 : 공유 할 때, 미리보기 화면을 구성할 수 있게 해 주는 Meta를 오픈그래프라 한다.
    원리 : 내가 원하는 정보의 URL을 복사한 후 카톡창에 붙여넣는 순간 카톡에서 일하는 크롤러가 잽싸게 해당 URL을 먼저 방문해서,
    웹페이지에 있는 오픈그래프 데이터를 수집해 카톡창에 미리보기 형식으로 구성해 주는 방식.



