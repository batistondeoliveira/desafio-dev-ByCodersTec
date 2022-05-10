import { format } from 'date-fns';
import { pt } from 'date-fns/locale';
import { zonedTimeToUtc } from 'date-fns-tz';

function Table({ data }) {
  return (
    <>      
      {data.loja.map(loja => (
        <table>
          <thead>
            <tr className="header-loja">
              <th className="font"><strong>Loja:</strong></th>
              <th colspan={5} width="90%">{loja.nome}</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            <tr rules="rows">
              <td colspan={7}>
                <table rules="rows">
                  <thead>
                    <tr className="header-lancamento">
                      <th width="12%">Tipo</th>
                      <th width="9%">Data</th>              
                      <th width="12%">CPF</th>
                      <th width="15%">Cartão</th>
                      <th width="8%">Hora</th>
                      <th width="27%">Representante</th>
                      <th width="12%">Valor</th>
                    </tr>
                  </thead>
                  <tbody>
                    {loja.lancamento.map(lancamento => (
                      <tr className="lancamento-detalhamento">
                        <td>{lancamento.tipoTransacao}</td>
                        <td>{format( zonedTimeToUtc(lancamento.data, 'America/Sao_Paulo'), "dd/MM/yyyy", {locale: pt} )}</td>              
                        <td>{lancamento.cpf}</td>
                        <td>{lancamento.cartao}</td>
                        <td>{lancamento.hora}</td>
                        <td>{lancamento.representanteLoja}</td>
                        <td style={{textAlign: 'right'}}>{ new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL'}).format(lancamento.valor) }</td>
                      </tr>
                    ))}                    
                  </tbody>
                  <tfoot>
                    <tr>
                      <td colSpan={5} />
                      <td style={{fontWeight: 'bold', textAlign: 'right'}}>Total:</td>
                      <td style={{textAlign: 'right'}}>{ new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL'}).format(loja.saldoPorLoja) }</td>
                    </tr>
                  </tfoot>
                </table>          
              </td>
            </tr>
          </tbody>          
        </table>          
      ))}

      <div className="saldo-container">
        <div className="saldo-label">
          Saldo em conta: 
        </div>
        <div className="saldo-valor">
          { new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL'}).format(data.saldoEmConta) }
        </div>
      </div>
    </>    
  )
}

export default Table;