function cargarArchivo(elemento) {
    var file = elemento.files[0];
    var objHidden = document.formularioCargaMatricula.nombreArchivo;
    objHidden.value = file.name;

    document.formularioCargaMatricula.target = "null";
    document.formularioCargaMatricula.action = "Usuario";
    document.formularioCargaMatricula.submit();
}