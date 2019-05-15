<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate var="year" value="${now}" pattern="yyyy" />








<footer class="footer has-text-grey-lighter">














<div class="columns is-centered has-text-centered  is-gapless   ">
  <div class="column">
<!--     <p>Home</p> -->
<!--      <p>Contact</p> -->
<!--        <p>About</p> -->
<!--      <p>Projects</p> -->
  </div>
  <div class="column">



<!--         <div class=""> -->
        <img src="../img/logo-only.png" style="width:50px;display: flex;margin:0 auto;opacity: 0.9;    margin-bottom: 10px;    margin-top: 10px;">
  <p class="is-size-6 has-text-centered">+34 952 58 44 44</p>
    <p class="is-size-6 has-text-centered">info@patriciomartin.com</p>
    <p class="is-size-6 has-text-centered has-margin-4"><i class="far fa-copyright"></i> ${year} Patricio Martin. <fmt:message key="footer.rights"/></p>
<!--     </div> -->
      <%@ include file="/WEB-INF/templates/pattern.jsp" %>

    
  </div>
  <div class="column">
<%--     <%@ include file="/WEB-INF/templates/social.jsp" %>  --%>
  </div>
<!--     <div class="column"> -->
<!--     Projects -->
<!--   </div> -->
<!--       <div class="column"> -->
<!--     Terms -->
<!--   </div> -->
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
	        el.classList.toggle('is-active');
	        $target.classList.toggle('is-active');

	      });
	    });
	  }

	});
</script>




</body>
</html>