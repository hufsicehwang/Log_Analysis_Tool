// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

let labels = document.querySelectorAll('.label');
let labelArr = new Array();
for (let i = 0; i < labels.length; i++) {
    labelArr.push(labels[i].innerText);
}

let data = document.querySelectorAll('.count');
let dataArr = new Array();
for (let i = 0; i < data.length; i++) {
    dataArr.push(data[i].innerText);
}

// Pie Chart Example
let ctx = document.getElementById("myPieChart");
let myPieChart = new Chart(ctx, {
    plugins: [ChartDataLabels],
    type: 'pie',
    data: {
        labels: labelArr,
        datasets: [{
            data: dataArr,
            backgroundColor: ['#4e73df', '#1cc88a'],
            hoverBackgroundColor: ['#2e59d9', '#17a673']
        }],
    },
    options: {
        responsive: true,
        maintainAspectRatio: false,
        legend: {
            position: 'right',
            labels: {
                padding: 20,
                boxWidth: 10
            }
        },
        plugins: {
            datalabels: {
                formatter: (value, ctx) => {
                    let sum = 0;
                    let dataArr = ctx.chart.data.datasets[0].data;
                    dataArr.map(data => {
                        sum += Number(data);
                    });
                    let percentage = (value * 100 / sum).toFixed(2) + "%";
                    return percentage;
                },
                color: 'white',
                labels: {
                    title: {
                        font: {
                            size: '16'
                        }
                    }
                }
            }
        }
    }
});
