import React, { useState, useEffect } from "react";
import axios from "axios";
import "../styles/Dashboard.css";

const AdminDashboard = () => {
  const [counts, setCounts] = useState({
    finalSubmissionCount: 0,
    initialSubmissionCount: 0,
  });

  useEffect(() => {
    const fetchCounts = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/dashboard/counts");
        setCounts(response.data);
      } catch (error) {
        console.error("Error fetching counts:", error);
      }
    };

    fetchCounts();
  }, []);

  return (
    <div className="dashboard-container">
      <div className="dashboard-content">
        <div className="card total-projects1">
          <h3>TOTAL PROJECTS</h3>
          <p>3</p>
        </div>
        <div className="card initial-submission1">
          <h3>INITIAL SUBMISSION MARK ALLOCATION COMPLETED</h3>
          <p>{counts.initialSubmissionCount}</p>
        </div>
        <div className="card final-submission">
          <h3>FINAL SUBMISSION MARK ALLOCATION COMPLETED</h3>
          <p>{counts.finalSubmissionCount}</p>
        </div>
      </div>
    </div>
  );
};

export default AdminDashboard;
