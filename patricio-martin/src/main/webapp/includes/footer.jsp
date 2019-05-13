




<footer class="footer">

  

<div class="columns is-centered has-text-centered  is-gapless is-uppercase is-size-6 has-text-weight-semibold">
  <div class="column">
    Home
  </div>
  <div class="column">
    About
  </div>
  <div class="column">
    Contact
  </div>
    <div class="column">
    Projects
  </div>
      <div class="column">
    Terms
  </div>
</div>

  
        <%@ include file="/WEB-INF/templates/pattern.jsp" %>
        
        
  <p class="is-size-7 has-text-centered">+34 952 58 44 44</p>
    <p class="is-size-7 has-text-centered">info@patriciomartin.com</p>
    <p class="is-size-7 has-text-centered has-margin-4">Copyright @ 2019. All rights reserved.</p>
    
    

  
</footer>








<script>
// HAMBURGER MENU TOGGLE LOGIC
document.addEventListener('DOMContentLoaded', () => {
    const $navbarBurgers = Array.prototype.slice.call(document.querySelectorAll('.navbar-burger'), 0);
    if ($navbarBurgers.length > 0) {
        $navbarBurgers.forEach(el => {
            el.addEventListener('click', () => {
                const target = el.dataset.target;
                const $target = document.getElementById(target);
                el.classList.toggle('is-active');
                $target.classList.toggle('is-active');
                toggleNavColor();
            })
        })
    }
})

function toggleNavColor(){
	const navbar = document.getElementById('navbar');
	navbar.classList.toggle('is-closed');
}

</script>




</body>
</html>