<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="includes/header.jsp"%>

<script src="../../vendors/photoswipe/photoswipe.min.js"></script>
<script src="../../vendors/photoswipe/photoswipe-ui-default.min.js"></script>
<link rel="stylesheet" href="../../vendors/photoswipe/photoswipe.css">
<link rel="stylesheet" href="../../vendors/photoswipe/default-skin.css">
    
<style>
	@media all and (min-width : 768px) and (max-width : 1363px)  { .single-thumbnail {width: 180px !important; height: 120px !important;}}
	.pswp__minis-list{left: 0 !important;}
	.single-purchase{top: -30px !important;} 
	/* image gallery stuff */
	.rowg{display:-ms-flexbox;display:flex;-ms-flex-wrap:wrap;flex-wrap:wrap;padding:0 4px}.columng{-ms-flex:25%;flex:25%;max-width:25%;padding:0 4px}.columng img{margin-top:8px;vertical-align:middle}@media screen and (max-width:800px){.columng{-ms-flex:50%;flex:50%;max-width:50%}}@media screen and (max-width:600px){.column{-ms-flex:100%;flex:100%;max-width:100%}}
</style>

<fmt:bundle basename = "text" prefix = "${project}.">

<section class="single-hero">
  <div class="single-hero-nav"><%@ include file="includes/nav.jsp"%></div>
  <div class="single-hero-image-container">
    <div class="single-hero-image">
      <a class="psw-item"><img src="<fmt:message key="hero.cover"/>" width="2880" height="1920" data-index="0"></a>    
    </div>
  </div>
  <div class="single-hero-gradient"></div>
</section>

<header class="single-header">
	<div class="container">
		<div class="single-columns">
			<div class="single-column is-head">
				<div class="single-thumbnails">
					<div class="single-thumbnails-list">
					  <a class="single-thumbnail psw-item"><img src="<fmt:message key="hero.image1"/>" style="width:100%;height:auto;min-height: 150px;"></a>
					  <a class="single-thumbnail psw-item"><img src="<fmt:message key="hero.image2"/>" style="width:100%;height:auto;min-height: 150px;"></a>
					  <a class="single-thumbnail psw-item"><img src="<fmt:message key="hero.image3"/>" style="width:100%;height:auto;min-height: 150px;"></a>
					</div>
					<div class="single-thumbnails-action">
					  <a class="button is-info  is-small psw-trigger" href=""><span class="button-text"><fmt:message key="btn.photos"/></span></a>
					</div>
				</div>
				<div class="single-heading">
				  <h1 class="title single-heading-title" style="color:black !important;"><fmt:message key="title"/></h1>
				  <h2 class="location single-heading-location"><fmt:message key="subtitle"/></h2>
				 <%@ include file="WEB-INF/templates/pattern.jsp" %>
				  <div class="single-heading-introduction"><fmt:message key="lead-paragraph"/></div>
				  <div class="single-metas">
				    <div class="single-meta">
				      <p class="single-meta-label"><fmt:message key="details.region"/></p>   
					  <p class="single-meta-link"><strong><fmt:message key="details.region.value"/></strong></p>    
					</div>
				    <div class="single-meta">
				      <p class="single-meta-label"><fmt:message key="details.city"/></p>
					  <p class="single-meta-link"><strong><fmt:message key="details.city.value"/></strong></p>    
					</div>
				    <div class="single-meta">
				      <p class="single-meta-label"><fmt:message key="details.type"/></p>
					  <p class="single-meta-link"><a href="#"><fmt:message key="details.type.value"/></a></p>    
					</div>
				  </div>
				</div>
			</div>
			<div class="single-column is-meta">
				<div class="single-purchase">
					<div class="single-purchase-action">
						<img src='<fmt:message key="hero.website"/>' style="margin: 0 auto !important;display: flex;margin-bottom: 20px !important;">
						<a class="button is-info" href="<fmt:message key="website"/>" target="_blank">
						<span class="button-text"><strong><fmt:message key="btn.website"/></strong>&nbsp;<i class="fas fa-long-arrow-alt-right" style="margin-bottom:-2px !important;"></i></span>
						</a>
					</div>
				</div>
				<div class="single-stats">
					<div class="list-stats">
				      	<div class="stat">
				      		<strong class="stat-value"><fmt:message key="details.golf.value"/></strong>
				      		<em class="stat-label"><fmt:message key="details.golf"/></em>
						</div>
						<div class="stat">
				    		<strong class="stat-value"><fmt:message key="details.hectars.value"/></strong>
				    		<em class="stat-label"><fmt:message key="details.hectars"/></em>
						</div>
						<div class="stat">
							<strong class="stat-value"><fmt:message key="details.units.value"/></strong>
							<em class="stat-label"><fmt:message key="details.units"/></em>
						</div>
						<div class="stat">
							<strong class="stat-value"><fmt:message key="details.restaurants.value"/></strong>
							<em class="stat-label"><fmt:message key="details.restaurants"/></em>
						</div>
						
				  </div>
				</div>
			</div>
        </div>
	</div>
</header>

<section class="single-main">
	<div class="container">
		<div class="single-columns">
			<div class="single-column is-lead">
				<div class="single-content content"><p><fmt:message key="description"/></p></div>
            	<div class="single-grid" style="margin: 0 auto !important;">
					<div class="rowg" > 
					  <div class="columng">
					    <img src="<fmt:message key="mason.1"/>" style="width:100%">
					    <img src="<fmt:message key="mason.2"/>" style="width:100%">
					  </div>
					  <div class="columng">
					    <img src="<fmt:message key="mason.3"/>" style="width:100%">
					    <img src="<fmt:message key="mason.4"/>" style="width:100%">
					  </div>  
					  <div class="columng">
					    <img src="<fmt:message key="mason.5"/>" style="width:100%">
					    <img src="<fmt:message key="mason.6"/>" style="width:100%">
					  </div>
					    <div class="columng">
					    <img src="<fmt:message key="mason.7"/>" style="width:100%">
					 	<img src="<fmt:message key="mason.8"/>" style="width:100%">
					  </div>
					</div>
				    <div class="single-grid-action">
				      <a class="button is-info  psw-trigger" href=""><span class="button-text"><fmt:message key="btn.photos"/></span></a>
				    </div>
				</div>
			</div>
		</div>
	</div>
</section>
</fmt:bundle>
    
<!-- photoswipe stuff -->
<script type="text/javascript">${photos}</script>
<div class="pswp" tabindex="-1" role="dialog" aria-hidden="true"> <div class="pswp__bg"></div><div class="pswp__scroll-wrap"> <div class="pswp__container"> <div class="pswp__item"></div><div class="pswp__item"></div><div class="pswp__item"></div></div><div class="pswp__ui pswp__ui--hidden"> <div class="pswp__top-bar"> <div class="pswp__counter"></div><button class="pswp__button pswp__button--close" title="Close (Esc)"></button> <button class="pswp__button pswp__button--share" title="Share"></button> <button class="pswp__button pswp__button--fs" title="Toggle fullscreen"></button> <button class="pswp__button pswp__button--zoom" title="Zoom in/out"></button> <div class="pswp__preloader"> <div class="pswp__preloader__icn"> <div class="pswp__preloader__cut"> <div class="pswp__preloader__donut"></div></div></div></div></div><div class="pswp__share-modal pswp__share-modal--hidden pswp__single-tap"> <div class="pswp__share-tooltip"></div></div><button class="pswp__button pswp__button--arrow--left" title="Previous (arrow left)"> </button> <button class="pswp__button pswp__button--arrow--right" title="Next (arrow right)"> </button> <div class="pswp__caption"> <div class="pswp__caption__center"></div></div></div><div class="pswp__minis"> <div class="pswp__minis-list"></div></div></div></div>
<script>
window.psw_current_index=0;function buildItems(){const all_items=window.photoswipe_items; let items=[]; if (Array.isArray(all_items) && all_items.length > 0){all_items.forEach(original=>{const item={src: original.src, w: original.w, h: original.h}; items.push(item);});}return items;}function initThumbnails(){const html_items=document.querySelectorAll('.psw-item'); html_items.forEach((html_item, index)=>{html_item.onclick=onThumbnailsClick;});}function updateThumbnails(psw_items){const html_items=document.querySelectorAll('.psw-item'); html_items.forEach((html_item, index)=>{psw_items[index].el=html_item;}); return psw_items;}function onThumbnailsClick(e){e=e || window.event; e.preventDefault ? e.preventDefault() : e.returnValue=false; const target=e.target || e.srcElement; const index=target.dataset['index']; if (index >=0){// open PhotoSwipe if valid index found openPhotoswipe(index);}return false;}function onTriggerClick(e){e=e || window.event; e.preventDefault ? e.preventDefault() : e.returnValue=false; if (window.psw_current_index >=0){openPhotoswipe(window.psw_current_index);}return false;}function onMiniClick(e, psw_gallery){e=e || window.event; e.preventDefault ? e.preventDefault() : e.returnValue=false; const target=e.target || e.srcElement; const index=target.dataset['index']; if (index >=0){psw_gallery.goTo(parseInt(index, 10));}return false;}function addMinis(psw_gallery){const container=document.querySelectorAll('.pswp__minis-list')[0]; const all_items=window.photoswipe_items; if (Array.isArray(all_items) && all_items.length > 0){all_items.forEach((image, index)=>{const link_el=document.createElement('a'); const image_el=document.createElement('img'); image_el.setAttribute('src', image.src); image_el.setAttribute('width', image.w); image_el.setAttribute('height', image.h); image_el.setAttribute('data-index', index); image_el.addEventListener('click', event=>{return onMiniClick(event, psw_gallery);}); link_el.className='pswp__mini'; link_el.appendChild(image_el); container.appendChild(link_el);});}}function removeMinis(psw_gallery){const container=document.querySelectorAll('.pswp__minis-list')[0]; const minis=container.querySelectorAll('.pswp__mini'); minis.forEach(el=>{el.removeEventListener('click', event=>{return onMiniClick(event, psw_gallery);}); container.removeChild(el);});}function moveMinis(index){const list_el=document.querySelectorAll('.pswp__minis-list')[0]; const minis=list_el.querySelectorAll('.pswp__mini'); const selected_mini=minis[index]; const mini_width=64; // Offset the container const offset=-1 * mini_width * index; list_el.style.transform=`translate3d(${offset}px, 0, 0)`; // Highlight the current item minis.forEach(el=>{el.classList.remove('is-active');}); selected_mini.classList.add('is-active');}function openPhotoswipe(index){const psw_el=document.querySelectorAll('.pswp')[0]; let psw_items=buildItems(); psw_items=updateThumbnails(psw_items); const psw_options={bgOpacity: 0.9, closeOnScroll: false, getThumbBoundsFn: function (index){if (!psw_items[index].el){return;}const thumbnail=psw_items[index].el.getElementsByTagName('img')[0]; const pageYScroll=window.pageYOffset || document.documentElement.scrollTop; const rect=thumbnail.getBoundingClientRect(); return{x: rect.left, y: rect.top + pageYScroll, w: rect.width};}, history: false, index: parseInt(index, 10), preload: [1, 3], shareButtons: [{id: 'facebook', label: 'Share on Facebook', url: 'https://www.facebook.com/sharer/sharer.php?u={{url}}'},{id: 'twitter', label: 'Tweet', url: 'https://twitter.com/intent/tweet?text={{text}}&url={{url}}'}]}; if (isNaN(psw_options.index)){return;}const psw_gallery=new PhotoSwipe(psw_el, PhotoSwipeUI_Default, psw_items, psw_options); psw_gallery.init(); addMinis(psw_gallery); moveMinis(index); psw_gallery.listen('afterChange', ()=>{moveMinis(psw_gallery.getCurrentIndex());}); psw_gallery.listen('imageLoadComplete', (index, item)=>{const current_el=psw_gallery.currItem.container; current_el.addEventListener('contextmenu', event=> event.preventDefault()); window.psw_current_index=index;}); psw_gallery.listen('close', ()=>{psw_el.classList.add('is-closing');}); psw_gallery.listen('destroy', ()=>{removeMinis(psw_gallery); psw_el.classList.remove('is-closing');});}document.addEventListener('DOMContentLoaded', ()=>{initThumbnails(); const psw_triggers=document.querySelectorAll('.psw-trigger'); if (psw_triggers.length > 0){psw_triggers.forEach(el=>{el.onclick=onTriggerClick;});}});
</script>

<%@ include file="WEB-INF/templates/contact.jsp" %>
<%@ include file="WEB-INF/templates/newsletter.jsp" %>
<%@ include file="includes/footer.jsp"%>