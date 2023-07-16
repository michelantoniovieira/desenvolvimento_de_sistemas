/**
 * 
 */

function validar() {
	//alert('teste')

	let nome = frmCliente.nome.value
	let endereco = frmCliente.endereco.value
	let modalidade = frmCliente.modalidade.value

	if (nome === "") {
		alert('preencha o campo nome')
		frmCliente.nome.focus()
		return false
	}

	else if (endereco === "") {
		alert('preencha o campo endereco')
		frmCliente.endereco.focus()
		return false
	}

	else if (modalidade === "") {
		alert('preencha o campo modalidade')
		frmCliente.modalidade.focus()
		return false
	}

	else {
		document.forms["frmCliente"].submit()
	}

}