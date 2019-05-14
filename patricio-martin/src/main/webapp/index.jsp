<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="includes/header.jsp"%>






<style>



.message{
background-color: transparent !important;
}
.message-surtitle, .title{
color: white !important;
font-family:'Soleil Bold' !important;
}

.is-white-outlined{
    background-color: transparent !important;
}
.is-white-outlined:hover{
    background-color: white !important;
    color:black !important;
}



.property-img{
margin-bottom: -20px;margin-right: -10px;    opacity: 0.8;
    max-width: 100px;
}


.control.has-icons-left .icon, .control.has-icons-right .icon{
top: 3px !important;
}

























</style>

<section class="hero front-hero">
  <div class="front-hero-media">
    <video class="front-hero-video" muted autoplay loop playsinline>
      <source src="https://storage.googleapis.com/patricio-martin.appspot.com/plot-6-2018.mp4" data-store="https://ivanballiniestates.com/wp-content/themes/ivan-ballini-v4/videos/20190322-jt.mp4" type="video/mp4">
    </video>
  </div>
  <div class="hero-overlay front-hero-overlay __web-inspector-hide-shortcut__"></div>
  
  <jsp:include page="includes/include_nav.jsp"></jsp:include>
  
  
  
  
  

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 <div class="hero-content front-hero-content" >
    <div id="messages" class="messages">
    <div class="message is-1 is-shown"><p class="message-surtitle">Welcome to</p><h1 class="title hero-title message-title">Patricio Martin Architects</h1></div>
    <div class="message is-2"><p class="message-surtitle">Architects based on </p><h1 class="title hero-title message-title">The Costa del Sol, Spain</h1></div>
    </div>
    
    <%@ include file="WEB-INF/templates/pattern.jsp" %>


    <div class="hero-subtitle front-hero-subtitle">
      <p><fmt:message key="label.welcome" />Patricio Martin can provide a full architectural and building service.
From the initial survey and design concept, through all stages of the building process, right up to the completed project and final result.</p>
    </div>
    <nav class="buttons front-hero-buttons">
      <a class="button is-info" href="../projects/">
      <span class="button-text">
  <strong>View</strong> all <strong style="padding-right:8px;">projects</strong>     </span>
  
<i class="fas fa-long-arrow-alt-right"></i>
  </a>
      <a class="button is-white-outlined" href="../contact/">
      <span class="button-text">
      <strong>Contact</strong> us <strong  style="padding-right:8px;">now</strong>    </span>
      <i class="far fa-envelope"></i>
  </a>
    </nav>
  </div>

</section>







  
  <div class="front-properties">
  <div class="container">
  
  
    <div class="front-properties-list">
    <div id="properties-list" class="list-properties">
      
<article class="list-property">
<a href="../projects/la-cala/" class="card property post-2098 type-property status-publish has-post-thumbnail hentry type-manoir region-deauville city-benerville-sur-mer has-5-to-9-rooms has-5-bedrooms region-blue">
  <figure class="card-image property-image">
<img class="responsive-image" src="http://patriciomartin.com/img/la-cala/thumbs/3.jpg" sizes="(max-width: 540px) 100vw, 720px" srcset="http://patriciomartin.com/img/la-cala/thumbs/3.jpg 540w, http://patriciomartin.com/img/la-cala/thumbs/3.jpg 1080w, http://patriciomartin.com/img/la-cala/thumbs/3.jpg 1440w" height="480" width="720">
  </figure>
  <div class="card-content property-content clearfix">
    <div class="property-heading">
      <p class="location property-location">La Cala</p>
	<h3 class="title property-name">Golf & Country Club</h3>
    </div>
    <div class="property-info"><p class="price property-price"><img src="../img/homepage/la-cala2.png" class="property-img"></p>
    </div>
  </div>
</a>
</article>


<article class="list-property">
<a href="../projects/san-eliseo/" class="card property post-610 type-property status-publish has-post-thumbnail hentry type-chateau region-bernay city-bernay has-10-rooms has-5-bedrooms region-red">
  <figure class="card-image property-image">
<img class="responsive-image" src="http://patriciomartin.com/img/san-eliseo/thumbs/4.jpg" sizes="(max-width: 540px) 100vw, 720px" srcset="http://patriciomartin.com/img/san-eliseo/thumbs/4.jpg 540w, http://patriciomartin.com/img/san-eliseo/thumbs/4.jpg 1080w, http://patriciomartin.com/img/san-eliseo/thumbs/4.jpg 1440w" height="480" width="720">
  </figure>
  <div class="card-content property-content clearfix">
    <div class="property-heading">
      <p class="location property-location">Argentina</p>
      <h3 class="title property-name">San Eliseo</h3>
    </div>
    <div class="property-info"><p class="price property-price"><img src="../img/homepage/san-eliseo.png" class="property-img"></p>
    </div>
  </div>
</a>
</article>


<article class="list-property">
<a  href="../projects/rancho-santa-monica/" class="card property post-553 type-property status-publish has-post-thumbnail hentry type-manoir region-honfleur city-honfleur has-5-to-9-rooms has-3-to-4-bedrooms region-green">
  <figure class="card-image property-image">
<img class="responsive-image" src="http://patriciomartin.com/img/rancho-santa-monica/thumbs/6.jpg" sizes="(max-width: 540px) 100vw, 720px" srcset="http://patriciomartin.com/img/rancho-santa-monica/thumbs/6.jpg 540w, http://patriciomartin.com/img/rancho-santa-monica/thumbs/6.jpg 1080w, http://patriciomartin.com/img/rancho-santa-monica/thumbs/6.jpg 1440w" height="480" width="720">
  </figure>
  <div class="card-content property-content clearfix">
    <div class="property-heading">
      <p class="location property-location">Benalmádena</p>
      <h3 class="title property-name">Rancho Santa Monica</h3>
    </div>
        <div class="property-info">
      <p class="price property-price">
        <img src="../img/homepage/rancho.png" class="property-img">
        </p>
    </div>
  </div>
</a>
</article>


<article class="list-property">
<a href="../projects/domus-designs/" class="card property post-796 type-property status-publish has-post-thumbnail hentry type-manoir region-deauville city-tourgeville has-5-to-9-rooms has-3-to-4-bedrooms region-blue">
  <figure class="card-image property-image">
<img class="responsive-image" src="http://patriciomartin.com/img/domus-designs/thumbs/1.jpg" sizes="(max-width: 540px) 100vw, 720px" srcset="http://patriciomartin.com/img/domus-designs/thumbs/1.jpg 540w, http://patriciomartin.com/img/domus-designs/thumbs/1.jpg 1080w, http://patriciomartin.com/img/domus-designs/thumbs/1.jpg 1440w" height="480" width="720">
  </figure>
  <div class="card-content property-content clearfix">
    <div class="property-heading">
      <p class="location property-location">Costa Del Sol</p>
      <h3 class="title property-name">Domus Designs Villas</h3>
    </div>
    <div class="property-info">
      <p class="price property-price">
        <img src="../img/homepage/domus.png" class="property-img">
        </p>
    </div>
  </div>
</a>
</article>

</div>    
</div>

    <nav class="action front-properties-action">
      <a class="button is-info" href="../projects/" style="margin-bottom: 20px;">
      <span class="button-text">
      <strong style="padding-right:8px;">View all projects</strong></span><i class="fas fa-long-arrow-alt-right"></i></a>
    </nav>
    
  </div>
</div>
  
  
  
<section class="collaborate">
  <div class="collaborate-overlay"></div>
  <div class="container">
    <div class="box collaborate-box">
      <div class="box-content">
        <h4 class="title collaborate-title" style="color:black !important;">Work with us</h4>
  		  <%@ include file="WEB-INF/templates/pattern.jsp" %>
        <div class="content collaborate-content">
          <p>Patricio Martin can provide a full architectural and building service.</p>
        </div>
       <div class="collaborate-buttons">
         <a class="button is-info  open-modal" data-target="contactModal" href="#"><span class="button-text"  style="padding-right:8px;"><strong>Contact</strong> us</span><i class="fas fa-long-arrow-alt-right"></i></a>
       </div>
      </div>
    </div>
  </div>
</section>














<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/cookieconsent2/3.1.0/cookieconsent.min.css" />
<script src="//cdnjs.cloudflare.com/ajax/libs/cookieconsent2/3.1.0/cookieconsent.min.js"></script>
<script>
window.addEventListener("load", function(){
window.cookieconsent.initialise({
  "palette": {
    "popup": {
      "background": "#343c66",
      "text": "#cfcfe8"
    },
    "button": {
      "background": "#f71559"
    }
  },
  "theme": "classic",
  "content": {
    "message": "change this --&gt; https://cookieconsent.insites.com/download/"
  }
})});
</script>


<script>

document.addEventListener("DOMContentLoaded", function(){

	  // Messages cycle

	  const SHOWN_CLASS = 'is-shown';
	  const MESSAGES_SPEED = 3600;

	  function loopMessages() {
	    const container_el = document.getElementById('messages');
	    const items = container_el.querySelectorAll('.message');
	const current_item = container_el.getElementsByClassName("message is-shown")[0];
	    const next_item = current_item.nextElementSibling ? current_item.nextElementSibling : items[0];

	    current_item.classList.remove(SHOWN_CLASS);
	    next_item.classList.add(SHOWN_CLASS);

	    setTimeout(loopMessages, MESSAGES_SPEED);
	  }
	  setTimeout(loopMessages, MESSAGES_SPEED);

	});

</script>





<jsp:include flush="true" page="includes/footer.jsp"/>