
import './App.css';
import {BrowserRouter, Routes, Route, Link} from "react-router-dom";

import ToolkitPage from './pages/toolkitPage';
import ThunkPage from './pages/thunkPage';


function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <nav>
          <Link to="/">Toolkit Home</Link> | <Link to="/thunk-home">Thunk Home</Link>
        </nav>
        <Routes>
          <Route path='/' element={
            <ToolkitPage />} 
          />
          <Route path='/thunk-home' element={
            <ThunkPage />} 
          />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
