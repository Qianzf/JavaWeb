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

    .footer {
        text-align: center;
        padding: 3px 0px 12px 0;
        font-size: 12px;
        line-height: 21px;
        text-align: center;
        color: #9E9E9E;
        text-shadow: 0 1px 2px #999;
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
        min-height: 700px;
        background: #fff;
        box-shadow: 0 0 6px #B0BEC5;
        border-radius: 10px;
        overflow: auto;
        padding: 10px 20px;
        margin-top: 60px;
    }
    .p-title {
        margin: 10px 0px;
        font-size: 25px;
        line-height: 30px;
        padding-bottom: 5px;
        padding-top: 5px;
        border-left: 7px solid #E91E63;
        padding-left: 10px;
    }

    .p-content {
        position: relative;
        z-index: 1;
        line-height: 1.6;
        word-wrap: break-word !important;
        font-size: 15px;
        line-height: 1.7;
        color: #222;
        border-top: 1px solid #f5f5f5;
        padding-top: 9px;
        width: 100%;
    }
</style>
<div class="fixed-title">
    <div>
        <i class="fa fa-arrow-left" aria-hidden="true" title="返回" onclick="history.back()"></i>
        <i class="fa fa-sign-in" aria-hidden="true" title="账号登录" style="float: right;line-height: 48px;"></i>
    </div>
</div>

<div class="meng-bottom">
</div>

<div class="main">
    <div class="content">
        <h1 class="p-title">${acticle_title}</h1>
        <p class="p-content">
           ${acticle_content}
        </p>
    </div>
</div>


<div class="footer">
    Powered by AXE! Author: QQQZF. &copy; 2018
</div>
<script type="text/javascript">

</script>
