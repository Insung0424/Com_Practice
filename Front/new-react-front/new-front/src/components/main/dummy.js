// import React from 'react';

// import Chart from '../Chart/Chart';

// const ExpensesChart = (props) => {
//   const chartDataPoints = [
//     { label: 'Jan', value: 0 },
//     { label: 'Feb', value: 0 },
//     { label: 'Mar', value: 0 }, 
//     { label: 'Apr', value: 0 },
//     { label: 'May', value: 0 },
//     { label: 'Jun', value: 0 },
//     { label: 'Jul', value: 0 },
//     { label: 'Aug', value: 0 },
//     { label: 'Sep', value: 0 },
//     { label: 'Oct', value: 0 },
//     { label: 'Nov', value: 0 },
//     { label: 'Dec', value: 0 },
//   ];

//   for (const expense of props.expenses) {
//     const expenseMonth = expense.date.getMonth(); // starting at 0 => January => 0
//     chartDataPoints[expenseMonth].value += expense.amount;
//   }

//   return <Chart dataPoints={chartDataPoints} />;
// };

// export default ExpensesChart;

// =============================================================================================================

// import React from "react";
// import "./Chart.css";
// import ChartBar from "./ChartBar";

// const Chart = (props) => {
//   const valueArray = props.dataPoints.map((dataPoint) => dataPoint.value);
//   const totalMaximum = Math.max(...valueArray);

//   return (
//     <div className="chart">
//       {props.dataPoints.map((dataPoint) => (
//         <ChartBar
//           value={dataPoint.value}
//           maxValue={totalMaximum}
//           label={dataPoint.label}
//           key={dataPoint.label}
//         />
//       ))}
//     </div>
//   );
// };

// export default Chart;

// =============================================================================================================

// import React from "react";
// import "./ChartBar.css";

// const ChartBar = (props) => {
//   let barFillHeight = "0%";

//   if (props.maxValue > 0) {
//     barFillHeight = Math.round((props.value / props.maxValue) * 100) + "%";
//   }

//   return (
//     <div className="chart-bar">
//       <div className="chart-bar__inner">
//         <div
//           className="chart-bar__fill"
//           style={{ height: barFillHeight }}
//         ></div>
//       </div>
//       <div className="chart-bar__label">{props.label}</div>
//     </div>
//   );
// };

// export default ChartBar;