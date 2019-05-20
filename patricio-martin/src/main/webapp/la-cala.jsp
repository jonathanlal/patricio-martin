<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="includes/header.jsp"%>




 <script src="../../vendors/photoswipe/photoswipe.min.js"></script>
    <script src="../../vendors/photoswipe/photoswipe-ui-default.min.js"></script>
    <link rel="stylesheet" href="../../vendors/photoswipe/photoswipe.css">
    <link rel="stylesheet" href="../../vendors/photoswipe/default-skin.css">
    
    <style>
    
    .pswp__minis-list{
    
    left: 0 !important;
    }
    
    </style>

<!-- <section class="hero"> -->
<!--   <div class="hero-background" style="background-image: url(https://ivanballiniestates.com/wp-content/themes/ivan-ballini-v4/images/hab/maison-honfleur.jpg);"></div> -->
<!--   <div class="hero-overlay"></div> -->
<%--   <div class="hero-nav"><%@ include file="includes/include_nav.jsp"%></div> --%>
<!--   <div class="hero-content"> -->
<!--     <div class="container"> -->
<%--       <h1 class="title hero-title has-text-white" style="margin-bottom:10px;"><fmt:message key="about.hero.title"/></h1> --%>
<%--       <p class="hero-subtitle"><fmt:message key="about.hero.subtitle"/></p> --%>
<%-- 		<%@ include file="WEB-INF/templates/pattern.jsp" %> --%>
<!--     </div> -->
<!--   </div> -->
<!-- </section> -->







      <section class="single-hero">
  <div class="single-hero-nav">
<%@ include file="includes/include_nav.jsp"%>
  </div>

  <div class="single-hero-image-container">
    <div class="single-hero-image">
      <a class="psw-item"><img src="https://www.lacala.com/wp-content/uploads/2018/09/Gallery-Swimming-Pool.jpg" width="2880" height="1920" data-index="0"></a>    </div>
  </div>

  <div class="single-hero-gradient"></div>
</section>

    <header class="single-header">
      <div class="container">
        <div class="single-columns">
          <div class="single-column is-head">
            <div class="single-thumbnails">
  <div class="single-thumbnails-list">
    <a class="single-thumbnail psw-item">
    <img src="https://ivanballiniestates.com/wp-content/uploads/2019/03/manoir-vue-mer-a-vendre-benerville-1206-2-360x240.jpg" width="180" height="120" data-index="1"sizes="180px"srcset="https://ivanballiniestates.com/wp-content/uploads/2019/03/manoir-vue-mer-a-vendre-benerville-1206-2-360x240.jpg 360w,https://ivanballiniestates.com/wp-content/uploads/2019/03/manoir-vue-mer-a-vendre-benerville-1206-2-540x360.jpg 540w,https://ivanballiniestates.com/wp-content/uploads/2019/03/manoir-vue-mer-a-vendre-benerville-1206-2-1080x720.jpg 1080w"></a><a class="single-thumbnail psw-item"><img src="https://ivanballiniestates.com/wp-content/uploads/2019/03/manoir-vue-mer-a-vendre-benerville-1206-3-360x240.jpg" width="180" height="120" data-index="2"sizes="180px"srcset="https://ivanballiniestates.com/wp-content/uploads/2019/03/manoir-vue-mer-a-vendre-benerville-1206-3-360x240.jpg 360w,https://ivanballiniestates.com/wp-content/uploads/2019/03/manoir-vue-mer-a-vendre-benerville-1206-3-540x360.jpg 540w,https://ivanballiniestates.com/wp-content/uploads/2019/03/manoir-vue-mer-a-vendre-benerville-1206-3-1080x720.jpg 1080w"></a><a class="single-thumbnail psw-item"><img src="https://ivanballiniestates.com/wp-content/uploads/2019/03/manoir-vue-mer-a-vendre-benerville-1206-4-360x240.jpg" width="180" height="120" data-index="3"sizes="180px"srcset="https://ivanballiniestates.com/wp-content/uploads/2019/03/manoir-vue-mer-a-vendre-benerville-1206-4-360x240.jpg 360w,https://ivanballiniestates.com/wp-content/uploads/2019/03/manoir-vue-mer-a-vendre-benerville-1206-4-540x360.jpg 540w,https://ivanballiniestates.com/wp-content/uploads/2019/03/manoir-vue-mer-a-vendre-benerville-1206-4-1080x720.jpg 1080w"></a>  </div>

  <div class="single-thumbnails-action">
    <a class="button is-info  is-small psw-trigger" href="">
      <span class="button-text"><fmt:message key="lacala.btn.photos"/>   </span>
 	</a>
  </div>
</div>
            <div class="single-heading">
  <h1 class="title single-heading-title">
   <fmt:message key="lacala.title"/>  </h1>

  <h2 class="location single-heading-location"><fmt:message key="lacala.subtitle"/></h2>

 <%@ include file="WEB-INF/templates/pattern.jsp" %>
 

  <div class="single-heading-introduction"><fmt:message key="lacala.lead-paragraph"/></div>
  <div class="single-metas">
    <div class="single-meta">
      <p class="single-meta-label">
        <fmt:message key="lacala.details.region"/> </p>   

            <p class="single-meta-link"><strong>La Cala</strong></p>    </div>

    <div class="single-meta">
      <p class="single-meta-label">
        <fmt:message key="lacala.details.city"/></p>

            <p class="single-meta-link"><strong>Malaga</strong></p>    </div>

    <div class="single-meta">
      <p class="single-meta-label">
        <fmt:message key="lacala.details.type"/>      </p>

            <p class="single-meta-link"><a href="https://ivanballiniestates.com/type/manoir">Hotel</a></p>    </div>

  </div>
</div>
          </div>

          <div class="single-column is-meta">
            <div class="single-purchase">
<!--   <div class="single-purchase-price"> -->
<!--     <div class="price single-purchase-amount"> -->
<!--       2 900 000 €    </div> -->

    
<!--     <div class="single-purchase-label" title="Prix honoraires d'agence inclus"> -->
<!--       Prix HAI    </div> -->
<!--   </div> -->

  <div class="single-purchase-action">
    <a class="button is-info" href="https://www.lacala.com" target="_blank">
      <span class="button-text"><strong><fmt:message key="lacala.btn.website"/></strong> <i class="fas fa-long-arrow-alt-right" style="margin-bottom:-2px !important;"></i></span>
  </a>
  </div>
</div>


            <div class="single-stats">
  <div class="list-stats">
      <div class="stat">

    <strong class="stat-value">
     <fmt:message key="lacala.details.golf.value"/>    </strong>

    <em class="stat-label">
      <fmt:message key="lacala.details.golf"/>      </em>
  </div>
  <div class="stat">

    <strong class="stat-value">
     <fmt:message key="lacala.details.hectars.value"/>   </strong>

    <em class="stat-label">
    <fmt:message key="lacala.details.hectars"/>  </em>
  </div>
  <div class="stat">

    <strong class="stat-value">
     <fmt:message key="lacala.details.units.value"/>    </strong>

    <em class="stat-label">
      <fmt:message key="lacala.details.units"/>      </em>
  </div>
<!--   <div class="stat"> -->

<!--     <strong class="stat-value"> -->
<!--       1 ha    </strong> -->

<!--     <em class="stat-label"> -->
<!--       Terrain      </em> -->
<!--   </div> -->
  </div>
</div>
          </div>
        </div>
      </div>
    </header>

    <main class="single-main">
      <div class="container">
        <div class="single-columns">
          <div class="single-column is-lead">
            <div class="single-content content"><p><fmt:message key="lacala.description"/></p></div>
            <div class="single-grid">
  <div class="single-grid-container">
    <div class="single-grid-items">
      <a class="single-cell psw-item"><img src="../../img/la-cala/1.jpg" width="480" height="320" data-index="4"sizes="480px"srcset="../../img/la-cala/1.jpg ../../img/la-cala/1.jpg 1440w"></a>
      <a class="single-cell psw-item"><img src="../../img/la-cala/2.jpg" width="240" height="160" data-index="5"sizes="240px"srcset="../../img/la-cala/2.jpg ../../img/la-cala/2.jpg ../../img/la-cala/2.jpg 1440w"></a>
      <a class="single-cell psw-item"><img src="../../img/la-cala/3.jpg" width="240" height="160" data-index="6"sizes="240px"srcset="../../img/la-cala/3.jpg ../../img/la-cala/3.jpg ../../img/la-cala/3.jpg 1440w"></a>
      <a class="single-cell psw-item"><img src="../../img/la-cala/4.jpg" width="240" height="160" data-index="7"sizes="240px"srcset="../../img/la-cala/4.jpg ../../img/la-cala/4.jpg ../../img/la-cala/4.jpg 1440w"></a>
      <a class="single-cell psw-item"><img src="../../img/la-cala/5.jpg" width="240" height="160" data-index="8"sizes="240px"srcset="../../img/la-cala/5.jpg ../../img/la-cala/5.jpg ../../img/la-cala/5.jpg 1440w"></a>
      <a class="single-cell psw-item"><img src="../../img/la-cala/6.jpg" width="240" height="160" data-index="9"sizes="240px"srcset="../../img/la-cala/6.jpg ../../img/la-cala/6.jpg ../../img/la-cala/6.jpg 1440w"></a>    </div>
  </div>

  <div class="single-grid-action">
   <a class="button is-info  psw-trigger" href=""><span class="button-text"><fmt:message key="lacala.btn.photos"/></span></a>
  </div>
</div>
          </div>

        </div>
      </div>
    </main>

    <script type="text/javascript">
      window.photoswipe_items = [
    	  {"thumbnail":
    	  {"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-1-360x240.jpg","w":360,"h":240},
    	  "medium_large":
    	  {"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-1-1440x960.jpg","w":1440,"h":960},
    	  "large":
    	  {"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-1.jpg","w":2880,"h":1920}},
    	  {"thumbnail":
    	  {"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-2-360x240.jpg","w":360,"h":240},
    	  "medium_large":
    	  {"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-2-1440x960.jpg","w":1440,"h":960},
    	  "large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-2.jpg","w":2880,"h":1920}},
    	  {"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-3-360x240.jpg","w":360,"h":240},
    	"medium_large":
    	{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-3-1440x960.jpg","w":1440,"h":960},
    	"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-3.jpg","w":2880,"h":1920}},
{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-4-360x240.jpg","w":360,"h":240},
	"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-4-1440x960.jpg","w":1440,"h":960},
	"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-4.jpg","w":2880,"h":1920}},
	{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-5-360x240.jpg","w":360,"h":240},
		"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-5-1440x960.jpg","w":1440,"h":960},
		"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-5.jpg","w":2880,"h":1920}},
		{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-6-360x240.jpg","w":360,"h":240},
			"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-6-1440x960.jpg","w":1440,"h":960},
			"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-6.jpg","w":2880,"h":1920}},
			{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-7-360x240.jpg","w":360,"h":240},
				"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-7-1440x960.jpg","w":1440,"h":960},
				"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-7.jpg","w":2880,"h":1920}},
				{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-8-360x240.jpg","w":360,"h":240},
					"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-8-1440x960.jpg","w":1440,"h":960},
					"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-8.jpg","w":2880,"h":1920}},
					{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-9-360x240.jpg","w":360,"h":240},
						"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-9-1440x960.jpg","w":1440,"h":960},
						"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-9.jpg","w":2880,"h":1920}},
						{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-10-360x240.jpg","w":360,"h":240},
							"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-10-1440x960.jpg","w":1440,"h":960},
							"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-10.jpg","w":2880,"h":1920}},
							{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-11-360x240.jpg","w":360,"h":240},
								"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-11-1440x960.jpg","w":1440,"h":960},
								"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-11.jpg","w":2880,"h":1920}},
								{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-12-360x240.jpg","w":360,"h":240},
									"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-12-1440x960.jpg","w":1440,"h":960},
									"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-12.jpg","w":2880,"h":1920}},
									{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-13-360x240.jpg","w":360,"h":240},
										"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-13-1440x960.jpg","w":1440,"h":960},
										"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-13.jpg","w":2880,"h":1920}},
										{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-14-360x240.jpg","w":360,"h":240},
"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-14-1440x960.jpg","w":1440,"h":960},
"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-14.jpg","w":2880,"h":1920}},
{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-15-360x240.jpg","w":360,"h":240},
	"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-15-1440x960.jpg","w":1440,"h":960},
	"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-15.jpg","w":2880,"h":1920}},
	{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-16-360x240.jpg","w":360,"h":240},
		"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-16-1440x960.jpg","w":1440,"h":960},
		"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-16.jpg","w":2880,"h":1920}},
		{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-17-360x240.jpg","w":360,"h":240},
			"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-17-1440x960.jpg","w":1440,"h":960},
			"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-17.jpg","w":2880,"h":1920}},
			{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-18-360x240.jpg","w":360,"h":240},
				"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-18-1440x960.jpg","w":1440,"h":960},
				"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-18.jpg","w":2880,"h":1920}},
				{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-19-360x240.jpg","w":360,"h":240},
					"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-19-1440x960.jpg","w":1440,"h":960},
					"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-19.jpg","w":2880,"h":1920}},
					{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-20-360x240.jpg","w":360,"h":240},
						"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-20-1440x960.jpg","w":1440,"h":960},
						"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-20.jpg","w":2880,"h":1920}},
						{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-21-360x240.jpg","w":360,"h":240},
							"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-21-1440x960.jpg","w":1440,"h":960},
							"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-21.jpg","w":2880,"h":1920}},
							{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-22-360x240.jpg","w":360,"h":240},
								"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-22-1440x960.jpg","w":1440,"h":960},
								"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-22.jpg","w":2880,"h":1920}},
								{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-23-360x240.jpg","w":360,"h":240},
									"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-23-1440x960.jpg","w":1440,"h":960},
									"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-23.jpg","w":2880,"h":1920}},
									{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-24-360x240.jpg","w":360,"h":240},
										"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-24-1440x960.jpg","w":1440,"h":960},
										"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-24.jpg","w":2880,"h":1920}},
										{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-25-360x240.jpg","w":360,"h":240},
											"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-25-1440x960.jpg","w":1440,"h":960},
											"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-25.jpg","w":2880,"h":1920}},{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-26-360x240.jpg","w":360,"h":240},"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-26-1440x960.jpg","w":1440,"h":960},"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-26.jpg","w":2880,"h":1920}},{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-27-360x240.jpg","w":360,"h":240},"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-27-1440x960.jpg","w":1440,"h":960},"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-27.jpg","w":2880,"h":1920}},{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-28-360x240.jpg","w":360,"h":240},"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-28-1440x960.jpg","w":1440,"h":960},"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-28.jpg","w":2880,"h":1920}},{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-29-360x240.jpg","w":360,"h":240},"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-29-1440x960.jpg","w":1440,"h":960},"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-29.jpg","w":2880,"h":1920}},{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-30-360x240.jpg","w":360,"h":240},"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-30-1440x960.jpg","w":1440,"h":960},"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-30.jpg","w":2880,"h":1920}},{"thumbnail":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-31-360x240.jpg","w":360,"h":240},"medium_large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-31-1440x960.jpg","w":1440,"h":960},"large":{"src":"https:\/\/ivanballiniestates.com\/wp-content\/uploads\/2019\/03\/manoir-vue-mer-a-vendre-benerville-1206-31.jpg","w":2880,"h":1920}}];
    </script>

    
  
<!-- Root element of PhotoSwipe. Must have class pswp. -->
<div class="pswp" tabindex="-1" role="dialog" aria-hidden="true">
  <!-- Background of PhotoSwipe.
     It's a separate element as animating opacity is faster than rgba(). -->
  <div class="pswp__bg"></div>
  <!-- Slides wrapper with overflow:hidden. -->
  <div class="pswp__scroll-wrap">
    <!-- Container that holds slides.
      PhotoSwipe keeps only 3 of them in the DOM to save memory.
      Don't modify these 3 pswp__item elements, data is added later on. -->
    <div class="pswp__container">
      <div class="pswp__item"></div>
      <div class="pswp__item"></div>
      <div class="pswp__item"></div>
    </div>
    <!-- Default (PhotoSwipeUI_Default) interface on top of sliding area. Can be changed. -->
    <div class="pswp__ui pswp__ui--hidden">
      <div class="pswp__top-bar">
        <!--  Controls are self-explanatory. Order can be changed. -->
        <div class="pswp__counter"></div>
        <button class="pswp__button pswp__button--close" title="Close (Esc)"></button>
        <button class="pswp__button pswp__button--share" title="Share"></button>
        <button class="pswp__button pswp__button--fs" title="Toggle fullscreen"></button>
        <button class="pswp__button pswp__button--zoom" title="Zoom in/out"></button>
        <!-- Preloader demo http://codepen.io/dimsemenov/pen/yyBWoR -->
        <!-- element will get class pswp__preloader--active when preloader is running -->
        <div class="pswp__preloader">
          <div class="pswp__preloader__icn">
            <div class="pswp__preloader__cut">
            <div class="pswp__preloader__donut"></div>
            </div>
          </div>
        </div>
      </div>
      <div class="pswp__share-modal pswp__share-modal--hidden pswp__single-tap">
        <div class="pswp__share-tooltip"></div>
      </div>
      <button class="pswp__button pswp__button--arrow--left" title="Previous (arrow left)">
      </button>
      <button class="pswp__button pswp__button--arrow--right" title="Next (arrow right)">
      </button>
      <div class="pswp__caption">
        <div class="pswp__caption__center"></div>
      </div>
    </div>
    <div class="pswp__minis">
      <div class="pswp__minis-list"></div>
    </div>
  </div>
</div>




<script>


window.psw_current_index = 0;

function buildItems() {
  const all_items = window.photoswipe_items;
  let items = [];

  if (Array.isArray(all_items) && all_items.length > 0) {
    all_items.forEach(original => {
      const item = {
        src: original.large.src,
        msrc: original.medium_large.src,
        w: original.large.w,
        h: original.large.h
      };

      items.push(item);
    });
  }

  return items;
}

function initThumbnails() {
  const html_items = document.querySelectorAll('.psw-item');

  html_items.forEach((html_item, index) => {
    html_item.onclick = onThumbnailsClick;
  });
}

function updateThumbnails(psw_items) {
  const html_items = document.querySelectorAll('.psw-item');

  html_items.forEach((html_item, index) => {
    psw_items[index].el = html_item;
  });

  return psw_items;
}

function onThumbnailsClick(e) {
  e = e || window.event;
  e.preventDefault ? e.preventDefault() : e.returnValue = false;

  const target = e.target || e.srcElement;
  const index = target.dataset['index'];

  if (index >= 0) {
    // open PhotoSwipe if valid index found
    openPhotoswipe(index);
  }

  return false;
}

function onTriggerClick(e) {
  e = e || window.event;
  e.preventDefault ? e.preventDefault() : e.returnValue = false;

  if (window.psw_current_index >= 0) {
    openPhotoswipe(window.psw_current_index);
  }

  return false;
}

function onMiniClick(e, psw_gallery) {
  e = e || window.event;
  e.preventDefault ? e.preventDefault() : e.returnValue = false;

  const target = e.target || e.srcElement;
  const index = target.dataset['index'];

  if (index >= 0) {
    psw_gallery.goTo(parseInt(index, 10));
  }

  return false;
}

function addMinis(psw_gallery) {
  const container = document.querySelectorAll('.pswp__minis-list')[0];
  const all_items = window.photoswipe_items;

  if (Array.isArray(all_items) && all_items.length > 0) {
    all_items.forEach((image, index) => {
      const link_el = document.createElement('a');
      const image_el = document.createElement('img');
      image_el.setAttribute('src', image.thumbnail.src);
      image_el.setAttribute('width', image.thumbnail.w);
      image_el.setAttribute('height', image.thumbnail.h);
      image_el.setAttribute('data-index', index);
      image_el.addEventListener('click', event => {
        return onMiniClick(event, psw_gallery);
      });
      link_el.className = 'pswp__mini';
      link_el.appendChild(image_el);
      container.appendChild(link_el);
    });
  }
}

function removeMinis(psw_gallery) {
  const container = document.querySelectorAll('.pswp__minis-list')[0];
  const minis = container.querySelectorAll('.pswp__mini');

  minis.forEach(el => {
    el.removeEventListener('click', event => {
      return onMiniClick(event, psw_gallery);
    });
    container.removeChild(el);
  });
}

function moveMinis(index) {
  const list_el = document.querySelectorAll('.pswp__minis-list')[0];
  const minis = list_el.querySelectorAll('.pswp__mini');
  const selected_mini = minis[index];
  const mini_width = 64;

  // Offset the container
  const offset = -1 * mini_width * index;
  list_el.style.transform = `translate3d(${offset}px, 0, 0)`;

  // Highlight the current item
  minis.forEach(el => {
    el.classList.remove('is-active');
  });
  selected_mini.classList.add('is-active');
}

function openPhotoswipe(index) {
  const psw_el = document.querySelectorAll('.pswp')[0];
  let psw_items = buildItems();
  psw_items = updateThumbnails(psw_items);
  const psw_options = {
    bgOpacity: 0.9,
    closeOnScroll: false,
    getThumbBoundsFn: function (index) {
      if (!psw_items[index].el) {
        return;
      }

      const thumbnail = psw_items[index].el.getElementsByTagName('img')[0];
      const pageYScroll = window.pageYOffset || document.documentElement.scrollTop;
      const rect = thumbnail.getBoundingClientRect();

      return {
        x: rect.left,
        y: rect.top + pageYScroll,
        w: rect.width
      };
    },
    history: false,
    index: parseInt(index, 10),
    preload: [1, 3],
    shareButtons: [{
      id: 'facebook',
      label: 'Share on Facebook',
      url: 'https://www.facebook.com/sharer/sharer.php?u={{url}}'
    }, {
      id: 'twitter',
      label: 'Tweet',
      url: 'https://twitter.com/intent/tweet?text={{text}}&url={{url}}'
    }]
  };

  if (isNaN(psw_options.index)) {
    return;
  }

  const psw_gallery = new PhotoSwipe(psw_el, PhotoSwipeUI_Default, psw_items, psw_options);
  psw_gallery.init();

  addMinis(psw_gallery);
  moveMinis(index);

  psw_gallery.listen('afterChange', () => {
    moveMinis(psw_gallery.getCurrentIndex());
  });

  psw_gallery.listen('imageLoadComplete', (index, item) => {
    const current_el = psw_gallery.currItem.container;
    current_el.addEventListener('contextmenu', event => event.preventDefault());
    window.psw_current_index = index;
  });

  psw_gallery.listen('close', () => {
    psw_el.classList.add('is-closing');
  });

  psw_gallery.listen('destroy', () => {
    removeMinis(psw_gallery);
    psw_el.classList.remove('is-closing');
  });
}

document.addEventListener('DOMContentLoaded', () => {
  initThumbnails();

  const psw_triggers = document.querySelectorAll('.psw-trigger');

  if (psw_triggers.length > 0) {
    psw_triggers.forEach(el => {
      el.onclick = onTriggerClick;
    });
  }
});

</script>
    


<%@ include file="WEB-INF/templates/contact.jsp" %>
<%@ include file="WEB-INF/templates/newsletter.jsp" %>
<%@ include file="includes/footer.jsp"%>
