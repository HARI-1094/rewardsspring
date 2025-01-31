// src/components/Sidebar.js
import React from 'react';
import { Link } from 'react-router-dom';
import '../styles/Sidebar.css';

const Sidebar2 = () => {
  return (
    <div className="sidebar">
      <Link to="/ReviewerDashboard">Dashboard</Link>
      <Link to="/reviewer-marks">Reviewer Marks</Link>
      <Link to="/team-communication-marks">Team Communication Marks</Link>
      
    </div>
  );
};

export default Sidebar2;
