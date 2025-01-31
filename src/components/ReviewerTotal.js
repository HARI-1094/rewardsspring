import React, { useState } from "react";
import axios from "axios";
import "../styles/ReviewerTotal.css";

const ReviewerTotal = () => {
  const [selectedPid, setSelectedPid] = useState("");
  const [reviewerTotal, setReviewerTotal] = useState(null);

  // Handle PID selection and fetch reviewer total
  const handlePidChange = async (event) => {
    const pid = event.target.value;
    setSelectedPid(pid);

    if (pid) {
      try {
        const response = await axios.get(`http://localhost:8080/api/reviewer_total/${pid}`);
        setReviewerTotal(response.data.total || "Unable to calculate total for this PID.");
      } catch (error) {
        console.error("Error fetching reviewer total:", error.message);
        setReviewerTotal("Error fetching total.");
      }
    } else {
      setReviewerTotal(null);
    }
  };

  return (
    <div className="reviewer-total">
      <h2>Reviewer Total</h2>

      {/* Project ID selection */}
      <div className="project-ids">
        <h3>Select Project ID</h3>
        <select value={selectedPid} onChange={handlePidChange}>
          <option value="">Select a Project ID</option>
          <option value="1">PID 1</option>
          <option value="2">PID 2</option>
          <option value="3">PID 3</option>
        </select>
      </div>

      {/* Display total marks */}
      {selectedPid && (
        <div className="total-display">
          <h4>Total Marks:</h4>
          <p>{reviewerTotal !== null ? reviewerTotal : "Please select a PID to view the total."}</p>
        </div>
      )}
    </div>
  );
};

export default ReviewerTotal;
