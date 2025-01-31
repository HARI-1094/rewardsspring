// src/App.js
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import RoleSelection from './components/RoleSelection';
import AdminLogin from './components/AdminLogin';
import ReviewerLogin from './components/ReviewerLogin';
import Dashboard from './components/Dashboard';
import ReviewerDashboard from './components/ReviewerDashboard';
import InitialSubmission from './components/InitialSubmission';
import FinalSubmission from './components/FinalSubmission';
import TotalRPPage from './components/TotalRPPage';
import ReviewerMarks from './components/ReviewerMarks';
import Layout from './components/Layout'; 
import Layout2 from './components/Layout2'; 
import Teamcommunication from './components/Teamcommunication';
import Worklog_marks from "./components/Worklog_marks";
import Plagiarism_marks from "./components/Plagiarism_marks";
// Import the Layout component

function App() {
  return (
    <Router>
      <Routes>
        {/* Pages without sidebar and header */}
        <Route path="/" element={<RoleSelection />} />
        <Route path="/admin-login" element={<AdminLogin />} />
        <Route path="/reviewer-login" element={<ReviewerLogin />} />
        
        
        {/* Pages with sidebar and header */}
        <Route path="/" element={<Layout />}>
        <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/initial-submission" element={<InitialSubmission />} />
          <Route path="/final-submission" element={<FinalSubmission />} />
          <Route path="/total-rp" element={<TotalRPPage />} />
          <Route path="/worklog-marks" element={<Worklog_marks />} />
          <Route path="/plagiarism" element={<Plagiarism_marks />} />
         
         
        </Route>
        <Route path="/" element={<Layout2 />}>
        <Route path="/reviewerdashboard" element={<ReviewerDashboard />} />
          <Route path="/tcmarks" element={<InitialSubmission />} />
          <Route path="/reviewer-marks" element={<ReviewerMarks />} />
          <Route path="/team-communication-marks" element={<Teamcommunication />} />

        </Route>
      </Routes>
    </Router>
  );
}

export default App;
