const FooterTop = () => 
  <div className="footer-top">
    <div className="footer-top-about">
      <h3>Sobre Mim</h3>
      <p>{process.env.REACT_APP_ABOUT_ME}</p>
      <p><i className="fas fa-phone"></i> {process.env.REACT_APP_TELEFONE}</p>
      <p><i className="fas fa-envelope"></i> {process.env.REACT_APP_EMAIL}</p>        
    </div>      
  </div>

export default FooterTop;
