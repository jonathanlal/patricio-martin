package com.patriciomartin.models;

//FIRST FIELD NEEDS TO BE UNIQUE!!!!!! EVEN FOR LANGUAGES



public class Mappings {
	public static String[] 
	URL_INDEX_EN = {"/","index.jsp", "en"},
	URL_INDEX_ES = {"/inicio/","index.jsp", "es"},
	URL_ABOUT_EN = {"/about/","about.jsp", "en"},
	URL_ABOUT_ES = {"/nosotros/","about.jsp", "es"},
	URL_SERVICES_EN = {"/services/","services.jsp", "en"},
	URL_SERVICES_ES = {"/servicios/","services.jsp", "es"},
	URL_CONTACT_EN = {"/contact/","contact.jsp", "en"},
	URL_CONTACT_ES = {"/contacto/","contact.jsp", "es"},
	URL_PROJECTS_EN = {"/projects/","projects.jsp", "en"},
	URL_PROJECTS_ES = {"/projectos/","projects.jsp", "es"},
	URL_PROJECTS_LACALA_EN = {"/projects/la-cala/","project.jsp?p=la-cala", "en"},
	URL_PROJECTS_SANELISEO_EN = {"/projects/san-eliseo/","project.jsp?p=san-eliseo", "en"},
	URL_PROJECTS_DOMUS_EN = {"/projects/domus/","project.jsp?p=domus", "en"},
	URL_PROJECTS_RANCHO_EN = {"/projects/rancho/","project.jsp?p=rancho", "en"},
	URL_PROJECTS_LACALA_ES = {"/projectos/la-cala/","project.jsp?p=la-cala", "es"},
	URL_PROJECTS_SANELISEO_ES = {"/projectos/san-eliseo/","project.jsp?p=san-eliseo", "es"},
	URL_PROJECTS_DOMUS_ES = {"/projectos/domus/","project.jsp?p=domus", "es"},
	URL_PROJECTS_RANCHO_ES = {"/projectos/rancho/","project.jsp?p=rancho", "es"},
	URL_TEST_ES = {"/test.jsp","test.jsp", "en"}, 
	URL_THANKYOU_ES = {"/gracias/","thanks.jsp", "es"}, 
	URL_THANKYOU_EN = {"/thank-you/","thanks.jsp", "en"}, 
	GOOGLE_ADMIN_WILDCARD_EN = {"/_ah/","*", "*"}, //this doesnt work on production...
	WD_ADMIN_WILDCARD_EN = {"/wd-admin/","*", "*"};
	
	
}
