import React, { useState } from "react";

function Register() {

  const [user, setUser] = useState({
    fullName: "",
    email: "",
    password: ""
  });

  const [errors, setErrors] = useState({
    fullName: "",
    email: "",
    password: ""
  });

  const handleChange = (event) => {

    const { name, value } = event.target;

    let validationErrors = { ...errors };

    switch (name) {

      case "fullName":

        validationErrors.fullName =
          value.length < 5
            ? "Full Name must be 5 characters long!"
            : "";

        break;

      case "email":

        const validEmailRegex =
          /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        validationErrors.email =
          validEmailRegex.test(value)
            ? ""
            : "Email is not valid!";

        break;

      case "password":

        validationErrors.password =
          value.length < 8
            ? "Password must be 8 characters long!"
            : "";

        break;

      default:
        break;
    }

    setErrors(validationErrors);

    setUser({
      ...user,
      [name]: value
    });
  };

  const validateForm = () => {

    return (

      errors.fullName === "" &&
      errors.email === "" &&
      errors.password === "" &&
      user.fullName !== "" &&
      user.email !== "" &&
      user.password !== ""

    );

  };

  const handleSubmit = (event) => {

    event.preventDefault();

    if (validateForm()) {

      alert("Valid Form");

    } else {

      if (errors.fullName !== "") {

        alert(errors.fullName);

      } else if (errors.email !== "") {

        alert(errors.email);

      } else if (errors.password !== "") {

        alert(errors.password);

      }

    }

  };

  return (

    <div className="container">

      <h1>Register Here!!!</h1>

      <form onSubmit={handleSubmit}>

        <table>

          <tbody>

            <tr>

              <td>Name:</td>

              <td>

                <input
                  type="text"
                  name="fullName"
                  value={user.fullName}
                  onChange={handleChange}
                />

              </td>

            </tr>

            <tr>

              <td>Email:</td>

              <td>

                <input
                  type="text"
                  name="email"
                  value={user.email}
                  onChange={handleChange}
                />

              </td>

            </tr>

            <tr>

              <td>Password:</td>

              <td>

                <input
                  type="password"
                  name="password"
                  value={user.password}
                  onChange={handleChange}
                />

              </td>

            </tr>

            <tr>

              <td></td>

              <td>

                <button type="submit">
                  Submit
                </button>

              </td>

            </tr>

          </tbody>

        </table>

      </form>

    </div>

  );

}

export default Register;