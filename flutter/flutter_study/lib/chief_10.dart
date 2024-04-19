import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'MY LOVE SOOYOUNG',
      home: LotSo(),
    );
  }
}

class LotSo extends StatelessWidget {
  const LotSo({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.pink[100],
      appBar: AppBar(
        title: Text('LotSoYoung'),
        backgroundColor: Colors.pink[300],
        centerTitle: true,
        elevation: 0.0,
      ),
      body: const Padding(
        padding:EdgeInsets.fromLTRB(30.0, 40.0, 0.0, 0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start, // 가로 시작점 정렬하기 
          children: [
            Center(
              child: CircleAvatar(backgroundImage: AssetImage('assets/lotso_02.png'),
              radius: 60,
              ),
            ),
            Divider(  // 선 likes <br/>
              height: 60.0,
              color: Colors.grey,
              thickness:0.5, //두께 지정
              endIndent:30.0, //끝에서부터 어느정도 떨어질지  
            ),
            Text('cute lovely soyoung',
            style: TextStyle(
              color: Colors.white,
              letterSpacing: 2.0,
            ),
            ),
            SizedBox(
              height: 10.0,
            ),
            Text('사랑스러운 소영',
            style: TextStyle(
              color: Colors.white,
              letterSpacing: 2.0,
              fontSize: 28.0,
              fontWeight: FontWeight.bold
            ),
            ),
            SizedBox(
              height: 30,
            ),
            Text('귀요미 소영',
            style: TextStyle(
              color: Colors.white,
              letterSpacing: 2.0,
            ),
            ),
            SizedBox(
              height: 10.0,
            ),
            Text('이뿐 소영',
            style: TextStyle(
              color: Colors.white,
              letterSpacing: 2.0,
              fontSize: 28.0,
              fontWeight: FontWeight.bold
            ),
            ),
            Row(
              children: [
                CircleAvatar(backgroundImage:AssetImage('assets/lotso_01.png'),), //플러터가 제공하는 멋진 위젯
                Icon(Icons.favorite,
                color: Colors.pink,
                ),
                Text('귀엽고',
                style: TextStyle(
                  fontSize: 15
                ),
                ),
                SizedBox(
                  width: 20.0,
                ),
                Icon(Icons.favorite,
                color: Colors.pink,),
                Text('사랑스럽고',
                style: TextStyle(
                  fontSize: 15
                ),
                ),
                SizedBox(
                  width: 20.0,
                ),
              ],
            ),
            Row(
              children: [
                CircleAvatar(backgroundImage: AssetImage('assets/lotso_02.png'),
                ),
                Icon(Icons.favorite,
                color: Colors.pink,),
                
                Text('깜찍한 소영이',style: TextStyle(
                  fontSize: 15
                )
                ),
              ],
            ),        
          ],
        ),
        ),
    );
  }
}