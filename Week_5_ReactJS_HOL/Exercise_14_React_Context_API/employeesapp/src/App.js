import { useState } from "react";
import EmployeesList from "./components/EmployeesList";
import ThemeContext from "./ThemeContext";
import "./App.css";

function App() {

  const [theme, setTheme] = useState("light");

  const employees = [
    {
      id: 1,
      name: "John Smith",
      designation: "Software Engineer"
    },
    {
      id: 2,
      name: "Alice Johnson",
      designation: "React Developer"
    },
    {
      id: 3,
      name: "David Miller",
      designation: "UI Designer"
    },
    {
      id: 4,
      name: "Emma Wilson",
      designation: "Project Manager"
    }
  ];

  const changeTheme = () => {

    setTheme(theme === "light" ? "dark" : "light");

  };

  return (

    <ThemeContext.Provider value={theme}>

      <div className="App">

        <h1>Employee Management System</h1>

        <button
          className="toggle-btn"
          onClick={changeTheme}
        >
          Switch Theme
        </button>

        <EmployeesList employees={employees} />

      </div>

    </ThemeContext.Provider>

  );

}

export default App;