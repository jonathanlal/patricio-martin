<input id="fnametxt" type="hidden" value="<fmt:message key="contact.form.name"/>"/>
<input id="femailtxt" type="hidden" value="<fmt:message key="contact.form.email"/>"/>
<input id="fphonetxt" type="hidden" value="<fmt:message key="contact.form.phone"/>"/>
<input id="fmessagetxt" type="hidden" value="<fmt:message key="contact.form.message"/>"/>

<script>
//MULTILINGUAL SITES (in order for java code to be able to run here we need to put this in a .jsp file...)	
var language = '<%=session.getAttribute("language")%>'; 
function getValidationText(elementID){
	if(language.indexOf('null')>=0 || language.indexOf('en')>=0){
		if(elementID.indexOf('fname')>=0){return "*Type in your name.";}
		if(elementID.indexOf('femail')>=0){return "*Type in your email.";}
	}
	if(language.indexOf('es')>=0){
		if(elementID.indexOf('fname')>=0){return "*Escribe tu nombre.";}
		if(elementID.indexOf('femail')>=0){return "*Ingrese su correo electrónico.";}
	}
}
document.getElementById("btnContactSubmit").onclick = function() {
	if(validateForm()){submitContact()}
};
function validateForm() {
	var check = false;
	var e=document.getElementById("femail").value,n=/^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
	if(!e.match(n)){
		errorInput("femail");
	}else{check=true;}
	if(document.getElementById("fname").value == '' || document.getElementById("fname").value.length == 0){
		errorInput("fname");
		check=false;
	}else{check=true;}
	return check;
}
function resetErrorInput(){
	changePlaceHolderTextByElementID("fname");
    var name = document.getElementById("fname");
    name.classList.remove("errorInput");
    changePlaceHolderTextByElementID("femail");
    var email = document.getElementById("femail");
    email.classList.remove("errorInput");
}
function changePlaceHolderTextByElementID(elementID){
	document.getElementById(elementID).placeholder=getTextFromNode(elementID+'txt');
}
function getTextFromNode(elementID){
	var node = document.getElementById(elementID);
	return node.textContent || node.innerText;
}
function errorInput(elementID){
	 var element = document.getElementById(elementID);
	 element.placeholder=getValidationText(elementID);
	 element.className += " errorInput";
	 window.setTimeout(resetErrorInput, 3000);
}
function submitContact(){
	var fmessage = document.getElementById('fmessage').value;
	var fname = document.getElementById('fname').value;
	var femail = document.getElementById('femail').value;
	var fphone = document.getElementById('fphone').value;
// 	var hearfrominput = document.getElementById("hearfrom");
// 	var hearfrom = hearfrominput.options[hearfrominput.selectedIndex].value;
  document.getElementById("emailsent").style.display = "block";
  document.getElementById("emailcontainer").style.display = "none";
	var e = "name="+fname+"&email="+femail+"&msg="+fmessage+"&phone="+fphone;//+"&hearfrom="+hearfrom;
	var n=new XMLHttpRequest();
	n.open("POST","../../../ContactServlet",!0),
	n.setRequestHeader("Content-type","application/x-www-form-urlencoded"),
	n.onreadystatechange=function(){
		  if (n.readyState == 4) {
			  document.getElementById("emailsent").style.display = "block";
			  document.getElementById("emailcontainer").style.display = "none";
	        }
	},n.send(e)
}

</script>