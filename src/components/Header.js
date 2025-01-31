// src/components/Header.js
import React from 'react';
import { useNavigate } from 'react-router-dom';
import '../styles/Header.css';

const Header = () => {
  const navigate = useNavigate();

  const handleLogout = () => {
    navigate('/');  // Redirect to the role selection page on logout
  };

  return (
    <div className="header">
      <div className="logo">TAC REWARDS</div>
      <button className="logout-button" onClick={handleLogout}>Log Out</button>
    </div>
  );
};

export default Header;
