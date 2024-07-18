<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add a new Task</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: url('img/emp9.jpg') no-repeat center center fixed;
            background-size: cover;
            color: #333;
            padding: 30px;
        }
        h2 {
            text-align: center;
            color: #fff;
            text-shadow: 2px 2px 4px #000;
        }
        form {
            max-width: 400px;
            margin: auto;
            padding: 60px;
            background: rgba(255, 255, 255, 0.8);
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
        }
        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="date"],
        input[type="time"],
        select,
        textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #00BFFF;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #00008B;
        }
    </style>
</head>
<body>
<h2>Add a new Task</h2>
    <form action="newtask" method="post">
        <label>Project Name</label>
        <input type="text" name="project-name" required/><br>
        
        <label>Role</label>
        <input type="text" name="task-role" required/><br>
        
        <label>Date</label>
        <input type="date" name="task-date" required/><br>
        
        <label>Start Time</label>
        <input type="time" name="task-start-time" required/><br>
        
        <label>End Time</label>
        <input type="time" name="task-end-time" required/><br>
        
        <label>Duration</label>
        <input type="time" name="duration" required/><br>
        
        <label>Task Category</label>
        <select name="task-category" required>
            <option value="Checking">Checking</option>
            <option value="Coding">Coding</option>
            <option value="Production">Production</option>
            <option value="Testing">Testing</option>
            <option value="Meeting">Meeting</option>
            <option value="Designing">Designing</option>
            <option value="Debugging">Debugging</option>
        </select><br>
        
        <label>Description</label>
        <textarea name="task-description" required></textarea><br>
        
        <input type="submit" value="Add"/>     
    </form>
</body>
</html>
