const Main = ({ title, children }) =>
  <main className="app-grid">
    <h2>{title}</h2>
    <div className="app-grid-container">
      <div className="app-grid-card">  
         {children}
      </div>            
    </div>
  </main>

export default Main;