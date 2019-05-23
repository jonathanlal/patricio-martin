<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:bundle basename = "text">

<div id="navbar" class="nav navbar" style="background-color: transparent;z-index: 1001;">
	<div class="i-gradient">
		<div class="container">
			<nav class="nav-content">
				<!-- LOGO -->
				<a class="nav-brand" href="../../"><img src="../../img/logo/navbar.png" alt="Patricio Martin"></a>
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
					<a href="../../ChangeLanguage?lang=es" class="wpml-ls-link"><span class="wpml-ls-native">Spanish</span></a>
					<li class="wpml-ls-slot-shortcode_actions wpml-ls-item wpml-ls-item-en wpml-ls-last-item wpml-ls-item-legacy-list-horizontal ${language eq 'en' || empty language ? 'wpml-ls-current-language' : ''}">
					<a href="../../ChangeLanguage?lang=en" class="wpml-ls-link"><span class="wpml-ls-native">English</span><span class="wpml-ls-display"><span class="wpml-ls-bracket"> (</span>Anglais<span class="wpml-ls-bracket">)</span></span></a>
					</li>
					</ul>
				</div>
				<!-- MAIN LINKS -->
				<div class="navbar-menu" id="navMenu">
					<div class="nav-list">
						<div class="nav-item is-home"><a href="<fmt:message key="url.about"/>"><fmt:message key="nav.about"/></a></div>
						<div class="nav-item is-properties"><a href="<fmt:message key="url.projects"/>"><fmt:message key="nav.projects"/></a></div>
						<div class="nav-item is-regions"><a href="<fmt:message key="url.services"/>"><fmt:message key="nav.services"/></a></div>
						<div class="nav-item is-contact"><a href="<fmt:message key="url.services"/>"><fmt:message key="nav.services"/></a></div>
					</div>
					<aside class="nav-contact">
						<p><a class="open-modal" data-target="contactModal">info@patriciomartin.com</a></p>
						<p><a href="tel:+34952584444">+34 952 58 44 44</a></p>
					</aside>
				</div>
			</nav>
		</div>
	</div>
</div>
 
 </fmt:bundle>