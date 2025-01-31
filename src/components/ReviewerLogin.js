// src/components/ReviewerLogin.js
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import '../styles/ReviewerLogin.css';
import logo from '../assets/logo.png';
import axios from 'axios';

const ReviewerLogin = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    const response = await fetch('http://localhost:8080/login/reviewer', {
      method: 'POST',
      headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
      body: new URLSearchParams({ username, password }),
    });

    const result = await response.text();
    if (result === "Reviewer dashboard") {
      navigate('/ReviewerDashboard'); // Redirect to Admin Dashboard
    } else {
      alert('Invalid credentials');
    }
  };

  return (
    <div className="login-container">
      <h2>Welcome back!</h2>
      <img src={logo} alt="Logo" className="login-logo" />
      <form onSubmit={handleLogin}>
        <input
          type="text"
          placeholder="Username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          required
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
        <button type="submit" className="login-button">Login</button>
      </form>
    </div>
  );
};

export default ReviewerLogin;
