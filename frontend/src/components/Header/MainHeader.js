const MainHeader = () => 
  <div className="main-header">
    <div className="main-header-container">
      <a href="/#" id="brand">          
        <img src={`${process.env.PUBLIC_URL}/assets/img/logo.svg`} alt="logo" />
      </a>        
      <div className="header-actions-menu">
        <a href={process.env.REACT_APP_GITHUB_URL} target="_blank" rel="noreferrer">
          <div className="header-git-container">              
            <img src={`${process.env.PUBLIC_URL}/assets/img/github.svg`} alt="linkedin"/>
            <p className="cnab-contact-link">/{process.env.REACT_APP_GITHUB_NOME}</p>
          </div>
        </a>
      </div>
    </div>
  </div>

export default MainHeader;