import 'package:flutter/material.dart';

void mian() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: '동포',
      theme: ThemeData(primarySwatch: Colors.orange),
      home: const DongPoo(),
    );
  }
}

class DongPoo extends StatelessWidget {
  const DongPoo({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('동포'),
        centerTitle: true,
        elevation: 0.0,
        leading: IconButton(
            onPressed: () {
              //눌렀을때 행동
            },
            icon: const Icon(Icons.heart_broken)),
        actions: [
          IconButton(
              onPressed: () {
                print('hello');
              },
              icon: const Icon(Icons.abc_outlined)),
          IconButton(
              onPressed: () => 'helloWorld', icon: const Icon(Icons.alarm))
        ],
      ),
    );
  }
}
/*
import 'package:flutter/material.dart';

void main(){ 
  return runApp(MyAP());
}
class MyAP extends StatelessWidget {
  const MyAP({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'APPBAR',
      theme: ThemeData(
        primarySwatch: Colors.amber
      ),
      home: MyPage(),
    );
  }
}

class MyPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('동포'),
        centerTitle: true,
        elevation: 0.0,
        leading: IconButton(onPressed:() {
          print('menu button is clicked');        
          }, icon: Icon(Icons.menu)),
          actions: [
            IconButton(onPressed:() {
          print('안녕하살법');        
          }, icon: Icon(Icons.shopping_cart)),
          IconButton(onPressed:() {
          print('안녕하살법 받아치기');        
          }, icon: Icon(Icons.search_sharp)),
          ],
      ),
    );
  }
}
*/