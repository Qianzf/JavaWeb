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

    .p-content {
        position: relative;
        z-index: 1;
        line-height: 1.6;
        word-wrap: break-word !important;
        font-size: 14px;
        line-height: 1.7;
        color: #222;
        padding-top: 9px;
        width: 100%;
    }
    .p-content::first-letter
    {
        float: left;
        font-size:2.5em;
        padding-right:5px;
        text-transform:uppercase;
    }
</style>
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
                <a href="${basePath}/"><li>首页</li></a>
                <li class="menu-active">关于</li>
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
        <p class="p-content">
            京东于2004年正式涉足电商领域。2016年，京东集团市场交易额达到9392亿元*，净收入达到2601亿元，同比增长43%。京东是中国收入规模最大的互联网企业。2016年7月，京东入榜2016《财富》全球500强，成为中国首家、唯一入选的互联网企业。

            2014年5月，京东集团在美国纳斯达克证券交易所正式挂牌上市，是中国第一个成功赴美上市的大型综合型电商平台，并成功跻身全球前十大互联网公司排行榜，2015年7月，京东凭借高成长性入选纳斯达克100指数和纳斯达克100平均加权指数。

            致力于成为为社会创造最大价值的企业
            京东致力于成为一家为社会创造最大价值的公司。经过13年砥砺前行，京东在商业领域一次又一次突破创新，取得了跨越式发展。与此同时，京东不忘初心，积极履行企业社会责任，在促进就业、提升社会效率、反哺实体经济等方面不断为社会做出贡献。

            截至2017年3月31日，京东集团拥有超过12万名正式员工，并间接拉动众包配送员、乡村推广员、中小企业职员等就业人数超过400万。2016年，京东全面推进落实电商精准扶贫工作，通过品牌品质、自营直采、地方特产、众筹扶贫等模式，在832个国家级贫困县扩展合作商家近5000家，上线贫困地区商品近200万个，实现扶贫农产品销售额近百亿元。依托强大的物流基础设施网络和供应链整合能力，京东大幅提升了行业运营效率，降低了社会成本。在品质电商的理念下，京东优化电商模式，精耕细作反哺实体经济，进一步助力供给侧改革。京东以社会和环境为抓手整合内外资源，与政府、媒体和公益组织协同创新，为用户、为合作伙伴、为员工、为环境、为社会创造共享价值。

            全面布局三大业务板块
            京东集团业务涉及电商、金融和物流三大板块。

            主营的电商业务京东商城已成长为中国最大的自营式电商企业，保持了远快于行业平均增速的增长，依据目前的发展速度，2021年前将成为中国最大的B2C电商平台。京东商城致力于打造一站式综合购物平台，服务中国亿万家庭，3C、家电、消费品、服饰、家居家装、生鲜和新通路（B2B）全品类领航发力，满足消费者多元化需求。

            在传统优势品类上，京东已成为中国最大手机、数码、电脑零售商，超过其他任何一家平台线上线下的销售总和。京东已成为中国线上线下最大的家电零售商，占据国内家电网购市场份额的62%*。京东超市2017年整体目标是交易额过千亿，力争在2019年前成为国内线上、线下商超领域绝对的销售额第一、市场份额第一、消费者满意度第一。京东服饰是京东平台上最大且增速最快的品类，新用户购买的品类中，大服饰占据40%以上，成拉新能力最强的核心品类。京东家居家装是中国品质家居生活首选平台，合作商家突破2.5万家，计划五年内成为国内线上线下最大的家居家装零售渠道。2016年京东商城积极布局生鲜业务，致力于成为中国消费者安全放心的品质生鲜首选电商平台，目前已在240个城市实现自营生鲜产品次日达。新通路重释渠道价值，旨在为全国百万家中小门店提供优质货源和服务。2016年实现覆盖5万家中小门店，2017年目标覆盖超50万家。

            京东金融集团，于2013年10月开始独立运营，定位为金融科技公司。京东金融依托京东生态平台积累的交易记录数据和信用体系，向社会各阶层提供融资贷款、理财、支付、众筹等各类金融服务。夯实金融门户基础，并依托京东众创生态圈，为创业创新者提供全产业链一站式服务。京东金融现已建立九大业务板块，分别是供应链金融、消费金融、众筹、财富管理、支付、保险、证券、金融科技和农村金融。京东金融APP，为用户提供了“一站式金融生活移动平台”，涵盖了目前理财加消费的金融产品。2017年3月，京东集团正式签署重组京东金融的最终协议。

            京东集团于2017年4月25日正式成立京东物流子集团，以更好地向全社会输出京东物流的专业能力，帮助产业链上下游的合作伙伴降低供应链成本、提升流通效率，共同打造极致的客户体验。京东物流将为合作伙伴提供包括仓储、运输、配送、客服、售后的正逆向一体化供应链解决方案服务、物流云和物流科技服务、商家数据服务、跨境物流服务、快递与快运服务等全方位的产品和服务，致力于与商家和社会化物流企业协同发展，以科技创新打造智慧供应链的价值网络，并最终成为中国商业最重要的基础设施之一。目前，京东是全球唯一拥有中小件、大件、冷链、B2B、跨境和众包（达达）六大物流网络的企业，凭借这六张大网在全球范围内的覆盖以及大数据、云计算、智能设备的引入应用，京东物流将打造一个从产品销量分析预测，到入库出库、再到运输配送各个环节无所不包，综合效率最优、算法最科学的智慧供应链服务系统。截止目前，京东物流在全国范围内拥有263个大型仓库，运营了9个大型智能化物流中心“亚洲一号”，自营配送覆盖了全国98%的人口，将商品流通成本降低了70%，物流的运营效率提升了2倍以上。另外，京东物流还通过一系列技术创新，研发并推广创新环保材料，全方位打造了“时效、环保、创新、智能”的绿色物流体系。

            全面向技术转型
            京东是一家以技术为成长驱动的公司，从成立伊始，就投入大量资源开发完善可靠、能够不断升级、以应用服务为核心的自有技术平台，从而驱动电商、金融、物流等各类业务的成长。未来，京东将更加重视技术的战略地位，发展云计算、大数据、智慧物流、人工智能、AR/VR、智能硬件等最新技术，以推动京东实现快速、可持续增长。未来十二年，京东集团将坚定地朝着技术转型，用技术将第一个十二年建立的所有商业模式进行改造，打造一个包括智能商业、智能金融、智能保险在内的全球领先的智能商业体。

            正道成功
            京东坚持诚信经营，大量品牌直供从源头杜绝假货，对假冒伪劣商品“零容忍”，通过严审商家资质、严控进货渠道、自主研发质控系统等六大举措确保正品行货。京东坚守“正道成功”的价值取向，坚定地呼吁用合法方式获得商业成功。

            2016年京东重拳出击、实力反腐。推行实名公布反腐案例、设立反腐奖励专项基金、公布《京东集团举报人保护和奖励制度》、上线反腐网站 “廉洁京东”等数项坚定、扎实的反腐举措，打造健康有序的商业环境。

            京东奉行客户为先、诚信、团队、创新、激情的价值观，期望成为全球最值得信赖的企业。

            备注：
            * 按照行业内主要友商的近似统计方式统计数据
            * 工信部迪赛研究院《2016家电网购分析报告》
            配送服务说明：
            211限时达：当日上午11：00前提交的现货订单（部分城市为上午10点前），以订单出库完成拣货时间点开始计算，当日送达；夜里11：00前提交的现货订单（以订单出库后完成拣货时间点开始计算），次日15：00前送达。

            次日达：在一定时间点之前提交的现货订单（以订单出库后完成拣货的时间点开始计算），将于次日送达。

            极速达：京东为消费者提供的一项个性化付费增值服务。消费者通过“在线支付”方式全额成功付款或“货到付款”方式成功提交订单，并勾选“极速达”服务后，京东会在服务时间内，2小时将商品送至消费者所留地址，目前仅北京、上海、广州、成都等部分城市的部分派送区域支持极速达服务。

            京准达：京东为消费者提供的一项个性化的精准送达服务。消费者通过“在线支付”方式全额成功付款或“货到付款”方式成功提交订单，并选择“京准达”的具体送达时间段后，京东会在指定的时间段内，将商品准时送达至消费者所留地址。目前，全国超过200个城市支持精准至2小时一个波次的“京准达”服务，其中北京、上海、广州等30个城市支持精准至1小时。

            夜间配：京东为消费者提供更快速、更便利的一项增值服务。消费者下单时在日历中选择“19:00-22:00”时段，属“夜间配”服务范围内的商品，京东会尽可能安排配送员在消费者选定当日晚间19:00-22:00送货上门。目前，“夜间配”业务在北京、上海、广州、成都、武汉、沈阳六个城市提供服务。

            媒体垂询:
        </p>
    </div>
</div>


<div class="footer">
    Powered by AXE! Author: QQQZF. &copy; 2018
</div>
<script type="text/javascript">
    getStartedInitialization();
    function getStartedInitialization(){
        $('#pagination').extendPagination({
            totalCount: 100,
            showCount: 1,
            limit: 10,
            callback: function (curr, limit, totalCount) {
                console.log(curr, limit, totalCount);
            }
        });
    }
</script>
