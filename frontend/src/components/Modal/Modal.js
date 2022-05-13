const Modal = ({ open, children }) =>   
  <>        
    {open && 
      <div className="modal">
        <div>                        
          { children }                
        </div>
      </div>            
    }
  </>

export default Modal;
