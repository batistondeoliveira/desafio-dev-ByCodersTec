import Preload from '../Preload';
import { ModalError } from '../Modal';

const Main = ({ className, title, children, preload, messageError, handleErrorClick }) =>
  <main className="app-grid">
    <Preload show={preload} />
    <ModalError 
      open={messageError !== undefined} 
      message={messageError}
      handleClose={handleErrorClick} 
    />

    <h2>{title}</h2>
    <div className="app-grid-container">
      <div className={`app-grid-card ${className}`}>  
         {children}
      </div>            
    </div>
  </main>

Main.defaultProps = {
  message: ''
}

export default Main;