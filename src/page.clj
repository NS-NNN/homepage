(ns page)

; orange: e44d26
; black: 202020
; gray: 949494
; font: oswald medium

(def include-font 
  [:link {:href "https://fonts.googleapis.com/css?family=Noto+Sans+KR|Oswald&display=swap"
          :rel "stylesheet"}])

(def include-header-style
  [:link {:rel "stylesheet"
          :type "text/css"
          :href "css/menu.css"}])

(def include-default-style
  [:link {:rel "stylesheet"
          :type "text/css"
          :href "css/default.css"}])

(def menu
  [:div#menu
   [:div#about.selection [:a {:href "about.html"}  "NNN에 대하여"]]
   [:div#members.selection [:a {:href "members.html"}  "동아리원 소개"]]
   [:div#result.selection [:a {:href "result.html"}  "결과물"]]])

(def header 
  [:div.header
   [:div.title [:a {:href "index.html"} [:span "NNN"] ".com"] ]
   menu])

(def home
  [:html
   [:head
    [:title "NNN"]
    include-font
    include-default-style
    [:link {:rel "stylesheet"
            :type "text/css"
            :href "css/home.css"}]
    ]
   [:body
    [:div#title
     [:span "NNN"] ".com"]
    menu
    ]])

(def about
  [:html
   [:head 
    [:title "About"]
    include-font
    include-header-style
    include-default-style
    [:link {:rel "stylesheet"
            :type "text/css"
            :href "css/about.css"}]]
   [:body
    header
    [:div.body
     [:img.logo {:src "img/HTML5.svg" :alt "HTML Logo"}]
     [:p.explain "NNN은 낙생고의 컴퓨터 자율 동아리입니다. 2019년도에 NNN은
                 웹사이트 개발을 목표로 활동을 했습니다. 웹페이지를 만드는 HTML과
                 CSS를 배우고 서버를 만들기 위해서 파이썬을 배우려고 했습니다."]]]])

; name descr img
(def members-data
  [["정원상" "바보" "img/정원상.jpg"]
   ["서동준" "동준이" "img/profile.svg"]
   ["안재휘" "가장 성실한 분" "img/안재휘.jpg"]
   ["김승민" "승민이" "img/profile.svg"]
   ["김주현" "멸치" "img/김주현.jpg"]
   ["정재윤" "동아리 부장" "img/profile.svg"]
   ["길진우" "땅콩" "img/길진우.jpg"]
   ["이인섭" "인섭이" "img/profile.svg"]]) ; TODO: fill the data

(def members
  [:html
   [:head
    [:title "Members"]
    include-font
    include-header-style
    include-default-style
    [:link {:rel "stylesheet"
            :type "text/css"
            :href "css/members.css"}]]
   [:body
    header
    [:div.body
     (for [[member explain img] members-data]
       [:div.member
        [:img.profile {:src img :alt "profile image"}]
        [:p.name member]
        [:p.descr explain]])]]])

; title member descr img
(def result-data
  [["스네이크 게임" "안재휘" "파이썬과 tkinter로 만든 고전적인 스네이크 게임. 하지만 속도 조절 가능하다!" "img/snake.png"]
   ["오버워치 소개" "김승민" "오버워치 게임에 대한 소개와 오버워치 히어로들 소개. 나무위키와 연계" "img/overwatch.png"]
   ["승민이" "김주현" "승민이" "img/face.jpg"]
   ["낙생위키" "안재휘" "낙생고에 관한 정보를 위키 형식으로 정리. 여러개의 항목이 있어 볼 수 있다" "img/wiki.png"]])

(def result
  [:html
   [:head
    [:title "Result"]
    include-font
    include-header-style
    include-default-style
    [:link {:rel "stylesheet"
            :type "text/css"
            :href "css/result.css"}]] ; TODO: write result.css
   [:body
    header
    [:div.body
     (for [[title member descr img] result-data]
       [:div.result
        [:div.product {:style (format "background-image:url(%s)" img)}]
        [:img.profile {:src (last (some #(if ( = (first %) member) %) members-data)) :alt "profile image"}]
        [:p.t title]
        [:p.descr descr]])]]])
