import React from 'react';
import {BrowserRouter, Routes, Route, Link} from "react-router-dom";

import './App.css';
import Props from './pages/propsPage';
import Redux from './pages/reduxPage';

function App() {

  return (
    <div className="App">
      <BrowserRouter>
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
      </BrowserRouter>
    </div>
  );
}

export default App;

