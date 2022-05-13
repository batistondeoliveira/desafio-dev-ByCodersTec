import Modal from './Modal'
import Header from './Header'
import Body from './Body'
import Footer from './Footer'

const ModalError = ({ open, message, handleClose }) =>
  <Modal open={open}>
    <Header 
      title={message !== undefined ? message.error : ''}
      close 
      handleClose={handleClose} 
    />        

    <Body>
      <p>{message !== undefined ? message.message : ''}</p>        
    </Body>

    <Footer>
      <button className="btn" onClick={handleClose}>OK</button>
    </Footer>
  </Modal>

export default ModalError;
