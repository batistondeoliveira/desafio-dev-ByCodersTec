import Preload from '../Preload';

const Main = ({ title, children, preload }) =>
  <main className="app-grid">
    <Preload show={preload} />

    <h2>{title}</h2>
    <div className="app-grid-container">
      <div className="app-grid-card">  
         {children}
      </div>            
    </div>
  </main>

export default Main;