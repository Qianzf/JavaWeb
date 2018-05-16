<style>
    html, body {
        margin:0;
        padding: 0;
        background: #FFF;
        font-family: -apple-system,BlinkMacSystemFont,Helvetica Neue,PingFang SC,Microsoft YaHei,Source Han Sans SC,Noto Sans CJK SC,WenQuanYi Micro Hei,sans-serif;
        font-size: 15px;
        color: #1a1a1a;
        background-image: url("${basePath}/static/images/bg1.png");
    }
    div {
        border-radius: 4px;
        background: transparent;
        word-break: break-all;
        word-wrap: break-word;
    }
    .header {
        width: 100%;
        height:200px;
        z-index: 100;
        box-sizing: border-box;
        top:0;
        min-width: 1190px;
        overflow: hidden;
        box-shadow: 0 1px 3px rgba(26,26,26,.1);
        background-clip: content-box;
    }
    .main {
        display: flex;
        width: 1190px;
        flex-wrap: nowrap;
        flex-direction: row;
        justify-content: center;
        align-items: flex-start;
        margin: 10px auto 10px auto;
        padding:0 10px;
        overflow: auto;
    }
    .left-side {
        min-height: 300px;
        flex-basis:auto;
        width: 350px;
        order:2;
    }
    .left-side .info-card {
        width:260px;
        height:300px;
        background-color: #F6F6F6;
        box-shadow: 0 1px 3px rgba(26,26,26,.1);
    }
    .content-side {
        min-height: 900px;
        flex-basis:auto;
        min-width: 900px;
        max-width: 1024px;
        width:100%;
        margin-right: 10px;
        order:1;
        background-color: #F6F6F6;
        box-shadow: 0 1px 3px rgba(26,26,26,.1);
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
        margin: 32px 15px 10px;
    }

    .small-title {
        font-size: 16px;
        margin: 0px 15px 10px;
        color: cadetblue;
    }
    .main-menu ul{
        list-style: none;
        padding-left: 10px;
        margin-top: 38px;
    }
    .main-menu ul li{
        float: left;
        width: 120px;
        font-size: 17px;
        text-align: center;
        margin-right: 10px;
        padding: 5px 0px;
        cursor: pointer;
        border-radius: 5px;
        color: #607D8B;
        border: 1px dashed lightblue;
    }
    .main-menu ul  .menu-active, .main-menu ul li:hover {
        background-color: #39f;
        color: white;
        border: 1px solid #39f;
        box-shadow: 0 0 4px #03A9F4;
    }
    .search {
        padding: 0 10px;
        float: right;
        width: 280px;
    }
</style>

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

<div class="main">
    <!-- 侧边栏 -->
    <div class="left-side">
        <div class="info-card">

        </div>
    </div>

    <!-- 内容栏 -->
    <div class="content-side">

    </div>
</div>

<div class="footer">
   Powered by AXE! Author: QQQZF. &copy; 2018
</div>
<script>
</script>