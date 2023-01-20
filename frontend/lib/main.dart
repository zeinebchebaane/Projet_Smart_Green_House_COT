import 'package:flutter/material.dart';
import 'package:flutter_auth_ui/screens/screens.dart';
import 'package:flutter_auth_ui/screens/humidity_screen.dart';
import 'package:http/http.dart' as http;

void main() {
runApp(
  MaterialApp(
    debugShowCheckedModeBanner: false,
    home: WelcomePage(),
    )
);
 }
 class WelcomePage extends StatefulWidget {
  @override
  State<WelcomePage> createState() => _WelcomePageState();
}
class _WelcomePageState extends State<WelcomePage> {
  @override 
  Widget build(BuildContext context){
    return Scaffold(
      body: Container(
        child: Stack(children: [
          Positioned.fill(child: Image.asset('assets/images/welcome.PNG',
          fit: BoxFit.cover),
          ),
          Center(
            child: Column
            (
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Container(
                  width: 130,
                  height: 130,
                  alignment: Alignment.center,
                  child: Image.asset('assets/images/logo.PNG',
                ) ,
                ),
              SizedBox(height: 20,),              
              Text("Let's plant with us",
              textAlign: TextAlign.center,
              style: TextStyle(color: Colors.white,
              fontSize: 25,
              fontWeight: FontWeight.w300)),
              SizedBox(height: 20,),              
              Text('Smart Green House',
              textAlign: TextAlign.center,
              style: TextStyle(color: Colors.white,
              fontSize: 17,
              fontWeight: FontWeight.bold),),
              SizedBox(height: 30),             
               new SizedBox(
                height: 50,
                width: 230,
              child: ElevatedButton(
            child: Text('Sign In'),
            style: ElevatedButton.styleFrom(
              primary: Color.fromARGB(255, 9, 124, 113),
              onPrimary: Colors.white,
              onSurface: Colors.grey,
              shadowColor: Colors.grey,
              elevation: 5,
              textStyle: TextStyle(
              color: Colors.white,
                fontSize: 15,
                fontWeight: FontWeight.bold
            ),
          shape: RoundedRectangleBorder( borderRadius: BorderRadius.circular(30),
                                  )),
              onPressed: () {
                Navigator.push (
                  context,
                  MaterialPageRoute(builder: (context) => const LoginScreen()));
              },
            ),
           
                        ),
                         SizedBox(height: 20),
                        new SizedBox(
                height: 50,
                width: 230,
              child: ElevatedButton(
            child: Text('Register'),
            style: ElevatedButton.styleFrom(
              primary: Color.fromARGB(255, 9, 124, 113),
              onPrimary: Colors.white,
              onSurface: Colors.grey,
              shadowColor: Colors.grey,
              elevation: 5,
              textStyle: TextStyle(
              color: Colors.white,
                fontSize: 15,
                fontWeight: FontWeight.bold
            ),
          shape: RoundedRectangleBorder( borderRadius: BorderRadius.circular(30),
                                  )),
              onPressed: () {
                   Navigator.push (
                  context,
                  MaterialPageRoute(builder: (context) => const SignUpScreen()));;
              },
            ),
                        ),]
     
             ),
          )
        ],),
        ));
             
             
           
     
   }
}
