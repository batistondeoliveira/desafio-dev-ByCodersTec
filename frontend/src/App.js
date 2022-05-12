import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import ImportarCNAB from "./pages/ImportarCNAB";
import RelatorioFinanceiro from "./pages/RelatorioFinanceiro";

const App = () =>
  <BrowserRouter basename="/cnab-frontend">        
    <Navbar />
    
    <Routes>      
      <Route path="/" element={<ImportarCNAB />} />
      <Route path="/relatorio" element={<RelatorioFinanceiro />} />
    </Routes>
    
    <Footer />
  </BrowserRouter>            

export default App;
