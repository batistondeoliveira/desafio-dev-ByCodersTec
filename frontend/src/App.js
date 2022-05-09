import {
  BrowserRouter,
  Routes
} from "react-router-dom";
import Navbar from "./components/Navbar";

function App() {
  return (
    <BrowserRouter basename="/cnab-frontend">
      <Navbar />
      <Routes>
        
      </Routes>
    </BrowserRouter>
  );
}

export default App;
