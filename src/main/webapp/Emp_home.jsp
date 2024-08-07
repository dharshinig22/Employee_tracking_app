<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Task Duration Pie Chart</title>
<style>
    body {
        background-image: url('img/emp8.jpg'); 
        background-size: cover;
        font-family: Arial, sans-serif;
        background-color: #f8f9fa;
        margin: 0;
        padding: 20px;
    }

    .header {
        background-color: #343a40;
        color: #ffffff;
        padding: 10px;
        text-align: center;
    }

    .operation {
        text-align: center;
        margin: 20px 0;
    }

    .operation a {
        color: #007bff;
        margin: 0 10px;
        text-decoration: none;
    }

    .chart-container {
        width: 40%;
        margin: auto;
        text-align: center;
    }

    #totalDuration {
        text-align: center;
        margin-top: 20px;
    }
</style>
</head>
<body>
<div class="header">
    <% String employee_name = (String) session.getAttribute("emp_name");
    if(employee_name != null) {
        out.println("<h2>Welcome, " + employee_name + "</h2>");
    } else {
        out.println("Username not found");
    }
    %>
</div>
<div class="operation">
    <a href="add-task.jsp">Add Task</a>
    <a href="edit-task.jsp">Edit Task</a>
    <a href="delete-task.jsp">Delete Task</a>
</div>

<div class="chart-container">
    <canvas id="taskPieChart" width="100" height="100"></canvas>
</div>
<div class="chart-container">
    <canvas id="taskBarChart" width="100" height="100"></canvas>
</div>
<div id="totalDuration"></div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
    document.addEventListener("DOMContentLoaded", function() {
        fetch('GetTaskData')
            .then(response => response.json())
            .then(data => {
                console.log(data);
                if (data.error) {
                    console.error(data.error);
                    return;
                }

                const totalDurationInSeconds = Object.values(data).reduce((acc, curr) => acc + curr, 0);
                const totalDurationInHours = totalDurationInSeconds / 3600;
                document.getElementById('totalDuration').innerText = 'Total Duration: ' + totalDurationInHours.toFixed(2) + ' hours';

                const ctx = document.getElementById('taskPieChart').getContext('2d');
                const chartData = {
                    labels: Object.keys(data),
                    datasets: [{
                        data: Object.values(data).map(d => d / 3600),
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.2)',  
                            'rgba(54, 162, 235, 0.2)',  
                            'rgba(255, 206, 86, 0.2)',  
                            'rgba(75, 192, 192, 0.2)',  
                            'rgba(153, 102, 255, 0.2)',
                            'rgba(255, 159, 64, 0.2)',  
                            'rgba(201, 203, 207, 0.2)'  
                        ],
                        borderColor: [
                            'rgba(255, 99, 132, 1)',
                            'rgba(54, 162, 235, 1)',
                            'rgba(255, 206, 86, 1)',
                            'rgba(75, 192, 192, 1)',
                            'rgba(153, 102, 255, 1)',
                            'rgba(255, 159, 64, 1)',
                            'rgba(201, 203, 207, 1)'
                        ],
                        borderWidth: 1
                    }]
                };
                const config = {
                    type: 'pie',
                    data: chartData,
                    options: {
                        responsive: true,
                        plugins: {
                            legend: {
                                position: 'top',
                            },
                            title: {
                                display: true,
                                text: 'Your Total Progress'
                            },
                            tooltip: {
                                callbacks: {
                                    label: function(tooltipItem) {
                                        const value = tooltipItem.raw;
                                        return value.toFixed(2) + ' hours';
                                    }
                                }
                            }
                        }
                    },
                };

                new Chart(ctx, config);
            })
            .catch(error => console.error('Error fetching task data:', error));
        
        fetch('get5data')
        .then(response => response.json())
        .then(data => {
            console.log(data);
            if (data.error) {
                console.error('Error fetching bar data:', data.error);
                return;
            }

            const sortedData = Object.entries(data).sort((a, b) => new Date(a[0]) - new Date(b[0]));

            const ctxBar = document.getElementById('taskBarChart').getContext('2d');
            const chartDataBar = {
                labels: sortedData.map(entry => entry[0]), 
                datasets: [{
                    label: 'Hours worked per day (last 5 days)',
                    data: sortedData.map(entry => entry[1] / 3600), 
                    backgroundColor: 'rgba(54, 162, 235, 0.2)',
                    borderColor: 'rgba(54, 162, 235, 1)',
                    borderWidth: 1
                }]
            };

            const configBar = {
                type: 'bar',
                data: chartDataBar,
                options: {
                    responsive: true,
                    scales: {
                        y: {
                            beginAtZero: true,
                            title: {
                                display: true,
                                text: 'Hours'
                            }
                        }
                    },
                    plugins: {
                        legend: {
                            display: false
                        },
                        title: {
                            display: true,
                            text: 'Hours worked per day (Bar Chart)'
                        },
                        tooltip: {
                            callbacks: {
                                label: function(tooltipItem) {
                                    const value = tooltipItem.raw;
                                    return value.toFixed(2) + ' hours';
                                }
                            }
                        }
                    }
                }
            };

            new Chart(ctxBar, configBar);
        })
        .catch(error => console.error('Error fetching bar data:', error));
        
    });
</script>
</body>
</html>
