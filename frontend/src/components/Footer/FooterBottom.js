const FooterBottom = () => 
  <div className="footer-bottom">
    <div className="footer-bottom-social">
      <a href={process.env.REACT_APP_LINKEDIN_URL} target="_blank" rel="noreferrer">
        <i className="fab fa-linkedin"></i>
      </a>
      <a href={process.env.REACT_APP_GITHUB_URL} target="_blank" rel="noreferrer">
        <i className="fab fa-github"></i>        
      </a>
    </div>
    <p>{process.env.REACT_APP_COPYRIGHT}</p>
  </div>

export default FooterBottom;
