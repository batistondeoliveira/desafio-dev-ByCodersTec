const Preload = ({ show }) => 
  <>
    {show && 
      <>
        <div className="preloader">    
          
        </div>
        
        <div className="preloader-inner">    
          <div className="bolas">
            <div></div>
            <div></div>
            <div></div>                    
          </div>
        </div>
      </>
    }
  </>
export default Preload;
  