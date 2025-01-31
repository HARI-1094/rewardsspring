import React, { useState } from "react";
import axios from "axios";
import "../styles/TotalRPPage.css";

const TotalRPPage = () => {
  const [category, setCategory] = useState("");
  const [projectId, setProjectId] = useState("");
  const [totalPoints, setTotalPoints] = useState(null);
  const [projectDetails, setProjectDetails] = useState("");

  const handleCategoryChange = (event) => {
    setCategory(event.target.value);
  };

  const handleProjectIdChange = async (event) => {
    const pid = event.target.value.split(" ")[1]; // Extract PID
    setProjectId(pid);

    if (pid) {
      try {
        const response = await axios.get(`http://localhost:8080/api/reward-points/${pid}`);
        setTotalPoints(response.data.totalRewardPoints);
        setProjectDetails(response.data.projectDetails || "No project details available.");
      } catch (error) {
        console.error("Error fetching total reward points:", error);
        setTotalPoints("Error fetching data");
        setProjectDetails("Error fetching project details.");
      }
    } else {
      setTotalPoints(null);
      setProjectDetails("");
    }
  };

  return (
    <div className="total-rp-page">
      <h2>Total Reward Points Calculated</h2>
      <div className="dropdowns">
        <div className="category">
          <label>Select Category</label>
          <select value={category} onChange={handleCategoryChange}>
            <option value="">Select Category</option>
            <option value="Software">Software</option>
            <option value="Hardware">Hardware</option>
          </select>
        </div>
        <div className="project-id">
          <label>Select Project ID</label>
          <select value={projectId} onChange={handleProjectIdChange}>
            <option value="">Select Project ID</option>
            <option value="PID 1">PID 1</option>
            <option value="PID 2">PID 2</option>
            <option value="PID 3">PID 3</option>
          </select>
        </div>
      </div>

      <div className="results">
        <h3>
          {category} {projectId ? `PID ${projectId}` : ""}
        </h3>
        <div className="total-rp">
          <h4>Total Reward Points Awarded</h4>
          <div className="points">
            <p>{totalPoints !== null ? totalPoints : "0"}</p>
          </div>
        </div>
      </div>

      <div className="additional-info">
        <h4>Project Details</h4>
        <p>{projectDetails}</p>
      </div>
    </div>
  );
};

export default TotalRPPage;
