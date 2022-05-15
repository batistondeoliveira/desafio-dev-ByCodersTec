import React from 'react';
import Main from '../../components/Main';
import Empty from './Empty';
import RelatorioDesktop from './Desktop';
import RelatorioMobile from './Mobile';
import RelatorioService from '../../service/RelatorioService';
import './RelatorioFinanceiro.css';

const RelatorioFinanceiro = () => {
  const [data, setData] = React.useState({loja: [], saldoEmConta: 0});
  const [preload, setPreload] = React.useState(false);

  React.useEffect(() => {
    setPreload(true);

    RelatorioService.get().then(response => {
      setData(response.data);
      setPreload(false);
    });
  }, []);

  return (          
    <Main className="rel" title="Relatório Financeiro" preload={preload}>              
      {!preload &&
        <>
          {data.loja.length === 0
            ? <Empty />
            : <>
              <RelatorioMobile show={data.loja.length > 0} data={data} /> 
              <RelatorioDesktop show={data.loja.length > 0} data={data} />
            </>
          }                                
        </>
      }
    </Main>      
  )
}

export default RelatorioFinanceiro;
