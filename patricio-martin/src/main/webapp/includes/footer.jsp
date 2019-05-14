<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate var="year" value="${now}" pattern="yyyy" />



 <section id="newsletter" class="section is-medium" style="background-color:#E7E5E0">
  <div class="container">
    <div class="columns is-vcentered">
      <div class="column" style="    margin-top: -20px;">
        <p class="title">Newsletter</p>
        <p class="subtitle is-4 has-text-grey-light">Features, releases, showcases... stay in the loop!</p>
      </div>




      <div class="column">
      
        <form action="https://mail.jgthms.com/subscribe" method="POST" accept-charset="utf-8">
          <div class="field is-grouped">
            <div class="control has-icons-left is-expanded">
              <input type="email" value="" name="email" class="input is-medium is-flat" placeholder="email address" required="">
              <span class="icon is-small is-left">
                <svg class="svg-inline--fa fa-envelope fa-w-16" aria-hidden="true" data-prefix="fas" data-icon="envelope" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" data-fa-i2svg=""><path fill="currentColor" d="M502.3 190.8c3.9-3.1 9.7-.2 9.7 4.7V400c0 26.5-21.5 48-48 48H48c-26.5 0-48-21.5-48-48V195.6c0-5 5.7-7.8 9.7-4.7 22.4 17.4 52.1 39.5 154.1 113.6 21.1 15.4 56.7 47.8 92.2 47.6 35.7.3 72-32.8 92.3-47.6 102-74.1 131.6-96.3 154-113.7zM256 320c23.2.4 56.6-29.2 73.4-41.4 132.7-96.3 142.8-104.7 173.4-128.7 5.8-4.5 9.2-11.5 9.2-18.9v-19c0-26.5-21.5-48-48-48H48C21.5 64 0 85.5 0 112v19c0 7.4 3.4 14.3 9.2 18.9 30.6 23.9 40.7 32.4 173.4 128.7 16.8 12.2 50.2 41.8 73.4 41.4z"></path></svg><!-- <i class="fas fa-envelope"></i> -->
              </span>
              <img class="bd-drawing bd-is-spam-free" src="https://bulma.io/images/drawing/spam-free.png" width="112" height="88" style="    position: absolute !important;bottom:100% !important;right:90% !important;">

            </div>

            <div class="control">
              <div class="is-hidden">
                <input type="text" name="hp" id="hp">
              </div>
              <input type="hidden" name="list" value="So5UY3O9gHJkq892bn763Tyf4A">
              <button class="button is-medium is-info">
                <strong>Subscribe</strong>
              </button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</section>




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
    <p class="is-size-6 has-text-centered has-margin-4"><i class="far fa-copyright"></i> ${year} Patricio Martin. All rights reserved.</p>
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