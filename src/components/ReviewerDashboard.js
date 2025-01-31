import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../styles/ReviewerDashboard.css';

const ReviewerDashboard = () => {
  const [totalProjects, setTotalProjects] = useState(3); // Static value, adjust as needed
  const [tcMarksCount, setTcMarksCount] = useState(0);   // For Team Communication Marks
  const [reviewerMarksCount, setReviewerMarksCount] = useState(0);  // For Reviewer Marks

  // Fetch the counts when the component mounts
  useEffect(() => {
    const fetchData = async () => {
      try {
        // Fetch Team Communication Marks Count
        const tcResponse = await axios.get('http://localhost:8080/api/team-communication-marks/count');
        setTcMarksCount(tcResponse.data);

        // Fetch Reviewer Marks Count
        const reviewerResponse = await axios.get('http://localhost:8080/api/marks/count');
        setReviewerMarksCount(reviewerResponse.data);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };

    fetchData();
  }, []);

  return (
    <div className="reviewerdashboard-container">
      <div className="reviewerdashboard-content">
        <div className="card total-projects">
          <h3>TOTAL PROJECTS</h3>
          <p>{totalProjects}</p>
        </div>
        <div className="card tcmarks">
          <h3>TEAM COMMUNICATION MARKS ALLOTTED FOR</h3>
          <p>{tcMarksCount}</p>
        </div>
        <div className="card reviewermarks">
          <h3>REVIEWER MARKS ALLOTTED FOR</h3>
          <p>{reviewerMarksCount}</p>
        </div>
      </div>
    </div>
  );
};

export default ReviewerDashboard;
