// src/components/Sidebar.js
import React from 'react';
import { Link } from 'react-router-dom';
import '../styles/Sidebar.css';

const Sidebar = () => {
  return (
    <div className="sidebar">
      <Link to="/dashboard">Dashboard</Link>
      <Link to="/initial-submission">Initial Submission</Link>
      <Link to="/final-submission">Final Submission</Link>
      <Link to="/worklog-marks">Worklog Marks</Link>
      <Link to="/plagiarism">Plagiarism</Link>
      <Link to="/total-rp">Total RP Calculated</Link>
    </div>
  );
};

export default Sidebar;
