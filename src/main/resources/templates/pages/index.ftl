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
        min-height: 1000px;
        background: #e6e6e6;
        box-shadow: 0 0 8px #2F211C;
        border-radius: 10px;
        overflow: auto;
    }
</style>
<div class="fixed-title">
    <div>
        <i class="fa fa-bars" aria-hidden="true" title="菜单"></i>
        <i class="fa fa-sign-in" aria-hidden="true" title="账号登录" style="float: right;line-height: 48px;"></i>
    </div>
</div>

<div class="header">
    <div style="margin: 0 auto;width: 1140px;">
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
    <div class="content">
    </div>
</div>

<div class="footer">
   Powered by AXE! Author: QQQZF. &copy; 2018
</div>
<script>
</script>