<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<c:choose>
	<c:when test="${category eq 'login'}"><c:set var="title" value="로그인"/></c:when>
</c:choose>
    
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<title>Colorlib | Free Bootstrap Website Template</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<meta name="robots" content="noindex, nofollow" />

<link href="assets/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="assets/css/template.css" rel="stylesheet" media="screen">
<link href="assets/css/fa.min.css" rel="stylesheet" media="screen">
<link href="assets/css/gfonts.min.css" rel="stylesheet" media="screen">
<script>if ( top !== self ) top.location.replace( self.location.href );// Hey, don't iframe my iframe!</script>


<!--[if lt IE 9]>
		<script>/*@cc_on'abbr article aside audio canvas details figcaption figure footer header hgroup mark meter nav output progress section summary subline time video'.replace(/\w+/g,function(n){document.createElement(n)})@*/</script>
	<![endif]-->

<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
<script>
	  window.dataLayer = window.dataLayer || [];
	  function gtag(){dataLayer.push(arguments);}
	  gtag('js', new Date());

	  gtag('config', 'UA-23581568-13');
	</script>
<script nonce="9f017cf6-592c-4eb2-8977-18a7b2a7dab6">(function(w,d){!function(db,dc,dd,de){db[dd]=db[dd]||{};db[dd].executed=[];db.zaraz={deferred:[],listeners:[]};db.zaraz.q=[];db.zaraz._f=function(df){return async function(){var dg=Array.prototype.slice.call(arguments);db.zaraz.q.push({m:df,a:dg})}};for(const dh of["track","set","debug"])db.zaraz[dh]=db.zaraz._f(dh);db.zaraz.init=()=>{var di=dc.getElementsByTagName(de)[0],dj=dc.createElement(de),dk=dc.getElementsByTagName("title")[0];dk&&(db[dd].t=dc.getElementsByTagName("title")[0].text);db[dd].x=Math.random();db[dd].w=db.screen.width;db[dd].h=db.screen.height;db[dd].j=db.innerHeight;db[dd].e=db.innerWidth;db[dd].l=db.location.href;db[dd].r=dc.referrer;db[dd].k=db.screen.colorDepth;db[dd].n=dc.characterSet;db[dd].o=(new Date).getTimezoneOffset();if(db.dataLayer)for(const dp of Object.entries(Object.entries(dataLayer).reduce(((dq,dr)=>({...dq[1],...dr[1]})),{})))zaraz.set(dp[0],dp[1],{scope:"page"});db[dd].q=[];for(;db.zaraz.q.length;){const ds=db.zaraz.q.shift();db[dd].q.push(ds)}dj.defer=!0;for(const dt of[localStorage,sessionStorage])Object.keys(dt||{}).filter((dv=>dv.startsWith("_zaraz_"))).forEach((du=>{try{db[dd]["z_"+du.slice(7)]=JSON.parse(dt.getItem(du))}catch{db[dd]["z_"+du.slice(7)]=dt.getItem(du)}}));dj.referrerPolicy="origin";dj.src="/cdn-cgi/zaraz/s.js?z="+btoa(encodeURIComponent(JSON.stringify(db[dd])));di.parentNode.insertBefore(dj,di)};["complete","interactive"].includes(dc.readyState)?zaraz.init():db.addEventListener("DOMContentLoaded",zaraz.init)}(w,d,"zarazData","script");})(window,document);</script></head>
<body>

<header class="switcher-bar ssss clearfix">

<div class="logo textual pull-left">
<a href="https://colorlib.com/wp/templates/" title="Switcher">
<img src="assets/img/logo.png" alt="Colorlib logo">
</a>
</div>

<div class="product-switcher pull-left">
<a href="#" title="Select a Product">
Select a Product <span>+</span>
</a>
</div>

<div class="remove-btn header-btn pull-right">
<a href="#" title="Close this bar" class="icon-remove"></a>
</div>

<div class="purchase-btn header-btn pull-right">
<a href="#" title="Buy now" class="icon-shopping-cart"></a>
</div>

<div class="mobile-btn header-btn pull-right hidden-xs">
<a href="#" title="Smartphone View" class="icon-mobile-phone"></a>
</div>

<div class="tablet-btn header-btn pull-right hidden-xs">
<a href="#" title="Tablet View" class="icon-tablet"></a>
</div>

<div class="desktop-btn header-btn pull-right hidden-xs">
<a href="#" title="Desktop View" class="icon-desktop"></a>
</div>
</header>

<section class="switcher-body">
<a href="#" title="Prev" class="icon-chevron-left products-prev"></a>
<div class="products-wrapper">
<div class="products-list clearfix">
</div>
</div>
<a href="#" title="Next" class="icon-chevron-right products-next"></a>
</section>

<iframe class="product-iframe" frameborder="0" border="0"></iframe>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="assets/js/products.js"></script>
<script src="assets/js/application.min.js"></script>

</div>
<script defer src="https://static.cloudflareinsights.com/beacon.min.js/v8b253dfea2ab4077af8c6f58422dfbfd1689876627854" integrity="sha512-bjgnUKX4azu3dLTVtie9u6TKqgx29RBwfj3QXYt5EKfWM/9hPSAI/4qcV5NACjwAo8UtTeWefx6Zq5PHcMm7Tg==" data-cf-beacon='{"rayId":"7ff6230378a4dfe5","token":"cd0b4b3a733644fc843ef0b185f98241","version":"2023.8.0","si":100}' crossorigin="anonymous"></script>
</body>
</html>
