// src/components/RoleSelection.js
import React from 'react';
import { useNavigate } from 'react-router-dom';
import '../styles/RoleSelection.css';
import logo from '../assets/logo.png';

const RoleSelection = () => {
  const navigate = useNavigate();

  return (
    <div className="role-selection-container">
      <h2>Welcome back!</h2>
      <h2>Select your role</h2>
      <img src={logo} alt="Logo" className="login-logo" /> {/* Add the logo image */}
      <div className="buttons">
        <button onClick={() => navigate('/admin-login')} className="role-button">
          Admin
        </button>
        <button onClick={() => navigate('./reviewer-login')} className="role-button">
          Reviewer
        </button>
      </div>
    </div>
  );
};

export default RoleSelection;
