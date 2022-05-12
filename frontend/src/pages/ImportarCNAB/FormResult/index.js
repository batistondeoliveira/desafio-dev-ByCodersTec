import React from 'react';
import TableResult from './TableResult';
import './styles.css';

function ResultForm({ data, callback }) {
  return (
    <div className="cnab-result-container">
      <div className="cnab-card-bottom-result-container"> 
        <div className="form-group cnab-form-group"> 
          <TableResult data={data} />         
        </div>

        <div className="cnab-form-btn-container">
            <button type="submit" className="btn btn-primary cnab-btn" onClick={callback}>Voltar</button>
        </div>
      </div>
    </div>
  )
}

export default ResultForm;