import React from 'react';
import Main from '../../components/Main';

function ImportarCNAB() {
    const [processado, setProcessado] = React.useState(false);
    const [data, setData] = React.useState([]);

    return (   
      <Main title="Importar arquivo CNAB">
        <form className="app-grid-form">
          <div className="app-grid-form-input">
            <label>Selecione o arquivo CNAB</label>
            <input 
              type="file"               
              style={{display: 'none'}}
              accept="application/txt"              
            />

            <div className="form-control">
              <button type="button" className="btn btn-danger">Escolher arquivo</button>
              {/* <span>{file.fileName}</span> */}
            </div>
          </div>              
          <div className="app-grid-form-button">
            <button type="button" className="btn">Processar</button>
          </div>
        </form>
      </Main>
    )
}

export default ImportarCNAB;
