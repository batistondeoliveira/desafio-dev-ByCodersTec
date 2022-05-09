import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import Navbar from "./components/Navbar";
import Cnab from "./components/Cnab";

function App() {
  return (
    <BrowserRouter basename="/cnab-frontend">
      <Navbar />
      <Routes>
        <Route path="/" element={<Cnab />} />        
      </Routes>
    </BrowserRouter>
  );
}

export default App;
