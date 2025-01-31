import React, { useState } from 'react';
import '../styles/ReviewerMarks.css';

const ReviewerMarks = () => {
  const [pid, setPid] = useState('');
  const [idea, setIdea] = useState(0);
  const [conciseness, setConciseness] = useState(0);
  const [clarity, setClarity] = useState(0);
  const [novelty, setNovelty] = useState(0);
  const [execution, setExecution] = useState(0);
  const [completeness, setCompleteness] = useState(0);
  const [coordination, setCoordination] = useState(0);
  const [workSplitUp, setWorkSplitUp] = useState(0);

  const handleSubmit = (e) => {
    e.preventDefault();

    const totalMarks = parseInt(idea) + parseInt(conciseness) + parseInt(clarity) +
                       parseInt(novelty) + parseInt(execution) + parseInt(completeness) +
                       parseInt(coordination) + parseInt(workSplitUp);

    const marksData = {
      pid,
      idea: parseInt(idea),
      conciseness: parseInt(conciseness),
      clarity: parseInt(clarity),
      novelty: parseInt(novelty),
      execution: parseInt(execution),
      completeness: parseInt(completeness),
      coordination: parseInt(coordination),
      workSplitUp: parseInt(workSplitUp),
      totalMarks: totalMarks
    };

    fetch('http://localhost:8080/api/marks', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(marksData),
    })
    .then(response => response.json())
    .then(data => {
      console.log('Success:', data);
      alert("Marks submitted successfully!");
    })
    .catch((error) => {
      console.error('Error:', error);
      alert("Failed to submit marks.");
    });
  };

  return (
    <form className="marks-form" onSubmit={handleSubmit}>
      <div className="select-pid">
        <label htmlFor="pid">Select PID</label>
        <select id="pid" value={pid} onChange={(e) => setPid(e.target.value)}>
          <option value="1">PID 1</option>
          <option value="2">PID 2</option>
          <option value="3">PID 3</option>
        </select>
      </div>

      <div className="mark-allocation-title">
        <h3>Mark Allocation</h3>
      </div>

      <div className="marks-grid">
        <div className="marks-input">
          <label htmlFor="idea">Idea</label>
          <input type="number" id="idea" value={idea} onChange={(e) => setIdea(e.target.value)} />
        </div>

        <div className="marks-input">
          <label htmlFor="novelty">Novelty</label>
          <input type="number" id="novelty" value={novelty} onChange={(e) => setNovelty(e.target.value)} />
        </div>

        <div className="marks-input">
          <label htmlFor="conciseness">Conciseness</label>
          <input type="number" id="conciseness" value={conciseness} onChange={(e) => setConciseness(e.target.value)} />
        </div>

        <div className="marks-input">
          <label htmlFor="execution">Execution</label>
          <input type="number" id="execution" value={execution} onChange={(e) => setExecution(e.target.value)} />
        </div>

        <div className="marks-input">
          <label htmlFor="clarity">Clarity</label>
          <input type="number" id="clarity" value={clarity} onChange={(e) => setClarity(e.target.value)} />
        </div>

        <div className="marks-input">
          <label htmlFor="completeness">Completeness</label>
          <input type="number" id="completeness" value={completeness} onChange={(e) => setCompleteness(e.target.value)} />
        </div>

        <div className="marks-input">
          <label htmlFor="coordination">Coordination</label>
          <input type="number" id="coordination" value={coordination} onChange={(e) => setCoordination(e.target.value)} />
        </div>

        <div className="marks-input">
          <label htmlFor="workSplitUp">Work Split-up</label>
          <input type="number" id="workSplitUp" value={workSplitUp} onChange={(e) => setWorkSplitUp(e.target.value)} />
        </div>
      </div>

      <div className="submit-button">
        <button type="submit">Submit</button>
      </div>
    </form>
  );
};

export default ReviewerMarks;
