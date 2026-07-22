import "./App.css";

import {
    BrowserRouter,
    Routes,
    Route,
    Link,
    Navigate
} from "react-router-dom";

import Home from "./Components/Home";
import TrainersList from "./Components/TrainersList";
import TrainerDetails from "./Components/TrainerDetails";

function App() {

    return (

        <BrowserRouter>

            <div className="App">

                <h1>My Academy Trainers App</h1>

                <nav>

                    <Link to="/home">Home</Link>

                    {" | "}

                    <Link to="/trainers">Show Trainers</Link>

                </nav>

                <hr />

                <Routes>

                    <Route
                        path="/"
                        element={<Navigate to="/home" replace />}
                    />

                    <Route
                        path="/home"
                        element={<Home />}
                    />

                    <Route
                        path="/trainers"
                        element={<TrainersList />}
                    />

                    <Route
                        path="/trainers/:id"
                        element={<TrainerDetails />}
                    />

                </Routes>

            </div>

        </BrowserRouter>

    );

}

export default App;