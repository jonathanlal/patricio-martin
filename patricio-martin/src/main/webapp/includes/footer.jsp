<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- <jsp:useBean id="now" class="java.util.Date" /> --%>
<fmt:formatDate var="year" value="${now}" pattern="yyyy" />

<footer class="footer has-text-grey-lighter is-centered has-text-centered">

<div class="footer-links-container">
    <span class="main-footer__links"><a href="../../"><fmt:message key="nav.home"/></a></span>
    <span class="main-footer__links"><a href="<fmt:message key="url.about"/>"><fmt:message key="nav.about"/></a></span>
    <span class="main-footer__links"><a href="<fmt:message key="url.contact"/>"><fmt:message key="nav.contact"/></a></span>
    <span class="main-footer__links"><a href="<fmt:message key="url.services"/>"><fmt:message key="nav.services"/></a></span>
    <span class="main-footer__links"><a href="<fmt:message key="url.projects"/>"><fmt:message key="nav.projects"/></a></span>
    <span class="main-footer__links last"><a href="<fmt:message key="url.terms"/>"><fmt:message key="nav.terms"/></a></span>
</div>
<br><br>

	<div class="columns is-gapless">
		<div class="column"></div>
		<div class="column">
		  					<img src="../../img/logo/logo.png" style="width:50px;display: flex;margin:0 auto;opacity: 0.9;margin-bottom: 10px;margin-top: 10px;">
		
		     		<%@ include file="/WEB-INF/templates/pattern.jsp" %>
		
 			<p class="is-size-6 has-text-centered">+34 952 58 44 44</p>
   			<p class="is-size-6 has-text-centered">info@patriciomartin.com</p>
   			<p class="is-size-6 has-text-centered has-margin-4"><i class="far fa-copyright"></i> ${year} Patricio Martin. <fmt:message key="footer.rights"/></p>
  		
  		</div>
  		<div class="column"></div>
	</div>
</footer>

<script>
document.addEventListener('DOMContentLoaded', () => {
	  // Get all "navbar-burger" elements
	  const $navbarBurgers = Array.prototype.slice.call(document.querySelectorAll('.navbar-burger'), 0);
	  // Check if there are any navbar burgers
	  if ($navbarBurgers.length > 0) {
	    // Add a click event on each of them
	    $navbarBurgers.forEach( el => {
	      el.addEventListener('click', () => {
	        // Get the target from the "data-target" attribute
	        const target = el.dataset.target;
	        const $target = document.getElementById(target);
	        // Toggle the "is-active" class on both the "navbar-burger" and the "navbar-menu"
	        document.getElementById('nav-languages').classList.toggle('languages-neg');
	        el.classList.toggle('is-active');
	        $target.classList.toggle('is-active');
	      });
	    });
	  }
	});
</script>


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

</body>
</html>