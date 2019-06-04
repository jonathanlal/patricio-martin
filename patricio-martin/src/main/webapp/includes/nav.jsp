<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:bundle basename = "text">

<div id="navbar" class="nav navbar" style="background-color: transparent;z-index: 1001;">
	<div class="i-gradient">
		<div class="container">
			<nav class="nav-content">
				<!-- LOGO -->
				<a class="nav-brand" href=""><img src="/img/logo/navbar.png" alt="Patricio Martin"></a>
				<!-- BURGER -->
				<a role="button" class="navbar-burger" data-target="navMenu" aria-label="menu" aria-expanded="false">
				  <span aria-hidden="true"></span>
				  <span aria-hidden="true"></span>
				  <span aria-hidden="true"></span>
				</a>
				<!-- LANGUAGE -->
				<div class="nav-languages" id="nav-languages">
					<ul>
					<li class="wpml-ls-slot-shortcode_actions wpml-ls-item wpml-ls-item-fr  wpml-ls-first-item wpml-ls-item-legacy-list-horizontal ${language eq 'es' ? 'wpml-ls-current-language' : ''}">
					<a rel="nofollow" href="/ChangeLanguage?lang=es" class="wpml-ls-link"><span class="wpml-ls-native">Spanish</span></a>
					<li class="wpml-ls-slot-shortcode_actions wpml-ls-item wpml-ls-item-en wpml-ls-last-item wpml-ls-item-legacy-list-horizontal ${language eq 'en' || empty language ? 'wpml-ls-current-language' : ''}">
					<a rel="nofollow" href="/ChangeLanguage?lang=en" class="wpml-ls-link"><span class="wpml-ls-native">English</span><span class="wpml-ls-display"><span class="wpml-ls-bracket"> (</span>Anglais<span class="wpml-ls-bracket">)</span></span></a>
					</li>
					</ul>
				</div>
				
				
				
				
				<!-- MAIN LINKS -->
				<div class="navbar-menu" id="navMenu">							
				<div  class="is-hidden-desktop" style="background-color: white;display:block;position:absolute;width:100%;height:100%;margin-top:-10px !important;opacity:0.7;"></div>								
					<div class="nav-list " style="position: relative; top: -13px; left: 26px; transition: none 0s ease 0s;">
						<div class="nav-item "><a href="<fmt:message key="url.about"/>"><fmt:message key="nav.about"/></a></div>
						<div class="nav-item "><a href="<fmt:message key="url.projects"/>"><fmt:message key="nav.projects"/></a></div>
						<div class="nav-item "><a href="<fmt:message key="url.services"/>"><fmt:message key="nav.services"/></a></div>
						<div class="nav-item "><a href="<fmt:message key="url.contact"/>"><fmt:message key="nav.contact"/></a></div>
					</div>
					
					<div id="mobileLanguage" class="is-hidden-desktop">
					<div class="nav-list">
				<div class="nav-item">
				<a rel="nofollow" href="/ChangeLanguage?lang=en" style="margin-right: 10px;"><img alt="English" src="/img/en_flag.png"></a>
				<a rel="nofollow" href="/ChangeLanguage?lang=es"><img alt="Spanish" src="/img/es_flag.png"></a>
				</div>
					</div>
					</div>
					
					<aside class="nav-contact is-hidden-mobile">
						<p><a href="mailto:info@patriciomartin.com">info@patriciomartin.com</a></p>
						<p><a href="tel:+34952584444">+34 952 58 44 44</a></p>
					</aside>
					

					
					
					
				</div>
			</nav>
		</div>
	</div>
</div>
 
 </fmt:bundle>