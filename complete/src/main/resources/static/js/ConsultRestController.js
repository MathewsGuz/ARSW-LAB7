var RestControllerModule = (function () {
  
  var getInfo = function (identifier,hist,callback) {
    axios.get('/info/'+hist+"/"+identifier)
            .then(function(info){
                callback.onSuccess(info.data);
                console.log(info);
            })
            .catch(function(error){
                callback.onFailed(error);
                console.log(error);
            });
  };
  
  

  return {
    getInfo: getInfo
  };
  
  

})();