
<style>
.panel-block{justify-content: center !important;}
.textarea{min-height: 144px !important;}
.card{padding-top:0 !important;padding-bottom:20px !important;}
  .button {padding: .625em 2em .875em !important;}
  .card-content{position:relative !important;padding: 2rem 1.5rem 1.5rem !important;background-image: none;}
  .card, .card-content, .card:hover{box-shadow: inherit !important;background-color: #E7E5E0 !important;}
      .google-maps {
        position: relative;
        padding-bottom: 75%; // This is the aspect ratio
        height: 0;
        overflow: hidden;
    }
    .google-maps iframe {
        position: absolute;
        top: 0;
        left: 0;
        width: 100% !important;
        height: 100% !important;
    }
</style>

<section class="hero">
  <div class="hero-background" style="background-image: url(../../img/contact.jpg);"></div>
  <div class="hero-overlay"></div>
  <div class="hero-nav"><%@ include file="includes/nav.jsp"%></div>
  <div class="hero-content">
    <div class="container">
      <h1 class="title hero-title has-text-white" style="margin-bottom:10px;"><fmt:message key="contact.hero.title"/></h1>
      <p class="hero-subtitle"><fmt:message key="contact.hero.subtitle"/></p>
	  <%@ include file="WEB-INF/templates/pattern.jsp" %>
    </div>
  </div>
</section>

<section class="main page-main">
 <div class="page-body">
  <div class="page-content">
   <div class="container">
    <div class="content">
    <h3 class=" has-text-centered has-text-grey-darker"><fmt:message key="contact.intro"/></h3>
    
    <div class="card">
        <div class="card-content">
		<div class="columns" style="margin-bottom:0 !important;">
			<div class="column" style="padding-bottom:0 !important;">
				<div class="field">
					<div class="control has-icons-left">
						<input id="fname" class="input" type="text" placeholder="<fmt:message key="contact.form.name"/>">
			    		<span class="icon is-small is-left"><i class="fas fa-user"></i></span>
			  		</div>
				</div>
				<div class="field">
					<div class="control has-icons-left">
			    		<input id="femail" class="input is-danger" type="email" placeholder="<fmt:message key="contact.form.email"/>" value="">
			    		<span class="icon is-small is-left"><i class="fas fa-envelope"></i></span>
			  		</div>
				</div>
				<div class="field has-addons">
					<div class="control">
			    		<span class="select" id="fphonecode">
			      			<select>
			        			<option value="+44">+44</option>
			        			<option value="+34">+34</option>
			        			<option value="+69">+69</option>
			      			</select>
			    		</span>
<!-- 			       		<span class="icon is-small is-left"><i class="fas fa-envelope"></i></span> -->
			  		</div>
			 		<div class="control is-expanded"><input id="fphone" class="input" type="text" placeholder="<fmt:message key="contact.form.phone"/>"></div>
				</div>
			</div>
			<div class="column">
				<div class="field">
					<div class="control"><textarea id="fmessage" class="textarea" placeholder="<fmt:message key="contact.form.message"/>"></textarea></div>
				</div>
			</div>
		</div>
		<div class="field" style="float: right;">
		<div class="control"><button class="button is-success is-small" id="btnContactSubmit"><fmt:message key="contact.form.send"/></button></div>
		</div>
		   </div>   
	</div>
		
		
		
		
		
		
		
		
		
<nav class="panel is-size-5" style="margin-top:1.5rem;">
  <a class="panel-block"><span class="panel-icon"><i class="fas fa-phone" aria-hidden="true"></i></span>+34 952 58 44 44</a>
  <a class="panel-block"><span class="panel-icon"><i class="far fa-envelope" aria-hidden="true"></i></span>info@patriciomartin.com</a>
  <a class="panel-block"><span class="panel-icon"><i class="fas fa-map-marker-alt" aria-hidden="true"></i></span>Av. Jesús Santos Rein, 15, Of. 4, 29640 Fuengirola</a>
</nav>
		
		
		
		
		
		<div class="google-maps">
		<iframe width="600" height="450" frameborder="0" style="border:0" src="https://www.google.com/maps/embed/v1/place?q=Av.%20Jes%C3%BAs%20Santos%20Rein%2C%2015%2C%20Of.%204%2C%2029640%20Fuengirola&key=AIzaSyB5tocSbBnYlgmrlj0qQJH1VQXXNdUXivA" allowfullscreen></iframe>
		</div>
		
		
		
		
    </div>
   </div>
  </div>
 </div>
</section>

<!-- <script type="text/javascript" src="../../js/contact.js?v=2"></script> -->


<%@ include file="js/contact.jsp" %>
<script>




</script>



<%@ include file="WEB-INF/templates/newsletter.jsp" %>
