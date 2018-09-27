<!DOCTYPE html>
<html lang="zh">
<header>
    <script src="./static/js/require.js"></script>
    <script src="./static/js/main.js"></script>
    <#--<script src="./static/js/global.js"></script>-->
    <script src="./static/js/search.js"></script>
    <link rel="stylesheet" href="./static/css/global.css">
    <#--<link rel="stylesheet" href="./static/css/main.css">-->
    <link rel="stylesheet" href="./static/css/home.css">

</header>
<body>
<div>
<#--<span class="aria-readonly" tabindex="0" aria-hidden="true">张超超的博客良好支持读屏软件阅读，请放心使用。</span>-->
<#--<div class="rainbow"></div>-->
    <div class="home">
        <div class="home-color-bg"></div>
        <div class="home-box">
            <h2 title="For Future, For Freedom." id="indexLogo">
                张超超的网站
                <a aria-hidden="true" href="/entry/">
                <img src="./favicon.ico" alt="张超超" @click="imgCartoon"/></a>
            </h2>
            <h3 title="For Future, For Freedom." aria-hidden="true">
                Barret Lee's personal website
            </h3>
            <p>
                <font aria-hidden="true">&raquo;</font> <a href="/entry/" aria-label="点击查看博客文章列表">博客</a>
                <font aria-hidden="true">/ </font><a href="/message/" aria-label="给张超超留言">问答</a>
                <font aria-hidden="true">/ </font><a href="/demo/" aria-label="张超超的实验室">实验</a>
                <font aria-hidden="true">/ </font><a href="/about/" aria-label="查看张超超的个人信息">关于</a>
            </p>
            <p>
                <font aria-hidden="true">&raquo;</font>
                <i class="icon" title="Github">
                    <a href="https://github.com/barretlee" target="_blank" aria-label="张超超的 Github 地址">☃</a>
                </i>
                <i class="icon" title="Sina Weibo">
                    <a href="http://weibo.com/173248656" target="_blank" aria-label="张超超的博客文章订阅地址">◈</a>
                </i>
            </p>
        </div>
        <span class="local-search local-search-google local-search-plugin home-search">
            <input type="search" placeholder="站内搜索" id="local-search-input" class="local-search-input-cls"/>
            <i class="icon" aria-hidden="true" title="点击进入 Google 搜索">✈</i>
            <div id="local-search-result" class="local-search-result-cls"></div>
        </span>
    </div>
    <p class="home-page-hosted">
        Hosted by
        <a href="https://pages.coding.me"  target="_blank" ref="external">Coding Pages</a>
    </p>

</div>
<script>
    requirejs(['jquery'], function ($) {


        function randomItem(array) {
            return array[Math.floor(Math.random() * array.length)];
        }

        var $flyzone;

        function flyzone() {
            if (!$flyzone) {
                $flyzone = $("<div>").attr("id", "flyzone").prependTo(document.body);
            }

            return $flyzone;
        }

        var sizes = ["smaller", "small", "medium", "large", "fat"];

        var sizeDimensions = {
            "smaller": 40,
            "small": 70,
            "medium": 90,
            "large": 120,
            "fat": 200
        };

        function randomOpacity(threshold) {
            var opacity = Math.random();

            while (opacity < threshold) {
                opacity = Math.random();
            }

            return opacity;
        }

        function makeLarry(sizeName, speed) {
            var size = sizeDimensions[sizeName];
            var top = Math.floor((flyzone().height() - size) * Math.random());

            var $img = $("<img>")
                    .addClass("larry size-" + sizeName)
                    .attr("src", "./static/ico/zc.png")
                    .attr({
                        "tabindex": "0",
                        "aria-hidden": "true"
                    })
                    .attr("width", size)
                    .attr("height", size)
                    .css({
                        position: "absolute",
                        opacity: randomOpacity(0.4),
                        top: top,
                        left: -size + 15
                    });

            $img.prependTo(flyzone());

            var left = flyzone().width() + size;

            $img.animate({
                left: left
            }, speed, function () {
                $img.remove();
                makeRandomLarry();
            });

            return $img;
        }

        function makeRandomLarry() {
            var size = randomItem(sizes);
            var speed = Math.floor(Math.random() * 20000) + 15000;
            return makeLarry(size, speed);
        }

        $(function () {
            $("#indexLogo").click(function () {
                makeRandomLarry();
            });
            $(".home-box h2 a").click(function (evt) {debugger
                evt.preventDefault();
                makeRandomLarry();
                return false;
            });
        });

//        var match = (/\blarry(=(\d+))?\b/i).exec(window.location.search);
//        if (match) {
//            var n = parseInt(match[2]) || 20;
//            $(function () {
//                for (var i = 0; i < n; ++i) {
//                    setTimeout(makeRandomLarry, Math.random() * n * 500);
//                }
//            });
//        }

    })
</script>
<style>
</style>
</body>
</html>