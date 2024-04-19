import 'package:flutter/material.dart';

void main() => runApp(Class());

class Class extends StatelessWidget {
  const Class({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: '동포',
      theme: ThemeData(
        primarySwatch: Colors.blue
      ),
      home: MyHome(),
    );
  }
}

class MyHome extends StatelessWidget {
  const MyHome({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('data'), // 타이틀
        centerTitle: true, // 텍스트 센터
        backgroundColor: Colors.redAccent, //백그라운드
        elevation: 0.0, //높이
      ),
      body: Padding(
        padding:EdgeInsets.fromLTRB(30.0, 40.0, 0.0, 0.0), //Left Top Right Bottom
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center, //가로축 세로축에 축 
            children: [
              Text('data'),Text('hello'),Text('world'),
            ],
          ),
        ),
      ),
    );
  }
}