import React from 'react';
import { FormCnab, FormResult } from '../../components/Cnab';

function Form() {
    const [processado, setProcessado] = React.useState(false);
    const [data, setData] = React.useState([]);

    return (
      <div className="container">
        <div className="row">
            {!processado
              ? <FormCnab callback={(data, processado) => {setData(data); setProcessado(processado)}} />
              : <FormResult data={data} callback={() => {setData([]); setProcessado(false)}} />
            }            
        </div>
    </div>
    )
}

export default Form;