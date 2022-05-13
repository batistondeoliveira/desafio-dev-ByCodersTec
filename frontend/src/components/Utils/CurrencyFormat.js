export const CurrencyFormat = (valor) => 
  new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL'}).format(valor);