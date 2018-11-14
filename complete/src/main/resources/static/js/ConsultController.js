var ConsultControllerModule = (function () {
    var showInfo = function(){
         
        var identifier =document.getElementById('identificador').value;
        var hist = document.getElementById('id').options[document.getElementById('id').selectedIndex].text;
        
        var callback = {
            
            onSuccess: function(response){
                $("table").empty();
                var lista="";
                for (x in response){
                    if (x.includes("Series")){
                        lista = response[x];
                    }
                }
                if (lista==""){
                    lista=response;
                }
                var primero=0;
                var tabla = document.getElementById('myTable');
                for (property in lista){
                    var obj= lista[property];
                    console.log(property);
                    if (primero==0){
                        var encabezado = document.createElement('tr');
                        var no= document.createElement('td');
                        no.appendChild(document.createTextNode("No"));
                        encabezado.appendChild(no);
                        for (nombre in obj){
                            var propiedad= document.createElement('td');
                            propiedad.appendChild(document.createTextNode(nombre));
                            encabezado.appendChild(propiedad);
                        }
                        primero=1;
                        tabla.appendChild(encabezado);
                    }
                    var tr = document.createElement('tr');
                    var num= document.createElement('td');
                    num.appendChild(document.createTextNode(property));
                    tr.appendChild(num);
                    for (x in obj){
                        var td= document.createElement('td');
                        td.appendChild(document.createTextNode(obj[x]));
                        tr.appendChild(td);
                    }
                    tabla.appendChild(tr);
                }
            },
            onFailed: function(exception){
                console.log(exception);
                alert("There is a problem with our servers. We apologize for the inconvince, please try again later");  
            }
         };
        RestControllerModule.getInfo(identifier,hist,callback);

    };
   
  

  return {
    showInfo: showInfo
  };
})();

