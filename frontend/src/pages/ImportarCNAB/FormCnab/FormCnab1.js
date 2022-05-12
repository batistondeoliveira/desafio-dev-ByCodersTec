import React from 'react';
import CnabService from '../../../service/CnabService';

import './styles.css';

function FormCnab({ callback }) {
  let inputFile = React.createRef();
  const [state, setState] = React.useState({
    txtButton: 'Processar',
    preload: false
  });

  const [file, setFile] = React.useState({
    fileName: 'Nenhum arquivo escolhido',
    file: null
  });

  const handleUploadClickOpen = () => {
    inputFile.current.click();
  }

  const loadFile = (file) => {    
    const { name } = file;
    const reader = new FileReader();

    reader.readAsDataURL(file);
    reader.onloadend = function() {
      setFile({
        ...file,
        fileName: name,
        file 
      });
    }
  }

  const handleSubmit = () => {
    setState({
      ...state,
      txtButton: 'Aguarde...',
      preload: true
    });   

    var formData = new FormData();

    formData.append('conteudo', file.file);
    formData.append('user', 'bycoderstec');
    formData.append('user', file.fileName);    
    
    CnabService.send(formData).then(response => {
      setState({
        txtButton: 'Processar',
        preload: false,        
      });

      callback(response.data);
    });    
  }
  
  return (
    <div className="cnab-form-container">
      <div className="cnab-card-bottom-container">          
          <form id="form" className="cnab-form" onSubmit={handleSubmit}>
              <div className="form-group cnab-form-group">
                  <label htmlFor="cnab-file">Selecione o arquivo CNAB</label>
                  <input 
                    type="file" 
                    ref={inputFile} 
                    style={{display: 'none'}}
                    accept="application/txt"
                    onChange={(event) => loadFile(event.target.files[0])}
                  />

                  <div className="form-control input-file" style={{cursor: 'pointer'}} disabled={state.preload} onClick={handleUploadClickOpen}>
                    <button disabled={state.preload} type="button" className="btn btn-danger">Escolher arquivo</button>
                    <span disabled={state.preload}>{file.fileName}</span>
                  </div>
              </div>              
              <div className="cnab-form-btn-container">
                  <button type="button" className="btn btn-primary cnab-btn" disabled={state.preload} onClick={handleSubmit}>{state.txtButton}</button>
              </div>
          </form>          
      </div >
    </div >   
  )
}

export default FormCnab;