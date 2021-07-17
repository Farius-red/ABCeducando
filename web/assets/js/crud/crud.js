  function crud(c) {

    document.getElementById('metodo').value = c;
    let formulario = document.getElementById('crudForm');
    if (document.getElementById('metodo').value === '') {
        alert('el value del input esta vacio');
    } else {
        
        formulario.submit();
    }

}   