import React, { useState } from "react";
import "./App.css";

import Greeting from "./components/Greeting";

function App() {

  const [isLoggedIn, setIsLoggedIn] = useState(false);

  function handleLogin() {
    setIsLoggedIn(true);
  }

  function handleLogout() {
    setIsLoggedIn(false);
  }

  return (

    <div className="App">

      <Greeting
        isLoggedIn={isLoggedIn}
        onLogin={handleLogin}
        onLogout={handleLogout}
      />

    </div>

  );

}

export default App;