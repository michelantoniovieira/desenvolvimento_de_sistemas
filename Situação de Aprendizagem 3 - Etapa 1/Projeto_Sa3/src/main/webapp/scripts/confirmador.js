/**
 * 
 */

 function confirmar(matricula)
 {
	 let resposta = confirm("Confirmar exclusão do contato?")
	 if(resposta===true)
	 {
		 //alert(matricula)
		 window.location.href = "delete?matricula=" + matricula
	 }
 }