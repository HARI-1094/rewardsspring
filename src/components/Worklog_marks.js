import React, { useState } from "react";
import axios from "axios";
import "../styles/Worklog_marks.css";

const Worklog_marks = () => {
  const [selectedPid, setSelectedPid] = useState("");
  const [worklogMarks, setWorklog_marks] = useState(null);

  // Fetch worklog marks by PID
  const handlePidChange = async (event) => {
    const pid = event.target.value;
    setSelectedPid(pid);

    if (pid) {
      try {
        const response = await axios.get(`http://localhost:8080/api/worklog-marks/${pid}`);
        setWorklog_marks(response.data.marks); // Assuming the API returns { marks: <value> }
      } catch (error) {
        console.error("Error fetching worklog marks:", error.message);
        setWorklog_marks("Error fetching marks.");
      }
    } else {
      setWorklog_marks(null);
    }
  };

  return (
    <div className="worklog-marks">
      <h2>View Worklog Marks</h2>

      {/* PID Selection */}
      <div className="project-ids">
        <h3>Select Project ID</h3>
        <select value={selectedPid} onChange={handlePidChange}>
          <option value="">Select a Project ID</option>
          <option value="1">PID 1</option>
          <option value="2">PID 2</option>
          <option value="3">PID 3</option>
          {/* Add more PIDs as needed */}
        </select>
      </div>

      {/* Display Worklog Marks */}
      {worklogMarks !== null && (
        <div className="worklog-details">
          <h4>Worklog Marks</h4>
          <p>{worklogMarks}</p>
        </div>
      )}
    </div>
  );
};

export default Worklog_marks;
