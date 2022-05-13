import React from 'react';
import { Navigate } from 'react-router-dom';
import Main from '../../components/Main';
import CnabService from '../../service/CnabService';

function ImportarCNAB() {
  let inputFile = React.createRef();
  const [state, setState] = React.useState({
    txtButton: 'Processar',
    preload: false,
    success: false,
    error: undefined
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

  const handleSubmit = (e) => {
    e.preventDefault();

    setState({
      ...state,
      txtButton: 'Aguarde...',
      preload: true
    });   

    var formData = new FormData();

    formData.append('conteudo', file.file);
    
    CnabService.send(formData).then(response => {
      setState({
        ...state,
        txtButton: 'Processar',
        preload: false,
        success: true
      });
    }).catch(error => {
      console.log(error);
      setState({
        ...state,
        error: error.response.data,
        txtButton: 'Processar',
        preload: false
      })
    });    
  }

  return (   
    <Main 
      className="mini" 
      title="Importar arquivo CNAB" 
      messageError={state.error}
      handleErrorClick={() => { alert('1'); setState({...state, error: undefined})}}
      preload={state.preload}      
    >
      <form id="form" className="app-grid-form" onSubmit={(e) => handleSubmit(e)}>
        <div className="app-grid-form-input">
          <label>Selecione o arquivo CNAB</label>
          <input 
            type="file"
            ref={inputFile}          
            style={{display: 'none'}}
            accept="application/txt"              
            onChange={(event) => loadFile(event.target.files[0])}
          />

          <div className="form-control" disabled={state.preload} onClick={handleUploadClickOpen}>
            <button disabled={state.preload} type="button" className="btn btn-danger">Escolher arquivo</button>
            <span disabled={state.preload}>{file.fileName}</span>
          </div>
        </div>              
        <div className="app-grid-form-button">
          <button type="submit" className="btn">Processar</button>
        </div>
      </form>

      {(state.success) &&
        <Navigate to="/relatorio" />
      }
    </Main>
  )
}

export default ImportarCNAB;
