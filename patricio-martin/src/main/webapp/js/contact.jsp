<input class="input_field_init" id="fnametxt" type="hidden" value="<fmt:message key="contact.form.name"/>"/>
<input class="input_field_init" id="femailtxt" type="hidden" value="<fmt:message key="contact.form.email"/>"/>
<input class="input_field_init" id="fphonetxt" type="hidden" value="<fmt:message key="contact.form.phone"/>"/>
<input class="input_field_init" id="fmessagetxt" type="hidden" value="<fmt:message key="contact.form.message"/>"/>
<input class="input_field_init" id="fmsgSenttxt" type="hidden" value="<fmt:message key="contact.form.success"/>"/>

<input class="input_field_init" id="fbtntxt" type="hidden" value="<fmt:message key="contact.form.send"/>">

<input class="input_field_init" id="fnametxt-placeholdererror" type="hidden" value="<fmt:message key="contact.form.name.error"/>">
<input class="input_field_init" id="femailtxt-placeholdererror" type="hidden" value="<fmt:message key="contact.form.email.error"/>">

<style>
.errorInput::-webkit-input-placeholder {
    color: red !important;
}
</style>



<script>
//get all init fields and put their placeholders
window.onload = function(){
	var x = document.getElementsByClassName("input_field_init");
	for (var i = 0; i < x.length; i++) {
		var input_id = x[i].id;
		var input_value = x[i].value;
		if(!input_id.includes("placeholdererror" && !input_id.includes('fbtn') && !input_id.includes('fmsgSenttxt'))){
			document.getElementById(input_id.substring(0, input_id.length - 3)).placeholder=getTextFromNode(input_id);	
		}
		if(input_id.includes('fbtn') || input_id.includes('fmsgSent')){
			document.getElementById(input_id.substring(0, input_id.length - 3)).innerHTML = document.getElementById(input_id).value;	
		}
	}
}

document.getElementById("fbtn").onclick = function() {
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
function resetErrorInput(elementID){
	changePlaceHolderTextByElementID(elementID, elementID+"txt");
    document.getElementById(elementID).classList.remove("errorInput");
}
function changePlaceHolderTextByElementID(elementID, elementIDPlaceholder){
	document.getElementById(elementID).placeholder=getTextFromNode(elementIDPlaceholder);
}
function getTextFromNode(elementID){
	var text = document.getElementById(elementID).value;
	return text;
}
function errorInput(elementID){
	 var element = document.getElementById(elementID);
	 element.placeholder = getValidationText(elementID);
	 element.className += " errorInput";
	 window.setTimeout(function(){
		 resetErrorInput(elementID);
	 }, 3000);
}
function getValidationText(elementID){
	return document.getElementById(elementID+"txt-placeholdererror").value;
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
	n.open("POST","../../../../ContactServlet",!0),
	n.setRequestHeader("Content-type","application/x-www-form-urlencoded"),
	n.onreadystatechange=function(){
		  if (n.readyState == 4) {
			  document.getElementById("emailsent").style.display = "block";
			  document.getElementById("emailcontainer").style.display = "none";
	        }
	},n.send(e)
}

</script>