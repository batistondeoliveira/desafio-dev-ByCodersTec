import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import ImportarCNAB from "./pages/ImportarCNAB";

function App() {
  return (
    <>
      <Navbar />
              
      <BrowserRouter basename="/cnab-frontend">        
        <Routes>
          <Route path="/" element={<ImportarCNAB />} />        
        </Routes>
      </BrowserRouter>      

      <Footer />
    </>
  );
}

export default App;
