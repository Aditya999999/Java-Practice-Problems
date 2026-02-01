import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

// App Layouts
import Social from './components/social/';
import DragDrop from './components/DragDrop/';
import Jquery from './components/Jquery/';

// Import CSS for the application
import './index.css';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Social />} />
        <Route path="/social" element={<Social />} />
        <Route path="/dnd" element={<DragDrop />} />
        <Route path="/jquery" element={<Jquery />} />
      </Routes>
    </Router>
  );
}

export default App;
