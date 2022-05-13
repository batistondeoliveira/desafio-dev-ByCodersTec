import { Table, ColumnTypeEnum, AlignEnum } from '../../components/Table';
import { CurrencyFormat } from '../../components/Utils/CurrencyFormat';

const head = [
  {title: 'Tipo', fieldName: 'tipoTransacao', width: '16%'},
  {title: 'Data', fieldName: 'data', width: '9%', type: ColumnTypeEnum.DATE},
  {title: 'CPF', fieldName: 'cpf', width: '9%'},
  {title: 'Cartão', fieldName: 'cartao', width: '9%'},
  {title: 'Hora', fieldName: 'hora', width: '9%'},
  {title: 'Representante', fieldName: 'representanteLoja', width: '25%'},
  {title: 'Valor', fieldName: 'valor', width: '12%', type: ColumnTypeEnum.CURRENCY, align: AlignEnum.RIGHT}
];

const TableRelatorio = ({ show, data }) => 
  <>
    {show &&
      <>
        {data.loja.map(loja =>
          <table rules="rows">
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
                  <Table 
                    head={head} 
                    body={loja.lancamento} 
                    footer={
                      <tfoot>
                        <tr>
                          <td colSpan={5} />
                          <td style={{fontWeight: 'bold', textAlign: 'right'}}>Total:</td>
                          <td style={{textAlign: 'right'}}>{ CurrencyFormat(loja.saldoPorLoja) }</td>
                        </tr>
                      </tfoot>
                    }
                  />              
                </td>
              </tr>
            </tbody>          
          </table>          
        )}

        <div className="saldo-container">
          <div className="saldo-label">
            Saldo em conta: 
          </div>
          <div className="saldo-valor">
            { new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL'}).format(data.saldoEmConta) }
          </div>
        </div>
      </>
    }
  </>

export default TableRelatorio;
