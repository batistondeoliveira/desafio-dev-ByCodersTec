import React from 'react';

import './styles.css';

function FormCnab({ callback }) {
  const [state, setState] = React.useState({
    txtButton: 'Processar',
    preload: false
  });

  const handleSubmit = () => {
    setState({
      ...state,
      txtButton: 'Aguarde...',
      preload: true
    });   
    
    callback();
  }
  
  return (
    <div className="cnab-form-container">
      <div className="cnab-card-bottom-container">          
          <form className="cnab-form" onSubmit={handleSubmit}>
              <div className="form-group cnab-form-group">
                  <label htmlFor="cnab-file">Selecione o arquivo CNAB</label>
                  <input type="file" className="form-control" id="cnab-file" disabled={state.preload}/>
              </div>              
              <div className="cnab-form-btn-container">
                  <button type="submit" className="btn btn-primary cnab-btn" disabled={state.preload}>{state.txtButton}</button>
              </div>
          </form>          
      </div >
    </div >   
  )
}

export default FormCnab;