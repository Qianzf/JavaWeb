<style>
    html, body {
        margin:0;
        padding: 0;
        background: #FAFAFA;
        font-family: -apple-system,BlinkMacSystemFont,Helvetica Neue,PingFang SC,Microsoft YaHei,Source Han Sans SC,Noto Sans CJK SC,WenQuanYi Micro Hei,sans-serif;
        font-size: 15px;
        color: #1a1a1a;
        background-image: url("${basePath}/static/images/bg1.png");
    }
    a:hover{
        text-decoration: none;
    }
    div {
        background: transparent;
        word-break: break-all;
        word-wrap: break-word;
        z-index: 10;
    }
    .header {
        width: 100%;
        height: 215px;
        margin-top: 60px;
        z-index: 100;
        box-sizing: border-box;
        top: 0;
        min-width: 1190px;
        overflow: hidden;
        background-clip: content-box;
        position: relative;
        color: white;
    }


    .footer {
        text-align: center;
        padding: 3px 0px 12px 0;
        font-size: 12px;
        line-height: 21px;
        text-align: center;
        color: #9E9E9E;
        text-shadow: 0 1px 2px #999;
    }

    .big-title {
        font-size: 32px;
        margin: 40px 0px 10px;
    }

    .small-title {
        font-size: 16px;
        margin: 0px 0px 50px;
        color: #9eadb5;
    }
    .main-menu ul{
        list-style: none;
        padding-left: 0px;
        margin-top: 38px;
    }
    .main-menu ul li{
        float: left;
        width: 100px;
        font-size: 15px;
        text-align: center;
        margin-right: 15px;
        padding: 5px 0px;
        cursor: pointer;
        border-radius: 5px;
        color: #fff;
        border: 1px dashed lightblue;
    }
    .main-menu ul  .menu-active, .main-menu ul li:hover {
        background-color: #2a6496;
        color: white;
        border: 1px solid #57284C;
        box-shadow: 0 0 12px 0px #421F3A;
        background: linear-gradient(to top, #235179 0%,#739EC1 100%);
    }
    .search {
        padding: 0px;
        float: right;
        width: 280px;
    }

    .fixed-title {
        width: 100%;
        height: 48px;
        z-index: 999;
        top: 0;
        background: rgba(38, 50, 56, 0.94);
        position: fixed;
        box-shadow: 0 1px 7px rgb(68, 30, 62);
        border-radius: 0;
    }
    .meng-bottom {
        background-color: rgba(66, 13, 54, 0.88);
        min-width: 1190px;
        position: absolute;
        top: 0;
        height: 465px;
        width: 100%;
        box-shadow: 0 0 10px #607D8B;
        background-image: url("/static/images/topBg.png");
    }
    .fixed-title {
        margin: 0 auto;
        width: 100%;
        line-height: 48px;
        padding:0 30px;
        font-size: 22px;
        color: white;
        text-shadow: 0 1px 2px #78909C;
    }
    .fixed-title i{
        cursor: pointer;
    }
    .main {
        display: flex;
        width: 1190px;
        flex-wrap: nowrap;
        flex-direction: row;
        justify-content: center;
        align-items: flex-start;
        margin: 14px auto 10px auto;
        padding: 0 20px;
        position: relative;

    }
    .content {
        width: 100%;
        min-height: 200px;
        background: #fff;
        box-shadow: 0 0 6px #B0BEC5;
        border-radius: 10px;
        overflow: auto;
        padding: 10px 20px;
    }
    .articleList {
        width: 100%;
        height: 100px;
        margin-top: 10px;
        border-bottom: 1px solid #b0bec559;
    }
    .acticle-title {
        margin: 13px 0 5px 0;
        font-size: 18px;
        width: 100%;
        overflow: hidden;
        text-overflow: ellipsis;
        word-break: normal;
        word-wrap: none;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        font-weight: 400;
    }
    .acticle-desc {
        color: #999;
    }
    .noarticle {
        text-align: center;
        line-height: 180px;
        font-size: 24px;
        color: darkgray;
    }
    .page {
        font-weight: 900;
        height: 40px;
        text-align: center;
        color: #888;
        margin: 20px auto 0;
        background: #f2f2f2;
    }

    .pagelist {
        font-size: 0;
        background: #fff;
        height: 50px;
        line-height: 50px;
    }

    .pagelist span {
        font-size: 14px;
    }

    .pagelist .jump {
        border: 1px solid #ccc;
        padding: 5px 8px;
        -webkit-border-radius: 4px;
        -moz-border-radius: 4px;
        border-radius: 4px;
        cursor: pointer;
        margin-left: 5px;
    }

    .pagelist .bgprimary {
        cursor: default;
        color: #fff;
        background: #337ab7;
        border-color: #337ab7;
    }

    .jumpinp input {
        width: 55px;
        height: 26px;
        font-size: 13px;
        border: 1px solid #ccc;
        -webkit-border-radius: 4px;
        -moz-border-radius: 4px;
        border-radius: 4px;
        text-align: center;
    }

    .ellipsis {
        padding: 0px 8px;
    }

    .jumppoint {
        margin-left: 30px;
    }

    .pagelist .gobtn {}

    .bgprimary {
        cursor: default;
        color: #fff;
        background: #337ab7;
        border-color: #337ab7;
    }
    [v-cloak] {
        display: none;
    }
</style>
<div id="app" v-cloak>
<div class="fixed-title">
    <div>
        <i class="fa fa-home" aria-hidden="true" title="家的位置" onclick="window.location='${basePath}/'"></i>
        <i class="fa fa-sign-in" aria-hidden="true" title="账号登录" style="float: right;line-height: 48px;"></i>
    </div>
</div>

<div class="header">
    <div style="margin: 0 auto;width: 1140px;">
        <div class="big-title">
            随风而来的忧愁少年
        </div>
        <div class="small-title">
            代码风格，归因逻辑，耦合系数，平行四边形
        </div>
        <div class="main-menu">
            <ul>
                <li class="menu-active">首页</li>
                <a href="${basePath}/pages/"><li >关于</li></a>
            </ul>
        </div>
        <div class="search">
            <div class="input-group" @keyup.13="search">
                <input type="text" id="search" class="form-control" placeholder="搜索"  value="${keyword!""}" aria-label="Amount (to the nearest dollar)">
                <span onclick="search(1,10)"  class="input-group-addon"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></span>
            </div>
        </div>
    </div>
</div>
<div class="meng-bottom">
</div>

<div class="main">
    <div class="content" >
        <div >
            <div v-if="data && data.length > 0">
                <div  v-for="article in data" class="articleList">
                    <a :href="'./details/'+article.id+'.html'">
                        <p class="acticle-title" v-text="article.articleName"></p>
                        <p class="acticle-desc" v-text="article.articleDesc"></p>
                    </a>
                </div>
            </div>
            <div v-else class="noarticle">
                Sorry! 暂无文章
            </div>
        </div>
        <div v-if="data && data.length > 0" class="pagelist">
            <span class="jump"v-show="current_page>1" @click="current_page--;jumpPage(current_page)">上一页</span>
            <span v-show="current_page > 5" class="jump" @click="jumpPage(1)">1</span>
            <span class="ellipsis"  v-show="efont">...</span>
            <span class="jump" v-for="num in indexs" :class="{bgprimary:current_page==num}" @click="jumpPage(num)">{{num}}</span>
            <span class="ellipsis"  v-show="efont&&current_page<pages-4">...</span>

            <span v-show="current_page < pages" class="jump" @click="current_page++;jumpPage(current_page)">下一页</span>
        </div>
    </div>
</div>
</div>


<div class="footer">
   Powered by AXE! Author: QQQZF. &copy; 2018
</div>
</div>
<script type="text/javascript">
    var response = ${response!"{}"};
    var totalPage = parseInt(response.totalNum / response.pageSize);
    if (response.totalNum % response.pageSize != 0) {
        totalPage ++;
    }
    // VUE
   var app = new Vue({
        el: '#app',
        data: {
            data: response.data,
            current_page: response.pageNum, //当前页
            pages: totalPage, //总页数
            changePage:'',//跳转页
            nowIndex:0
        },
        methods:{
            search:function(){
                search(1,10);
            },
            jumpPage: function(id) {
                this.current_page = id;
                console.log(this.current_page);
                search(this.current_page, 10);
            },
        },
       computed:{
           show:function(){
               return this.pages && this.pages !=1
           },
           efont: function() {
               if (this.pages <= 7) return false;
               return this.current_page > 5
           },
           indexs: function() {

               var left = 1,
                       right = this.pages,
                       ar = [];
               if (this.pages >= 7) {
                   if (this.current_page > 5 && this.current_page < this.pages - 4) {
                       left = Number(this.current_page) - 3;
                       right = Number(this.current_page) + 3;
                   } else {
                       if (this.current_page <= 5) {
                           left = 1;
                           right = 7;
                       } else {
                           right = this.pages;

                           left = this.pages - 6;
                       }
                   }
               }
               while (left <= right) {
                   ar.push(left);
                   left++;
               }
               return ar;
           },
       },
   });


    function search(pageNum, pageSize) {
        var keyword = $("#search").val();
        console.log("./?pageNum=" + pageNum + "&pageSize=" + pageSize + "&keyword=" + keyword);
        window.location.href = "./?pageNum=" + pageNum + "&pageSize=" + pageSize + "&keyword=" + keyword;
    }

</script>
