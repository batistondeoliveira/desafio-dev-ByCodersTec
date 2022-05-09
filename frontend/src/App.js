import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import Navbar from "./components/Navbar";
import FormCnab from "./components/FormCnab";

function App() {
  return (
    <BrowserRouter basename="/cnab-frontend">
      <Navbar />
      <Routes>
        <Route path="/" element={<FormCnab />} />        
      </Routes>
    </BrowserRouter>
  );
}

export default App;
