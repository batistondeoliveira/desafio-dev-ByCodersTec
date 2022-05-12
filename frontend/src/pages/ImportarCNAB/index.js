import React from 'react';
import FormCnab from './FormCnab';
import FormResult from './FormResult';

function ImportarCNAB() {
    const [processado, setProcessado] = React.useState(false);
    const [data, setData] = React.useState([]);

    return (   
      <>
        {!processado
          ? <FormCnab callback={(data) => {setData(data); setProcessado(true)}} />
          : <FormResult data={data} callback={() => {setData([]); setProcessado(false)}} />
        }        
      </>
    )
}

export default ImportarCNAB;