
class BaseApi{

  
var authPath = "http://127.0.0.1:8080/smartgreenhouse-1.0-SNAPSHOT/api/oauth2/token/";
var registerPath="http://127.0.0.1:8080/smartgreenhouse-1.0-SNAPSHOT/api/signup" ;
var valueStreamPath="" ;

// more routes
Map<String,String> headers = {
  "Content-Type": "application/json; charset=UTF-8" };


  Map<String,String> headersAuth = {
    "Content-Type": "application/x-www-form-urlencoded"  };

  Map<String,String> createProtectedHeader(String accestoken){

    var headersProtected = {
      "Authorization":"Bearer $accestoken"
    };
    return  headersProtected ;


  }

}
