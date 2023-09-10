import React from "react";
import {Routes, Route, Link} from "react-router-dom";

import Home from "./pages/Home";
import About from "./pages/About";
import Counter from "./pages/Counter";
import Input from "./pages/Input";
import Login from "./pages/Login";
import UserList from "./pages/UserList";


function App() {
  return (
    <div className="App">
      <nav>
        <Link to="/">Home</Link> | <Link to="/about">About</Link> | <Link to="/counter">Counter</Link>
        | <Link to="/input">Input</Link> | <Link to="/login">Login</Link> | <Link to="/userList">UserList</Link>
      </nav>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/counter" element={<Counter />} />
        <Route path="/input" element={<Input />} />
        <Route path="/login" element={<Login />} />
        <Route path="/userList" element={<UserList />} />
      </Routes>
    </div>
  );
}

export default App;
