<section class="collaborate">
  <div class="collaborate-overlay"></div>
  <div class="container">
    <div class="box collaborate-box">
      <div class="box-content">
        <h4 class="title collaborate-title" style="color:black !important;"><fmt:message key="index.contact.title"/></h4>
  		  <%@ include file="/WEB-INF/templates/pattern.jsp" %>
        <div class="content collaborate-content">
          <p><fmt:message key="index.contact.paragraph"/></p>
        </div>
       <div class="collaborate-buttons">
       
             <button class="button is-info open-modal" data-target="contactModal">
                <strong class="button-text margin-top-minus-4px" style="padding-right:8px;"><fmt:message key="index.contact.btnContact"/> </strong><i class="fas fa-long-arrow-alt-right" style="margin-top:-5px !important;"></i>
              </button>
       
<!--          <a class="button is-info  open-modal" data-target="contactModal" href="#"> -->
<!--          <strong class="button-text" style="padding-right:8px;font-size:20px;line-height:30px;font-family: inherit;"> -->
<!--          <fmt:message key="index.contact.btnContact"/> -->
<!--          </strong><i class="fas fa-long-arrow-alt-right"></i> -->
<!--          </a> -->
       </div>
      </div>
    </div>
  </div>
</section>









<div id="contactModal" class="modal">
  <div class="modal-background close-modal"></div>
  <div class="modal-body">
    <div class="modal-content">
      <header class="modal-header">
        <p class="title modal-title">
          Contact        </p>
        <p class="modal-cross">
          <span class="delete close-modal">
            <svg aria-hidden="true" data-prefix="far" data-icon="times-circle" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" class="svg-inline--fa fa-times-circle fa-w-16 fa-2x"><path fill="currentColor" d="M256 8C119 8 8 119 8 256s111 248 248 248 248-111 248-248S393 8 256 8zm0 448c-110.5 0-200-89.5-200-200S145.5 56 256 56s200 89.5 200 200-89.5 200-200 200zm101.8-262.2L295.6 256l62.2 62.2c4.7 4.7 4.7 12.3 0 17l-22.6 22.6c-4.7 4.7-12.3 4.7-17 0L256 295.6l-62.2 62.2c-4.7 4.7-12.3 4.7-17 0l-22.6-22.6c-4.7-4.7-4.7-12.3 0-17l62.2-62.2-62.2-62.2c-4.7-4.7-4.7-12.3 0-17l22.6-22.6c4.7-4.7 12.3-4.7 17 0l62.2 62.2 62.2-62.2c4.7-4.7 12.3-4.7 17 0l22.6 22.6c4.7 4.7 4.7 12.3 0 17z" class=""></path></svg>
          </span>
        </p>
      </header>

      <div class="modal-form">
        <div role="form" class="wpcf7" id="wpcf7-f5-o1" lang="fr-FR" dir="ltr">
<div class="screen-reader-response"></div>
<form action="/#wpcf7-f5-o1" method="post" class="wpcf7-form" novalidate="novalidate">
<div style="display: none;">
<input type="hidden" name="_wpcf7" value="5">
<input type="hidden" name="_wpcf7_version" value="5.1.1">
<input type="hidden" name="_wpcf7_locale" value="fr_FR">
<input type="hidden" name="_wpcf7_unit_tag" value="wpcf7-f5-o1">
<input type="hidden" name="_wpcf7_container_post" value="0">
<input type="hidden" name="g-recaptcha-response" value="">
</div>
<div class="form">
<div class="form-field">
<label class="form-label" for="contact-name">Nom</label><p></p>
<div class="form-control"><span class="wpcf7-form-control-wrap contact-name"><input type="text" name="contact-name" value="" size="40" class="wpcf7-form-control wpcf7-text wpcf7-validates-as-required input" aria-required="true" aria-invalid="false"></span></div>
</div>
<div class="form-field">
<label class="form-label" for="contact-email">Email</label><p></p>
<div class="form-control"><span class="wpcf7-form-control-wrap contact-email"><input type="email" name="contact-email" value="" size="40" class="wpcf7-form-control wpcf7-text wpcf7-email wpcf7-validates-as-required wpcf7-validates-as-email input" aria-required="true" aria-invalid="false"></span></div>
</div>
<div class="form-field">
<label class="form-label" for="contact-subject">Sujet</label><p></p>
<div class="form-control"><span class="wpcf7-form-control-wrap contact-subject"><input type="text" name="contact-subject" value="" size="40" class="wpcf7-form-control wpcf7-text wpcf7-validates-as-required input" aria-required="true" aria-invalid="false"></span></div>
</div>
<div class="form-field">
<label class="form-label" for="contact-message">Message</label><p></p>
<div class="form-control"><span class="wpcf7-form-control-wrap contact-message"><textarea name="contact-message" cols="40" rows="10" class="wpcf7-form-control wpcf7-textarea wpcf7-validates-as-required textarea" aria-required="true" aria-invalid="false"></textarea></span></div>
</div>
<div class="form-buttons"><input type="submit" value="Envoyer" class="wpcf7-form-control wpcf7-submit button is-primary is-small"><span class="ajax-loader"></span><a class="button is-small close-modal">Annuler</a></div>
</div>
<div class="wpcf7-response-output wpcf7-display-none"></div></form></div>      </div>
    </div>
  </div>
  <button class="close-modal is-large"></button>
</div>


<script>

var classname = document.getElementsByClassName("open-modal");


var myFunction = function() {
    var attribute = this.getAttribute("data-myattribute");
    alert(attribute);
};

for (var i = 0; i < classname.length; i++) {
    classname[i].addEventListener('click', myFunction, false);
}


// $(".open-modal").click(function() {
// 	  $(".modal").addClass("is-active");  
// 	});

// 	$(".modal-close").click(function() {
// 	   $(".modal").removeClass("is-active");
// 	});

</script>