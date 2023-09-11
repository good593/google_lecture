import React from 'react';
import {Routes, Route, Link} from "react-router-dom";

import './App.css';
import Props from './pages/propsPage';
import Redux from './pages/reduxPage';

function App() {

  return (
    <div className="App">
      <nav>
        <Link to="/">Props Home</Link> | <Link to="/redux">Redux Home</Link>
      </nav>
      <Routes>
        <Route path='/' element={
          <Props />} 
        />
        <Route path='/redux' element={
          <Redux />} 
        />
      </Routes>
    </div>
  );
}

export default App;

