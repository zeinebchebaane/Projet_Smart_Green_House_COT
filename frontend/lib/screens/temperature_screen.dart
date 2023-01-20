
import 'package:flutter/material.dart';
import 'dart:async';
import 'dart:math' as math;
import 'package:get/get.dart';
import 'package:fl_chart/fl_chart.dart';
import 'package:syncfusion_flutter_charts/charts.dart';

class TemperatureScreen extends StatefulWidget {

  const TemperatureScreen({Key? key}) : super(key: key);

  @override
  State<TemperatureScreen> createState() => _TemperatureScreenState();
}

class _TemperatureScreenState extends State<TemperatureScreen> {
  late List<LiveData> chartData;
  late ChartSeriesController _chartSeriesController;
  @override

  void initState() {
   Text (
                      'Temperature_Chart',
                      style: TextStyle(
                        color: Color.fromARGB(143, 76, 175, 79),
                        fontSize: 14,
                        fontWeight: FontWeight.bold,
                      ),
                    );
    chartData = getChartData();
    Timer.periodic(const Duration(seconds: 1), updateDataSource);
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return SafeArea(
        child: Scaffold(
            body: SfCartesianChart(
              
                series: <LineSeries<LiveData, int>>[
          LineSeries<LiveData, int>(
            onRendererCreated: (ChartSeriesController controller) {
              _chartSeriesController = controller;
            },
            dataSource: chartData,
            color: Color.fromARGB(255, 224, 9, 9),
            xValueMapper: (LiveData sales, _) => sales.time,
            yValueMapper: (LiveData sales, _) => sales.speed,
          )
        ],
                primaryXAxis: NumericAxis(
                    majorGridLines: const MajorGridLines(width: 0),
                    edgeLabelPlacement: EdgeLabelPlacement.shift,
                    interval: 3,
                    title: AxisTitle(text: 'Time (seconds)')),
                primaryYAxis: NumericAxis(
                    axisLine: const AxisLine(width: 0),
                    majorTickLines: const MajorTickLines(size: 0),
                    title: AxisTitle(text: 'Temperature (°C)')))));
  }

  int time = 19;
  void updateDataSource(Timer timer) {
    chartData.add(LiveData(time++, (math.Random().nextInt(60) + 30)));
    chartData.removeAt(0);
    _chartSeriesController.updateDataSource(
        addedDataIndex: chartData.length - 1, removedDataIndex: 0);
  }

  List<LiveData> getChartData() {
    return <LiveData>[
      LiveData(0, 42),
      LiveData(1, 47),
      LiveData(2, 43),
      LiveData(3, 49),
      LiveData(4, 54),
      LiveData(5, 41),
      LiveData(6, 58),
      LiveData(7, 51),
      LiveData(8, 98),
      LiveData(9, 41),
      LiveData(10, 53),
      LiveData(11, 72),
      LiveData(12, 86),
      LiveData(13, 52),
      LiveData(14, 94),
      LiveData(15, 92),
      LiveData(16, 86),
      LiveData(17, 72),
      LiveData(18, 94)
    ];
  }
}

class LiveData {
  LiveData(this.time, this.speed);
  final int time;
  final num speed;
}

//   final Color sinColor = Colors.redAccent;
//   final Color cosColor = Colors.blueAccent;

//   final limitCount = 100;
//   final sinPoints = <FlSpot>[];
//   final cosPoints = <FlSpot>[];

//   double xValue = 0;
//   double step = 0.05;

//   // late Timer timer;
  
//   @override
//   void initState() {
//     super.initState();
//     for(int i=0; i < 100; i++){
//       sinPoints.add(FlSpot(i*step, math.sin(i*step)));
//       cosPoints.add(FlSpot(i*step, math.cos(i*step)));
//     }
//   }

//   @override
//   Widget build(BuildContext context) {
//     // This method is rerun every time setState is called, for instance as done
//     // by the _incrementCounter method above.
//     //
//     // The Flutter framework has been optimized to make rerunning build methods
//     // fast, so that you can just rebuild anything that needs updating rather
//     // than having to individually change instances of widgets.
//     return Scaffold(
//       body: Center(
//         // Center is a layout widget. It takes a single child and positions it
//         // in the middle of the parent.
//         child: cosPoints.isNotEmpty
//         ? SizedBox(
//           width: 300,
//           height: 300,
//           child: LineChart(
//             LineChartData(
//               minY: -1,
//               maxY: 1,
//               minX: sinPoints.first.x,
//               maxX: sinPoints.last.x,
//               lineTouchData: LineTouchData(enabled: false),
//               clipData: FlClipData.all(),
//               gridData: FlGridData(
//                 show: true,
//                 drawVerticalLine: false,
//               ),
//               lineBarsData: [
//                 sinLine(sinPoints),
//                 cosLine(cosPoints),
//               ],
//               titlesData: FlTitlesData(
//                 show: false,
//               ),
//             ),
//           ),
//         ): Container(),
//       ),
//     );
//   }

//   LineChartBarData sinLine(List<FlSpot> points) {
//     return LineChartBarData(
//       spots: points,
//       dotData: FlDotData(
//         show: false,
//       ),
//       // gradient: LinearGradient(
//       //   colors: [sinColor.withOpacity(0), sinColor],
//       //   stops: const [0.1, 1.0],
//       // ),
//       barWidth: 4,
//       isCurved: false,
//     );
//   }

//   LineChartBarData cosLine(List<FlSpot> points) {
//     return LineChartBarData(
//       spots: points,
//       dotData: FlDotData(
//         show: false,
//       ),
//       // gradient: LinearGradient(
//       //   colors: [sinColor.withOpacity(0), sinColor],
//       //   stops: const [0.1, 1.0],
//       // ),
//       barWidth: 4,
//       isCurved: false,
//     );
//   }

//   // @override
//   // void dispose() {
//   //   timer.cancel();
//   //   super.dispose();
//   // }
// }




