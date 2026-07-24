import { useContext } from "react";
import ThemeContext from "../ThemeContext";

function EmployeeCard({ employee }) {

  const theme = useContext(ThemeContext);

  return (

    <div className="employee-card">

      <h2>{employee.name}</h2>

      <p>
        <strong>Designation:</strong> {employee.designation}
      </p>

      <button className={theme}>
        View Profile
      </button>

    </div>

  );

}

export default EmployeeCard;