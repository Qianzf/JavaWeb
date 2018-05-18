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
        box-shadow: 0 1px 3px rgba(26,26,26,.1);
        background-clip: content-box;
        position: relative;
        color: white;
    }
    .main {
        display: flex;
        width: 1190px;
        flex-wrap: nowrap;
        flex-direction: row;
        justify-content: center;
        align-items: flex-start;
        margin: 14px auto 10px auto;
        padding: 0 10px;
        overflow: auto;
        background: white;
        position: relative;
        box-shadow: 0 0 12px #1f1612;
    }
    .left-side {
        min-height: 300px;
        flex-basis:auto;
        width: 350px;
        order:2;
    }
    .content-side {
        min-height: 900px;
        flex-basis:auto;
        min-width: 900px;
        max-width: 1024px;
        width:100%;
        margin-right: 10px;
        order:1;
        background-color: transparent;

    }
    .footer {
        text-align: center;
        padding: 3px 0px 12px 0;
        font-size: 12px;
        line-height: 21px;
        text-align: center;
        color: #9E9E9E;
        text-shadow: 0 1px 2px #999;
        margin-right: 260px;
    }

    .big-title {
        font-size: 32px;
        margin: 48px 0px 10px;
    }

    .small-title {
        font-size: 16px;
        margin: 0px 0px 10px;
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
        background-color: #39f;
        color: white;
        border: 1px solid #39f;
        box-shadow: 0 0 12px 0px #003248;
    }
    .search {
        padding: 0px;
        float: right;
        width: 280px;
    }
    .content-card {
        margin-bottom: 10px;
        background: #fff;
        overflow: hidden;
        border-radius: 2px;
        box-shadow: 0 1px 3px rgba(26,26,26,.1);
        box-sizing: border-box;
        width: 100%;
        height: 200px;
    }
    .info-card {
        margin-bottom: 10px;
        background: #fff;
        overflow: hidden;
        border-radius: 2px;
        box-shadow: 0 1px 3px rgba(26,26,26,.1);
        box-sizing: border-box;
        width:260px;
        height:300px;
    }
    .fixed-title {
        width: 100%;
        height: 48px;
        z-index: 999;
        top: 0;
        background: #263238;
        position: fixed;
        box-shadow: 0 1px 7px rgb(68, 30, 62);
        border-radius: 0;
    }
    .meng-bottom {
        background: #52234a;
        position: absolute;
        top: 0;
        height: 465px;
        width: 100%;
        box-shadow: 0 0 10px #607D8B;
    }
    .fixed-title div{
        margin: 0 auto;
        width: 1190px;
        line-height: 48px;
        font-size: 20px;
        color: white;
        text-shadow: 0 1px 2px #78909C;
    }
</style>
<div class="fixed-title">
    <div>
        AXE
    </div>
</div>

<div class="header">
    <div style="margin: 0 auto;width: 1190px;">
        <div class="big-title">
            AXE的前端设计风格
        </div>
        <div class="small-title">
            前端开发，网站运营，网站开发，网站建设，网站制作，网站模板，wordpress，网站开发教程，建站
        </div>
        <div class="main-menu">
            <ul>
                <li class="menu-active">首页</li>
                <li>服务</li>
                <li>书单</li>
                <li>商店</li>
                <li>关于</li>
            </ul>
        </div>
        <div class="search">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="搜索" aria-label="Amount (to the nearest dollar)">
                <span class="input-group-addon"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></span>
            </div>
        </div>
    </div>
</div>
<div class="meng-bottom">
</div>

<div class="main">
    <!-- 侧边栏 -->
    <div class="left-side">
        <div class="info-card">

        </div>
    </div>

    <!-- 内容栏 -->
    <div class="content-side">
        <div class="content-card">

        </div>
        <div class="content-card">

        </div>
        <div class="content-card">

        </div>
    </div>
</div>

<div class="footer">
   Powered by AXE! Author: QQQZF. &copy; 2018
</div>
<script>
</script>