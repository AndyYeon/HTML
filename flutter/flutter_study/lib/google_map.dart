import 'package:flutter/material.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';

class HomeScreen extends StatelessWidget {
  static const LatLng companyLatLng = LatLng(
    37.5324234, //위도
    126.921252, //경도
  );

  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return const Scaffold(
        body: GoogleMap(
            initialCameraPosition: CameraPosition(
      target: companyLatLng,
      zoom: 16, //확대 정도
    )));
  }
}

AppBar renderAppBar() {
  return AppBar(
    centerTitle: true,
    title: const Text(
      '구글맵 테스트',
      style: TextStyle(
        color: Colors.green,
        fontWeight: FontWeight.w700,
      ),
    ),
    backgroundColor: Colors.white,
  );
}
