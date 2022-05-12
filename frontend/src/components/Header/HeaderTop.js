const HeaderTop = () => 
  <div className="header-top">
    <div className="header-top-container">
      <div className="info-container">
        <span><i className="fas fa-phone"></i> {process.env.REACT_APP_TELEFONE}</span>
        <span><i className="fas fa-envelope"></i>{process.env.REACT_APP_EMAIL}</span>                    
        <span>
          <a href={process.env.REACT_APP_LINKEDIN} target="_blank" rel="noreferrer">
            <i className="fab fa-linkedin"></i> 
            {process.env.REACT_APP_LINKEDIN_NOME}
          </a>  
        </span>          
      </div>        
    </div>
  </div>

export default HeaderTop;
