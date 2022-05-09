import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import Navbar from "./components/Navbar";
import Form from "./pages/Form";

function App() {
  return (
    <BrowserRouter basename="/cnab-frontend">
      <Navbar />
      <Routes>
        <Route path="/" element={<Form />} />        
      </Routes>
    </BrowserRouter>
  );
}

export default App;
