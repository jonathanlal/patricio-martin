<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  
  <div id="navbar" class="nav navbar is-white">
  <div class="i-gradient">
  <div class="container">
    <nav class="nav-content ">
      <a class="nav-brand" href="../../">
      <img src="../img/patricio-martin2-w.png" alt="Bulma: a modern CSS framework based on Flexbox">
      </a>

<!--       <a class="nav-burger" data-target="nav"> -->
<!--         <span></span> -->
<!--         <span></span> -->
<!--         <span></span> -->
<!--       </a> -->

	<a role="button" class="navbar-burger" data-target="navMenu" aria-label="menu" aria-expanded="false">
	  <span aria-hidden="true"></span>
	  <span aria-hidden="true"></span>
	  <span aria-hidden="true"></span>
	</a>

      <div class="nav-menu navbar-menu" id="navMenu">
        <div class="nav-list">
          <div class="nav-item is-home">
            <a href="<fmt:message key="url.about"/>">
              <fmt:message key="nav.about"/>            </a>
          </div>

          <div class="nav-item is-properties">
            <a href="<fmt:message key="url.projects"/>"><fmt:message key="nav.projects"/></a>
          </div>

          <div class="nav-item is-regions">
            <a href="<fmt:message key="url.services"/>"><fmt:message key="nav.services"/></a>          </div>
        </div>

        <aside class="nav-contact">
          <p>
            <a class="open-modal" data-target="contactModal">
              info@patriciomartin.com
            </a>
          </p>

          <p>
            <a href="tel:+34952584444">
              +34 952 58 44 44
            </a>
          </p>
        </aside>
      </div>

<!-- 		    <form action="../../ChangeLanguage" method="post">     -->
<%-- 		    <input type="hidden" value="${page}" name="page"/> --%>
<div class="nav-languages">

  
  
  	<ul>
  	
  	<li class="wpml-ls-slot-shortcode_actions wpml-ls-item wpml-ls-item-fr  wpml-ls-first-item wpml-ls-item-legacy-list-horizontal ${language eq 'es' ? 'wpml-ls-current-language' : ''}">
	<a href="../../ChangeLanguage?lang=es" class="wpml-ls-link"><span class="wpml-ls-native">Spanish</span></a>
	  		
	
	
	<li class="wpml-ls-slot-shortcode_actions wpml-ls-item wpml-ls-item-en wpml-ls-last-item wpml-ls-item-legacy-list-horizontal ${language eq 'en' || empty language ? 'wpml-ls-current-language' : ''}">
	<a href="../../ChangeLanguage?lang=en" class="wpml-ls-link"><span class="wpml-ls-native">English</span><span class="wpml-ls-display"><span class="wpml-ls-bracket"> (</span>Anglais<span class="wpml-ls-bracket">)</span></span></a>
	</li>
	
	</ul>
		    
		    
<!--             <input class="flags" type="image" src="img/spain.png" name="selection" value="spain" alt="Submit Form" /> -->
<!--             <input class="flags" type="image" src="img/english2.png" name="selection" value="england" alt="Submit Form" /> -->
<!--             <input class="flags" type="image" src="img/norway.png" name="selection" value="norway" alt="Submit Form" /> -->
       	

<!--         <form action="../../ChangeLanguage"> -->
<!-- <div class="wpml-ls-statics-shortcode_actions wpml-ls wpml-ls-legacy-list-horizontal"> -->
<!-- 	<ul><li class="wpml-ls-slot-shortcode_actions wpml-ls-item wpml-ls-item-fr wpml-ls-current-language wpml-ls-first-item wpml-ls-item-legacy-list-horizontal"> -->
<!-- 	<a href="../../ChangeLanguage?lang=es" class="wpml-ls-link"><span class="wpml-ls-native">Français</span></a> -->
<!-- 	</li><li class="wpml-ls-slot-shortcode_actions wpml-ls-item wpml-ls-item-en wpml-ls-last-item wpml-ls-item-legacy-list-horizontal"> -->
<!-- 	<a href="../../ChangeLanguage?lang=en" class="wpml-ls-link"><span class="wpml-ls-native">English</span><span class="wpml-ls-display"><span class="wpml-ls-bracket"> (</span>Anglais<span class="wpml-ls-bracket">)</span></span></a> -->
<!-- 	</li></ul> -->
<!-- </div>  -->
<!--   </form> -->
  
</div>
<!-- 	</form> -->

    </nav>
  </div>
</div>
 </div>