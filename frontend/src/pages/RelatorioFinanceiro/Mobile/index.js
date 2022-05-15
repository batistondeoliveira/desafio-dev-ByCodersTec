import { TableMobile, ColumnTypeEnum, AlignEnum } from '../../../components/Table'
import { CurrencyFormat } from '../../../components/Utils/CurrencyFormat';

const head = [
  {title: 'Tipo', fieldName: 'tipoTransacao', width: '16%'},
  {title: 'Data', fieldName: 'data', width: '9%', type: ColumnTypeEnum.DATE},
  {title: 'CPF', fieldName: 'cpf', width: '9%'},
  {title: 'Cartão', fieldName: 'cartao', width: '9%'},
  {title: 'Hora', fieldName: 'hora', width: '9%'},
  {title: 'Representante', fieldName: 'representanteLoja', width: '25%'},
  {title: 'Valor', fieldName: 'valor', width: '12%', type: ColumnTypeEnum.CURRENCY, align: AlignEnum.RIGHT}
];

const RelatorioMobile = ({ show, data }) => 
  <>
    {show &&
      <div className="mobile">
        {data.loja.map((loja, index) =>
          <div key={index} className="loja">
            <div className="row">
              <strong>Loja:</strong> {loja.nome}
            </div>
            {loja.lancamento.map((lancamento, index1) =>
              <div key={index1} className="row">                
                <TableMobile head={head} body={lancamento} />
              </div>
            )} 
            <div className="total">
              <strong>Total:</strong> {CurrencyFormat(loja.saldoPorLoja)}
            </div>                                           
          </div>
        )}
        <div className="total">
          <strong>Saldo:</strong> {CurrencyFormat(data.saldoEmConta)}
        </div>
      </div>
    }
  </>  

export default RelatorioMobile;
