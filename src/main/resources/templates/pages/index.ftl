<style>
    html, body {
        margin:0;
        padding: 0;
        background: #F6F6F6;
        font-family: -apple-system,BlinkMacSystemFont,Helvetica Neue,PingFang SC,Microsoft YaHei,Source Han Sans SC,Noto Sans CJK SC,WenQuanYi Micro Hei,sans-serif;
        font-size: 15px;
        color: #1a1a1a;
    }
    div {
        border-radius: 4px;
        background: #F6F6F6;
    }
    .header {
        width: 100%;
        height:55px;
        z-index: 100;
        box-sizing: border-box;
        position: fixed;
        top:0;
        min-width: 1190px;
        overflow: hidden;
        background: rgba(255,255,255,0.85);
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
        margin: 65px auto 10px auto;
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
        background-color: #fff;
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
        background-color: #fff;
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
</style>

<div class="header">
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