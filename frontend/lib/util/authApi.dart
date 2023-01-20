import 'dart:convert';
import 'dart:io' ;
import 'package:flutter_auth_ui/models/user.dart';
import 'package:http/http.dart' as http;
import 'dart:convert' as convert;


import 'baseapi.dart';


class AuthAPI extends BaseApi {


  Future signUp(String email, String username, String password ) async {
    var body = jsonEncode({
        'email': email,
        'username': username,
        'password': password,
        'roles': ['ADMIN']

    });
       var   response = await http.post(Uri.parse(super.registerPath), headers: super.headers, body: body);
        return response ;
        }


  Future<http.Response> login(String email, String password) async {
    var body = jsonEncode({'grandType':'PASSWORD','email': email, 'password': password});
    http.Response response = await http.post(Uri.parse(super.authPath), headers: super.headers, body: body) ;

    return response;

  }



  Future<http.Response> refreshToken(String refreshToken) async {
    var body = jsonEncode({'grandType':'REFRESH_TOKEN','refreshToken': refreshToken});
    http.Response response =
    await http.post(Uri.parse(super.authPath), headers: super.headers, body: body );
    return response;
  }
}



