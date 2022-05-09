import { ReactComponent as GithubIcon} from '../../assents/img/github.svg'
import 'bootstrap/dist/css/bootstrap.css';
import './styles.css';

function Navbar() {
  return (
    <header>
        <nav className="container">
            <div className="cnab-nav-content">
                <h1>Leitura Arquivo CNAB</h1>
                <a href="https://github.com/batistondeoliveira" target="_blank" rel="noreferrer">
                    <div className="cnab-contact-container">
                        <GithubIcon />
                        <p className="cnab-contact-link">/batistondeoliveira</p>
                    </div>
                </a>
            </div>
        </nav>
    </header>
  )
}

export default Navbar;