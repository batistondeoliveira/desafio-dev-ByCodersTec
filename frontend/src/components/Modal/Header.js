const Header = ({ title, handleClose }) =>
  <header>
    {handleClose !== undefined &&
      <button className="fechar" onClick={() => handleClose()}>X</button>
    }            

    <h2>{ title }</h2>

    <hr />
  </header>                
  
export default Header;
