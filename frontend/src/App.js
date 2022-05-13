import { Suspense, lazy } from "react";
import {  
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import Preload from "./components/Preload";

const ImportarCNAB = lazy(() => import("./pages/ImportarCNAB"));
const RelatorioFinanceiro = lazy(() => import("./pages/RelatorioFinanceiro"));

const App = () =>
  <BrowserRouter basename="/cnab-frontend">    
    <Suspense fallback={<Preload show={true} />}>
      <Navbar />

      <Routes>      
        <Route exact path="/" element={<ImportarCNAB />} />
        <Route path="/relatorio" element={<RelatorioFinanceiro />} />
      </Routes>

      <Footer />      
    </Suspense>    
  </BrowserRouter>            

export default App;
