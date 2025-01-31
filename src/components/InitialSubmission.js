import React, { useState } from "react";
import axios from "axios";
import "../styles/InitialSubmission.css";

const InitialSubmission = () => {
  const [selectedPid, setSelectedPid] = useState("");
  const [marks, setMarks] = useState("");
  const [projectDetails, setProjectDetails] = useState("");

  // Fetch project details by PID
  const handlePidChange = async (event) => {
    const pid = event.target.value;
    setSelectedPid(pid);

    if (pid) {
      try {
        const response = await axios.get(`http://localhost:8080/api/submissions/${pid}`);
        setProjectDetails(response.data.projectDetails || "No details available for this project.");
      } catch (error) {
        console.error("Error fetching project details:", error.message);
        setProjectDetails("Error fetching project details.");
      }
    } else {
      setProjectDetails("");
    }
  };

  // Handle marks input change
  const handleMarksChange = (event) => {
    setMarks(event.target.value);
  };

  // Submit marks for the selected PID
  const handleSubmit = async () => {
    if (selectedPid && marks) {
      try {
        const payload = {
          pid: selectedPid,
          projectDetails,
          marks: parseInt(marks, 10),
        };
        await axios.post("http://localhost:8080/api/submissions", payload);
        alert("Marks submitted successfully!");
        // Reset form
        setSelectedPid("");
        setMarks("");
        setProjectDetails("");
      } catch (error) {
        console.error("Error submitting marks:", error.message);
        alert("Error submitting marks. Please try again.");
      }
    } else {
      alert("Please select a Project ID and enter marks.");
    }
  };

  return (
    <div className="initial-submission">
      <h2>Initial Submission</h2>

      <div className="project-ids">
        <h3>Project IDs</h3>
        <select value={selectedPid} onChange={handlePidChange}>
          <option value="">Select a Project ID</option>
          <option value="1">PID 1</option>
          <option value="2">PID 2</option>
          <option value="3">PID 3</option>
        </select>
      </div>

      {selectedPid && (
        <div className="project-details">
          <h4>Project Details:</h4>
          <p>{projectDetails}</p>
        </div>
      )}

      <div className="actions">
        <div className="enter-marks">
          <input
            type="number"
            placeholder="Enter the marks"
            value={marks}
            onChange={handleMarksChange}
          />
          <button onClick={handleSubmit}>Submit</button>
        </div>
      </div>
    </div>
  );
};

export default InitialSubmission;
