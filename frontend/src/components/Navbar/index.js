import { HeaderTop, MainHeader, HeaderBottom} from '../Header';

function Navbar() {
  return (
    <header className="header">
      <HeaderTop />
      
      <MainHeader />
      
      <HeaderBottom />
    </header>  
  )
}

export default Navbar;